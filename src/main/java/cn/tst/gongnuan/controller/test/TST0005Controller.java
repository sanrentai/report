package cn.tst.gongnuan.controller.test;

import org.apache.log4j.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import cn.tst.gongnuan.bizlogic.TST0005BizLogic;
import cn.tst.gongnuan.common.SepC;
import cn.tst.gongnuan.controller.BusinessBaseController;
import cn.tst.gongnuan.service.dto.HYR0001DTO;
import cn.tst.gongnuan.viewmodel.TST0005ViewModel;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 物资信息查看
 *
 * @author CaoChun
 */
@ViewScoped
@Named(SepC.ControllerID.TST0005)
public class TST0005Controller extends BusinessBaseController {

    private static final Logger LOG = Logger.getLogger(TST0005Controller.class.getName());

    @EJB
    private TST0005BizLogic bizLogic;

    /**
     * 物资信息查看视图模型
     */

    private TST0005ViewModel vm;

    @PostConstruct
    public void init() {
        vm = new TST0005ViewModel();
        bizLogic.loadTST0005ViewModel(vm);
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
    public TST0005ViewModel getVm() {
        return vm;
    }

    public void setVm(TST0005ViewModel vm) {
        this.vm = vm;
    }

}
