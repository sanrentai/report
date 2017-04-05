/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "group_menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GroupMenu.findAll", query = "SELECT g FROM GroupMenu g")
    , @NamedQuery(name = "GroupMenu.findByMenuId", query = "SELECT g FROM GroupMenu g WHERE g.menuId = :menuId")
    , @NamedQuery(name = "GroupMenu.findByMenuName", query = "SELECT g FROM GroupMenu g WHERE g.menuName = :menuName")})
public class GroupMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "menu_id")
    private String menuId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "menu_name")
    private String menuName;

    public GroupMenu() {
    }

    public GroupMenu(String menuId) {
        this.menuId = menuId;
    }

    public GroupMenu(String menuId, String menuName) {
        this.menuId = menuId;
        this.menuName = menuName;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menuId != null ? menuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupMenu)) {
            return false;
        }
        GroupMenu other = (GroupMenu) object;
        if ((this.menuId == null && other.menuId != null) || (this.menuId != null && !this.menuId.equals(other.menuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.gongnuan.entity.GroupMenu[ menuId=" + menuId + " ]";
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "menu")
    private List<GroupMenuItem> menuItems;

    public void setMenuItems(List<GroupMenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public List<GroupMenuItem> getMenuItems() {
        return menuItems;
    }

}
