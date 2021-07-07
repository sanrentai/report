/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.viewmodel;

import cn.tst.gongnuan.service.dto.HYR0006DTO;
import cn.tst.gongnuan.service.dto.XmShouFeiQingKuangBiaoDTO;
import cn.tst.gongnuan.service.dto.YearNumDTO;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CaoChun
 */
public class TST0005ViewModel extends BaseViewModel {

    private String yearnum;
    private Date ksDate;
    private Date jsDate;
    private List<YearNumDTO> yearnumList;
    private List<XmShouFeiQingKuangBiaoDTO> shuJuList;

    public TST0005ViewModel() {
    }

    public String getYearnum() {
        return yearnum;
    }

    public void setYearnum(String yearnum) {
        this.yearnum = yearnum;
    }

    public List<YearNumDTO> getYearnumList() {
        return yearnumList;
    }

    public void setYearnumList(List<YearNumDTO> yearnumList) {
        this.yearnumList = yearnumList;
    }

    public List<XmShouFeiQingKuangBiaoDTO> getShuJuList() {
        return shuJuList;
    }

    public void setShuJuList(List<XmShouFeiQingKuangBiaoDTO> shuJuList) {
        this.shuJuList = shuJuList;
    }

    public BigDecimal getTotalHs() {
        BigDecimal total = BigDecimal.ZERO;
        if (shuJuList == null) {
            return total;
        }
        for (XmShouFeiQingKuangBiaoDTO item : shuJuList) {
            total = total.add(item.getHs());
        }
        return total;
    }

    public Date getKsDate() {
        return ksDate;
    }

    public void setKsDate(Date ksDate) {
        this.ksDate = ksDate;
    }

    public Date getJsDate() {
        return jsDate;
    }

    public void setJsDate(Date jsDate) {
        this.jsDate = jsDate;
    }

    public BigDecimal getTotal(String t)
            throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        BigDecimal total = BigDecimal.ZERO;
        if (shuJuList == null) {
            return total;
        }

        for (XmShouFeiQingKuangBiaoDTO item : shuJuList) {
            Method method = item.getClass().getMethod("get" + t.substring(0, 1).toUpperCase() + t.substring(1));
            total = total.add((BigDecimal) method.invoke(item));
//            Field field = item.getClass().getField(t);
//            String type = field.getType().toString();
//            if("BigDecimal".equals(type)){
//                field.setAccessible(true);
//                total = total.add((BigDecimal)field.get(item));
//            }
        }

        return total;

    }
}
