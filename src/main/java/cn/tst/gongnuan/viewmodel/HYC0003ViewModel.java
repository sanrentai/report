/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.viewmodel;

import cn.tst.gongnuan.entity.VBuilding;
import cn.tst.gongnuan.entity.VCompany;
import cn.tst.gongnuan.entity.VYearnum;
import cn.tst.gongnuan.service.dto.BuildingDTO;
import cn.tst.gongnuan.service.dto.HySouFeiNianDuBiaoByBuildingDTO;
import cn.tst.gongnuan.service.dto.YearNumDTO;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author CaoChun
 */
public class HYC0003ViewModel extends BaseViewModel {
    
    private List<HySouFeiNianDuBiaoByBuildingDTO> shuJuList;
    ///年度
    private String yearnum;
    ///公司名称
    private String companyName;
    private VCompany selectCompany;
    ///公司名List
    private List<VCompany> companyList;
    
    private List<BuildingDTO> buildingList;
    ///年度list
    private List<YearNumDTO> yearnumList;
    
    private PieChartModel model;

    public PieChartModel getModel() {
        return model;
    }

    public void setModel(PieChartModel model) {
        this.model = model;
    }
    ///大楼号码
    private String buildingNo;
    private BigDecimal totalOwe;
    private BigDecimal totalJk;
    private BigDecimal totalYjk;
    private BigDecimal totalSfl;
    private BigDecimal totalArea;
    
    private List<String> tabNameList;
    
    private Map<String, PieChartModel> modelMap;

    public Map<String, PieChartModel> getModelMap() {
        return modelMap;
    }

    public void setModelMap(Map<String, PieChartModel> modelMap) {
        this.modelMap = modelMap;
    }

    public List<String> getTabNameList() {
        return tabNameList;
    }

    public void setTabNameList(List<String> tabNameList) {
        this.tabNameList = tabNameList;
    }

    public BigDecimal getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(BigDecimal totalArea) {
        this.totalArea = totalArea;
    }

    public BigDecimal getTotalOwe() {
        return totalOwe;
    }

    public void setTotalOwe(BigDecimal totalOwe) {
        this.totalOwe = totalOwe;
    }

    public BigDecimal getTotalJk() {
        return totalJk;
    }

    public void setTotalJk(BigDecimal totalJk) {
        this.totalJk = totalJk;
    }

    public BigDecimal getTotalYjk() {
        return totalYjk;
    }

    public void setTotalYjk(BigDecimal totalYjk) {
        this.totalYjk = totalYjk;
    }

    public BigDecimal getTotalSfl() {
        return totalSfl;
    }

    public void setTotalSfl(BigDecimal totalSfl) {
        this.totalSfl = totalSfl;
    }

    public List<HySouFeiNianDuBiaoByBuildingDTO> getShuJuList() {
        return shuJuList;
    }

    public void setShuJuList(List<HySouFeiNianDuBiaoByBuildingDTO> shuJuList) {
        this.shuJuList = shuJuList;
    }

    public List<VCompany> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<VCompany> companyList) {
        this.companyList = companyList;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    public VCompany getSelectCompany() {
        return selectCompany;
    }

    public void setSelectCompany(VCompany selectCompany) {
        this.selectCompany = selectCompany;
    }

    public List<BuildingDTO> getBuildingList() {
        return buildingList;
    }

    public void setBuildingList(List<BuildingDTO> buildingList) {
        this.buildingList = buildingList;
    }

    public List<YearNumDTO> getYearnumList() {
        return yearnumList;
    }

    public void setYearnumList(List<YearNumDTO> yearnumList) {
        this.yearnumList = yearnumList;
    }

    public String getYearnum() {
        return yearnum;
    }

    public void setYearnum(String yearnum) {
        this.yearnum = yearnum;
    }
    
    
}
