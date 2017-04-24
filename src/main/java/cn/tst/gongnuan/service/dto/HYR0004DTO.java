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
public class HYR0004DTO implements Serializable {
    @Id
    private int no;
    private String unit;
    private String ownerid;
    private String hrz;
    private String xiaoqu;
    private String louhao;
    private String roomname;
    private String name;
    private String tzdate;
    private String area_o;
    private String area_n;
    private String roomtype_o;
    private String roomtype_n;
    private String tg_o;
    private String tg_n;
    private String jcoper;
    private String cljg;
    private String appendix;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(String ownerid) {
        this.ownerid = ownerid;
    }

    public String getHrz() {
        return hrz;
    }

    public void setHrz(String hrz) {
        this.hrz = hrz;
    }

    public String getXiaoqu() {
        return xiaoqu;
    }

    public void setXiaoqu(String xiaoqu) {
        this.xiaoqu = xiaoqu;
    }

    public String getLouhao() {
        return louhao;
    }

    public void setLouhao(String louhao) {
        this.louhao = louhao;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTzdate() {
        return tzdate;
    }

    public void setTzdate(String tzdate) {
        this.tzdate = tzdate;
    }

    public String getArea_o() {
        return area_o;
    }

    public void setArea_o(String area_o) {
        this.area_o = area_o;
    }

    public String getArea_n() {
        return area_n;
    }

    public void setArea_n(String area_n) {
        this.area_n = area_n;
    }

    public String getRoomtype_o() {
        return roomtype_o;
    }

    public void setRoomtype_o(String roomtype_o) {
        this.roomtype_o = roomtype_o;
    }

    public String getRoomtype_n() {
        return roomtype_n;
    }

    public void setRoomtype_n(String roomtype_n) {
        this.roomtype_n = roomtype_n;
    }

    public String getTg_o() {
        return tg_o;
    }

    public void setTg_o(String tg_o) {
        this.tg_o = tg_o;
    }

    public String getTg_n() {
        return tg_n;
    }

    public void setTg_n(String tg_n) {
        this.tg_n = tg_n;
    }

    public String getJcoper() {
        return jcoper;
    }

    public void setJcoper(String jcoper) {
        this.jcoper = jcoper;
    }

    public String getCljg() {
        return cljg;
    }

    public void setCljg(String cljg) {
        this.cljg = cljg;
    }

    public String getAppendix() {
        return appendix;
    }

    public void setAppendix(String appendix) {
        this.appendix = appendix;
    }
}
