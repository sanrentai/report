/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.service.impl;

import cn.tst.gongnuan.entity.Employee;
import cn.tst.gongnuan.service.dto.XiaoQuDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 * 
 * @author 曹春
 */
@Stateless
public class XiaoQuProcFacade  extends AbstractFacade<Employee> {

    private static final Logger LOG = Logger.getLogger(Employee.class.getName());

    public XiaoQuProcFacade() {
        super(Employee.class);
    }

    public List<XiaoQuDTO> getShuJu(String companyName,String huanReZhan) {
        StringBuilder sb = new StringBuilder();
        sb.append("EXEC	 [dbo].[p_uptown_area]");
        sb.append(" @company = ?1 , ");
        sb.append(" @areaid = ?2 ");
        Query query = getEntityManager().createNativeQuery(sb.toString(), XiaoQuDTO.class);
        query.setParameter(1, companyName);
        query.setParameter(2, huanReZhan);
        List<XiaoQuDTO> result = query.getResultList();
        return result;
    }

}

