/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.viewmodel;

import cn.tst.gongnuan.entity.VCompany;
import cn.tst.gongnuan.service.dto.HySouFeiNianDuBiaoByGongSiDTO;
import cn.tst.gongnuan.service.dto.YearNumDTO;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.primefaces.model.chart.BarChartModel;

/**
 *
 * @author CaoChun
 */
public class HYC0002ViewModel extends BaseViewModel {

    private List<HySouFeiNianDuBiaoByGongSiDTO> shuJuList;

    private String yearnum;

    private String companyName;

    private String companyName1;

    private List<VCompany> companyList;

    private List<YearNumDTO> yearnumList;

    private BarChartModel areaModel;
    
    private BarChartModel ysjeModel;
    
    private BarChartModel yisjeModel;
    
    private BarChartModel qkModel;

    public BarChartModel getQkModel() {
        return qkModel;
    }

    public void setQkModel(BarChartModel qkModel) {
        this.qkModel = qkModel;
    }

    public BarChartModel getYisjeModel() {
        return yisjeModel;
    }

    public void setYisjeModel(BarChartModel yisjeModel) {
        this.yisjeModel = yisjeModel;
    }

    public BarChartModel getYsjeModel() {
        return ysjeModel;
    }

    public void setYsjeModel(BarChartModel ysjeModel) {
        this.ysjeModel = ysjeModel;
    }
    
    private BarChartModel ratioModel;

    public BarChartModel getAreaModel() {
        return areaModel;
    }

    public void setAreaModel(BarChartModel areaModel) {
        this.areaModel = areaModel;
    }

    public BarChartModel getRatioModel() {
        return ratioModel;
    }

    public void setRatioModel(BarChartModel ratioModel) {
        this.ratioModel = ratioModel;
    }

    public HYC0002ViewModel() {
    }

    public String getYearnum() {
        return yearnum;
    }

    public void setYearnum(String yearnum) {
        this.yearnum = yearnum;
    }


    public BigDecimal getTotalYjk() {
        BigDecimal result = BigDecimal.ZERO;
        if (shuJuList == null) {
            return result;
        }
        for (HySouFeiNianDuBiaoByGongSiDTO item : shuJuList) {
            result = result.add(item.getYjk());
        }
        return result;
    }

    public BigDecimal getTotalJk() {
        BigDecimal result = BigDecimal.ZERO;
        if (shuJuList == null) {
            return result;
        }
        for (HySouFeiNianDuBiaoByGongSiDTO item : shuJuList) {
            result = result.add(item.getJk());
        }
        return result;
    }

    public BigDecimal getTotalOwe() {
        BigDecimal result = BigDecimal.ZERO;
        if (shuJuList == null) {
            return result;
        }
        for (HySouFeiNianDuBiaoByGongSiDTO item : shuJuList) {
            result = result.add(item.getOwe());
        }
        return result;
    }

    public BigDecimal getTotalArea() {
        BigDecimal total = BigDecimal.ZERO;
        if (shuJuList == null) {
            return total;
        }
        for (HySouFeiNianDuBiaoByGongSiDTO item : shuJuList) {
            total = total.add(item.getArea());
        }
        return total;
    }

    public List<HySouFeiNianDuBiaoByGongSiDTO> getShuJuList() {
        return shuJuList;
    }

    public void setShuJuList(List<HySouFeiNianDuBiaoByGongSiDTO> shuJuList) {
        this.shuJuList = shuJuList;
    }

    public List<VCompany> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<VCompany> companyList) {
        this.companyList = companyList;
    }

    public List<YearNumDTO> getYearnumList() {
        return yearnumList;
    }

    public void setYearnumList(List<YearNumDTO> yearnumList) {
        this.yearnumList = yearnumList;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName1() {
        return companyName1;
    }

    public void setCompanyName1(String companyName1) {
        this.companyName1 = companyName1;
    }
}
