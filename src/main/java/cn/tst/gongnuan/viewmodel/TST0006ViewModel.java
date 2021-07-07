/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.viewmodel;

import cn.tst.gongnuan.service.dto.HYR0006DTO;
import cn.tst.gongnuan.service.dto.YearNumDTO;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author CaoChun
 */
public class TST0006ViewModel extends BaseViewModel {

    private String yearnum;
    private List<YearNumDTO> yearnumList;
    private List<HYR0006DTO> shuJuList;

    public TST0006ViewModel() {
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

    public List<HYR0006DTO> getShuJuList() {
        return shuJuList;
    }

    public void setShuJuList(List<HYR0006DTO> shuJuList) {
        this.shuJuList = shuJuList;
    }

    public BigDecimal getTotalArea_tg() {
        BigDecimal total = BigDecimal.ZERO;
        if (shuJuList == null) {
            return total;
        }
        for (HYR0006DTO item : shuJuList) {
            total = total.add(item.getArea_tg());
        }
        return total;
    }

    public BigDecimal getTotalYjk_tg() {
        BigDecimal total = BigDecimal.ZERO;
        if (shuJuList == null) {
            return total;
        }
        for (HYR0006DTO item : shuJuList) {
            total = total.add(item.getYjk_tg());
        }
        return total;
    }

    public BigDecimal getTotalJk_tg() {
        BigDecimal total = BigDecimal.ZERO;
        if (shuJuList == null) {
            return total;
        }
        for (HYR0006DTO item : shuJuList) {
            total = total.add(item.getJk_tg());
        }
        return total;
    }

    public BigDecimal getTotalOwe_tg() {
        BigDecimal total = BigDecimal.ZERO;
        if (shuJuList == null) {
            return total;
        }
        for (HYR0006DTO item : shuJuList) {
            total = total.add(item.getOwe_tg());
        }
        return total;
    }

    public BigDecimal getTotalHs() {
        BigDecimal total = BigDecimal.ZERO;
        if (shuJuList == null) {
            return total;
        }
        for (HYR0006DTO item : shuJuList) {
            total = total.add(item.getHs());
        }
        return total;
    }
}
