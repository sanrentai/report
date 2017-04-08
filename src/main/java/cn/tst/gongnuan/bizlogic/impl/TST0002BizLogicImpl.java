/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.bizlogic.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import cn.tst.gongnuan.viewmodel.TST0002ViewModel;
import org.apache.log4j.Logger;
import cn.tst.gongnuan.bizlogic.TST0002BizLogic;
import cn.tst.gongnuan.entity.TConfig;
import cn.tst.gongnuan.service.impl.HYR0002Facade;
import cn.tst.gongnuan.service.impl.TConfigFacade;

/**
 * 出库入库统计实现类
 *
 * @author CaoChun
 */
@Stateless
public class TST0002BizLogicImpl extends BaseBizLogic implements TST0002BizLogic {

    private static final Logger LOG = Logger.getLogger(TST0002BizLogicImpl.class.getName());

    @EJB
    private HYR0002Facade facade;
    
    @EJB
    private TConfigFacade configDao;

    @Override
    public void query(TST0002ViewModel vm) {
        vm.setQueryResultList(facade.query(vm.getPayDate(), vm.getStartDate(), vm.getEndDate()));
    }
    
    @Override
    public void loadTST0002ViewModel(TST0002ViewModel vm) {
        TConfig c = configDao.findAll().get(0);
        vm.setStartDate(c.getStartdate());
        vm.setEndDate(c.getEnddate());
    }
}
