/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.viewmodel;

import cn.tst.gongnuan.entity.VCompany;
import cn.tst.gongnuan.entity.VYearnum;
import cn.tst.gongnuan.service.dto.BuildingDTO;
import cn.tst.gongnuan.service.dto.HYR0001DTO;
import cn.tst.gongnuan.service.dto.HuanReZhanDTO;
import cn.tst.gongnuan.service.dto.SouFeiNianDuBiaoByGongSiDTO;
import cn.tst.gongnuan.service.dto.XiaoQuDTO;
import cn.tst.gongnuan.service.dto.YearNumDTO;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author CaoChun
 */
public class TST0001ViewModel extends BaseViewModel {

    private Date payDate;
    //公司名
    private String companyName;
    //换热站id
    private String huanRenZhanId;
    //小区id
    private String xiaoQuId;
    //大楼id
    private String buildingId;
    private String yearnum;
    private List<VCompany> companyList;

    private List<HuanReZhanDTO> huanReZhanList;
    private List<XiaoQuDTO> xiaoQuList;
    private List<BuildingDTO> buildingList;
    private List<HYR0001DTO> shuJuList;

    private List<YearNumDTO> yearnumList;

    private BigDecimal totalArea;
    private BigDecimal totalYjk;
    private BigDecimal totalJk;
    private BigDecimal totalGratis1;
    private BigDecimal totalOwe;
    private BigDecimal totalZnj;
    private BigDecimal totalZnjmoney;
    private BigDecimal totalZnj_jm;
    private BigDecimal totalZnjOwe;
    private BigDecimal totalZsfy;
    private BigDecimal totalSfl;
    private BigDecimal totalQfl;
    
    private String headerText;

    public String getHeaderText() {
        return headerText;
    }

    public void setHeaderText(String headerText) {
        this.headerText = headerText;
    }

    public TST0001ViewModel() {
        this.companyName = "全部";
        this.huanRenZhanId = "全部";
        this.xiaoQuId = "全部";
        this.buildingId = "全部";
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public List<HYR0001DTO> getShuJuList() {
        return shuJuList;
    }

    public void setShuJuList(List<HYR0001DTO> shuJuList) {
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

    public String getHuanRenZhanId() {
        return huanRenZhanId;
    }

    public void setHuanRenZhanId(String huanRenZhanId) {
        this.huanRenZhanId = huanRenZhanId;
    }

    public String getXiaoQuId() {
        return xiaoQuId;
    }

    public void setXiaoQuId(String xiaoQuId) {
        this.xiaoQuId = xiaoQuId;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public List<HuanReZhanDTO> getHuanReZhanList() {
        return huanReZhanList;
    }

    public void setHuanReZhanList(List<HuanReZhanDTO> huanReZhanList) {
        this.huanReZhanList = huanReZhanList;
    }

    public List<XiaoQuDTO> getXiaoQuList() {
        return xiaoQuList;
    }

    public void setXiaoQuList(List<XiaoQuDTO> xiaoQuList) {
        this.xiaoQuList = xiaoQuList;
    }

    public List<BuildingDTO> getBuildingList() {
        return buildingList;
    }

    public void setBuildingList(List<BuildingDTO> buildingList) {
        this.buildingList = buildingList;
    }

    public String getYearnum() {
        return yearnum;
    }

    public void setYearnum(String yearnum) {
        this.yearnum = yearnum;
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

    public BigDecimal getTotalGratis1() {
        return totalGratis1;
    }

    public void setTotalGratis1(BigDecimal totalGratis1) {
        this.totalGratis1 = totalGratis1;
    }

    public BigDecimal getTotalOwe() {
        return totalOwe;
    }

    public void setTotalOwe(BigDecimal totalOwe) {
        this.totalOwe = totalOwe;
    }

    public BigDecimal getTotalZnj() {
        return totalZnj;
    }

    public void setTotalZnj(BigDecimal totalZnj) {
        this.totalZnj = totalZnj;
    }

    public BigDecimal getTotalZnjmoney() {
        return totalZnjmoney;
    }

    public void setTotalZnjmoney(BigDecimal totalZnjmoney) {
        this.totalZnjmoney = totalZnjmoney;
    }

    public BigDecimal getTotalZnj_jm() {
        return totalZnj_jm;
    }

    public void setTotalZnj_jm(BigDecimal totalZnj_jm) {
        this.totalZnj_jm = totalZnj_jm;
    }

    public BigDecimal getTotalZnjOwe() {
        return totalZnjOwe;
    }

    public void setTotalZnjOwe(BigDecimal totalZnjOwe) {
        this.totalZnjOwe = totalZnjOwe;
    }

    public BigDecimal getTotalZsfy() {
        return totalZsfy;
    }

    public void setTotalZsfy(BigDecimal totalZsfy) {
        this.totalZsfy = totalZsfy;
    }

    public BigDecimal getTotalSfl() {
        return totalSfl;
    }

    public void setTotalSfl(BigDecimal totalSfl) {
        this.totalSfl = totalSfl;
    }

    public BigDecimal getTotalQfl() {
        return totalQfl;
    }

    public void setTotalQfl(BigDecimal totalQfl) {
        this.totalQfl = totalQfl;
    }

}
