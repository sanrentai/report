/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.service.impl;

import cn.tst.gongnuan.entity.Employee;
import cn.tst.gongnuan.service.dto.HySouFeiNianDuBiaoByBuildingDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author 曹春
 */
@Stateless
public class HySouFeiNianDuBiaoByBuildingFacade  extends AbsFacade<Employee> {

    private static final Logger LOG = Logger.getLogger(Employee.class.getName());

    public HySouFeiNianDuBiaoByBuildingFacade() {
        super(Employee.class);
    }

    public List<HySouFeiNianDuBiaoByBuildingDTO> getSouFeiNianDuBiaoByBuildingList(String companyName,String yearnum,String buildingNo) {
        StringBuilder sb = new StringBuilder();
        sb.append("EXEC	 [dbo].[p_sfndb_b_n] ");
        sb.append(" @company = ?2 , ");
        sb.append(" @buildingid = ?3, ");
        sb.append(" @yearnum = ?1 ");
        Query query = getEntityManager().createNativeQuery(sb.toString(), HySouFeiNianDuBiaoByBuildingDTO.class);
        query.setParameter(1, yearnum);
        query.setParameter(2, companyName);
        query.setParameter(3, buildingNo);
        List<HySouFeiNianDuBiaoByBuildingDTO> result = query.getResultList();
        return result;
    }

}

