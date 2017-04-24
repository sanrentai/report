/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.bizlogic.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import cn.tst.gongnuan.viewmodel.TST0001ViewModel;
import org.apache.log4j.Logger;
import cn.tst.gongnuan.bizlogic.TST0001BizLogic;
import cn.tst.gongnuan.entity.VCompany;
import cn.tst.gongnuan.service.dto.BuildingDTO;
import cn.tst.gongnuan.service.dto.HYR0001DTO;
import cn.tst.gongnuan.service.dto.HuanReZhanDTO;
import cn.tst.gongnuan.service.dto.SouFeiNianDuBiaoByGongSiDTO;
import cn.tst.gongnuan.service.dto.XiaoQuDTO;
import cn.tst.gongnuan.service.dto.YearNumDTO;
import cn.tst.gongnuan.service.impl.BuildingProcFacade;
import cn.tst.gongnuan.service.impl.HYR0001Facade;
import cn.tst.gongnuan.service.impl.HuanReZhanProcFacade;
import cn.tst.gongnuan.service.impl.VCompanyFacade;
import cn.tst.gongnuan.service.impl.XiaoQuProcFacade;
import cn.tst.gongnuan.service.impl.YearNumProcFacade;

/**
 * 出库入库统计实现类
 *
 * @author CaoChun
 */
@Stateless
public class TST0001BizLogicImpl extends BaseBizLogic implements TST0001BizLogic {

    private static final Logger LOG = Logger.getLogger(TST0001BizLogicImpl.class.getName());

    @EJB
    private HYR0001Facade suJuDao;

    @EJB
    private VCompanyFacade vCompanyDao;

    @EJB
    private YearNumProcFacade vYearnumDao;

    @EJB
    private HuanReZhanProcFacade huanReZhanDao;

    @EJB
    private XiaoQuProcFacade xiaoQuDao;

    @EJB
    private BuildingProcFacade buildingDao;

    @Override
    public void loadTST0001ViewModel(TST0001ViewModel vm) {
        List<VCompany> findAll = vCompanyDao.findAll();
        vm.setCompanyList(findAll);
        List<YearNumDTO> yearnumList = vYearnumDao.getShuJu();
        vm.setYearnumList(yearnumList);
    }

    @Override
    public void chaXun(TST0001ViewModel vm) {
        List<HYR0001DTO> shuJuList;
        
        if (vm.getCompanyName().equals("全部")) {
            //按分公司汇总
            shuJuList = suJuDao.getShuJuList(vm.getYearnum());
        } else {
            //按换热站汇总
            if (vm.getHuanRenZhanId().equals("全部")) {
                shuJuList = suJuDao.getShuJuListByCompany(vm.getYearnum(), vm.getCompanyName());
            } else {
                if (vm.getXiaoQuId().equals("全部")) {
                    //按小区汇总
                    shuJuList = suJuDao.getShuJuListByHuanReZhan(vm.getYearnum(), vm.getCompanyName(), vm.getHuanRenZhanId());
                } else {
                    if (vm.getBuildingId().equals("全部")) {
                        //按大楼汇总
                        shuJuList = suJuDao.getShuJuListByXiaoQu(vm.getYearnum(), vm.getCompanyName(), vm.getXiaoQuId());
                    } else {
                        //大楼明细
                        shuJuList = suJuDao.getShuJuListByBuilding(vm.getYearnum(), vm.getCompanyName(), vm.getBuildingId());
                    }
                }
            }
        }
        vm.setShuJuList(shuJuList);
    }

    @Override
    public void daoChuExcel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeCompany(TST0001ViewModel vm) {
        List<HuanReZhanDTO> shuJu = huanReZhanDao.getShuJu(vm.getCompanyName());
        vm.setHuanReZhanList(shuJu);
    }

    @Override
    public void changeHuanReZhan(TST0001ViewModel vm) {
        List<XiaoQuDTO> shuJu = xiaoQuDao.getShuJu(vm.getCompanyName(), vm.getHuanRenZhanId());
        vm.setXiaoQuList(shuJu);
    }

    @Override
    public void changeXiaoQu(TST0001ViewModel vm) {
        List<BuildingDTO> shuJuByXiaoQu = buildingDao.getShuJuByXiaoQu(vm.getCompanyName(), vm.getXiaoQuId());
        vm.setBuildingList(shuJuByXiaoQu);
    }

}
