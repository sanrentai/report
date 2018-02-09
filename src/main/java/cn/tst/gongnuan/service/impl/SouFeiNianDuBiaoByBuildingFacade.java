/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.service.impl;

import cn.tst.gongnuan.entity.Employee;
import cn.tst.gongnuan.service.dto.SouFeiNianDuBiaoByBuildingDTO;
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
public class SouFeiNianDuBiaoByBuildingFacade  extends AbsFacade<Employee> {

    private static final Logger LOG = Logger.getLogger(Employee.class.getName());

    public SouFeiNianDuBiaoByBuildingFacade() {
        super(Employee.class);
    }

    public List<SouFeiNianDuBiaoByBuildingDTO> getSouFeiNianDuBiaoByBuildingList(String companyName,Date payDate,String buildingNo) {
        StringBuilder sb = new StringBuilder();
        sb.append("EXEC	 [dbo].[p_sfndb_b] ");
        sb.append(" @company = ?2 , ");
        sb.append(" @buildingid = ?3, ");
        sb.append(" @paydate = ?1 ");
        Query query = getEntityManager().createNativeQuery(sb.toString(), SouFeiNianDuBiaoByBuildingDTO.class);
        query.setParameter(1, payDate, TemporalType.DATE);
        query.setParameter(2, companyName);
        query.setParameter(3, buildingNo);
        List<SouFeiNianDuBiaoByBuildingDTO> result = query.getResultList();
        return result;
    }

}

