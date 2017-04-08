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
import cn.tst.gongnuan.service.dto.SouFeiMingXiDTO;
import cn.tst.gongnuan.service.dto.SouFeiNianDuBiaoByBuildingDTO;
import cn.tst.gongnuan.viewmodel.CHA0003ViewModel;
import java.math.BigDecimal;
import java.util.Date;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;
import javax.faces.context.FacesContext;
import org.primefaces.component.tabview.*;
import org.primefaces.component.chart.renderer.PieRenderer;
import org.primefaces.component.chart.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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
    
    public void createModel() {
        Map<String, Map<String, BigDecimal>> data = new HashMap();
        for (SouFeiNianDuBiaoByBuildingDTO item : vm.getShuJuList()) {
            if(data.containsKey(item.getYearNum())){
                Map<String, BigDecimal> sfyAndJkMap = data.get(item.getYearNum());
                if(sfyAndJkMap.containsKey(item.getSfy())) {
                    BigDecimal value = sfyAndJkMap.get(item.getSfy()).add(item.getJk());
                    sfyAndJkMap.put(item.getSfy(), value);
                } else {
                    sfyAndJkMap.put(item.getSfy(), item.getJk());
                }
            } else {
                Map<String, BigDecimal> sfyAndJkMap = new HashMap();
                sfyAndJkMap.put(item.getSfy(), item.getJk());
                data.put(item.getYearNum(), sfyAndJkMap);
            }
        }
        Object[] yearNumObjectArray = data.keySet().toArray();
        String[] yearNumArray = new String[yearNumObjectArray.length];
        for(int index = 0; index < yearNumObjectArray.length; ++index) {
            yearNumArray[index] = (String)yearNumObjectArray[index];
        }
        Arrays.sort(yearNumArray);
        List<String> yearNumList = Arrays.asList(yearNumArray);
        Collections.reverse(yearNumList);
        LOG.info(yearNumList.size());
        vm.setTabNameList(yearNumList);
        
        Map<String, PieChartModel> modelMap = new HashMap();
        for(Object yearNum: yearNumList) {
            Map<String, BigDecimal> sfyAndJkMap = data.get((String)yearNum);
            PieChartModel model = new PieChartModel();
            model.setTitle("收费员图");
            model.setLegendPosition("w");
            for(String sfy: sfyAndJkMap.keySet()) {
                LOG.info(sfy);
                model.set(sfy, sfyAndJkMap.get(sfy));
            }
            modelMap.put((String)yearNum, model);
        }
        vm.setModelMap(modelMap);
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
        createModel();
        for(String item: vm.getTabNameList()){
            LOG.info(item);
        }
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
