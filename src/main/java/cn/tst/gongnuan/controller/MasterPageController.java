package cn.tst.gongnuan.controller;

import cn.tst.gongnuan.bizlogic.MasterPageBizLogic;
import java.text.MessageFormat;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import cn.tst.gongnuan.common.SepC;
import cn.tst.gongnuan.entity.GroupMenu;
import cn.tst.gongnuan.entity.GroupMenuItem;
import cn.tst.gongnuan.entity.RepBiao;
import cn.tst.gongnuan.viewmodel.MasterPageViewModel;
import java.util.HashMap;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 * 菜单控制器控制器
 *
 * @author ps_xy@pscp.co.jp
 */
@ViewScoped
@Named(SepC.ControllerID.MASTER)
public class MasterPageController extends BusinessBaseController {

    private MasterPageViewModel vm;

    private String selectedFunctionId;        //选中的菜单项目ID
    private String contentURL;                //加载画面的URL
//    private List<GroupMenuItem> groupMenuItemList;
//    private List<GroupMenu> groupMenuList;
//    private GroupMenu menu;
    private MenuModel menus;

    @EJB
    private MasterPageBizLogic bizLogic;

    /**
     * 页面初始�?
     */
    @PostConstruct
    public void init() {
        this.vm = new MasterPageViewModel();

        this.bizLogic.loadMasterPageBizLogic(vm);
        this.createMenu();
    }

    //***********************************************************************************************
    //                                  私有方法全部放在类的�?下方
    //***********************************************************************************************
    private void createMenu() {

        ///创建Menu模型
        this.menus = new DefaultMenuModel();
//        Map<GroupMenu, List<GroupMenuItem>> groupByMenus = new HashMap<>();
        ///通过明细行groupBy转换成Header -> Detail
        vm.getGroupMenuList().forEach(gm -> {
//            groupByMenus.put(gm, gm.getMenuItems());
            DefaultSubMenu titleItem = new DefaultSubMenu();
            final String pageFunctionPath;
            switch (gm.getMenuId()) {
                case "CHA":
                    pageFunctionPath = "charge/";
                    break;
                case "MST":
                    pageFunctionPath = "master/";
                    break;
                case "WYB":
                    pageFunctionPath = "wuyefei/";
                    break;
                case "TST":
                    pageFunctionPath = "test/";
                    for (RepBiao biao : vm.getBiaoList()) {
                        DefaultMenuItem menuItem = new DefaultMenuItem();
                        String commandName = MessageFormat.format("#'{' {0}.transfer2Page(''{1}'',''{2}'') '}'",
                                SepC.ControllerID.MASTER,
                                biao.getBiaoMing(),
                                pageFunctionPath);

                        ///子菜单项目名
                        menuItem.setValue(biao.getCnBiaoMing());
                        ///Ajax请求
                        menuItem.setAjax(true);
                        ///设置为异步的
                        menuItem.setAsync(false);
                        ///设置Ajax请求命令
                        menuItem.setCommand(commandName);
                        ///不做任何验证
                        menuItem.setImmediate(true);
                        ///重置�?有�??
                        menuItem.setResetValues(true);
                        ///直提交自�?
                        menuItem.setProcess("@this");
                        ///PageLoad 动画效果
                        menuItem.setOnstart("restartPace();");
                        ///更新页面内容
                        menuItem.setUpdate("frmMain:sub_content");
                        ///添加子菜�?
                        titleItem.addElement(menuItem);
                    }
                    break;
                case "HYR":
                    pageFunctionPath = "hongyu/";
                    break;
                case "HYC":
                    pageFunctionPath = "hycharge/";
                    break;
                default:
                    return;
            }
            gm.getMenuItems().forEach(subMenu -> {

                DefaultMenuItem menuItem = new DefaultMenuItem();

                String commandName = MessageFormat.format("#'{' {0}.transfer2Page(''{1}'',''{2}'') '}'",
                        SepC.ControllerID.MASTER,
                        subMenu.getItemId(),
                        pageFunctionPath);

                ///子菜单项目名
                menuItem.setValue(subMenu.getItemName());
                ///Ajax请求
                menuItem.setAjax(true);
                ///设置为异步的
                menuItem.setAsync(false);
                ///设置Ajax请求命令
                menuItem.setCommand(commandName);
                ///不做任何验证
                menuItem.setImmediate(true);
                ///重置�?有�??
                menuItem.setResetValues(true);
                ///直提交自�?
                menuItem.setProcess("@this");
                ///PageLoad 动画效果
                menuItem.setOnstart("restartPace();");
                ///更新页面内容
                menuItem.setUpdate("frmMain:sub_content");
                ///添加子菜�?
                titleItem.addElement(menuItem);
            });
            titleItem.setLabel(gm.getMenuName());

            ///添加菜单 系统菜单只有 系统管理员才显示
            if (titleItem.getLabel().equals("系统设置")) {
                if (accountManager.getEmployee().getEmpId().equals("000000")) {
                    this.menus.addElement(titleItem);
                }
            } else {
                this.menus.addElement(titleItem);
            }
        });
    }

    /**
     * Ajax页面跳转
     *
     * @param menuItemId 菜单ID
     * @param pageFunctionPath 跳转页面路径
     */
    public void transfer2Page(String menuItemId, String pageFunctionPath) {
        ///设置嵌入页面的URL
        this.contentURL = "/views/" + pageFunctionPath + "/" + menuItemId + ".xhtml";
        ///从视图种删除不相关的控制�?
        this.removeUnsedControllerFromViewMap("ctrl" + menuItemId);
    }

    /**
     * 删除未使用的控制器ID
     *
     * @param currentControllerId 当前控制器ID
     */
    private void removeUnsedControllerFromViewMap(String currentControllerId) {

        ///删除不需要加载的对象控制�?
        this.getViewMap().entrySet().removeIf(entry -> {
            ///要规避的ID 这些控制器不能删�? !!!
            //                    
            return !SepC.ControllerID.LOGIN.equals(entry.getKey())
                    && !SepC.ControllerID.MASTER.equals(entry.getKey())
                    && !SepC.ControllerID.SYSTEM_CONFIG.equals(entry.getKey())
                    && !SepC.ControllerID.GONG_ZUO_TAI.equals(entry.getKey())
                    && !currentControllerId.equals(entry.getKey());
        });

        //测试LOG
//        this.getViewMap().forEach((k, v) -> {
//            System.out.println(k + ":" + v);
//        });

        ///强制回收内存
        System.gc();
    }

    /**
     * 创建页面Title
     *
     * @param menuId 菜单ID
     * @param menuItemId 菜单项目ID
     * @return 页面Title内容
     */
    public String createPageTitle(String menuId, String menuItemId) {

        ///获取当前是使用的项目ID
        GroupMenuItem current = bizLogic.getCurrentGroupMenuItem(menuId, menuItemId);
        if (current != null) {
            return current.getMenu().getMenuName() + " > " + current.getItemName() + "(" + menuItemId + ")";
        } else {
            RepBiao biao = bizLogic.getCurrentRepBiao(menuItemId);
            GroupMenu currentCcCaiDan = bizLogic.getCurrentCcCaiDan(menuId);
            return currentCcCaiDan.getMenuName() + " > " + biao.getCnBiaoMing() + "(" + menuItemId + ")";
        }
    }

    private Map caiDanMap = new HashMap();

    public Map getCaiDanMap() {
        return caiDanMap;
    }

    public void setCaiDanMap(Map caiDanMap) {
        this.caiDanMap = caiDanMap;
    }

    public String getSelectedFunctionId() {
        return selectedFunctionId;
    }

    public void setSelectedFunctionId(String selectedFunctionId) {
        this.selectedFunctionId = selectedFunctionId;
    }

    public String getContentURL() {
        return contentURL;
    }

    public void setContentURL(String contentURL) {
        this.contentURL = contentURL;
    }

    public MenuModel getMenus() {
        return menus;
    }

    public void setMenus(MenuModel menus) {
        this.menus = menus;
    }

    public MasterPageViewModel getVm() {
        return vm;
    }

    public void setVm(MasterPageViewModel vm) {
        this.vm = vm;
    }
}
