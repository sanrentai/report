/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.entity;

import cn.tst.gongnuan.common.SepE;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "rep_biao_tiao_jian")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RepBiaoTiaoJian.findAll", query = "SELECT r FROM RepBiaoTiaoJian r")
    , @NamedQuery(name = "RepBiaoTiaoJian.findById", query = "SELECT r FROM RepBiaoTiaoJian r WHERE r.id = :id")
    , @NamedQuery(name = "RepBiaoTiaoJian.findByBiaoId", query = "SELECT r FROM RepBiaoTiaoJian r WHERE r.biaoId = :biaoId")
    , @NamedQuery(name = "RepBiaoTiaoJian.findByTitle", query = "SELECT r FROM RepBiaoTiaoJian r WHERE r.title = :title")
    , @NamedQuery(name = "RepBiaoTiaoJian.findByCnTitle", query = "SELECT r FROM RepBiaoTiaoJian r WHERE r.cnTitle = :cnTitle")
    , @NamedQuery(name = "RepBiaoTiaoJian.findByTjType", query = "SELECT r FROM RepBiaoTiaoJian r WHERE r.tjType = :tjType")
    , @NamedQuery(name = "RepBiaoTiaoJian.findByInsRep", query = "SELECT r FROM RepBiaoTiaoJian r WHERE r.insRep = :insRep")
    , @NamedQuery(name = "RepBiaoTiaoJian.findByInsDate", query = "SELECT r FROM RepBiaoTiaoJian r WHERE r.insDate = :insDate")
    , @NamedQuery(name = "RepBiaoTiaoJian.findByUpdRep", query = "SELECT r FROM RepBiaoTiaoJian r WHERE r.updRep = :updRep")
    , @NamedQuery(name = "RepBiaoTiaoJian.findByUpdDate", query = "SELECT r FROM RepBiaoTiaoJian r WHERE r.updDate = :updDate")
    , @NamedQuery(name = "RepBiaoTiaoJian.findByDelFlg", query = "SELECT r FROM RepBiaoTiaoJian r WHERE r.delFlg = :delFlg")
    , @NamedQuery(name = "RepBiaoTiaoJian.findByVersion", query = "SELECT r FROM RepBiaoTiaoJian r WHERE r.version = :version")})
public class RepBiaoTiaoJian extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "biao_id")
    private int biaoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "cn_title")
    private String cnTitle;
    @NotNull
    @Column(name = "tj_type")
    private Integer tjType;
    @Size(max = 2147483647)
    @Column(name = "mj_sql")
    private String mjSql;
    @Size(max = 2147483647)
    @Column(name = "lj_sql")
    private String ljSql;
    @Size(max = 2147483647)
    @Column(name = "gl")
    private String gl;

    public RepBiaoTiaoJian() {
    }

    public RepBiaoTiaoJian(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getBiaoId() {
        return biaoId;
    }

    public void setBiaoId(int biaoId) {
        this.biaoId = biaoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCnTitle() {
        return cnTitle;
    }

    public void setCnTitle(String cnTitle) {
        this.cnTitle = cnTitle;
    }

    public SepE.BaoBiaoTiaoJianLeiXing getTjType() {
        if (tjType == null) {
            return SepE.BaoBiaoTiaoJianLeiXing.WEN_BEN;
        }
        return SepE.BaoBiaoTiaoJianLeiXing.parse(tjType);
    }

    public void setTjType(SepE.BaoBiaoTiaoJianLeiXing tjType) {
        this.tjType = tjType.getValue();
    }

    public String getGl() {
        return gl;
    }

    public void setGl(String gl) {
        this.gl = gl;
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
        if (!(object instanceof RepBiaoTiaoJian)) {
            return false;
        }
        RepBiaoTiaoJian other = (RepBiaoTiaoJian) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.gongnuan.entity.RepBiaoTiaoJian[ id=" + id + " ]";
    }

    //***********************************************************************************************
    //                                  自定义关系的追加
    //***********************************************************************************************
    /// 表
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
        @JoinColumn(name = "biao_id", referencedColumnName = "id", insertable = false, updatable = false)
        ,@JoinColumn(name = "del_flg", referencedColumnName = "del_flg", insertable = false, updatable = false)
    })
    private RepBiao biao;

    public RepBiao getBiao() {
        return biao;
    }

    public void setBiao(RepBiao biao) {
        this.biao = biao;
    }

    public String getMjSql() {
        return mjSql;
    }

    public void setMjSql(String mjSql) {
        this.mjSql = mjSql;
    }

    public String getLjSql() {
        return ljSql;
    }

    public void setLjSql(String ljSql) {
        this.ljSql = ljSql;
    }

}
