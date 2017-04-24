/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.bizlogic.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import cn.tst.gongnuan.viewmodel.WYB0001ViewModel;
import org.apache.log4j.Logger;
import cn.tst.gongnuan.bizlogic.WYB0001BizLogic;
import cn.tst.gongnuan.service.dto.YiYunSouFuWuYeFeiHuiZongBiaoDTO;
import cn.tst.gongnuan.service.impl.YiYunSouFuWuYeByNianDuFacade;
import cn.tst.gongnuan.service.impl.VCompanyFacade;
import cn.tst.gongnuan.service.impl.VYearnumFacade;
import java.math.BigDecimal;
import java.util.Calendar;

/**
 * 出库入库统计实现类
 *
 * @author CaoChun
 */
@Stateless
public class WYB0001BizLogicImpl extends BaseBizLogic implements WYB0001BizLogic {

    private static final Logger LOG = Logger.getLogger(WYB0001BizLogicImpl.class.getName());

    @EJB
    private YiYunSouFuWuYeByNianDuFacade suJuDao;

    @EJB
    private VCompanyFacade vCompanyDao;

    @EJB
    private VYearnumFacade vYearnumDao;

    @Override
    public void loadWYB0001ViewModel(WYB0001ViewModel vm) {
        Calendar a = Calendar.getInstance();
        int yearNum = a.get(Calendar.YEAR);
        vm.setYearNum(yearNum);
    }

    @Override
    public void chaXun(WYB0001ViewModel vm) {
        List<YiYunSouFuWuYeFeiHuiZongBiaoDTO> suJuList = suJuDao.getShuJuByNianDu(vm.getYearNum());
        vm.setShuJuList(suJuList);
        
    }

    @Override
    public void daoChuExcel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
