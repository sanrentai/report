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
 * 收费年度查看表DTO
 *
 * @author CaoChun
 */
@Entity
public class SouFeiNianDuChaKanBiaoDTO implements Serializable {

    @Id
    private long id;
    private String name;
    private String hrz;
    private String uptown;
    private String building;
    private String yearnum;
    private String roomtype;
    private BigDecimal area;
    private BigDecimal yjk;
    private BigDecimal jk;
    private BigDecimal jm;
    private BigDecimal yh;
    private BigDecimal owe;
    private BigDecimal sfl;
    private BigDecimal znj;
    

    public SouFeiNianDuChaKanBiaoDTO() {
    }

    public SouFeiNianDuChaKanBiaoDTO(long id, String name, String hrz, String uptown, String building, String yearnum, String roomtype, BigDecimal area, BigDecimal yjk, BigDecimal jk, BigDecimal jm, BigDecimal yh, BigDecimal owe, BigDecimal sfl, BigDecimal znj) {
        this.id = id;
        this.name = name;
        this.hrz = hrz;
        this.uptown = uptown;
        this.building = building;
        this.yearnum = yearnum;
        this.roomtype = roomtype;
        this.area = area;
        this.yjk = yjk;
        this.jk = jk;
        this.jm = jm;
        this.yh = yh;
        this.owe = owe;
        this.sfl = sfl;
        this.znj = znj;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearnum() {
        return yearnum;
    }

    public void setYearnum(String yearnum) {
        this.yearnum = yearnum;
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

    public BigDecimal getZnj() {
        return znj;
    }

    public void setZnj(BigDecimal znj) {
        this.znj = znj;
    }

    public String getHrz() {
        return hrz;
    }

    public void setHrz(String hrz) {
        this.hrz = hrz;
    }

    public String getUptown() {
        return uptown;
    }

    public void setUptown(String uptown) {
        this.uptown = uptown;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

}
