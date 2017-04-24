/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.service.impl;

import cn.tst.gongnuan.entity.Employee;
import cn.tst.gongnuan.service.dto.HYR0001DTO;
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
public class HYR0001Facade extends AbstractFacade<Employee> {

    private static final Logger LOG = Logger.getLogger(Employee.class.getName());

    public HYR0001Facade() {
        super(Employee.class);
    }

    public List<HYR0001DTO> getShuJuList(String yearnum) {
        StringBuilder sb = new StringBuilder();
        sb.append("EXEC	 [dbo].[p_HYR0001_1] ");
        sb.append(" @yearnum = ?1 ");
        Query query = getEntityManager().createNativeQuery(sb.toString(), HYR0001DTO.class);
        query.setParameter(1, yearnum);
        List<HYR0001DTO> result = query.getResultList();
        return result;
    }

    public List<HYR0001DTO> getShuJuListByCompany(String yearnum, String company) {
        StringBuilder sb = new StringBuilder();
        sb.append("EXEC	 [dbo].[p_HYR0001_2] ");
        sb.append(" @yearnum = ?1, ");
        sb.append(" @company = ?2 ");
        Query query = getEntityManager().createNativeQuery(sb.toString(), HYR0001DTO.class);
        query.setParameter(1, yearnum);
        query.setParameter(2, company);
        List<HYR0001DTO> result = query.getResultList();
        return result;
    }

    public List<HYR0001DTO> getShuJuListByHuanReZhan(String yearnum, String company, String id) {
        StringBuilder sb = new StringBuilder();
        sb.append("EXEC	 [dbo].[p_HYR0001_3] ");
        sb.append(" @yearnum = ?1, ");
        sb.append(" @company = ?2, ");
        sb.append("@id = ?3 ");
        Query query = getEntityManager().createNativeQuery(sb.toString(), HYR0001DTO.class);
        query.setParameter(1, yearnum);
        query.setParameter(2, company);
        query.setParameter(3, id);
        List<HYR0001DTO> result = query.getResultList();
        return result;
    }

    public List<HYR0001DTO> getShuJuListByXiaoQu(String yearnum, String company, String id) {
        StringBuilder sb = new StringBuilder();
        sb.append("EXEC	 [dbo].[p_HYR0001_4] ");
        sb.append(" @yearnum = ?1, ");
        sb.append(" @company = ?2, ");
        sb.append("@id = ?3 ");
        Query query = getEntityManager().createNativeQuery(sb.toString(), HYR0001DTO.class);
        query.setParameter(1, yearnum);
        query.setParameter(2, company);
        query.setParameter(3, id);
        List<HYR0001DTO> result = query.getResultList();
        return result;
    }

    public List<HYR0001DTO> getShuJuListByBuilding(String yearnum, String company, String id) {
        StringBuilder sb = new StringBuilder();
        sb.append("EXEC	 [dbo].[p_HYR0001_5] ");
        sb.append(" @yearnum = ?1, ");
        sb.append(" @company = ?2, ");
        sb.append("@id = ?3 ");
        Query query = getEntityManager().createNativeQuery(sb.toString(), HYR0001DTO.class);
        query.setParameter(1, yearnum);
        query.setParameter(2, company);
        query.setParameter(3, id);
        List<HYR0001DTO> result = query.getResultList();
        return result;
    }
}
