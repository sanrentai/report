/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.service.impl;

import cn.tst.gongnuan.entity.Employee;
import cn.tst.gongnuan.service.dto.HySouFeiMingXiDTO;
import cn.tst.gongnuan.service.dto.XmShouFeiQingKuangBiaoDTO;
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
public class XmShouFeiQingKuangBiaoFacade extends AbstractFacade<Employee> {

    private static final Logger LOG = Logger.getLogger(Employee.class.getName());

    public XmShouFeiQingKuangBiaoFacade() {
        super(Employee.class);
    }

    public List<XmShouFeiQingKuangBiaoDTO> getShuJu(String yearnum, Date ksdate, Date jsdate) {
        StringBuilder sb = new StringBuilder();
        sb.append("EXEC	 [dbo].[p_sfqkb]");
        sb.append(" @yearnum = ?1, ");
        sb.append(" @ksdate = ?2, ");
        sb.append(" @jsdate = ?3 ");
        Query query = getEntityManager().createNativeQuery(sb.toString(), XmShouFeiQingKuangBiaoDTO.class);
        query.setParameter(1, yearnum);
        query.setParameter(2, ksdate, TemporalType.DATE);
        query.setParameter(3, jsdate, TemporalType.DATE);
        List<XmShouFeiQingKuangBiaoDTO> result = query.getResultList();
        return result;
    }

}
