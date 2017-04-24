package cn.tst.gongnuan.controller.charge;

import org.apache.log4j.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import cn.tst.gongnuan.bizlogic.CHA0003BizLogic;
import cn.tst.gongnuan.common.SepC;
import cn.tst.gongnuan.controller.BusinessBaseController;
import cn.tst.gongnuan.entity.VCompany;
import cn.tst.gongnuan.entity.VSfmxb;
import cn.tst.gongnuan.service.dto.SouFeiNianDuBiaoByBuildingDTO;
import cn.tst.gongnuan.viewmodel.CHA0003ViewModel;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 物资信息查看
 *
 * @author CaoChun
 */
@ViewScoped
@Named(SepC.ControllerID.CHA0003)
public class CHA0003Controller extends BusinessBaseController {
    
    private static final Logger LOG = Logger.getLogger(CHA0003Controller.class.getName());
    
    @EJB
    private CHA0003BizLogic bizLogic;

    /**
     * 物资信息查看视图模型
     */
    private CHA0003ViewModel vm;
    
    @PostConstruct
    public void init() {
        vm = new CHA0003ViewModel();
        vm.setPayDate(new Date());
        bizLogic.loadCHA0003ViewModel(vm);
    }
    
    public void heJi() {
        BigDecimal totalOwe = BigDecimal.ZERO;
        BigDecimal totalYjk = BigDecimal.ZERO;
        BigDecimal totalJk = BigDecimal.ZERO;
        BigDecimal totalArea = BigDecimal.ZERO;
        if(vm.getShuJuList()==null){
            return;
        }
        for (SouFeiNianDuBiaoByBuildingDTO item : vm.getShuJuList()) {
            totalOwe = totalOwe.add(item.getOwe());
            totalYjk = totalYjk.add(item.getYjk());
            totalJk = totalJk.add(item.getJk());
            totalArea = totalArea.add(item.getArea());
        }
        BigDecimal totalSfl = totalJk.multiply(new BigDecimal("100")).divide(totalYjk, 2, BigDecimal.ROUND_HALF_UP);
        vm.setTotalArea(totalArea);
        vm.setTotalOwe(totalOwe);
        vm.setTotalYjk(totalYjk);
        vm.setTotalJk(totalJk);
        vm.setTotalSfl(totalSfl);
    }

    public void daoChuExcel() {
        //bizLogic.daoChuExcel();
        
    }
    
    public void changeCompany() {
        bizLogic.changeCompany(vm);
    }
    
    public void chaXun() {
        bizLogic.chaXun(vm);
        heJi();
    }

    //*****************************************************************
    //                        Getter Setter
    //*****************************************************************
    public CHA0003ViewModel getVm() {
        return vm;
    }

    public void setVm(CHA0003ViewModel vm) {
        this.vm = vm;
    }
    
}
