/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.service.impl;

import javax.ejb.Stateless;
import cn.tst.gongnuan.entity.Employee;
import cn.tst.gongnuan.service.dto.PayDetailDTO;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author 曹春
 */
@Stateless
public class EmployeeFacade extends AbsFacade<Employee> {

    private static final Logger LOG = Logger.getLogger(Employee.class.getName());

    public EmployeeFacade() {
        super(Employee.class);
    }

    public List<PayDetailDTO> getPayDetailDTO() {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT id,billid,roomid,yearnum,  ");
        sb.append(" Paydate,Thisaccount,paytype    ");
        sb.append(" FROM paydetail ");
        sb.append(" WHERE exist  ='0' ");
        sb.append(" ORDER BY ownerid,yearnum,paytype ");
//        sb.append(" WHERE ckll.chu_ku_riqi >= ?1  ");
//        sb.append(" AND ckll.chu_ku_riqi <= ?2  ");
//        sb.append(" AND cksq.wu_zi_id = ?3  ");
        Query query = getEntityManager().createNativeQuery(sb.toString(), PayDetailDTO.class);
//        query.setParameter(1, startDate, TemporalType.DATE);
//        query.setParameter(2, endDate, TemporalType.DATE);
//        query.setParameter(3, wuZiId);
        List<PayDetailDTO> result = query.getResultList();
        return result;
    }

    public Employee findLoginInfo(String loginId, String password) {
        // ログインＩＤとパスワードにて、ＤＢから認証情報を取得する�?
        Query qe = this.getEntityManager().createNamedQuery("Employee.findByEmpIdAndEmpLoginpw");
        qe.setParameter("empId", loginId);
        qe.setParameter("empLoginpw", password);
        List<Employee> result = qe.getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

    public Employee findByEmpId(String emdId) {
        Query qe = this.getEntityManager().createNamedQuery("Employee.findByEmpId");
        qe.setParameter("empId", emdId);
        List<Employee> result = qe.getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

}
