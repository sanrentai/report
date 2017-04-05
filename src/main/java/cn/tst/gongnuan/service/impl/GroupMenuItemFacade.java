/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.service.impl;

import javax.ejb.Stateless;
import cn.tst.gongnuan.entity.GroupMenuItem;
import java.util.List;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author 曹春
 */
@Stateless
public class GroupMenuItemFacade extends AbstractFacade<GroupMenuItem> {

    private static final Logger LOG = Logger.getLogger(GroupMenuItem.class.getName());

    public GroupMenuItemFacade() {
        super(GroupMenuItem.class);
    }

    public GroupMenuItem findByItemIdAndMenuId(String itemId,String menuId) {
        Query qe = this.getEntityManager().createNamedQuery("GroupMenuItem.findByItemIdAndMenuId");
        qe.setParameter("itemId", itemId);
        qe.setParameter("menuId", menuId);
        List<GroupMenuItem> result = qe.getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

}
