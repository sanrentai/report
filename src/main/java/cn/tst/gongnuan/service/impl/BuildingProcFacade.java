/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.service.impl;

import cn.tst.gongnuan.entity.Employee;
import cn.tst.gongnuan.service.dto.BuildingDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author 曹春
 */
@Stateless
public class BuildingProcFacade extends AbstractFacade<Employee> {

    private static final Logger LOG = Logger.getLogger(Employee.class.getName());

    public BuildingProcFacade() {
        super(Employee.class);
    }

    public List<BuildingDTO> getShuJu(String companyName) {
        StringBuilder sb = new StringBuilder();
        sb.append("EXEC	 [dbo].[p_building]");
        sb.append(" @company = ?1 ");
        Query query = getEntityManager().createNativeQuery(sb.toString(), BuildingDTO.class);
        query.setParameter(1, companyName);
        List<BuildingDTO> result = query.getResultList();
        return result;
    }

    public List<BuildingDTO> getShuJuByXiaoQu(String companyName,String xiaoQu) {
        StringBuilder sb = new StringBuilder();
        sb.append("EXEC	 [dbo].[p_building_uptown]");
        sb.append(" @company = ?1 , ");
        sb.append(" @uptownid = ?2 ");
        Query query = getEntityManager().createNativeQuery(sb.toString(), BuildingDTO.class);
        query.setParameter(1, companyName);
        query.setParameter(2, xiaoQu);
        List<BuildingDTO> result = query.getResultList();
        return result;
    }

}
