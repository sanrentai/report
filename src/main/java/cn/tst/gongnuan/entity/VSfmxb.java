/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "v_sfmxb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VSfmxb.findAll", query = "SELECT v FROM VSfmxb v")
    , @NamedQuery(name = "VSfmxb.findByName", query = "SELECT v FROM VSfmxb v WHERE v.name = :name")
    , @NamedQuery(name = "VSfmxb.findByArea", query = "SELECT v FROM VSfmxb v WHERE v.area = :area")
    , @NamedQuery(name = "VSfmxb.findByYjk", query = "SELECT v FROM VSfmxb v WHERE v.yjk = :yjk")
    , @NamedQuery(name = "VSfmxb.findByJk", query = "SELECT v FROM VSfmxb v WHERE v.jk = :jk")
    , @NamedQuery(name = "VSfmxb.findBySfl", query = "SELECT v FROM VSfmxb v WHERE v.sfl = :sfl")})
public class VSfmxb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "name")
    @Id
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "area")
    private BigDecimal area;
    @Column(name = "yjk")
    private BigDecimal yjk;
    @Column(name = "jk")
    private BigDecimal jk;
    @Column(name = "sfl")
    private BigDecimal sfl;

    public VSfmxb() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public BigDecimal getSfl() {
        return sfl;
    }

    public void setSfl(BigDecimal sfl) {
        this.sfl = sfl;
    }
    
}
