/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.service.impl;

import cn.tst.gongnuan.entity.Employee;
import cn.tst.gongnuan.service.dto.HySouFeiNianDuBiaoByGongSiDTO;
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
public class HySouFeiNianDuBiaoByGongSiFacade  extends AbstractFacade<Employee> {

    private static final Logger LOG = Logger.getLogger(Employee.class.getName());

    public HySouFeiNianDuBiaoByGongSiFacade() {
        super(Employee.class);
    }

    public List<HySouFeiNianDuBiaoByGongSiDTO> getSouFeiNianDuBiaoByGongSiList(String companyName,String yearnum) {
        StringBuilder sb = new StringBuilder();
        sb.append("EXEC	 [dbo].[p_sfndb_c_n] ");
        sb.append(" @company = ?2 , ");
        sb.append(" @yearnum = ?1 ");
        Query query = getEntityManager().createNativeQuery(sb.toString(), HySouFeiNianDuBiaoByGongSiDTO.class);
        query.setParameter(1, yearnum);
        query.setParameter(2, companyName);
        List<HySouFeiNianDuBiaoByGongSiDTO> result = query.getResultList();
        return result;
    }

}
