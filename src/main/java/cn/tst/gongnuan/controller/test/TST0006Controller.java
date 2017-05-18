package cn.tst.gongnuan.controller.test;

import org.apache.log4j.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import cn.tst.gongnuan.bizlogic.TST0006BizLogic;
import cn.tst.gongnuan.common.SepC;
import cn.tst.gongnuan.controller.BusinessBaseController;
import cn.tst.gongnuan.viewmodel.TST0006ViewModel;

/**
 * 物资信息查看
 *
 * @author CaoChun
 */
@ViewScoped
@Named(SepC.ControllerID.TST0006)
public class TST0006Controller extends BusinessBaseController {

    private static final Logger LOG = Logger.getLogger(TST0006Controller.class.getName());

    @EJB
    private TST0006BizLogic bizLogic;

    /**
     * 物资信息查看视图模型
     */

    private TST0006ViewModel vm;

    @PostConstruct
    public void init() {
        vm = new TST0006ViewModel();
        bizLogic.loadTST0006ViewModel(vm);
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
    public TST0006ViewModel getVm() {
        return vm;
    }

    public void setVm(TST0006ViewModel vm) {
        this.vm = vm;
    }

}
