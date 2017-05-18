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
 * 各公司年度报停汇总表
 *
 * @author CaoChun
 */
@Entity
public class HYR0006DTO implements Serializable {

    @Id
    private BigDecimal no;
    private String name;
    private String roomtype;
    private BigDecimal area_tg;
    private BigDecimal yjk_tg;
    private BigDecimal jk_tg;
    private BigDecimal owe_tg;
    private BigDecimal hs;

    public HYR0006DTO() {
    }

    public HYR0006DTO(BigDecimal no, String name, String roomtype, BigDecimal area_tg, BigDecimal yjk_tg, BigDecimal jk_tg, BigDecimal owe_tg, BigDecimal hs) {
        this.no = no;
        this.name = name;
        this.roomtype = roomtype;
        this.area_tg = area_tg;
        this.yjk_tg = yjk_tg;
        this.jk_tg = jk_tg;
        this.owe_tg = owe_tg;
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

    public BigDecimal getArea_tg() {
        return area_tg;
    }

    public void setArea_tg(BigDecimal area_tg) {
        this.area_tg = area_tg;
    }

    public BigDecimal getYjk_tg() {
        return yjk_tg;
    }

    public void setYjk_tg(BigDecimal yjk_tg) {
        this.yjk_tg = yjk_tg;
    }

    public BigDecimal getJk_tg() {
        return jk_tg;
    }

    public void setJk_tg(BigDecimal jk_tg) {
        this.jk_tg = jk_tg;
    }

    public BigDecimal getOwe_tg() {
        return owe_tg;
    }

    public void setOwe_tg(BigDecimal owe_tg) {
        this.owe_tg = owe_tg;
    }

    public BigDecimal getHs() {
        return hs;
    }

    public void setHs(BigDecimal hs) {
        this.hs = hs;
    }

}
