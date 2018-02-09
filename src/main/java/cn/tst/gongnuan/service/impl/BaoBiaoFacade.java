/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.service.impl;

import cn.tst.gongnuan.entity.Employee;
import cn.tst.gongnuan.entity.RepBiao;
import cn.tst.gongnuan.entity.RepBiaoTiaoJian;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.config.ResultType;
import org.eclipse.persistence.internal.sessions.ArrayRecord;

/**
 *
 * @author 曹春
 */
@Stateless
public class BaoBiaoFacade extends AbsFacade<Employee> {
    
    private static final Logger LOG = Logger.getLogger(BaoBiaoFacade.class.getName());
    
    public BaoBiaoFacade() {
        super(Employee.class);
    }
    
    public List<ArrayRecord> getShuJuList(RepBiao biao, Map tjMap) {

//        LOG.info(biao.getBSql());
//        LOG.info(tjMap);
        StringBuilder sb = new StringBuilder(biao.getBSql());
        List<RepBiaoTiaoJian> tiaoJianList = biao.getTiaoJianList();
        for (int i = 1; i <= tiaoJianList.size(); i++) {
            if (tjMap.get(tiaoJianList.get(i - 1).getTitle()) != null) {
                switch (tiaoJianList.get(i - 1).getTjType()) {
                    case RI_QI:
                        if (!StringUtils.isEmpty(tiaoJianList.get(i - 1).getLjSql())) {
                            sb.append(" and ").append(tiaoJianList.get(i - 1).getLjSql()).append(i);
                        }
                        break;
                    case WEN_BEN:
                        if (!StringUtils.isEmpty(tiaoJianList.get(i - 1).getLjSql())) {
                            sb.append(" and ").append(tiaoJianList.get(i - 1).getLjSql()).append(i);
                        }
                        break;
                    case SHU_ZI:
                        if (!StringUtils.isEmpty(tiaoJianList.get(i - 1).getLjSql())) {
                            sb.append(" and ").append(tiaoJianList.get(i - 1).getLjSql()).append(i);
                        }
                    case MEI_JU:
                        if (!StringUtils.isEmpty(tiaoJianList.get(i - 1).getLjSql())) {
                            sb.append(" and ").append(tiaoJianList.get(i - 1).getLjSql()).append(i);
                        }
                        break;
                }
            }
            
        }
        LOG.info(sb.toString());
        Query query = getEntityManager().createNativeQuery(sb.toString());
        
        for (int i = 1; i <= tiaoJianList.size(); i++) {
            if (tjMap.get(tiaoJianList.get(i - 1).getTitle()) != null) {
                switch (tiaoJianList.get(i - 1).getTjType()) {
                    case RI_QI:
                        query.setParameter(i, (Date) tjMap.get(tiaoJianList.get(i - 1).getTitle()), TemporalType.TIMESTAMP);
                        break;
                    case WEN_BEN:
                        query.setParameter(i, tjMap.get(tiaoJianList.get(i - 1).getTitle()));
                        break;
                    case SHU_ZI:
                        query.setParameter(i, tjMap.get(tiaoJianList.get(i - 1).getTitle()));
                    case MEI_JU:
                        query.setParameter(i, tjMap.get(tiaoJianList.get(i - 1).getTitle()));
                        break;
                }
            }
            
        }
//        query.setParameter(1, startDate, TemporalType.TIMESTAMP);
//        query.setParameter(2, DateUtils.addDays(endDate, 1), TemporalType.TIMESTAMP);
//        if (jdbm != null) {
//            query.setParameter(3, jdbm);
//        }

        query.setHint(QueryHints.RESULT_TYPE, ResultType.Map);
        List<ArrayRecord> rows;
        try {
            rows = query.getResultList();
//            LOG.info(rows);
        } catch (Exception e) {
            rows = new ArrayList<>();
            LOG.info(e.getMessage());
        }
        
        return rows;
    }
    
    public List<ArrayRecord> chaMeiJuByTiaoJian(String sql, Map<Integer, String> tjMap) {
        Query query = getEntityManager().createNativeQuery(sql);
        
        if (!tjMap.isEmpty()) {
//            int i = 1;
            for (Map.Entry<Integer, String> entry : tjMap.entrySet()) {
                LOG.info(entry.getKey() + ":" + entry.getValue());
                query.setParameter(entry.getKey(), entry.getValue());
//                i++;
            }
        }
        query.setHint(QueryHints.RESULT_TYPE, ResultType.Map);
        List<ArrayRecord> rows;
        try {
            rows = query.getResultList();
//            LOG.info(rows);
        } catch (Exception e) {
            rows = new ArrayList<>();
            LOG.info(e.getMessage());
        }
        return rows;
    }
    
    public List<ArrayRecord> chaMeiJu(String sql) {
        Query query = getEntityManager().createNativeQuery(sql);
        query.setHint(QueryHints.RESULT_TYPE, ResultType.Map);
        List<ArrayRecord> rows;
        try {
            rows = query.getResultList();
//            LOG.info(rows);
        } catch (Exception e) {
            rows = new ArrayList<>();
            LOG.info(e.getMessage());
        }
        return rows;
    }
    
}
