/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.viewmodel;

import cn.tst.gongnuan.service.dto.HYR0002DTO;
import cn.tst.gongnuan.service.dto.SouFeiMingXiDTO;
import cn.tst.gongnuan.service.dto.YearNumDTO;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.BarChartModel;

/**
 * 各分公司收费明细�?
 *
 * @author CaoChun
 */
public class CHA0001ViewModel extends BaseViewModel {

    private List<SouFeiMingXiDTO> shuJuList;

    private Date payDate;

    BigDecimal totalArea;
    BigDecimal totalYjk;
    BigDecimal totalJk;
    BigDecimal totalOwe;
    BigDecimal totalSfl;

    private String yearnum;
    private List<YearNumDTO> yearnumList;

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

    public CHA0001ViewModel() {
        this.payDate = new Date();
    }

    public List<SouFeiMingXiDTO> getShuJuList() {
        return shuJuList;
    }

    public void setShuJuList(List<SouFeiMingXiDTO> shuJuList) {
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

    public String getYearnum() {
        return yearnum;
    }

    public void setYearnum(String yearnum) {
        this.yearnum = yearnum;
    }

    public List<YearNumDTO> getYearnumList() {
        return yearnumList;
    }

    public void setYearnumList(List<YearNumDTO> yearnumList) {
        this.yearnumList = yearnumList;
    }

    public BigDecimal getTotal(String t)
            throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        BigDecimal total = BigDecimal.ZERO;
        if (shuJuList == null) {
            return total;
        }
        for (SouFeiMingXiDTO item : shuJuList) {
            Method method = item.getClass().getMethod("get" + t.substring(0, 1).toUpperCase() + t.substring(1));
            total = total.add((BigDecimal) method.invoke(item));
        }
        return total;
    }
}
