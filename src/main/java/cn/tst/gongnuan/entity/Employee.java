/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "EMPLOYEE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findByEmpIdAndEmpLoginpw", query = "SELECT e FROM Employee e WHERE e.empId = :empId AND e.empLoginpw = :empLoginpw")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "EMP_ID")
    private String empId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "EMP_NAME")
    private String empName;
    @Size(max = 15)
    @Column(name = "EMP_LOGINPW")
    private String empLoginpw;
    @Size(max = 20)
    @Column(name = "EMP_DBNAME")
    private String empDbname;
    @Size(max = 15)
    @Column(name = "EMP_DBPW")
    private String empDbpw;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMP_SUPER")
    private Character empSuper;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "EMP_DATA_ACCESS")
    private String empDataAccess;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMP_LEVEL")
    private Character empLevel;
    @Size(max = 3)
    @Column(name = "EMP_POSID")
    private String empPosid;
    @Column(name = "EMP_LOGON")
    private Character empLogon;
    @Column(name = "EMP_PRINT")
    private Character empPrint;
    @Size(max = 6)
    @Column(name = "EMP_JOB_AGENT")
    private String empJobAgent;
    @Column(name = "EMP_JOB_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date empJobDate;
    @Size(max = 10)
    @Column(name = "bm")
    private String bm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "state")
    private Character state;
    @Size(max = 50)
    @Column(name = "area")
    private String area;
    @Size(max = 10)
    @Column(name = "pq")
    private String pq;
    @Size(max = 10)
    @Column(name = "bmid")
    private String bmid;
    @Column(name = "sgd")
    private Character sgd;
    @Size(max = 1)
    @Column(name = "sp")
    private String sp;
    @Size(max = 1)
    @Column(name = "ifsf")
    private String ifsf;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sf_owexe")
    private BigDecimal sfOwexe;
    @Size(max = 10)
    @Column(name = "sf_year_b")
    private String sfYearB;
    @Size(max = 10)
    @Column(name = "sf_year_e")
    private String sfYearE;
    @Column(name = "log_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logDt;

    public Employee() {
    }

    public Employee(String empId) {
        this.empId = empId;
    }

    public Employee(String empId, String empName, Character empSuper, String empDataAccess, Character empLevel, Character state) {
        this.empId = empId;
        this.empName = empName;
        this.empSuper = empSuper;
        this.empDataAccess = empDataAccess;
        this.empLevel = empLevel;
        this.state = state;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpLoginpw() {
        return empLoginpw;
    }

    public void setEmpLoginpw(String empLoginpw) {
        this.empLoginpw = empLoginpw;
    }

    public String getEmpDbname() {
        return empDbname;
    }

    public void setEmpDbname(String empDbname) {
        this.empDbname = empDbname;
    }

    public String getEmpDbpw() {
        return empDbpw;
    }

    public void setEmpDbpw(String empDbpw) {
        this.empDbpw = empDbpw;
    }

    public Character getEmpSuper() {
        return empSuper;
    }

    public void setEmpSuper(Character empSuper) {
        this.empSuper = empSuper;
    }

    public String getEmpDataAccess() {
        return empDataAccess;
    }

    public void setEmpDataAccess(String empDataAccess) {
        this.empDataAccess = empDataAccess;
    }

    public Character getEmpLevel() {
        return empLevel;
    }

    public void setEmpLevel(Character empLevel) {
        this.empLevel = empLevel;
    }

    public String getEmpPosid() {
        return empPosid;
    }

    public void setEmpPosid(String empPosid) {
        this.empPosid = empPosid;
    }

    public Character getEmpLogon() {
        return empLogon;
    }

    public void setEmpLogon(Character empLogon) {
        this.empLogon = empLogon;
    }

    public Character getEmpPrint() {
        return empPrint;
    }

    public void setEmpPrint(Character empPrint) {
        this.empPrint = empPrint;
    }

    public String getEmpJobAgent() {
        return empJobAgent;
    }

    public void setEmpJobAgent(String empJobAgent) {
        this.empJobAgent = empJobAgent;
    }

    public Date getEmpJobDate() {
        return empJobDate;
    }

    public void setEmpJobDate(Date empJobDate) {
        this.empJobDate = empJobDate;
    }

    public String getBm() {
        return bm;
    }

    public void setBm(String bm) {
        this.bm = bm;
    }

    public Character getState() {
        return state;
    }

    public void setState(Character state) {
        this.state = state;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPq() {
        return pq;
    }

    public void setPq(String pq) {
        this.pq = pq;
    }

    public String getBmid() {
        return bmid;
    }

    public void setBmid(String bmid) {
        this.bmid = bmid;
    }

    public Character getSgd() {
        return sgd;
    }

    public void setSgd(Character sgd) {
        this.sgd = sgd;
    }

    public String getSp() {
        return sp;
    }

    public void setSp(String sp) {
        this.sp = sp;
    }

    public String getIfsf() {
        return ifsf;
    }

    public void setIfsf(String ifsf) {
        this.ifsf = ifsf;
    }

    public BigDecimal getSfOwexe() {
        return sfOwexe;
    }

    public void setSfOwexe(BigDecimal sfOwexe) {
        this.sfOwexe = sfOwexe;
    }

    public String getSfYearB() {
        return sfYearB;
    }

    public void setSfYearB(String sfYearB) {
        this.sfYearB = sfYearB;
    }

    public String getSfYearE() {
        return sfYearE;
    }

    public void setSfYearE(String sfYearE) {
        this.sfYearE = sfYearE;
    }

    public Date getLogDt() {
        return logDt;
    }

    public void setLogDt(Date logDt) {
        this.logDt = logDt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empId != null ? empId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.empId == null && other.empId != null) || (this.empId != null && !this.empId.equals(other.empId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.gongnuan.entity.Employee[ empId=" + empId + " ]";
    }
    
    @Transient
    public boolean isIsLockUser(){
        return  !this.state.equals('0');
    }
    
}
