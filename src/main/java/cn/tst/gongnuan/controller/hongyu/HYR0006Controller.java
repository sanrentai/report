package cn.tst.gongnuan.controller.hongyu;

import cn.tst.gongnuan.controller.test.*;
import org.apache.log4j.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import cn.tst.gongnuan.bizlogic.HYR0006BizLogic;
import cn.tst.gongnuan.common.SepC;
import cn.tst.gongnuan.controller.BusinessBaseController;
import cn.tst.gongnuan.viewmodel.HYR0006ViewModel;

/**
 * 物资信息查看
 *
 * @author CaoChun
 */
@ViewScoped
@Named(SepC.ControllerID.HYR0006)
public class HYR0006Controller extends BusinessBaseController {

    private static final Logger LOG = Logger.getLogger(HYR0006Controller.class.getName());

    @EJB
    private HYR0006BizLogic bizLogic;

    /**
     * 物资信息查看视图模型
     */

    private HYR0006ViewModel vm;

    @PostConstruct
    public void init() {
        vm = new HYR0006ViewModel();
        bizLogic.loadHYR0006ViewModel(vm);
    }

    public void daoChuExcel() {
        //bizLogic.daoChuExcel();

    }

    public void chaXun() {
        bizLogic.chaXun(vm);
    }

    //*****************************************************************
    //                        Getter Setter
    //*****************************************************************
    public HYR0006ViewModel getVm() {
        return vm;
    }

    public void setVm(HYR0006ViewModel vm) {
        this.vm = vm;
    }

}
