/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.service.impl;

import cn.tst.gongnuan.entity.Employee;
import javax.ejb.Stateless;
import cn.tst.gongnuan.service.dto.HYR0004DTO;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author Aaron
 */
@Stateless
public class HYR0004Facade extends AbstractFacade<Employee> {
    private static final Logger LOG = Logger.getLogger(Employee.class.getName());

    public HYR0004Facade() {
        super(Employee.class);
    }
    
    public List<HYR0004DTO> query(String yearnum, String company, String id) {
        StringBuilder sb = new StringBuilder();
        sb.append("EXEC	 [dbo].[p_HYR0004] ");
        sb.append(" @yearnum = ?1, ");
        sb.append(" @company = ?2, ");
        sb.append(" @id = ?3 ");
        Query query = getEntityManager().createNativeQuery(sb.toString(), HYR0004DTO.class);
        query.setParameter(1, yearnum);
        query.setParameter(2, company);
        query.setParameter(3, id);
        List<HYR0004DTO> result = query.getResultList();
        return result;
    }
}
