/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.controller.test;
import cn.tst.gongnuan.bizlogic.TST0002BizLogic;
import cn.tst.gongnuan.common.SepC;
import cn.tst.gongnuan.controller.BusinessBaseController;
import javax.ejb.EJB;
import cn.tst.gongnuan.viewmodel.TST0002ViewModel;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
/**
 *
 * @author Aaron
 */
@ViewScoped
@Named(SepC.ControllerID.TST0002)
public class TST0002Controller extends BusinessBaseController {
    @EJB
    private TST0002BizLogic bizLogic;

    private TST0002ViewModel vm;

    public TST0002BizLogic getBizLogic() {
        return bizLogic;
    }

    public void setBizLogic(TST0002BizLogic bizLogic) {
        this.bizLogic = bizLogic;
    }

    public TST0002ViewModel getVm() {
        return vm;
    }

    public void setVm(TST0002ViewModel vm) {
        this.vm = vm;
    }
    
    @PostConstruct
    public void init() {
        vm = new TST0002ViewModel();
        //bizLogic.loadTST0002ViewModel(vm);
    }
    
    public void query() {
        bizLogic.query(vm);
    }
}
