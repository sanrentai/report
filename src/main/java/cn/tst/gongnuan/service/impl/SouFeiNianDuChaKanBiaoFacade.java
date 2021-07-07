/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.service.impl;

import cn.tst.gongnuan.entity.Employee;
import cn.tst.gongnuan.service.dto.SouFeiNianDuChaKanBiaoDTO;
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
public class SouFeiNianDuChaKanBiaoFacade extends AbsFacade<Employee> {

    private static final Logger LOG = Logger.getLogger(SouFeiNianDuChaKanBiaoFacade.class.getName());

    public SouFeiNianDuChaKanBiaoFacade() {
        super(Employee.class);
    }

    public List<SouFeiNianDuChaKanBiaoDTO> getShuJuList(String yearnum, Date date) {
        StringBuilder sb = new StringBuilder();
        sb.append("EXEC	 [dbo].[p_sfndb_type_1] ");
        sb.append(" @paydate = ?1 , ");
        sb.append(" @yearnum = ?2 ");
        Query query = getEntityManager().createNativeQuery(sb.toString(), SouFeiNianDuChaKanBiaoDTO.class);
        query.setParameter(1, date, TemporalType.TIMESTAMP);
        query.setParameter(2, yearnum);
        List<SouFeiNianDuChaKanBiaoDTO> result = query.getResultList();
        return result;
    }

    public List<SouFeiNianDuChaKanBiaoDTO> getShuJuListByCompany(String yearnum,
            Date date, String company) {
        StringBuilder sb = new StringBuilder();
        sb.append("EXEC	 [dbo].[p_sfndb_type_2] ");
        sb.append(" @paydate = ?1 , ");
        sb.append(" @yearnum = ?2, ");
        sb.append(" @company = ?3 ");
        Query query = getEntityManager().createNativeQuery(sb.toString(), SouFeiNianDuChaKanBiaoDTO.class);
        query.setParameter(1, date, TemporalType.TIMESTAMP);
        query.setParameter(2, yearnum);
        query.setParameter(3, company);
        List<SouFeiNianDuChaKanBiaoDTO> result = query.getResultList();
        return result;
    }

    public List<SouFeiNianDuChaKanBiaoDTO> getShuJuListByHuanReZhan(String yearnum,
            Date date, String company, String id) {
        StringBuilder sb = new StringBuilder();
        sb.append("EXEC	 [dbo].[p_sfndb_type_3] ");
        sb.append(" @paydate = ?1 , ");
        sb.append(" @yearnum = ?2, ");
        sb.append(" @company = ?3, ");
        sb.append(" @id = ?4 ");
        Query query = getEntityManager().createNativeQuery(sb.toString(), SouFeiNianDuChaKanBiaoDTO.class);
        query.setParameter(1, date, TemporalType.TIMESTAMP);
        query.setParameter(2, yearnum);
        query.setParameter(3, company);
        query.setParameter(4, id);
        List<SouFeiNianDuChaKanBiaoDTO> result = query.getResultList();
        return result;
    }

    public List<SouFeiNianDuChaKanBiaoDTO> getShuJuListByXiaoQu(String yearnum,
            Date date, String company, String id) {
        StringBuilder sb = new StringBuilder();
        sb.append("EXEC	 [dbo].[p_sfndb_type_4] ");
        sb.append(" @paydate = ?1 , ");
        sb.append(" @yearnum = ?2, ");
        sb.append(" @company = ?3, ");
        sb.append(" @id = ?4 ");
        Query query = getEntityManager().createNativeQuery(sb.toString(), SouFeiNianDuChaKanBiaoDTO.class);
        query.setParameter(1, date, TemporalType.TIMESTAMP);
        query.setParameter(2, yearnum);
        query.setParameter(3, company);
        query.setParameter(4, id);
        List<SouFeiNianDuChaKanBiaoDTO> result = query.getResultList();
        return result;
    }

//    public List<SouFeiNianDuChaKanBiaoDTO> getShuJuListByBuilding(String yearnum, String company, String id) {
//        StringBuilder sb = new StringBuilder();
//        sb.append("EXEC	 [dbo].[p_HYR0001_5] ");
//        sb.append(" @yearnum = ?1, ");
//        sb.append(" @company = ?2, ");
//        sb.append("@id = ?3 ");
//        Query query = getEntityManager().createNativeQuery(sb.toString(), SouFeiNianDuChaKanBiaoDTO.class);
//        query.setParameter(1, yearnum);
//        query.setParameter(2, company);
//        query.setParameter(3, id);
//        List<SouFeiNianDuChaKanBiaoDTO> result = query.getResultList();
//        return result;
//    }
}
