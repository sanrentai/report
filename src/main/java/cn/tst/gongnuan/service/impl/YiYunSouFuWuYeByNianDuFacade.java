/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.service.impl;

import cn.tst.gongnuan.entity.Employee;
import cn.tst.gongnuan.service.dto.YiYunSouFuWuYeFeiHuiZongBiaoDTO;
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
public class YiYunSouFuWuYeByNianDuFacade extends AbstractFacade<Employee> {

    private static final Logger LOG = Logger.getLogger(Employee.class.getName());

    public YiYunSouFuWuYeByNianDuFacade() {
        super(Employee.class);
    }

    public List<YiYunSouFuWuYeFeiHuiZongBiaoDTO> getShuJuByNianDu(int yearNum) {
        LOG.info(new Date());
        StringBuilder sb = new StringBuilder();
        sb.append("EXEC	 [dbo].[p_wyhzb] ");
        sb.append(" @s_yearnum = ?1 ");
        LOG.info(new Date());
        Query query = getEntityManager().createNativeQuery(sb.toString(), YiYunSouFuWuYeFeiHuiZongBiaoDTO.class);
        query.setParameter(1, yearNum);
        LOG.info(new Date());
 
        List<YiYunSouFuWuYeFeiHuiZongBiaoDTO> result = query.getResultList();
        LOG.info("ttt");
        LOG.info(new Date());
        
        return result;
    }

}
