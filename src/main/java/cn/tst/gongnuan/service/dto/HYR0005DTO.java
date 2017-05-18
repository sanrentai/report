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
 * 采暖费年度报表，即系统里的应收采暖费汇总
 *
 * @author CaoChun
 */
@Entity
public class HYR0005DTO implements Serializable {

    @Id
    private BigDecimal no;
    private String name;
    private String roomtype;
    private BigDecimal area;
    private BigDecimal area_gn;
    private BigDecimal area_tg;
    private BigDecimal yjk;
    private BigDecimal yjk_gn;
    private BigDecimal yjk_tg;
    private BigDecimal jk;
    private BigDecimal jk_gn;
    private BigDecimal jk_tg;
    private BigDecimal owe;
    private BigDecimal owe_gn;
    private BigDecimal owe_tg;
    private BigDecimal gratis1;
    private BigDecimal znjmoney;
    private BigDecimal zsfy;
    private BigDecimal sfl;
    private BigDecimal hs;

    public HYR0005DTO() {
    }

    public HYR0005DTO(BigDecimal no, String name, String roomtype, BigDecimal area, BigDecimal area_gn, BigDecimal area_tg, BigDecimal yjk, BigDecimal yjk_gn, BigDecimal yjk_tg, BigDecimal jk, BigDecimal jk_gn, BigDecimal jk_tg, BigDecimal owe, BigDecimal owe_gn, BigDecimal owe_tg, BigDecimal gratis1, BigDecimal znjmoney, BigDecimal zsfy, BigDecimal sfl, BigDecimal hs) {
        this.no = no;
        this.name = name;
        this.roomtype = roomtype;
        this.area = area;
        this.area_gn = area_gn;
        this.area_tg = area_tg;
        this.yjk = yjk;
        this.yjk_gn = yjk_gn;
        this.yjk_tg = yjk_tg;
        this.jk = jk;
        this.jk_gn = jk_gn;
        this.jk_tg = jk_tg;
        this.owe = owe;
        this.owe_gn = owe_gn;
        this.owe_tg = owe_tg;
        this.gratis1 = gratis1;
        this.znjmoney = znjmoney;
        this.zsfy = zsfy;
        this.sfl = sfl;
        this.hs = hs;
    }

    public BigDecimal getNo() {
        return no;
    }

    public void setNo(BigDecimal no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getArea_gn() {
        return area_gn;
    }

    public void setArea_gn(BigDecimal area_gn) {
        this.area_gn = area_gn;
    }

    public BigDecimal getArea_tg() {
        return area_tg;
    }

    public void setArea_tg(BigDecimal area_tg) {
        this.area_tg = area_tg;
    }

    public BigDecimal getYjk() {
        return yjk;
    }

    public void setYjk(BigDecimal yjk) {
        this.yjk = yjk;
    }

    public BigDecimal getYjk_gn() {
        return yjk_gn;
    }

    public void setYjk_gn(BigDecimal yjk_gn) {
        this.yjk_gn = yjk_gn;
    }

    public BigDecimal getYjk_tg() {
        return yjk_tg;
    }

    public void setYjk_tg(BigDecimal yjk_tg) {
        this.yjk_tg = yjk_tg;
    }

    public BigDecimal getJk() {
        return jk;
    }

    public void setJk(BigDecimal jk) {
        this.jk = jk;
    }

    public BigDecimal getJk_gn() {
        return jk_gn;
    }

    public void setJk_gn(BigDecimal jk_gn) {
        this.jk_gn = jk_gn;
    }

    public BigDecimal getJk_tg() {
        return jk_tg;
    }

    public void setJk_tg(BigDecimal jk_tg) {
        this.jk_tg = jk_tg;
    }

    public BigDecimal getOwe() {
        return owe;
    }

    public void setOwe(BigDecimal owe) {
        this.owe = owe;
    }

    public BigDecimal getOwe_gn() {
        return owe_gn;
    }

    public void setOwe_gn(BigDecimal owe_gn) {
        this.owe_gn = owe_gn;
    }

    public BigDecimal getOwe_tg() {
        return owe_tg;
    }

    public void setOwe_tg(BigDecimal owe_tg) {
        this.owe_tg = owe_tg;
    }

    public BigDecimal getGratis1() {
        return gratis1;
    }

    public void setGratis1(BigDecimal gratis1) {
        this.gratis1 = gratis1;
    }

    public BigDecimal getZnjmoney() {
        return znjmoney;
    }

    public void setZnjmoney(BigDecimal znjmoney) {
        this.znjmoney = znjmoney;
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

    public BigDecimal getHs() {
        return hs;
    }

    public void setHs(BigDecimal hs) {
        this.hs = hs;
    }
    
}
