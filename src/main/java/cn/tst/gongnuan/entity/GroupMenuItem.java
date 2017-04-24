/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "group_menu_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GroupMenuItem.findAll", query = "SELECT g FROM GroupMenuItem g")
    , @NamedQuery(name = "GroupMenuItem.findByItemId", query = "SELECT g FROM GroupMenuItem g WHERE g.itemId = :itemId ")
    , @NamedQuery(name = "GroupMenuItem.findByItemName", query = "SELECT g FROM GroupMenuItem g WHERE g.itemName = :itemName")
    , @NamedQuery(name = "GroupMenuItem.findByItemIdAndMenuId", query = "SELECT g FROM GroupMenuItem g WHERE g.itemId = :itemId AND g.menuId = :menuId")})
public class GroupMenuItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "item_id")
    private String itemId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "item_name")
    private String itemName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "menu_id")
    private String menuId;

    public GroupMenuItem() {
    }

    public GroupMenuItem(String itemId) {
        this.itemId = itemId;
    }

    public GroupMenuItem(String itemId, String itemName, String menuId) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.menuId = menuId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupMenuItem)) {
            return false;
        }
        GroupMenuItem other = (GroupMenuItem) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.gongnuan.entity.GroupMenuItem[ itemId=" + itemId + " ]";
    }
    
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_id", referencedColumnName = "menu_id", insertable = false, updatable = false)
    private GroupMenu menu;

    public GroupMenu getMenu() {
        return menu;
    }

    public void setMenu(GroupMenu menu) {
        this.menu = menu;
    }
    
    
    
}
