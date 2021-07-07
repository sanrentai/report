/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.bizlogic.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import cn.tst.gongnuan.viewmodel.SFNDCKBViewModel;
import org.apache.log4j.Logger;
import cn.tst.gongnuan.bizlogic.SFNDCKBBizLogic;
import cn.tst.gongnuan.entity.TConfig;
import cn.tst.gongnuan.entity.VCompany;
import cn.tst.gongnuan.service.dto.SouFeiNianDuChaKanBiaoDTO;
import cn.tst.gongnuan.service.dto.HuanReZhanDTO;
import cn.tst.gongnuan.service.dto.XiaoQuDTO;
import cn.tst.gongnuan.service.dto.YearNumDTO;
import cn.tst.gongnuan.service.impl.BuildingProcFacade;
import cn.tst.gongnuan.service.impl.HuanReZhanProcFacade;
import cn.tst.gongnuan.service.impl.SouFeiNianDuChaKanBiaoFacade;
import cn.tst.gongnuan.service.impl.TConfigFacade;
import cn.tst.gongnuan.service.impl.VCompanyFacade;
import cn.tst.gongnuan.service.impl.XiaoQuProcFacade;
import cn.tst.gongnuan.service.impl.YearNumProcFacade;

/**
 * 出库入库统计实现类
 *
 * @author CaoChun
 */
@Stateless
public class SFNDCKBBizLogicImpl extends BaseBizLogic implements SFNDCKBBizLogic {

    private static final Logger LOG = Logger.getLogger(SFNDCKBBizLogicImpl.class.getName());

    @EJB
    private SouFeiNianDuChaKanBiaoFacade suJuDao;

    @EJB
    private VCompanyFacade vCompanyDao;

    @EJB
    private YearNumProcFacade vYearnumDao;

    @EJB
    private HuanReZhanProcFacade huanReZhanDao;

    @EJB
    private XiaoQuProcFacade xiaoQuDao;

//    @EJB
//    private BuildingProcFacade buildingDao;

    @EJB
    private TConfigFacade configDao;

    @Override
    public void loadSFNDCKBViewModel(SFNDCKBViewModel vm) {
        List<VCompany> findAll = vCompanyDao.findAll();
        vm.setCompanyList(findAll);
        List<YearNumDTO> yearnumList = vYearnumDao.getShuJu();
        vm.setYearnumList(yearnumList);

        TConfig c = configDao.findAll().get(0);
        LOG.info(c.getYearnum());
        vm.setYearnum(c.getYearnum());
    }

    @Override
    public void chaXun(SFNDCKBViewModel vm) {
        List<SouFeiNianDuChaKanBiaoDTO> shuJuList;

        if (vm.getCompanyName().equals("全部")) {
            //按分公司汇总
            shuJuList = suJuDao.getShuJuList(vm.getYearnum(), vm.getPayDate());
        } else {
            //按换热站汇总
            if (vm.getHuanRenZhanId().equals("全部")) {
                shuJuList = suJuDao.getShuJuListByCompany(vm.getYearnum(), vm.getPayDate(), vm.getCompanyName());
            } else {
                if (vm.getXiaoQuId().equals("全部")) {
                    //按小区汇总
                    shuJuList = suJuDao.getShuJuListByHuanReZhan(vm.getYearnum(), vm.getPayDate(), vm.getCompanyName(), vm.getHuanRenZhanId());
                } else {
                    //按楼汇总
                    shuJuList = suJuDao.getShuJuListByXiaoQu(vm.getYearnum(), vm.getPayDate(), vm.getCompanyName(), vm.getXiaoQuId());
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
    public void changeCompany(SFNDCKBViewModel vm) {
        List<HuanReZhanDTO> shuJu = huanReZhanDao.getShuJu(vm.getCompanyName());
        vm.setHuanReZhanList(shuJu);
    }

    @Override
    public void changeHuanReZhan(SFNDCKBViewModel vm) {
        List<XiaoQuDTO> shuJu = xiaoQuDao.getShuJu(vm.getCompanyName(), vm.getHuanRenZhanId());
        vm.setXiaoQuList(shuJu);
    }

//    @Override
//    public void changeXiaoQu(SFNDCKBViewModel vm) {
//        List<BuildingDTO> shuJuByXiaoQu = buildingDao.getShuJuByXiaoQu(vm.getCompanyName(), vm.getXiaoQuId());
//        vm.setBuildingList(shuJuByXiaoQu);
//    }
}
