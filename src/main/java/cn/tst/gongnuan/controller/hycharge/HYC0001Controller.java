package cn.tst.gongnuan.controller.hycharge;

import org.apache.log4j.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import cn.tst.gongnuan.bizlogic.HYC0001BizLogic;
import cn.tst.gongnuan.common.SepC;
import cn.tst.gongnuan.controller.BusinessBaseController;
import cn.tst.gongnuan.service.dto.HySouFeiMingXiDTO;
import cn.tst.gongnuan.viewmodel.HYC0001ViewModel;
import java.math.BigDecimal;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.CategoryAxis;

/**
 * 物资信息查看
 *
 * @author CaoChun
 */
@ViewScoped
@Named(SepC.ControllerID.HYC0001)
public class HYC0001Controller extends BusinessBaseController {

    private static final Logger LOG = Logger.getLogger(HYC0001Controller.class.getName());

    @EJB
    private HYC0001BizLogic bizLogic;

    /**
     * 物资信息查看视图模型
     */
    private HYC0001ViewModel vm;

    @PostConstruct
    public void init() {
        vm = new HYC0001ViewModel();
        bizLogic.loadHYC0001ViewModel(vm);
    }

    public void chaXun() {
        bizLogic.chaXun(vm);
        heJi();
        createAreaModel();
        createMoneyModel();
        createRatioModel();
    }

    public void daoChuExcel() {
        //bizLogic.daoChuExcel();
    }

    public void heJi() {
        BigDecimal totalOwe = BigDecimal.ZERO;
        BigDecimal totalArea = BigDecimal.ZERO;
        BigDecimal totalYjk = BigDecimal.ZERO;
        BigDecimal totalJk = BigDecimal.ZERO;
        if(vm.getShuJuList()==null||vm.getShuJuList().isEmpty()){
            return;
        }
        for (HySouFeiMingXiDTO item : vm.getShuJuList()) {
            totalArea = totalArea.add(item.getArea());
            totalYjk = totalYjk.add(item.getYjk());
            totalJk = totalJk.add(item.getJk());
            totalOwe = totalOwe.add(item.getOwe());
        }
        BigDecimal totalSfl = totalJk.multiply(new BigDecimal("100")).divide(totalYjk, 2, BigDecimal.ROUND_HALF_UP);
//        LOG.info(totalSfl);
        vm.setTotalArea(totalArea);
        vm.setTotalYjk(totalYjk);
        vm.setTotalJk(totalJk);
        vm.setTotalSfl(totalSfl);
        vm.setTotalOwe(totalOwe);
    }

    public void createRatioModel() {
        LineChartModel model = new LineChartModel();
        model.setTitle("收费率图");
        model.setLegendPosition("e");
        model.setShowPointLabels(true);
        ChartSeries sfl = new ChartSeries();
        sfl.setLabel("收费率");

        for (HySouFeiMingXiDTO item : vm.getShuJuList()) {
            sfl.set(item.getName(), item.getSfl());
        }
        model.getAxes().put(AxisType.X, new CategoryAxis("公司名"));
        model.getAxis(AxisType.X).setTickAngle(-30);
        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setLabel("收费率");
        model.addSeries(sfl);
        vm.setRatioModel(model);
    }

    public void createMoneyModel() {
        BarChartModel model = new BarChartModel();
        model.setTitle("应收金额/已收金额/尚欠金额");
        model.setLegendPosition("ne");
        Axis xAxis = model.getAxis(AxisType.X);
        xAxis.setLabel("公司名");
        xAxis.setTickAngle(-30);
        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setLabel("应收金额/已收金额/尚欠金额");

        ChartSeries ysje = new ChartSeries();
        ysje.setLabel("应收金额");
        for (HySouFeiMingXiDTO item : vm.getShuJuList()) {
            ysje.set(item.getName(), item.getYjk());
        }
        ChartSeries yisje = new ChartSeries();
        yisje.setLabel("已收金额");
        for (HySouFeiMingXiDTO item : vm.getShuJuList()) {
            yisje.set(item.getName(), item.getJk());
        }
        ChartSeries sqje = new ChartSeries();
        sqje.setLabel("尚欠金额");
        for (HySouFeiMingXiDTO item : vm.getShuJuList()) {
            sqje.set(item.getName(), item.getOwe());
        }

        model.addSeries(ysje);
        model.addSeries(yisje);
        model.addSeries(sqje);
        vm.setMoneyModel(model);
    }

    public void createAreaModel() {
        LineChartModel model = new LineChartModel();
        model.setTitle("面积图");
        model.setLegendPosition("e");
        model.setShowPointLabels(true);
        ChartSeries mj = new ChartSeries();
        mj.setLabel("面积");

        for (HySouFeiMingXiDTO item : vm.getShuJuList()) {
            mj.set(item.getName(), item.getArea());
        }
        model.getAxes().put(AxisType.X, new CategoryAxis("公司名"));
        model.getAxis(AxisType.X).setTickAngle(-30);
        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setLabel("面积");
        model.addSeries(mj);
        vm.setAreaModel(model);
    }

    //*****************************************************************
    //                        Getter Setter
    //*****************************************************************
    public HYC0001ViewModel getVm() {
        return vm;
    }

    public void setVm(HYC0001ViewModel vm) {
        this.vm = vm;
    }

}
