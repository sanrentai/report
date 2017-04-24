package cn.tst.gongnuan.bizlogic.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import cn.tst.gongnuan.bizlogic.SystemConfigBizLogic;
import cn.tst.gongnuan.common.SepC;
import cn.tst.gongnuan.viewmodel.SystemConfigViewModel;

/**
 * 系统配置实现类
 *
 * @author ps_xy@pscp.co.jp
 */
@Stateless
public class SystemConfigBizLogicImpl implements SystemConfigBizLogic {



    @Override
    public void initSystem(SystemConfigViewModel vm) {

    }

    @Override
    public boolean addLeiBieGuanLi(SystemConfigViewModel vm) {

        return true;
    }

}
