package cn.tst.gongnuan.bizlogic.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import cn.tst.gongnuan.bizlogic.SystemConfigBizLogic;
import cn.tst.gongnuan.common.SepC;
import cn.tst.gongnuan.entity.TConfig;
import cn.tst.gongnuan.service.impl.TConfigFacade;
import cn.tst.gongnuan.viewmodel.SystemConfigViewModel;
import java.util.List;

/**
 * 系统配置实现类
 *
 * @author 曹春
 */
@Stateless
public class SystemConfigBizLogicImpl implements SystemConfigBizLogic {

    @EJB
    TConfigFacade tConfigDAO;

    @Override
    public void initSystem(SystemConfigViewModel vm) {
        TConfig c = tConfigDAO.findAll().get(0);
        vm.setYearnum(c.getYearnum());
        vm.setStarDate(c.getStartdate());
        vm.setEndDate(c.getEnddate());
        vm.setTitle(c.getTitle());
    }

    @Override
    public boolean addLeiBieGuanLi(SystemConfigViewModel vm) {

        return true;
    }

}
