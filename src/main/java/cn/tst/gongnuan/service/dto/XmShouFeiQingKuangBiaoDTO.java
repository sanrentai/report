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
 * 收费情况表
 *
 * @author CaoChun
 */
@Entity
public class XmShouFeiQingKuangBiaoDTO implements Serializable {
    @Id
    private int id;
    //公司名
    private String name;
    //栋数
    private BigDecimal ds;
    private BigDecimal hs;
    private BigDecimal hs_f;
    private BigDecimal area;
    private BigDecimal area_f;
    private String count;
    private String count_f;
    private BigDecimal yjk;
    private BigDecimal yjk_f;
    private BigDecimal jk;
    private BigDecimal jk_f;
    private BigDecimal owe;
    private BigDecimal owe_f;
    private BigDecimal sfl;
    private BigDecimal znj;

    public XmShouFeiQingKuangBiaoDTO() {
    }

    public XmShouFeiQingKuangBiaoDTO(int id, String name, BigDecimal ds, BigDecimal hs, BigDecimal hs_f, BigDecimal area, BigDecimal area_f, String count, String count_f, BigDecimal yjk, BigDecimal yjk_f, BigDecimal jk, BigDecimal jk_f, BigDecimal owe, BigDecimal owe_f, BigDecimal sfl, BigDecimal znj) {
        this.id = id;
        this.name = name;
        this.ds = ds;
        this.hs = hs;
        this.hs_f = hs_f;
        this.area = area;
        this.area_f = area_f;
        this.count = count;
        this.count_f = count_f;
        this.yjk = yjk;
        this.yjk_f = yjk_f;
        this.jk = jk;
        this.jk_f = jk_f;
        this.owe = owe;
        this.owe_f = owe_f;
        this.sfl = sfl;
        this.znj = znj;
    }

    public BigDecimal getZnj() {
        return znj;
    }

    public void setZnj(BigDecimal znj) {
        this.znj = znj;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getDs() {
        return ds;
    }

    public void setDs(BigDecimal ds) {
        this.ds = ds;
    }

    public BigDecimal getHs() {
        return hs;
    }

    public void setHs(BigDecimal hs) {
        this.hs = hs;
    }

    public BigDecimal getHs_f() {
        return hs_f;
    }

    public void setHs_f(BigDecimal hs_f) {
        this.hs_f = hs_f;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getArea_f() {
        return area_f;
    }

    public void setArea_f(BigDecimal area_f) {
        this.area_f = area_f;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getCount_f() {
        return count_f;
    }

    public void setCount_f(String count_f) {
        this.count_f = count_f;
    }


    public BigDecimal getYjk() {
        return yjk;
    }

    public void setYjk(BigDecimal yjk) {
        this.yjk = yjk;
    }

    public BigDecimal getYjk_f() {
        return yjk_f;
    }

    public void setYjk_f(BigDecimal yjk_f) {
        this.yjk_f = yjk_f;
    }

    public BigDecimal getJk() {
        return jk;
    }

    public void setJk(BigDecimal jk) {
        this.jk = jk;
    }

    public BigDecimal getJk_f() {
        return jk_f;
    }

    public void setJk_f(BigDecimal jk_f) {
        this.jk_f = jk_f;
    }

    public BigDecimal getOwe() {
        return owe;
    }

    public void setOwe(BigDecimal owe) {
        this.owe = owe;
    }

    public BigDecimal getOwe_f() {
        return owe_f;
    }

    public void setOwe_f(BigDecimal owe_f) {
        this.owe_f = owe_f;
    }

    public BigDecimal getSfl() {
        return sfl;
    }

    public void setSfl(BigDecimal sfl) {
        this.sfl = sfl;
    }

}
