/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.entity;

import cn.tst.gongnuan.common.SepE;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
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
@Table(name = "rep_biao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RepBiao.findAll", query = "SELECT r FROM RepBiao r")
    , @NamedQuery(name = "RepBiao.findById", query = "SELECT r FROM RepBiao r WHERE r.id = :id")
    , @NamedQuery(name = "RepBiao.findByBiaoMing", query = "SELECT r FROM RepBiao r WHERE r.biaoMing = :biaoMing AND r.delFlg = :delFlg")
    , @NamedQuery(name = "RepBiao.findByBSql", query = "SELECT r FROM RepBiao r WHERE r.bSql = :bSql")
    , @NamedQuery(name = "RepBiao.findByQuanXianMing", query = "SELECT r FROM RepBiao r WHERE r.quanXianMing = :quanXianMing")
    , @NamedQuery(name = "RepBiao.findByInsRep", query = "SELECT r FROM RepBiao r WHERE r.insRep = :insRep")
    , @NamedQuery(name = "RepBiao.findByInsDate", query = "SELECT r FROM RepBiao r WHERE r.insDate = :insDate")
    , @NamedQuery(name = "RepBiao.findByUpdRep", query = "SELECT r FROM RepBiao r WHERE r.updRep = :updRep")
    , @NamedQuery(name = "RepBiao.findByUpdDate", query = "SELECT r FROM RepBiao r WHERE r.updDate = :updDate")
    , @NamedQuery(name = "RepBiao.findByDelFlg", query = "SELECT r FROM RepBiao r WHERE r.delFlg = :delFlg")
    , @NamedQuery(name = "RepBiao.findByVersion", query = "SELECT r FROM RepBiao r WHERE r.version = :version")})
public class RepBiao extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "biao_ming")
    private String biaoMing;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cn_biao_ming")
    private String cnBiaoMing;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "b_sql")
    private String bSql;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "quan_xian_ming")
    private String quanXianMing;

    public RepBiao() {
    }

    public RepBiao(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBiaoMing() {
        return biaoMing;
    }

    public void setBiaoMing(String biaoMing) {
        this.biaoMing = biaoMing;
    }

    public String getBSql() {
        return bSql;
    }

    public void setBSql(String bSql) {
        this.bSql = bSql;
    }

    public String getQuanXianMing() {
        return quanXianMing;
    }

    public void setQuanXianMing(String quanXianMing) {
        this.quanXianMing = quanXianMing;
    }

    public String getCnBiaoMing() {
        return cnBiaoMing;
    }

    public void setCnBiaoMing(String cnBiaoMing) {
        this.cnBiaoMing = cnBiaoMing;
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
        if (!(object instanceof RepBiao)) {
            return false;
        }
        RepBiao other = (RepBiao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.gongnuan.entity.RepBiao[ id=" + id + " ]";
    }

    //***********************************************************************************************
    //                                  自定义关系的追加
    //***********************************************************************************************
    ///菜单项目
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "biao")
    private List<RepBiaoTiaoJian> tiaoJianList;

    public List<RepBiaoTiaoJian> getTiaoJianList() {
        return tiaoJianList;
    }

    public void setTiaoJianList(List<RepBiaoTiaoJian> tiaoJianList) {
        this.tiaoJianList = tiaoJianList;
    }
//
//    public List<RepBiaoTiaoJian> getCanShuTiaoJianList() {
//        List<RepBiaoTiaoJian> tjList = new ArrayList<>();
//        for (RepBiaoTiaoJian tj : tiaoJianList) {
//            if (SepE.YesOrNo.YES.equals(tj.getIfCs())) {
//                tjList.add(tj);
//            }
//        }
//        return tjList;
//    }
//
//    public List<RepBiaoTiaoJian> getFeiCanShuTiaoJianList() {
//        List<RepBiaoTiaoJian> tjList = new ArrayList<>();
//        for (RepBiaoTiaoJian tj : tiaoJianList) {
//            if (SepE.YesOrNo.NO.equals(tj.getIfCs())) {
//                tjList.add(tj);
//            }
//        }
//        return tjList;
//    }

    public List<RepBiaoTiaoJian> getDateTiaoJianList() {
        List<RepBiaoTiaoJian> tjList = new ArrayList<>();
        for (RepBiaoTiaoJian tj : tiaoJianList) {
            if (SepE.BaoBiaoTiaoJianLeiXing.RI_QI.equals(tj.getTjType())) {
                tjList.add(tj);
            }
        }
        return tjList;
    }

    public List<RepBiaoTiaoJian> getNumberTiaoJianList() {
        List<RepBiaoTiaoJian> tjList = new ArrayList<>();
        for (RepBiaoTiaoJian tj : tiaoJianList) {
            if (SepE.BaoBiaoTiaoJianLeiXing.SHU_ZI.equals(tj.getTjType())) {
                tjList.add(tj);
            }
        }
        return tjList;
    }

    public List<RepBiaoTiaoJian> getStringTiaoJianList() {
        List<RepBiaoTiaoJian> tjList = new ArrayList<>();
        for (RepBiaoTiaoJian tj : tiaoJianList) {
            if (SepE.BaoBiaoTiaoJianLeiXing.WEN_BEN.equals(tj.getTjType())) {
                tjList.add(tj);
            }
        }
        return tjList;
    }

    public List<RepBiaoTiaoJian> getMeiJuTiaoJianList() {
        List<RepBiaoTiaoJian> tjList = new ArrayList<>();
        for (RepBiaoTiaoJian tj : tiaoJianList) {
            if (SepE.BaoBiaoTiaoJianLeiXing.MEI_JU.equals(tj.getTjType())) {
                tjList.add(tj);
            }
        }
        return tjList;
    }

}
