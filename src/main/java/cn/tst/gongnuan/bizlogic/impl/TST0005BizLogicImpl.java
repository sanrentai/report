/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.bizlogic.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import cn.tst.gongnuan.viewmodel.TST0005ViewModel;
import org.apache.log4j.Logger;
import cn.tst.gongnuan.bizlogic.TST0005BizLogic;
import cn.tst.gongnuan.entity.TConfig;
import cn.tst.gongnuan.service.dto.XmShouFeiQingKuangBiaoDTO;
import cn.tst.gongnuan.service.dto.YearNumDTO;
import cn.tst.gongnuan.service.impl.XmShouFeiQingKuangBiaoFacade;
import cn.tst.gongnuan.service.impl.TConfigFacade;
import cn.tst.gongnuan.service.impl.YearNumProcFacade;

/**
 * 出库入库统计实现类
 *
 * @author CaoChun
 */
@Stateless
public class TST0005BizLogicImpl extends BaseBizLogic implements TST0005BizLogic {

    private static final Logger LOG = Logger.getLogger(TST0005BizLogicImpl.class.getName());

    @EJB
    private XmShouFeiQingKuangBiaoFacade suJuDao;

    @EJB
    private YearNumProcFacade vYearnumDao;

    @EJB
    private TConfigFacade configDao;

    @Override
    public void loadTST0005ViewModel(TST0005ViewModel vm) {
        List<YearNumDTO> yearnumList = vYearnumDao.getShuJu();
        vm.setYearnumList(yearnumList);
        ///设置当前年度
        TConfig c = configDao.findAll().get(0);
        vm.setYearnum(c.getYearnum());
    }

    @Override
    public void chaXun(TST0005ViewModel vm) {
        List<XmShouFeiQingKuangBiaoDTO> shuJuList;

        shuJuList = suJuDao.getShuJu(vm.getYearnum(),vm.getKsDate(),vm.getJsDate());

        vm.setShuJuList(shuJuList);
    }

    @Override
    public void daoChuExcel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}