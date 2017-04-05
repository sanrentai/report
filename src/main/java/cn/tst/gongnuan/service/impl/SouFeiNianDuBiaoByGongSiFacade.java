/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.service.impl;

import cn.tst.gongnuan.entity.Employee;
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
public class SouFeiNianDuBiaoByGongSiFacade  extends AbstractFacade<Employee> {

    private static final Logger LOG = Logger.getLogger(Employee.class.getName());

    public SouFeiNianDuBiaoByGongSiFacade() {
        super(Employee.class);
    }

    public List<SouFeiNianDuBiaoByGongSiDTO> getSouFeiNianDuBiaoByGongSiList(String companyName,Date payDate) {
        StringBuilder sb = new StringBuilder();
        sb.append("EXEC	 [dbo].[p_sfndb_c] ");
        sb.append(" @company = ?2 , ");
        sb.append(" @paydate = ?1 ");
        Query query = getEntityManager().createNativeQuery(sb.toString(), SouFeiNianDuBiaoByGongSiDTO.class);
        query.setParameter(1, payDate, TemporalType.DATE);
        query.setParameter(2, companyName);
        List<SouFeiNianDuBiaoByGongSiDTO> result = query.getResultList();
        return result;
    }

}

