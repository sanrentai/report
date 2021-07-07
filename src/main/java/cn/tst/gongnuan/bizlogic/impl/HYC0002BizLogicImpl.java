/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.bizlogic.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import cn.tst.gongnuan.viewmodel.HYC0002ViewModel;
import org.apache.log4j.Logger;
import cn.tst.gongnuan.bizlogic.HYC0002BizLogic;
import cn.tst.gongnuan.entity.TConfig;
import cn.tst.gongnuan.entity.VCompany;
import cn.tst.gongnuan.service.dto.HySouFeiNianDuBiaoByGongSiDTO;
import cn.tst.gongnuan.service.dto.YearNumDTO;
import cn.tst.gongnuan.service.impl.HySouFeiNianDuBiaoByGongSiFacade;
import cn.tst.gongnuan.service.impl.TConfigFacade;
import cn.tst.gongnuan.service.impl.VCompanyFacade;
import cn.tst.gongnuan.service.impl.YearNumProcFacade;

/**
 * 出库入库统计实现类
 *
 * @author CaoChun
 */
@Stateless
public class HYC0002BizLogicImpl extends BaseBizLogic implements HYC0002BizLogic {

    private static final Logger LOG = Logger.getLogger(HYC0002BizLogicImpl.class.getName());

    @EJB
    private HySouFeiNianDuBiaoByGongSiFacade suJuDao;

    @EJB
    private VCompanyFacade vCompanyDao;

    @EJB
    private YearNumProcFacade vYearnumDao;

    @EJB
    private TConfigFacade configDao;

    @Override
    public void loadHYC0002ViewModel(HYC0002ViewModel vm) {
        List<VCompany> findAll = vCompanyDao.findAll();
        vm.setCompanyList(findAll);
        List<YearNumDTO> yearnumList = vYearnumDao.getShuJu();
        vm.setYearnumList(yearnumList);
        TConfig c = configDao.findAll().get(0);
        ///设置当前年度
        vm.setYearnum(c.getYearnum());
    }

    @Override
    public void chaXun(HYC0002ViewModel vm) {
        List<HySouFeiNianDuBiaoByGongSiDTO> souFeiNianDuBiaoByGongSiList = suJuDao.getSouFeiNianDuBiaoByGongSiList(vm.getCompanyName(), vm.getYearnum());
        vm.setShuJuList(souFeiNianDuBiaoByGongSiList);
    }

    @Override
    public void daoChuExcel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
