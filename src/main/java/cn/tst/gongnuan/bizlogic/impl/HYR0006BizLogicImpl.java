/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.bizlogic.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import cn.tst.gongnuan.viewmodel.HYR0006ViewModel;
import org.apache.log4j.Logger;
import cn.tst.gongnuan.bizlogic.HYR0006BizLogic;
import cn.tst.gongnuan.entity.TConfig;
import cn.tst.gongnuan.service.dto.HYR0006DTO;
import cn.tst.gongnuan.service.dto.YearNumDTO;
import cn.tst.gongnuan.service.impl.HYR0006Facade;
import cn.tst.gongnuan.service.impl.TConfigFacade;
import cn.tst.gongnuan.service.impl.YearNumProcFacade;

/**
 * 出库入库统计实现类
 *
 * @author CaoChun
 */
@Stateless
public class HYR0006BizLogicImpl extends BaseBizLogic implements HYR0006BizLogic {

    private static final Logger LOG = Logger.getLogger(HYR0006BizLogicImpl.class.getName());

    @EJB
    private HYR0006Facade suJuDao;

    @EJB
    private YearNumProcFacade vYearnumDao;

    @EJB
    private TConfigFacade configDao;

    @Override
    public void loadHYR0006ViewModel(HYR0006ViewModel vm) {
        List<YearNumDTO> yearnumList = vYearnumDao.getShuJu();
        vm.setYearnumList(yearnumList);
        ///设置当前年度
        TConfig c = configDao.findAll().get(0);
        vm.setYearnum(c.getYearnum());
    }

    @Override
    public void chaXun(HYR0006ViewModel vm) {
        List<HYR0006DTO> shuJuList;

        shuJuList = suJuDao.getShuJuList(vm.getYearnum());

        vm.setShuJuList(shuJuList);
    }

    @Override
    public void daoChuExcel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
