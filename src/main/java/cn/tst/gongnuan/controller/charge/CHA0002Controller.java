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
import cn.tst.gongnuan.service.dto.SouFeiNianDuBiaoByGongSiDTO;
import cn.tst.gongnuan.viewmodel.CHA0002ViewModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.CategoryAxis;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

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
        // createBarModel();
        createRatioModel();
        createAreaModel();
        createYsjeModel();
        createYisjeModel();
        createQkModel();
    }
    
    public void createRatioModel() {
        BarChartModel model = new BarChartModel();
        model.setTitle("收费率");
        model.setLegendPosition("ne");
        //model.setShowPointLabels(true);
        //model.getAxes().put(AxisType.X, new CategoryAxis("年度"));
        model.getAxis(AxisType.X).setLabel("年度");
        model.getAxis(AxisType.Y).setLabel("收费率");
        Map<String, Map<String, BigDecimal>> data = new HashMap();
        for(SouFeiNianDuBiaoByGongSiDTO item: vm.getShuJuList()) {
            if(data.containsKey(item.getName())) {
                data.get(item.getName()).put(item.getYearNum(), item.getSfl());
            } else {
                Map<String, BigDecimal> value = new HashMap();
                value.put(item.getYearNum(), item.getSfl());
                data.put(item.getName(), value);
            }
        }
        for(String companyName: data.keySet()) {
            ChartSeries series = new ChartSeries();
            series.setLabel(companyName);
            Map<String, BigDecimal> yearSpanAndRatio = data.get(companyName);
            Object[] keyArray = yearSpanAndRatio.keySet().toArray();
            Arrays.sort(keyArray);
            List<Object> keyList = Arrays.asList(keyArray);
            Collections.reverse(keyList);
            for(Object yearSpan: keyList) {
                series.set((String)yearSpan, yearSpanAndRatio.get(yearSpan));
            }
            model.addSeries(series);
        }
        vm.setRatioModel(model);
    }

    public void createAreaModel() {
        BarChartModel model = new BarChartModel();
        model.setTitle("面积");
        model.setLegendPosition("ne");
        //model.setShowPointLabels(true);
        //model.getAxes().put(AxisType.X, new CategoryAxis("年度"));
        model.getAxis(AxisType.X).setLabel("年度");
        model.getAxis(AxisType.Y).setLabel("面积");
        Map<String, Map<String, BigDecimal>> data = new HashMap();
        for(SouFeiNianDuBiaoByGongSiDTO item: vm.getShuJuList()) {
            if(data.containsKey(item.getName())) {
                data.get(item.getName()).put(item.getYearNum(), item.getArea());
            } else {
                Map<String, BigDecimal> value = new HashMap();
                value.put(item.getYearNum(), item.getArea());
                data.put(item.getName(), value);
            }
        }
        for(String companyName: data.keySet()) {
            ChartSeries series = new ChartSeries();
            series.setLabel(companyName);
            Map<String, BigDecimal> yearSpanAndArea = data.get(companyName);
            Object[] keyArray = yearSpanAndArea.keySet().toArray();
            Arrays.sort(keyArray);
            List<Object> keyList = Arrays.asList(keyArray);
            Collections.reverse(keyList);
            for(Object yearSpan: keyList) {
                series.set((String)yearSpan, yearSpanAndArea.get(yearSpan));
            }
            model.addSeries(series);
        }
        vm.setAreaModel(model);
    }

    public void createYsjeModel() {
        BarChartModel model = new BarChartModel();
        model.setTitle("应收金额");
        model.setLegendPosition("ne");
        //model.setShowPointLabels(true);
        //model.getAxes().put(AxisType.X, new CategoryAxis("年度"));
        model.getAxis(AxisType.X).setLabel("年度");
        model.getAxis(AxisType.Y).setLabel("应收金额");
        Map<String, Map<String, BigDecimal>> data = new HashMap();
        for(SouFeiNianDuBiaoByGongSiDTO item: vm.getShuJuList()) {
            if(data.containsKey(item.getName())) {
                data.get(item.getName()).put(item.getYearNum(), item.getYjk());
            } else {
                Map<String, BigDecimal> value = new HashMap();
                value.put(item.getYearNum(), item.getYjk());
                data.put(item.getName(), value);
            }
        }
        for(String companyName: data.keySet()) {
            ChartSeries series = new ChartSeries();
            series.setLabel(companyName);
            Map<String, BigDecimal> yearSpanAndYjk = data.get(companyName);
            Object[] keyArray = yearSpanAndYjk.keySet().toArray();
            Arrays.sort(keyArray);
            List<Object> keyList = Arrays.asList(keyArray);
            Collections.reverse(keyList);
            for(Object yearSpan: keyList) {
                series.set((String)yearSpan, yearSpanAndYjk.get(yearSpan));
            }
            model.addSeries(series);
        }
        vm.setYsjeModel(model);
    }
    
    public void createYisjeModel() {
        BarChartModel model = new BarChartModel();
        model.setTitle("已收金额");
        model.setLegendPosition("ne");
        //model.setShowPointLabels(true);
        //model.getAxes().put(AxisType.X, new CategoryAxis("年度"));
        model.getAxis(AxisType.X).setLabel("年度");
        model.getAxis(AxisType.Y).setLabel("已收金额");
        Map<String, Map<String, BigDecimal>> data = new HashMap();
        for(SouFeiNianDuBiaoByGongSiDTO item: vm.getShuJuList()) {
            if(data.containsKey(item.getName())) {
                data.get(item.getName()).put(item.getYearNum(), item.getJk());
            } else {
                Map<String, BigDecimal> value = new HashMap();
                value.put(item.getYearNum(), item.getJk());
                data.put(item.getName(), value);
            }
        }
        for(String companyName: data.keySet()) {
            ChartSeries series = new ChartSeries();
            series.setLabel(companyName);
            Map<String, BigDecimal> yearSpanAndJk = data.get(companyName);
            Object[] keyArray = yearSpanAndJk.keySet().toArray();
            Arrays.sort(keyArray);
            List<Object> keyList = Arrays.asList(keyArray);
            Collections.reverse(keyList);
            for(Object yearSpan: keyList) {
                series.set((String)yearSpan, yearSpanAndJk.get(yearSpan));
            }
            model.addSeries(series);
        }
        vm.setYisjeModel(model);
    }
    public void createQkModel() {
        BarChartModel model = new BarChartModel();
        model.setTitle("欠款");
        model.setLegendPosition("ne");
        //model.setShowPointLabels(true);
        //model.getAxes().put(AxisType.X, new CategoryAxis("年度"));
        model.getAxis(AxisType.X).setLabel("年度");
        model.getAxis(AxisType.Y).setLabel("欠款");
        Map<String, Map<String, BigDecimal>> data = new HashMap();
        for(SouFeiNianDuBiaoByGongSiDTO item: vm.getShuJuList()) {
            if(data.containsKey(item.getName())) {
                data.get(item.getName()).put(item.getYearNum(), item.getOwe());
            } else {
                Map<String, BigDecimal> value = new HashMap();
                value.put(item.getYearNum(), item.getOwe());
                data.put(item.getName(), value);
            }
        }
        for(String companyName: data.keySet()) {
            ChartSeries series = new ChartSeries();
            series.setLabel(companyName);
            Map<String, BigDecimal> yearSpanAndOwe = data.get(companyName);
            Object[] keyArray = yearSpanAndOwe.keySet().toArray();
            Arrays.sort(keyArray);
            List<Object> keyList = Arrays.asList(keyArray);
            Collections.reverse(keyList);
            for(Object yearSpan: keyList) {
                series.set((String)yearSpan, yearSpanAndOwe.get(yearSpan));
            }
            model.addSeries(series);
        }
        vm.setQkModel(model);
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
