/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.service.impl;

import cn.tst.gongnuan.entity.Employee;
import javax.ejb.Stateless;
import cn.tst.gongnuan.service.dto.HYR0002DTO;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author Aaron
 */
@Stateless
public class HYR0002Facade extends AbstractFacade<Employee> {
    private static final Logger LOG = Logger.getLogger(Employee.class.getName());

    public HYR0002Facade() {
        super(Employee.class);
    }
    
    public List<HYR0002DTO> query(Date payDate, Date startDate, Date endDate) {
        StringBuilder sb = new StringBuilder();
        sb.append("EXEC	 [dbo].[p_HYR0002] ");
        sb.append(" @paydate = ?1, ");
        sb.append(" @ksdate = ?2, ");
        sb.append(" @jsdate = ?3 ");
        Query query = getEntityManager().createNativeQuery(sb.toString(), HYR0002DTO.class);
        query.setParameter(1, payDate);
        query.setParameter(2, startDate);
        query.setParameter(3, endDate);
        List<HYR0002DTO> result = query.getResultList();
        return result;
    }
}
