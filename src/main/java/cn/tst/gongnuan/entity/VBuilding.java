/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "v_building")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VBuilding.findAll", query = "SELECT v FROM VBuilding v")
    , @NamedQuery(name = "VBuilding.findById", query = "SELECT v FROM VBuilding v WHERE v.id = :id")
    , @NamedQuery(name = "VBuilding.findByCompanyName", query = "SELECT v FROM VBuilding v WHERE v.companyName = :companyName")
    , @NamedQuery(name = "VBuilding.findByBuildingId", query = "SELECT v FROM VBuilding v WHERE v.buildingId = :buildingId")
    , @NamedQuery(name = "VBuilding.findByBuildingName", query = "SELECT v FROM VBuilding v WHERE v.buildingName = :buildingName")})
public class VBuilding implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private BigInteger id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "companyName")
    private String companyName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "buildingId")
    private String buildingId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "buildingName")
    private String buildingName;

    public VBuilding() {
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }
    @ManyToOne
    @JoinColumn(name = "companyName", referencedColumnName = "name", insertable = false, updatable = false)
    private VCompany company;

    public VCompany getCompany() {
        return company;
    }

    public void setCompany(VCompany company) {
        this.company = company;
    }
    
    
    
}
