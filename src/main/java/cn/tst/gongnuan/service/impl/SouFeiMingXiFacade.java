/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.service.impl;

import cn.tst.gongnuan.entity.Employee;
import cn.tst.gongnuan.service.dto.SouFeiMingXiDTO;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import org.apache.log4j.Logger;

/**
 *
 * @author 曹春
 */
@Stateless
public class SouFeiMingXiFacade  extends AbstractFacade<Employee> {

    private static final Logger LOG = Logger.getLogger(Employee.class.getName());

    public SouFeiMingXiFacade() {
        super(Employee.class);
    }

    public List<SouFeiMingXiDTO> getShuJu(Date payDate) {
        StringBuilder sb = new StringBuilder();
        sb.append("EXEC	 [dbo].[p_sfmxb]");
        sb.append(" @paydate = ?1 ");
        Query query = getEntityManager().createNativeQuery(sb.toString(), SouFeiMingXiDTO.class);
        query.setParameter(1, payDate, TemporalType.DATE);
        List<SouFeiMingXiDTO> result = query.getResultList();
        return result;
    }

}

