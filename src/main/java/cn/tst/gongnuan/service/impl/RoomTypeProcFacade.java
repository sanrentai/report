/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.service.impl;

import cn.tst.gongnuan.entity.Employee;
import cn.tst.gongnuan.service.dto.RoomTypeDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 * 
 * @author 曹春
 */
@Stateless
public class RoomTypeProcFacade  extends AbstractFacade<Employee> {

    private static final Logger LOG = Logger.getLogger(Employee.class.getName());

    public RoomTypeProcFacade() {
        super(Employee.class);
    }

    public List<RoomTypeDTO> getShuJu(String companyName) {
        StringBuilder sb = new StringBuilder();
        sb.append("EXEC	 [dbo].[p_roomtype_company]");
        sb.append(" @company = ?1 ");
        Query query = getEntityManager().createNativeQuery(sb.toString(), RoomTypeDTO.class);
        query.setParameter(1, companyName);
        List<RoomTypeDTO> result = query.getResultList();
        return result;
    }

}

