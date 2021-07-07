package cn.tst.gongnuan.controller.hongyu;

import cn.tst.gongnuan.controller.test.*;
import org.apache.log4j.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import cn.tst.gongnuan.bizlogic.HYR0004BizLogic;
import cn.tst.gongnuan.common.SepC;
import cn.tst.gongnuan.controller.BusinessBaseController;
import cn.tst.gongnuan.service.dto.HYR0004DTO;
import cn.tst.gongnuan.viewmodel.HYR0004ViewModel;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 物资信息查看
 *
 * @author CaoChun
 */
@ViewScoped
@Named(SepC.ControllerID.HYR0004)
public class HYR0004Controller extends BusinessBaseController {

    private static final Logger LOG = Logger.getLogger(HYR0003Controller.class.getName());

    @EJB
    private HYR0004BizLogic bizLogic;

    /**
     * 物资信息查看视图模型
     */

    private HYR0004ViewModel vm;

    @PostConstruct
    public void init() {
        vm = new HYR0004ViewModel();
        vm.setPayDate(new Date());
        bizLogic.loadHYR0004ViewModel(vm);
    }

    public void daoChuExcel() {
        //bizLogic.daoChuExcel();

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
        if(!vm.getXiaoQuId().equals("全部")) {
            bizLogic.changeXiaoQu(vm);
        }
    }

    public void changeHuanReZhan() {
        vm.setXiaoQuList(null);
        vm.setXiaoQuId("全部");
        vm.setBuildingList(null);
        vm.setBuildingId("全部");
        if(!vm.getHuanRenZhanId().equals("全部")) {
            bizLogic.changeHuanReZhan(vm);
        }
    }

    public void chaXun() {
        LOG.info("年度：" + vm.getYearnum());
        LOG.info("公司：" + vm.getCompanyName());
        LOG.info("换热站：" + vm.getHuanRenZhanId());
        LOG.info("小区：" + vm.getXiaoQuId());
        LOG.info("大楼：" + vm.getBuildingId());
        bizLogic.chaXun(vm);
    }

    //*****************************************************************
    //                        Getter Setter
    //*****************************************************************
    public HYR0004ViewModel getVm() {
        return vm;
    }

    public void setVm(HYR0004ViewModel vm) {
        this.vm = vm;
    }

}
