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
 *
 * @author Aaron
 */
@Entity
public class HYR0002DTO implements Serializable {

    @Id
    private int no;
    private String name;
    private BigDecimal jk_dn_r;
    private BigDecimal jk_fdn_r;
    private BigDecimal wx_r;
    private BigDecimal znj_r;
    private BigDecimal jk_dn_y;
    private BigDecimal jk_fdn_y;
    private BigDecimal wx_y;
    private BigDecimal znj_y;
    private BigDecimal jk_dn_lj;
    private BigDecimal jk_fdn_lj;
    private BigDecimal wx_lj;
    private BigDecimal znj_lj;
    
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public BigDecimal getThisDayTotal() {
        return jk_dn_r.add(jk_fdn_r);
    }

    public BigDecimal getThisMonthTotal() {
        return jk_dn_y.add(jk_fdn_y);
    }

    public BigDecimal getTotal() {
        return jk_dn_lj.add(jk_fdn_lj);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getJk_dn_r() {
        return jk_dn_r;
    }

    public void setJk_dn_r(BigDecimal jk_dn_r) {
        this.jk_dn_r = jk_dn_r;
    }

    public BigDecimal getJk_fdn_r() {
        return jk_fdn_r;
    }

    public void setJk_fdn_r(BigDecimal jk_fdn_r) {
        this.jk_fdn_r = jk_fdn_r;
    }

    public BigDecimal getJk_dn_y() {
        return jk_dn_y;
    }

    public void setJk_dn_y(BigDecimal jk_dn_y) {
        this.jk_dn_y = jk_dn_y;
    }

    public BigDecimal getJk_fdn_y() {
        return jk_fdn_y;
    }

    public void setJk_fdn_y(BigDecimal jk_fdn_y) {
        this.jk_fdn_y = jk_fdn_y;
    }

    public BigDecimal getJk_dn_lj() {
        return jk_dn_lj;
    }

    public void setJk_dn_lj(BigDecimal jk_dn_lj) {
        this.jk_dn_lj = jk_dn_lj;
    }

    public BigDecimal getJk_fdn_lj() {
        return jk_fdn_lj;
    }

    public void setJk_fdn_lj(BigDecimal jk_fdn_lj) {
        this.jk_fdn_lj = jk_fdn_lj;
    }

    public BigDecimal getWx_r() {
        return wx_r;
    }

    public void setWx_r(BigDecimal wx_r) {
        this.wx_r = wx_r;
    }

    public BigDecimal getZnj_r() {
        return znj_r;
    }

    public void setZnj_r(BigDecimal znj_r) {
        this.znj_r = znj_r;
    }

    public BigDecimal getWx_y() {
        return wx_y;
    }

    public void setWx_y(BigDecimal wx_y) {
        this.wx_y = wx_y;
    }

    public BigDecimal getZnj_y() {
        return znj_y;
    }

    public void setZnj_y(BigDecimal znj_y) {
        this.znj_y = znj_y;
    }

    public BigDecimal getWx_lj() {
        return wx_lj;
    }

    public void setWx_lj(BigDecimal wx_lj) {
        this.wx_lj = wx_lj;
    }

    public BigDecimal getZnj_lj() {
        return znj_lj;
    }

    public void setZnj_lj(BigDecimal znj_lj) {
        this.znj_lj = znj_lj;
    }
    
}
