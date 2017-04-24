package cn.tst.gongnuan.controller.test;

import org.apache.log4j.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import cn.tst.gongnuan.bizlogic.TST0001BizLogic;
import cn.tst.gongnuan.common.SepC;
import cn.tst.gongnuan.controller.BusinessBaseController;
import cn.tst.gongnuan.service.dto.HYR0001DTO;
import cn.tst.gongnuan.viewmodel.TST0001ViewModel;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 物资信息查看
 *
 * @author CaoChun
 */
@ViewScoped
@Named(SepC.ControllerID.TST0001)
public class TST0001Controller extends BusinessBaseController {

    private static final Logger LOG = Logger.getLogger(TST0001Controller.class.getName());

    @EJB
    private TST0001BizLogic bizLogic;

    /**
     * 物资信息查看视图模型
     */

    private TST0001ViewModel vm;

    @PostConstruct
    public void init() {
        vm = new TST0001ViewModel();
        vm.setPayDate(new Date());
        bizLogic.loadTST0001ViewModel(vm);
    }

    public void daoChuExcel() {
        //bizLogic.daoChuExcel();

    }

    public void heJi() {
        BigDecimal totalArea = BigDecimal.ZERO;
        BigDecimal totalYjk = BigDecimal.ZERO;
        BigDecimal totalJk = BigDecimal.ZERO;
        BigDecimal totalGratis1 = BigDecimal.ZERO;
        BigDecimal totalOwe = BigDecimal.ZERO;
        BigDecimal totalZnj = BigDecimal.ZERO;
        BigDecimal totalZnjmoney = BigDecimal.ZERO;
        BigDecimal totalZnj_jm = BigDecimal.ZERO;
        BigDecimal totalZnjOwe = BigDecimal.ZERO;
        BigDecimal totalZsfy = BigDecimal.ZERO;
        BigDecimal totalSfl;
        BigDecimal totalQfl;
        if (vm.getShuJuList() == null) {
            return;
        }
        for (HYR0001DTO item : vm.getShuJuList()) {
            totalArea = totalArea.add(item.getArea());
            totalYjk = totalYjk.add(item.getYjk());
            totalJk = totalJk.add(item.getJk());
            totalGratis1 = totalGratis1.add(item.getGratis1());
            totalOwe = totalOwe.add(item.getOwe());
            totalZnj = totalZnj.add(item.getZnj());
            totalZnjmoney = totalZnjmoney.add(item.getZnjmoney());
            totalZnj_jm = totalZnj_jm.add(item.getZnj_jm());
            totalZnjOwe = totalZnjOwe.add(item.getZnj_owe());
            totalZsfy = totalZsfy.add(item.getZsfy());
        }
        totalSfl = totalJk.add(totalGratis1).multiply(new BigDecimal("100")).divide(totalYjk, 2, BigDecimal.ROUND_HALF_UP);
        totalQfl = totalOwe.multiply(new BigDecimal("100")).divide(totalYjk, 2, BigDecimal.ROUND_HALF_UP);
        vm.setTotalArea(totalArea);
        vm.setTotalYjk(totalYjk);
        vm.setTotalJk(totalJk);
        vm.setTotalGratis1(totalGratis1);
        vm.setTotalOwe(totalOwe);
        vm.setTotalZnj(totalZnj);
        vm.setTotalZnjmoney(totalZnjmoney);
        vm.setTotalZnj_jm(totalZnj_jm);
        vm.setTotalZnjOwe(totalZnjOwe);
        vm.setTotalZsfy(totalZsfy);
        vm.setTotalSfl(totalSfl);
        vm.setTotalQfl(totalQfl);
    }

    public void changeCompany() {
        vm.setXiaoQuList(null);
        vm.setXiaoQuId("全部");
        vm.setBuildingList(null);
        vm.setBuildingId("全部");
        vm.setHuanRenZhanId("全部");
        vm.setHuanReZhanList(null);
        if(!vm.getCompanyName().equals("全部")) {
            bizLogic.changeCompany(vm);
        }
    }

    public void changeXiaoQu() {
        vm.setBuildingList(null);
        vm.setBuildingId("全部");
        bizLogic.changeXiaoQu(vm);
    }

    public void changeHuanReZhan() {
        vm.setXiaoQuList(null);
        vm.setXiaoQuId("全部");
        vm.setBuildingList(null);
        vm.setBuildingId("全部");
        bizLogic.changeHuanReZhan(vm);
    }

    public void chaXun() {
        LOG.info("年度：" + vm.getYearnum());
        LOG.info("公司：" + vm.getCompanyName());
        LOG.info("换热站：" + vm.getHuanRenZhanId());
        LOG.info("小区：" + vm.getXiaoQuId());
        LOG.info("大楼：" + vm.getBuildingId());
        bizLogic.chaXun(vm);
        heJi();
    }

    //*****************************************************************
    //                        Getter Setter
    //*****************************************************************
    public TST0001ViewModel getVm() {
        return vm;
    }

    public void setVm(TST0001ViewModel vm) {
        this.vm = vm;
    }

}
