/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.bizlogic.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import cn.tst.gongnuan.viewmodel.HYC0003ViewModel;
import org.apache.log4j.Logger;
import cn.tst.gongnuan.bizlogic.HYC0003BizLogic;
import cn.tst.gongnuan.entity.TConfig;
import cn.tst.gongnuan.entity.VBuilding;
import cn.tst.gongnuan.entity.VCompany;
import cn.tst.gongnuan.entity.VYearnum;
import cn.tst.gongnuan.service.dto.BuildingDTO;
import cn.tst.gongnuan.service.dto.HySouFeiNianDuBiaoByBuildingDTO;
import cn.tst.gongnuan.service.dto.YearNumDTO;
import cn.tst.gongnuan.service.impl.BuildingProcFacade;
import cn.tst.gongnuan.service.impl.HySouFeiNianDuBiaoByBuildingFacade;
import cn.tst.gongnuan.service.impl.TConfigFacade;
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
public class HYC0003BizLogicImpl extends BaseBizLogic implements HYC0003BizLogic {

    private static final Logger LOG = Logger.getLogger(HYC0003BizLogicImpl.class.getName());

    @EJB
    private HySouFeiNianDuBiaoByBuildingFacade suJuDao;

    @EJB
    BuildingProcFacade vBuildingDao;

    @EJB
    private VCompanyFacade vCompanyDao;

    @EJB
    private YearNumProcFacade vYearnumDao;

    @EJB
    private TConfigFacade configDao;

    @Override
    public void loadHYC0003ViewModel(HYC0003ViewModel vm) {
        List<VCompany> findAll = vCompanyDao.findAll();
        vm.setCompanyList(findAll);
        List<YearNumDTO> yearnumList = vYearnumDao.getShuJu();
        vm.setYearnumList(yearnumList);
        TConfig c = configDao.findAll().get(0);
        LOG.info(c.getYearnum());
        vm.setYearnum(c.getYearnum());
    }

    @Override
    public void chaXun(HYC0003ViewModel vm) {
        List<HySouFeiNianDuBiaoByBuildingDTO> souFeiNianDuBiaoByGongSiList = suJuDao.getSouFeiNianDuBiaoByBuildingList(vm.getCompanyName(), vm.getYearnum(), vm.getBuildingNo());
        vm.setShuJuList(souFeiNianDuBiaoByGongSiList);
        TConfig c = configDao.findAll().get(0);
        LOG.info(c.getYearnum());
        vm.setYearnum(c.getYearnum());
    }

    @Override
    public void changeCompany(HYC0003ViewModel vm) {
        List<BuildingDTO> buildingByCompanName = vBuildingDao.getShuJu(vm.getCompanyName());
        vm.setBuildingList(buildingByCompanName);
    }

    @Override
    public void daoChuExcel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
