package cn.tst.gongnuan.controller.hongyu;

import cn.tst.gongnuan.controller.test.*;
import org.apache.log4j.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import cn.tst.gongnuan.bizlogic.HYR0007BizLogic;
import cn.tst.gongnuan.common.SepC;
import cn.tst.gongnuan.controller.BusinessBaseController;
import cn.tst.gongnuan.viewmodel.HYR0007ViewModel;

/**
 * 各公司年度供热费减免费用汇总表
 *
 * @author CaoChun
 */
@ViewScoped
@Named(SepC.ControllerID.HYR0007)
public class HYR0007Controller extends BusinessBaseController {

    private static final Logger LOG = Logger.getLogger(HYR0007Controller.class.getName());

    @EJB
    private HYR0007BizLogic bizLogic;

    /**
     * 物资信息查看视图模型
     */

    private HYR0007ViewModel vm;

    @PostConstruct
    public void init() {
        vm = new HYR0007ViewModel();
        bizLogic.loadHYR0007ViewModel(vm);
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
    public HYR0007ViewModel getVm() {
        return vm;
    }

    public void setVm(HYR0007ViewModel vm) {
        this.vm = vm;
    }

}
