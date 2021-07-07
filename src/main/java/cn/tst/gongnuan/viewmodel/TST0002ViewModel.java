/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.viewmodel;

import java.util.Date;
import cn.tst.gongnuan.service.dto.HYR0002DTO;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
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

    public TST0002ViewModel() {
        payDate = new Date();
        endDate = new Date();
    }

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

    public BigDecimal getTotal(String t)
            throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        BigDecimal total = BigDecimal.ZERO;
        if (queryResultList == null) {
            return total;
        }
        for (HYR0002DTO item : queryResultList) {
            Method method = item.getClass().getMethod("get" + t.substring(0, 1).toUpperCase() + t.substring(1));
            total = total.add((BigDecimal) method.invoke(item));
        }
        return total;
    }

    public BigDecimal getTotalJk_dn_r() {
        BigDecimal result = BigDecimal.ZERO;
        for (HYR0002DTO item : queryResultList) {
            result = result.add(item.getJk_dn_r());
        }
        return result;
    }

    public BigDecimal getTotalJk_fdn_r() {
        BigDecimal result = BigDecimal.ZERO;
        for (HYR0002DTO item : queryResultList) {
            result = result.add(item.getJk_fdn_r());
        }
        return result;
    }

    public BigDecimal getTotalJk_dn_y() {
        BigDecimal result = BigDecimal.ZERO;
        for (HYR0002DTO item : queryResultList) {
            result = result.add(item.getJk_dn_y());
        }
        return result;
    }

    public BigDecimal getTotalJk_fdn_y() {
        BigDecimal result = BigDecimal.ZERO;
        for (HYR0002DTO item : queryResultList) {
            result = result.add(item.getJk_fdn_y());
        }
        return result;
    }

    public BigDecimal getTotalJk_dn_lj() {
        BigDecimal result = BigDecimal.ZERO;
        for (HYR0002DTO item : queryResultList) {
            result = result.add(item.getJk_dn_lj());
        }
        return result;
    }

    public BigDecimal getTotalJk_fdn_lj() {
        BigDecimal result = BigDecimal.ZERO;
        for (HYR0002DTO item : queryResultList) {
            result = result.add(item.getJk_fdn_lj());
        }
        return result;
    }

    public BigDecimal getThisDayTotal() {
        BigDecimal result = BigDecimal.ZERO;
        for (HYR0002DTO item : queryResultList) {
            result = result.add(item.getThisDayTotal());
        }
        return result;
    }

    public BigDecimal getThisMonthTotal() {
        BigDecimal result = BigDecimal.ZERO;
        for (HYR0002DTO item : queryResultList) {
            result = result.add(item.getThisMonthTotal());
        }
        return result;
    }

    public BigDecimal getTotal() {
        BigDecimal result = BigDecimal.ZERO;
        for (HYR0002DTO item : queryResultList) {
            result = result.add(item.getTotal());
        }
        return result;
    }
}
