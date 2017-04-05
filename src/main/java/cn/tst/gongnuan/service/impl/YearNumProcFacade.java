/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.service.impl;

import cn.tst.gongnuan.entity.Employee;
import cn.tst.gongnuan.service.dto.YearNumDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author 曹春
 */
@Stateless
public class YearNumProcFacade  extends AbstractFacade<Employee> {

    private static final Logger LOG = Logger.getLogger(Employee.class.getName());

    public YearNumProcFacade() {
        super(Employee.class);
    }

    public List<YearNumDTO> getShuJu() {
        StringBuilder sb = new StringBuilder();
        sb.append("EXEC	 [dbo].[p_yearnum]");
        Query query = getEntityManager().createNativeQuery(sb.toString(), YearNumDTO.class);
        List<YearNumDTO> result = query.getResultList();
        return result;
    }

}

