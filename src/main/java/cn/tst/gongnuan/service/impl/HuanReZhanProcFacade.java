/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.service.impl;

import cn.tst.gongnuan.entity.Employee;
import cn.tst.gongnuan.service.dto.HuanReZhanDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 * 
 * @author 曹春
 */
@Stateless
public class HuanReZhanProcFacade  extends AbstractFacade<Employee> {

    private static final Logger LOG = Logger.getLogger(Employee.class.getName());

    public HuanReZhanProcFacade() {
        super(Employee.class);
    }

    public List<HuanReZhanDTO> getShuJu(String companyName) {
        StringBuilder sb = new StringBuilder();
        sb.append("EXEC	 [dbo].[p_area_company]");
        sb.append(" @company = ?1 ");
        Query query = getEntityManager().createNativeQuery(sb.toString(), HuanReZhanDTO.class);
        query.setParameter(1, companyName);
        List<HuanReZhanDTO> result = query.getResultList();
        return result;
    }

}

