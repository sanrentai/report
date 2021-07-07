/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.controller.hongyu;
import cn.tst.gongnuan.controller.test.*;
import cn.tst.gongnuan.bizlogic.HYR0002BizLogic;
import cn.tst.gongnuan.common.SepC;
import cn.tst.gongnuan.controller.BusinessBaseController;
import javax.ejb.EJB;
import cn.tst.gongnuan.viewmodel.HYR0002ViewModel;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.math.BigDecimal;
/**
 *
 * @author Aaron
 */
@ViewScoped
@Named(SepC.ControllerID.HYR0002)
public class HYR0002Controller extends BusinessBaseController {
    @EJB
    private HYR0002BizLogic bizLogic;

    private HYR0002ViewModel vm;

    public HYR0002BizLogic getBizLogic() {
        return bizLogic;
    }

    public void setBizLogic(HYR0002BizLogic bizLogic) {
        this.bizLogic = bizLogic;
    }

    public HYR0002ViewModel getVm() {
        return vm;
    }

    public void setVm(HYR0002ViewModel vm) {
        this.vm = vm;
    }
    
    @PostConstruct
    public void init() {
        vm = new HYR0002ViewModel();
        bizLogic.loadHYR0002ViewModel(vm);
    }
    
    public void query() {
        bizLogic.query(vm);
    }
}
