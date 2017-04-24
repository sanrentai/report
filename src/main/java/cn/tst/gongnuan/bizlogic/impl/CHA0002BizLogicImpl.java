/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.bizlogic.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import cn.tst.gongnuan.viewmodel.CHA0002ViewModel;
import org.apache.log4j.Logger;
import cn.tst.gongnuan.bizlogic.CHA0002BizLogic;
import cn.tst.gongnuan.entity.VCompany;
import cn.tst.gongnuan.service.dto.SouFeiNianDuBiaoByGongSiDTO;
import cn.tst.gongnuan.service.dto.YearNumDTO;
import cn.tst.gongnuan.service.impl.SouFeiNianDuBiaoByGongSiFacade;
import cn.tst.gongnuan.service.impl.VCompanyFacade;
import cn.tst.gongnuan.service.impl.YearNumProcFacade;

/**
 * 出库入库统计实现类
 *
 * @author CaoChun
 */
@Stateless
public class CHA0002BizLogicImpl extends BaseBizLogic implements CHA0002BizLogic {

    private static final Logger LOG = Logger.getLogger(CHA0002BizLogicImpl.class.getName());

    @EJB
    private SouFeiNianDuBiaoByGongSiFacade suJuDao;
    
    @EJB
    private VCompanyFacade vCompanyDao;
    
    @EJB
    private YearNumProcFacade vYearnumDao;

    @Override
    public void loadCHA0002ViewModel(CHA0002ViewModel vm) {
        List<VCompany> findAll = vCompanyDao.findAll();
        vm.setCompanyList(findAll);
        List<YearNumDTO> yearnumList = vYearnumDao.getShuJu();
        vm.setYearnumList(yearnumList);
    }

    @Override
    public void chaXun(CHA0002ViewModel vm) {
        List<SouFeiNianDuBiaoByGongSiDTO> souFeiNianDuBiaoByGongSiList = suJuDao.getSouFeiNianDuBiaoByGongSiList(vm.getCompanyName(),vm.getPayDate());
        vm.setShuJuList(souFeiNianDuBiaoByGongSiList);
    }

    @Override
    public void daoChuExcel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
