/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.service.dto;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 *
 * @author Aaron
 */
@Entity
public class HYR0003DTO implements Serializable {
    @Id
    private int no;
    private String id;
    private String name;
    private BigDecimal area_jz;
    private BigDecimal area;
    private BigDecimal area_jk;
    private BigDecimal area_tg;
    private BigDecimal area_wjk;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
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

    public BigDecimal getArea_jz() {
        return area_jz;
    }

    public void setArea_jz(BigDecimal area_jz) {
        this.area_jz = area_jz;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getArea_jk() {
        return area_jk;
    }

    public void setArea_jk(BigDecimal area_jk) {
        this.area_jk = area_jk;
    }

    public BigDecimal getArea_tg() {
        return area_tg;
    }

    public void setArea_tg(BigDecimal area_tg) {
        this.area_tg = area_tg;
    }

    public BigDecimal getArea_wjk() {
        return area_wjk;
    }

    public void setArea_wjk(BigDecimal area_wjk) {
        this.area_wjk = area_wjk;
    }
}
