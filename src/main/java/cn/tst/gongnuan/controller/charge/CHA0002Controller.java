package cn.tst.gongnuan.controller.charge;

import org.apache.log4j.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import cn.tst.gongnuan.bizlogic.CHA0002BizLogic;
import cn.tst.gongnuan.common.SepC;
import cn.tst.gongnuan.controller.BusinessBaseController;
import cn.tst.gongnuan.service.dto.SouFeiNianDuBiaoByGongSiDTO;
import cn.tst.gongnuan.viewmodel.CHA0002ViewModel;
import com.google.common.collect.HashBiMap;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

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

    public void daoChuExcel() {
        //bizLogic.daoChuExcel();

    }

    public void chaXun() {
        bizLogic.chaXun(vm);
    }

    public void createBarModel() {
        String companyName = vm.getCompanyName1();
        if (companyName != null && companyName != "") {
            BarChartModel model = new BarChartModel();
            model.setTitle("金额图");
            model.setLegendPosition("nw");
            ChartSeries yjk = new ChartSeries();
            yjk.setLabel("应交款");
            ChartSeries jk = new ChartSeries();
            jk.setLabel("交款");
            ChartSeries owe = new ChartSeries();
            owe.setLabel("欠款");

            for (SouFeiNianDuBiaoByGongSiDTO item : vm.getShuJuList()) {
                if (companyName.equals(item.getName())) {
                    yjk.set(item.getYearNum(), item.getYjk());
                    jk.set(item.getYearNum(), item.getJk());
                    owe.set(item.getYearNum(), item.getOwe());
                }
            }
            Axis xAxis = model.getAxis(AxisType.X);
            xAxis.setLabel("年度");
            Axis yAxis = model.getAxis(AxisType.Y);
            xAxis.setLabel("金额");
            model.addSeries(yjk);
            model.addSeries(jk);
            model.addSeries(owe);
            vm.setAreaBarModel(model);
//            return model;
        } 
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
