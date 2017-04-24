package cn.tst.gongnuan.controller.charge;

import java.util.Calendar;
import org.apache.log4j.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import cn.tst.gongnuan.bizlogic.CHA0001BizLogic;
import cn.tst.gongnuan.common.SepC;
import cn.tst.gongnuan.controller.BusinessBaseController;
import cn.tst.gongnuan.entity.VSfmxb;
import cn.tst.gongnuan.service.dto.SouFeiMingXiDTO;
import cn.tst.gongnuan.viewmodel.CHA0001ViewModel;
import java.math.BigDecimal;

/**
 * 物资信息查看
 *
 * @author CaoChun
 */
@ViewScoped
@Named(SepC.ControllerID.CHA0001)
public class CHA0001Controller extends BusinessBaseController {

    private static final Logger LOG = Logger.getLogger(CHA0001Controller.class.getName());

    @EJB
    private CHA0001BizLogic bizLogic;

    /**
     * 物资信息查看视图模型
     */
    private CHA0001ViewModel vm;

    @PostConstruct
    public void init() {
        vm = new CHA0001ViewModel();
        bizLogic.loadCHA0001ViewModel(vm);
    }
    
    public void chaXun(){
        bizLogic.chaXun(vm);
        heJi();
    }

    public void daoChuExcel() {
        //bizLogic.daoChuExcel();
    }

    public void heJi() {
        BigDecimal totalOwe = BigDecimal.ZERO;
        BigDecimal totalArea = BigDecimal.ZERO;
        BigDecimal totalYjk = BigDecimal.ZERO;
        BigDecimal totalJk = BigDecimal.ZERO;
        for (SouFeiMingXiDTO item : vm.getShuJuList()) {
            totalArea = totalArea.add(item.getArea());
            totalYjk = totalYjk.add(item.getYjk());
            totalJk = totalJk.add(item.getJk());
            totalOwe=totalOwe.add(item.getOwe());
        }
        BigDecimal totalSfl=totalJk.multiply(new BigDecimal("100")).divide(totalYjk,2,BigDecimal.ROUND_HALF_UP);
//        LOG.info(totalSfl);
        vm.setTotalArea(totalArea);
        vm.setTotalYjk(totalYjk);
        vm.setTotalJk(totalJk);
        vm.setTotalSfl(totalSfl);
        vm.setTotalOwe(totalOwe);
    }

    //*****************************************************************
    //                        Getter Setter
    //*****************************************************************
    public CHA0001ViewModel getVm() {
        return vm;
    }

    public void setVm(CHA0001ViewModel vm) {
        this.vm = vm;
    }

}
