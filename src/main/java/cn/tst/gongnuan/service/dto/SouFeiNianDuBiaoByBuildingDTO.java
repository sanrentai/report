/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 * 收费年度表按楼
 *
 * @author CaoChun
 */
@Entity
public class SouFeiNianDuBiaoByBuildingDTO implements Serializable {
    @Id
    private String id;
    //公司名
    private String companyName;
    
    private String buildingName;
            
    //年度
    private String yearNum;  
    private BigDecimal area;
    private BigDecimal yjk;
    private BigDecimal jk;
    private BigDecimal owe;
    private BigDecimal sfl;
    private String sfy;
    private BigDecimal znj;
//    @Temporal(javax.persistence.TemporalType.DATE)
//    private Date payDate;
    public SouFeiNianDuBiaoByBuildingDTO() {
    }

    public SouFeiNianDuBiaoByBuildingDTO(String id, String companyName, String buildingName, String yearNum, BigDecimal area, BigDecimal yjk, BigDecimal jk, BigDecimal owe, BigDecimal sfl, String sfy, BigDecimal znj) {
        this.id = id;
        this.companyName = companyName;
        this.buildingName = buildingName;
        this.yearNum = yearNum;
        this.area = area;
        this.yjk = yjk;
        this.jk = jk;
        this.owe = owe;
        this.sfl = sfl;
        this.sfy = sfy;
        this.znj = znj;
    }

    public BigDecimal getZnj() {
        return znj;
    }

    public void setZnj(BigDecimal znj) {
        this.znj = znj;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public String getSfy() {
        return sfy;
    }

    public void setSfy(String sfy) {
        this.sfy = sfy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getYearNum() {
        return yearNum;
    }

    public void setYearNum(String yearNum) {
        this.yearNum = yearNum;
    }

    public BigDecimal getYjk() {
        return yjk;
    }

    public void setYjk(BigDecimal yjk) {
        this.yjk = yjk;
    }

    public BigDecimal getJk() {
        return jk;
    }

    public void setJk(BigDecimal jk) {
        this.jk = jk;
    }

    public BigDecimal getOwe() {
        return owe;
    }

    public void setOwe(BigDecimal owe) {
        this.owe = owe;
    }

    public BigDecimal getSfl() {
        return sfl;
    }

    public void setSfl(BigDecimal sfl) {
        this.sfl = sfl;
    }
}

