package cn.tst.gongnuan.controller.test;

import org.apache.log4j.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import cn.tst.gongnuan.bizlogic.TST0007BizLogic;
import cn.tst.gongnuan.common.SepC;
import cn.tst.gongnuan.controller.BusinessBaseController;
import cn.tst.gongnuan.viewmodel.TST0007ViewModel;

/**
 * 各公司年度供热费减免费用汇总表
 *
 * @author CaoChun
 */
@ViewScoped
@Named(SepC.ControllerID.TST0007)
public class TST0007Controller extends BusinessBaseController {

    private static final Logger LOG = Logger.getLogger(TST0007Controller.class.getName());

    @EJB
    private TST0007BizLogic bizLogic;

    /**
     * 物资信息查看视图模型
     */

    private TST0007ViewModel vm;

    @PostConstruct
    public void init() {
        vm = new TST0007ViewModel();
        bizLogic.loadTST0007ViewModel(vm);
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
    public TST0007ViewModel getVm() {
        return vm;
    }

    public void setVm(TST0007ViewModel vm) {
        this.vm = vm;
    }

}
