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
 * 宏宇收费汇总表一
 *
 * @author CaoChun
 */
@Entity
public class HYR0001DTO implements Serializable {

    @Id
    private String no;
    private String id;
    private String name;
    private String sfxm;
    private BigDecimal area;
    private BigDecimal yjk;
    private BigDecimal jk;
    private BigDecimal gratis1;
    private BigDecimal owe;
    private BigDecimal znj;
    private BigDecimal znjmoney;
    private BigDecimal znj_jm;
    private BigDecimal znj_owe;
    private BigDecimal zsfy;
    private BigDecimal sfl;
    private BigDecimal qfl;

    public HYR0001DTO() {
    }

    public HYR0001DTO(String no, String id, String name, String sfxm, BigDecimal area, BigDecimal yjk, BigDecimal jk, BigDecimal gratis1, BigDecimal owe, BigDecimal znj, BigDecimal znjmoney, BigDecimal znj_jm, BigDecimal znj_owe, BigDecimal zsfy, BigDecimal sfl, BigDecimal qfl) {
        this.no = no;
        this.id = id;
        this.name = name;
        this.sfxm = sfxm;
        this.area = area;
        this.yjk = yjk;
        this.jk = jk;
        this.gratis1 = gratis1;
        this.owe = owe;
        this.znj = znj;
        this.znjmoney = znjmoney;
        this.znj_jm = znj_jm;
        this.znj_owe = znj_owe;
        this.zsfy = zsfy;
        this.sfl = sfl;
        this.qfl = qfl;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
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

    public String getSfxm() {
        return sfxm;
    }

    public void setSfxm(String sfxm) {
        this.sfxm = sfxm;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
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

    public BigDecimal getGratis1() {
        return gratis1;
    }

    public void setGratis1(BigDecimal gratis1) {
        this.gratis1 = gratis1;
    }

    public BigDecimal getOwe() {
        return owe;
    }

    public void setOwe(BigDecimal owe) {
        this.owe = owe;
    }

    public BigDecimal getZnj() {
        return znj;
    }

    public void setZnj(BigDecimal znj) {
        this.znj = znj;
    }

    public BigDecimal getZnjmoney() {
        return znjmoney;
    }

    public void setZnjmoney(BigDecimal znjmoney) {
        this.znjmoney = znjmoney;
    }

    public BigDecimal getZnj_jm() {
        return znj_jm;
    }

    public void setZnj_jm(BigDecimal znj_jm) {
        this.znj_jm = znj_jm;
    }

    public BigDecimal getZnj_owe() {
        return znj_owe;
    }

    public void setZnj_owe(BigDecimal znj_owe) {
        this.znj_owe = znj_owe;
    }

    public BigDecimal getZsfy() {
        return zsfy;
    }

    public void setZsfy(BigDecimal zsfy) {
        this.zsfy = zsfy;
    }

    public BigDecimal getSfl() {
        return sfl;
    }

    public void setSfl(BigDecimal sfl) {
        this.sfl = sfl;
    }

    public BigDecimal getQfl() {
        return qfl;
    }

    public void setQfl(BigDecimal qfl) {
        this.qfl = qfl;
    }

}
