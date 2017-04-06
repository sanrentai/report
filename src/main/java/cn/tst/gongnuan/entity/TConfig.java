/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "t_config")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TConfig.findAll", query = "SELECT t FROM TConfig t")
    , @NamedQuery(name = "TConfig.findById", query = "SELECT t FROM TConfig t WHERE t.id = :id")
    , @NamedQuery(name = "TConfig.findByTitle", query = "SELECT t FROM TConfig t WHERE t.title = :title")
    , @NamedQuery(name = "TConfig.findByYearnum", query = "SELECT t FROM TConfig t WHERE t.yearnum = :yearnum")
    , @NamedQuery(name = "TConfig.findByStartdate", query = "SELECT t FROM TConfig t WHERE t.startdate = :startdate")
    , @NamedQuery(name = "TConfig.findByEnddate", query = "SELECT t FROM TConfig t WHERE t.enddate = :enddate")})
public class TConfig implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "yearnum")
    private String yearnum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "startdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;

    public TConfig() {
    }

    public TConfig(Integer id) {
        this.id = id;
    }

    public TConfig(Integer id, String title, String yearnum, Date startdate, Date enddate) {
        this.id = id;
        this.title = title;
        this.yearnum = yearnum;
        this.startdate = startdate;
        this.enddate = enddate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYearnum() {
        return yearnum;
    }

    public void setYearnum(String yearnum) {
        this.yearnum = yearnum;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TConfig)) {
            return false;
        }
        TConfig other = (TConfig) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.gongnuan.entity.TConfig[ id=" + id + " ]";
    }
    
}
