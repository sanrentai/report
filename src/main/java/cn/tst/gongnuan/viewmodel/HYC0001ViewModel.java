/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.viewmodel;

import cn.tst.gongnuan.service.dto.HySouFeiMingXiDTO;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.BarChartModel;

/**
 * 各分公司收费明细表
 *
 * @author CaoChun
 */
public class HYC0001ViewModel extends BaseViewModel {

    private List<HySouFeiMingXiDTO> shuJuList;

    private Date payDate;

    BigDecimal totalArea;
    BigDecimal totalYjk;
    BigDecimal totalJk;
    BigDecimal totalOwe;
    BigDecimal totalSfl;
    
    private LineChartModel areaModel;
    
    private BarChartModel moneyModel;
    
    private LineChartModel ratioModel;

    public LineChartModel getRatioModel() {
        return ratioModel;
    }

    public void setRatioModel(LineChartModel ratioModel) {
        this.ratioModel = ratioModel;
    }

    public BarChartModel getMoneyModel() {
        return moneyModel;
    }

    public void setMoneyModel(BarChartModel moneyModel) {
        this.moneyModel = moneyModel;
    }

    public LineChartModel getAreaModel() {
        return areaModel;
    }

    public void setAreaModel(LineChartModel areaModel) {
        this.areaModel = areaModel;
    }

    public HYC0001ViewModel() {
        this.payDate = new Date();
    }

    public List<HySouFeiMingXiDTO> getShuJuList() {
        return shuJuList;
    }

    public void setShuJuList(List<HySouFeiMingXiDTO> shuJuList) {
        this.shuJuList = shuJuList;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public BigDecimal getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(BigDecimal totalArea) {
        this.totalArea = totalArea;
    }

    public BigDecimal getTotalYjk() {
        return totalYjk;
    }

    public void setTotalYjk(BigDecimal totalYjk) {
        this.totalYjk = totalYjk;
    }

    public BigDecimal getTotalJk() {
        return totalJk;
    }

    public void setTotalJk(BigDecimal totalJk) {
        this.totalJk = totalJk;
    }

    public BigDecimal getTotalSfl() {
        return totalSfl;
    }

    public void setTotalSfl(BigDecimal totalSfl) {
        this.totalSfl = totalSfl;
    }

    public BigDecimal getTotalOwe() {
        return totalOwe;
    }

    public void setTotalOwe(BigDecimal totalOwe) {
        this.totalOwe = totalOwe;
    }

}
