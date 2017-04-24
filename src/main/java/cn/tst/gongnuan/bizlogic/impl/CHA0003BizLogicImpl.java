/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.bizlogic.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import cn.tst.gongnuan.viewmodel.CHA0003ViewModel;
import org.apache.log4j.Logger;
import cn.tst.gongnuan.bizlogic.CHA0003BizLogic;
import cn.tst.gongnuan.entity.VBuilding;
import cn.tst.gongnuan.entity.VCompany;
import cn.tst.gongnuan.entity.VYearnum;
import cn.tst.gongnuan.service.dto.BuildingDTO;
import cn.tst.gongnuan.service.dto.SouFeiNianDuBiaoByBuildingDTO;
import cn.tst.gongnuan.service.dto.YearNumDTO;
import cn.tst.gongnuan.service.impl.BuildingProcFacade;
import cn.tst.gongnuan.service.impl.SouFeiNianDuBiaoByBuildingFacade;
import cn.tst.gongnuan.service.impl.VBuildingFacade;
import cn.tst.gongnuan.service.impl.VCompanyFacade;
import cn.tst.gongnuan.service.impl.VYearnumFacade;
import cn.tst.gongnuan.service.impl.YearNumProcFacade;

/**
 * 出库入库统计实现类
 *
 * @author CaoChun
 */
@Stateless
public class CHA0003BizLogicImpl extends BaseBizLogic implements CHA0003BizLogic {

    private static final Logger LOG = Logger.getLogger(CHA0003BizLogicImpl.class.getName());

    @EJB
    private SouFeiNianDuBiaoByBuildingFacade suJuDao;
    
    @EJB BuildingProcFacade vBuildingDao;

    @EJB
    private VCompanyFacade vCompanyDao;

    @EJB
    private YearNumProcFacade vYearnumDao;

    @Override
    public void loadCHA0003ViewModel(CHA0003ViewModel vm) {
        List<VCompany> findAll = vCompanyDao.findAll();
        vm.setCompanyList(findAll);
        List<YearNumDTO> yearnumList = vYearnumDao.getShuJu();
        vm.setYearnumList(yearnumList);
    }

    @Override
    public void chaXun(CHA0003ViewModel vm) {
        List<SouFeiNianDuBiaoByBuildingDTO> souFeiNianDuBiaoByGongSiList = suJuDao.getSouFeiNianDuBiaoByBuildingList(vm.getCompanyName(), vm.getPayDate(), vm.getBuildingNo());
        vm.setShuJuList(souFeiNianDuBiaoByGongSiList);
    }

    @Override
    public void changeCompany(CHA0003ViewModel vm) {
        List<BuildingDTO> buildingByCompanName = vBuildingDao.getShuJu(vm.getCompanyName());
        vm.setBuildingList(buildingByCompanName);
    }

    @Override
    public void daoChuExcel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
