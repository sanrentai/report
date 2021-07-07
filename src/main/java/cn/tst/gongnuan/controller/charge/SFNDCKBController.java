package cn.tst.gongnuan.controller.charge;

import org.apache.log4j.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import cn.tst.gongnuan.bizlogic.SFNDCKBBizLogic;
import cn.tst.gongnuan.common.SepC;
import cn.tst.gongnuan.controller.BusinessBaseController;
import cn.tst.gongnuan.viewmodel.SFNDCKBViewModel;
import java.util.Date;

/**
 * 收费年度查看表
 *
 * @author CaoChun
 */
@ViewScoped
@Named(SepC.ControllerID.SHOU_FEI_NIAN_DU_CHA_KAN_BIAO)
public class SFNDCKBController extends BusinessBaseController {

    private static final Logger LOG = Logger.getLogger(SFNDCKBController.class.getName());

    @EJB
    private SFNDCKBBizLogic bizLogic;

    /**
     * 物资信息查看视图模型
     */

    private SFNDCKBViewModel vm;

    @PostConstruct
    public void init() {
        vm = new SFNDCKBViewModel();
        vm.setPayDate(new Date());
        bizLogic.loadSFNDCKBViewModel(vm);
    }

    public void daoChuExcel() {
        //bizLogic.daoChuExcel();

    }

    public void changeCompany() {
        vm.setXiaoQuList(null);
        vm.setXiaoQuId("全部");
//        vm.setBuildingList(null);
//        vm.setBuildingId("全部");
        vm.setHuanRenZhanId("全部");
        vm.setHuanReZhanList(null);
        if(!vm.getCompanyName().equals("全部")) {
            bizLogic.changeCompany(vm);
        }
    }

//    public void changeXiaoQu() {
//        vm.setBuildingList(null);
//        vm.setBuildingId("全部");
//        bizLogic.changeXiaoQu(vm);
//    }

    public void changeHuanReZhan() {
        vm.setXiaoQuList(null);
        vm.setXiaoQuId("全部");
//        vm.setBuildingList(null);
//        vm.setBuildingId("全部");
        bizLogic.changeHuanReZhan(vm);
    }

    public void chaXun() {
        LOG.info("年度：" + vm.getYearnum());
        LOG.info("公司：" + vm.getCompanyName());
        LOG.info("换热站：" + vm.getHuanRenZhanId());
        LOG.info("小区：" + vm.getXiaoQuId());
//        LOG.info("大楼：" + vm.getBuildingId());
        bizLogic.chaXun(vm);
//        heJi();
    }

    //*****************************************************************
    //                        Getter Setter
    //*****************************************************************
    public SFNDCKBViewModel getVm() {
        return vm;
    }

    public void setVm(SFNDCKBViewModel vm) {
        this.vm = vm;
    }

}
