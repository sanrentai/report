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
 * 收费年度表按公司
 *
 * @author CaoChun
 */
@Entity
public class YiYunSouFuWuYeFeiHuiZongBiaoDTO implements Serializable {

    @Id
    private int month;
    @Id
    private String uptownid;
    private String name;
    private BigDecimal jk_zz;
    private BigDecimal jk_hq;
    private BigDecimal jk_gy;
    private BigDecimal jk_wd;
    private BigDecimal jk_ck;
    private BigDecimal jk_cw;
    private BigDecimal jk_cf;
    private BigDecimal jk_hj;
    private int hs_zz;
    private int hs_hq;
    private int hs_gy;
    private int hs_wd;
    private int hs_ck;
    private int hs_cw;
    private int hs_cf;
    private int hs_hj;

    public YiYunSouFuWuYeFeiHuiZongBiaoDTO() {
    }

    public YiYunSouFuWuYeFeiHuiZongBiaoDTO(int month, String uptownid, String name, BigDecimal jk_zz, BigDecimal jk_hq, BigDecimal jk_gy, BigDecimal jk_wd, BigDecimal jk_ck, BigDecimal jk_cw, BigDecimal jk_cf, BigDecimal jk_hj, int hs_zz, int hs_hq, int hs_gy, int hs_wd, int hs_ck, int hs_cw, int hs_cf, int hs_hj) {
        this.month = month;
        this.uptownid = uptownid;
        this.name = name;
        this.jk_zz = jk_zz;
        this.jk_hq = jk_hq;
        this.jk_gy = jk_gy;
        this.jk_wd = jk_wd;
        this.jk_ck = jk_ck;
        this.jk_cw = jk_cw;
        this.jk_cf = jk_cf;
        this.jk_hj = jk_hj;
        this.hs_zz = hs_zz;
        this.hs_hq = hs_hq;
        this.hs_gy = hs_gy;
        this.hs_wd = hs_wd;
        this.hs_ck = hs_ck;
        this.hs_cw = hs_cw;
        this.hs_cf = hs_cf;
        this.hs_hj = hs_hj;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getUptownid() {
        return uptownid;
    }

    public void setUptownid(String uptownid) {
        this.uptownid = uptownid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getJk_zz() {
        return jk_zz;
    }

    public void setJk_zz(BigDecimal jk_zz) {
        this.jk_zz = jk_zz;
    }

    public BigDecimal getJk_hq() {
        return jk_hq;
    }

    public void setJk_hq(BigDecimal jk_hq) {
        this.jk_hq = jk_hq;
    }

    public BigDecimal getJk_gy() {
        return jk_gy;
    }

    public void setJk_gy(BigDecimal jk_gy) {
        this.jk_gy = jk_gy;
    }

    public BigDecimal getJk_wd() {
        return jk_wd;
    }

    public void setJk_wd(BigDecimal jk_wd) {
        this.jk_wd = jk_wd;
    }

    public BigDecimal getJk_ck() {
        return jk_ck;
    }

    public void setJk_ck(BigDecimal jk_ck) {
        this.jk_ck = jk_ck;
    }

    public BigDecimal getJk_cw() {
        return jk_cw;
    }

    public void setJk_cw(BigDecimal jk_cw) {
        this.jk_cw = jk_cw;
    }

    public BigDecimal getJk_cf() {
        return jk_cf;
    }

    public void setJk_cf(BigDecimal jk_cf) {
        this.jk_cf = jk_cf;
    }

    public BigDecimal getJk_hj() {
        return jk_hj;
    }

    public void setJk_hj(BigDecimal jk_hj) {
        this.jk_hj = jk_hj;
    }

    public int getHs_zz() {
        return hs_zz;
    }

    public void setHs_zz(int hs_zz) {
        this.hs_zz = hs_zz;
    }

    public int getHs_hq() {
        return hs_hq;
    }

    public void setHs_hq(int hs_hq) {
        this.hs_hq = hs_hq;
    }

    public int getHs_gy() {
        return hs_gy;
    }

    public void setHs_gy(int hs_gy) {
        this.hs_gy = hs_gy;
    }

    public int getHs_wd() {
        return hs_wd;
    }

    public void setHs_wd(int hs_wd) {
        this.hs_wd = hs_wd;
    }

    public int getHs_ck() {
        return hs_ck;
    }

    public void setHs_ck(int hs_ck) {
        this.hs_ck = hs_ck;
    }

    public int getHs_cw() {
        return hs_cw;
    }

    public void setHs_cw(int hs_cw) {
        this.hs_cw = hs_cw;
    }

    public int getHs_cf() {
        return hs_cf;
    }

    public void setHs_cf(int hs_cf) {
        this.hs_cf = hs_cf;
    }

    public int getHs_hj() {
        return hs_hj;
    }

    public void setHs_hj(int hs_hj) {
        this.hs_hj = hs_hj;
    }

}
