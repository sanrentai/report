package cn.tst.gongnuan.bizlogic.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import cn.tst.gongnuan.bizlogic.MasterPageBizLogic;
import cn.tst.gongnuan.entity.GroupMenu;
import cn.tst.gongnuan.entity.GroupMenuItem;
import cn.tst.gongnuan.entity.RepBiao;
import cn.tst.gongnuan.service.impl.GroupMenuFacade;
import cn.tst.gongnuan.service.impl.GroupMenuItemFacade;
import cn.tst.gongnuan.service.impl.RepBiaoFacade;
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

    @EJB
    private RepBiaoFacade biaoDao;

    @Override
    public void loadMasterPageBizLogic(MasterPageViewModel vm) {
        String mode;
        mode = "test";
//        ///获取用户可以使用的菜�?
//        List<GroupMenuItem> caiDanXiangMuList = this.groupMenuItemDao.findAll();
        List<GroupMenu> groupMenuList = this.groupMenuDao.findAll();///设置数据模型
        vm.setGroupMenuList(groupMenuList);
        List<RepBiao> biaoList = biaoDao.findAll();
        vm.setBiaoList(biaoList);

    }

    @Override
    public GroupMenuItem getCurrentGroupMenuItem(String menuId, String menuItemId) {
        return groupMenuItemDao.findByItemIdAndMenuId(menuItemId, menuId);
    }

    @Override
    public RepBiao getCurrentRepBiao(String menuItemId) {
        return biaoDao.findByBiaoMing(menuItemId);
    }

    @Override
    public GroupMenu getCurrentCcCaiDan(String menuId) {
        return groupMenuDao.findById(menuId);
    }

}
