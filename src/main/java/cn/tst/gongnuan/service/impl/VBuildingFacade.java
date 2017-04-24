/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.service.impl;

import javax.ejb.Stateless;
import cn.tst.gongnuan.entity.VBuilding;
import java.util.List;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author 曹春
 */
@Stateless
public class VBuildingFacade extends AbstractFacade<VBuilding> {

    private static final Logger LOG = Logger.getLogger(VBuilding.class.getName());

    public VBuildingFacade() {
        super(VBuilding.class);
    }
    
    public List<VBuilding> getBuildingByCompanName(String companyName){
        Query query = this.getEntityManager().createNamedQuery("VBuilding.findByCompanyName");
        query.setParameter("companyName", companyName);
        return query.getResultList();
    }

}
