package cn.tst.gongnuan.bizlogic.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import cn.tst.gongnuan.bizlogic.MasterPageBizLogic;
import cn.tst.gongnuan.entity.GroupMenu;
import cn.tst.gongnuan.entity.GroupMenuItem;
import cn.tst.gongnuan.service.impl.GroupMenuFacade;
import cn.tst.gongnuan.service.impl.GroupMenuItemFacade;
import cn.tst.gongnuan.viewmodel.MasterPageViewModel;
import java.util.ArrayList;

/**
 *
 * @author andysilver
 */
@Stateless
public class MasterPageBizLogicImpl implements MasterPageBizLogic {

    @EJB
    private GroupMenuItemFacade groupMenuItemDao;

    @EJB
    private GroupMenuFacade groupMenuDao;

    @Override
    public void loadMasterPageBizLogic(MasterPageViewModel vm) {
        String mode;
        mode = "test";
//        ///获取用户可以使用的菜单
//        List<GroupMenuItem> caiDanXiangMuList = this.groupMenuItemDao.findAll();
        List<GroupMenu> groupMenuList = this.groupMenuDao.findAll();///设置数据模型
//        if (mode.equals("test")) {
//            GroupMenu test = new GroupMenu();
//            test.setMenuId("TST");
//            test.setMenuName("测试");
//            test.setMenuItems(new ArrayList<>());
//            GroupMenuItem testItem = new GroupMenuItem();
//            testItem.setItemId("TST0001");
//            testItem.setItemName("测试项目001");
//            testItem.setMenuId("TST");
//            testItem.setMenu(test);
//            test.getMenuItems().add(testItem);
//            groupMenuList.add(test);
//        }
        vm.setGroupMenuList(groupMenuList);
    }

    @Override
    public GroupMenuItem getCurrentGroupMenuItem(String menuId, String menuItemId) {
        return groupMenuItemDao.findByItemIdAndMenuId(menuItemId, menuId);
    }

}
