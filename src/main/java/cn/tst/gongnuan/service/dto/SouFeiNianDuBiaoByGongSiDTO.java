/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 收费年度表按公司
 *
 * @author CaoChun
 */
@Entity
public class SouFeiNianDuBiaoByGongSiDTO implements Serializable {
    @Id
    private String id;
    //公司名
    private String name;
    //年度
    private String yearNum;  
    private BigDecimal area;
    private BigDecimal yjk;
    private BigDecimal jk;
    private BigDecimal jm;
    private BigDecimal yh;
    private BigDecimal owe;
    private BigDecimal sfl;
    private BigDecimal znj;
//    @Temporal(javax.persistence.TemporalType.DATE)
//    private Date payDate;
    public SouFeiNianDuBiaoByGongSiDTO() {
    }

    public SouFeiNianDuBiaoByGongSiDTO(String id, String name, String yearNum, BigDecimal area, BigDecimal yjk, BigDecimal jk, BigDecimal jm, BigDecimal yh, BigDecimal owe, BigDecimal sfl, BigDecimal znj) {
        this.id = id;
        this.name = name;
        this.yearNum = yearNum;
        this.area = area;
        this.yjk = yjk;
        this.jk = jk;
        this.jm = jm;
        this.yh = yh;
        this.owe = owe;
        this.sfl = sfl;
        this.znj = znj;
    }

    public BigDecimal getZnj() {
        return znj;
    }

    public void setZnj(BigDecimal znj) {
        this.znj = znj;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getJm() {
        return jm;
    }

    public void setJm(BigDecimal jm) {
        this.jm = jm;
    }

    public BigDecimal getYh() {
        return yh;
    }

    public void setYh(BigDecimal yh) {
        this.yh = yh;
    }
    
    
    
}
