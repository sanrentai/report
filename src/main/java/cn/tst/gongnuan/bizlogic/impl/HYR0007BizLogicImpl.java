/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.bizlogic.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import cn.tst.gongnuan.viewmodel.HYR0007ViewModel;
import org.apache.log4j.Logger;
import cn.tst.gongnuan.bizlogic.HYR0007BizLogic;
import cn.tst.gongnuan.entity.TConfig;
import cn.tst.gongnuan.service.dto.HYR0007DTO;
import cn.tst.gongnuan.service.dto.YearNumDTO;
import cn.tst.gongnuan.service.impl.HYR0007Facade;
import cn.tst.gongnuan.service.impl.TConfigFacade;
import cn.tst.gongnuan.service.impl.YearNumProcFacade;

/**
 * 各公司年度供热费减免费用汇总表
 *
 * @author CaoChun
 */
@Stateless
public class HYR0007BizLogicImpl extends BaseBizLogic implements HYR0007BizLogic {

    private static final Logger LOG = Logger.getLogger(HYR0007BizLogicImpl.class.getName());

    @EJB
    private HYR0007Facade suJuDao;

    @EJB
    private YearNumProcFacade vYearnumDao;

    @EJB
    private TConfigFacade configDao;

    @Override
    public void loadHYR0007ViewModel(HYR0007ViewModel vm) {
        List<YearNumDTO> yearnumList = vYearnumDao.getShuJu();
        vm.setYearnumList(yearnumList);
        ///设置当前年度
        TConfig c = configDao.findAll().get(0);
        vm.setYearnum(c.getYearnum());
    }

    @Override
    public void chaXun(HYR0007ViewModel vm) {
        List<HYR0007DTO> shuJuList;
        if (vm.getType().equals("房屋类型")) {
            shuJuList = suJuDao.getShuJuListByFangWuType(vm.getYearnum());
            vm.setShuJuList(shuJuList);
        }
        if (vm.getType().equals("减免类型")) {
            shuJuList = suJuDao.getShuJuListByJianMianType(vm.getYearnum());
            vm.setShuJuList(shuJuList);
        }

    }

    @Override
    public void daoChuExcel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
