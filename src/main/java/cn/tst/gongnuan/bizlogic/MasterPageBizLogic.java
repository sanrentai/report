package cn.tst.gongnuan.bizlogic;

import cn.tst.gongnuan.entity.GroupMenu;
import cn.tst.gongnuan.entity.GroupMenuItem;
import cn.tst.gongnuan.entity.RepBiao;
import cn.tst.gongnuan.viewmodel.MasterPageViewModel;

/**
 * 模板页务逻辑层
 *
 * @author ps_xy@pscp.co.jp
 */
public interface MasterPageBizLogic {

    /**
     * 初始化ViewModel
     *
     * @param vm 数据模型
     */
    void loadMasterPageBizLogic(MasterPageViewModel vm);

    /**
     * 获取当前菜单项目
     *
     * @param menuId 菜单ID
     * @param menuItemId 项目ID
     * @return
     */
    GroupMenuItem getCurrentGroupMenuItem(String menuId, String menuItemId);

    /**
     * 获取当前报表页面
     *
     * @param menuItemId 项目ID
     * @return
     */
    RepBiao getCurrentRepBiao(String menuItemId);

    /**
     * 获取当前菜单
     *
     * @param menuId 菜单ID
     * @return
     */
    GroupMenu getCurrentCcCaiDan(String menuId);

}
