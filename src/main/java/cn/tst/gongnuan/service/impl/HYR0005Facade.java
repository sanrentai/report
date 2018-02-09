/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.service.impl;

import cn.tst.gongnuan.entity.Employee;
import cn.tst.gongnuan.service.dto.HYR0005DTO;
import cn.tst.gongnuan.service.dto.SouFeiNianDuBiaoByGongSiDTO;
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
public class HYR0005Facade extends AbsFacade<Employee> {

    private static final Logger LOG = Logger.getLogger(Employee.class.getName());

    public HYR0005Facade() {
        super(Employee.class);
    }

    public List<HYR0005DTO> getShuJuList(String yearnum) {
        StringBuilder sb = new StringBuilder();
        sb.append("EXEC	 [dbo].[p_HYR0005] ");
        sb.append(" @yearnum = ?1 ");
        Query query = getEntityManager().createNativeQuery(sb.toString(), HYR0005DTO.class);
        query.setParameter(1, yearnum);
        List<HYR0005DTO> result = query.getResultList();
        return result;
    }

}
