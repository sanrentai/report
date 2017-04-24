package cn.tst.gongnuan.controller.charge;

import java.util.Calendar;
import org.apache.log4j.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import cn.tst.gongnuan.bizlogic.CHA0002BizLogic;
import cn.tst.gongnuan.common.SepC;
import cn.tst.gongnuan.controller.BusinessBaseController;
import cn.tst.gongnuan.viewmodel.CHA0002ViewModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 物资信息查看
 *
 * @author CaoChun
 */
@ViewScoped
@Named(SepC.ControllerID.CHA0002)
public class CHA0002Controller extends BusinessBaseController {

    private static final Logger LOG = Logger.getLogger(CHA0002Controller.class.getName());

    @EJB
    private CHA0002BizLogic bizLogic;

    /**
     * 物资信息查看视图模型
     */
    private CHA0002ViewModel vm;

    @PostConstruct
    public void init() {
        vm = new CHA0002ViewModel();
        vm.setPayDate(new Date());
        bizLogic.loadCHA0002ViewModel(vm);
    }
    
    public void daoChuExcel(){
        //bizLogic.daoChuExcel();
        
    }
    
    public void chaXun(){
        bizLogic.chaXun(vm);
    }

    //*****************************************************************
    //                        Getter Setter
    //*****************************************************************
    public CHA0002ViewModel getVm() {
        return vm;
    }
    public void setVm(CHA0002ViewModel vm) {
        this.vm = vm;
    }

}
