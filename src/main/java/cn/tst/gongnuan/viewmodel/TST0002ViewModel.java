/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.viewmodel;

import java.util.Date;
import cn.tst.gongnuan.service.dto.HYR0002DTO;
import java.util.List;

/**
 *
 * @author Aaron
 */
public class TST0002ViewModel {
    private Date payDate;
    private Date startDate;
    private Date endDate;
    private List<HYR0002DTO> queryResultList;

    public List<HYR0002DTO> getQueryResultList() {
        return queryResultList;
    }

    public void setQueryResultList(List<HYR0002DTO> queryResultList) {
        this.queryResultList = queryResultList;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
