/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.viewmodel;

import cn.tst.gongnuan.service.dto.HYR0005DTO;
import cn.tst.gongnuan.service.dto.YearNumDTO;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author CaoChun
 */
public class HYR0005ViewModel extends BaseViewModel {

    private String yearnum;
    private List<YearNumDTO> yearnumList;
    private List<HYR0005DTO> shuJuList;

    public HYR0005ViewModel() {
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

    public List<HYR0005DTO> getShuJuList() {
        return shuJuList;
    }

    public void setShuJuList(List<HYR0005DTO> shuJuList) {
        this.shuJuList = shuJuList;
    }

    public BigDecimal getTotalArea() {
        BigDecimal total = BigDecimal.ZERO;
        if (shuJuList == null) {
            return total;
        }
        for (HYR0005DTO item : shuJuList) {
            total = total.add(item.getArea());
        }
        return total;
    }

    public BigDecimal getTotalArea_gn() {
        BigDecimal total = BigDecimal.ZERO;
        if (shuJuList == null) {
            return total;
        }
        for (HYR0005DTO item : shuJuList) {
            total = total.add(item.getArea_gn());
        }
        return total;
    }

    public BigDecimal getTotalArea_tg() {
        BigDecimal total = BigDecimal.ZERO;
        if (shuJuList == null) {
            return total;
        }
        for (HYR0005DTO item : shuJuList) {
            total = total.add(item.getArea_tg());
        }
        return total;
    }

    public BigDecimal getTotalYjk() {
        BigDecimal total = BigDecimal.ZERO;
        if (shuJuList == null) {
            return total;
        }
        for (HYR0005DTO item : shuJuList) {
            total = total.add(item.getYjk());
        }
        return total;
    }

    public BigDecimal getTotalYjk_gn() {
        BigDecimal total = BigDecimal.ZERO;
        if (shuJuList == null) {
            return total;
        }
        for (HYR0005DTO item : shuJuList) {
            total = total.add(item.getYjk_gn());
        }
        return total;
    }

    public BigDecimal getTotalYjk_tg() {
        BigDecimal total = BigDecimal.ZERO;
        if (shuJuList == null) {
            return total;
        }
        for (HYR0005DTO item : shuJuList) {
            total = total.add(item.getYjk_tg());
        }
        return total;
    }

    public BigDecimal getTotalJk() {
        BigDecimal total = BigDecimal.ZERO;
        if (shuJuList == null) {
            return total;
        }
        for (HYR0005DTO item : shuJuList) {
            total = total.add(item.getJk());
        }
        return total;
    }

    public BigDecimal getTotalJk_gn() {
        BigDecimal total = BigDecimal.ZERO;
        if (shuJuList == null) {
            return total;
        }
        for (HYR0005DTO item : shuJuList) {
            total = total.add(item.getJk_gn());
        }
        return total;
    }

    public BigDecimal getTotalJk_tg() {
        BigDecimal total = BigDecimal.ZERO;
        if (shuJuList == null) {
            return total;
        }
        for (HYR0005DTO item : shuJuList) {
            total = total.add(item.getJk_tg());
        }
        return total;
    }

    public BigDecimal getTotalOwe() {
        BigDecimal total = BigDecimal.ZERO;
        if (shuJuList == null) {
            return total;
        }
        for (HYR0005DTO item : shuJuList) {
            total = total.add(item.getOwe());
        }
        return total;
    }

    public BigDecimal getTotalOwe_gn() {
        BigDecimal total = BigDecimal.ZERO;
        if (shuJuList == null) {
            return total;
        }
        for (HYR0005DTO item : shuJuList) {
            total = total.add(item.getOwe_gn());
        }
        return total;
    }

    public BigDecimal getTotalOwe_tg() {
        BigDecimal total = BigDecimal.ZERO;
        if (shuJuList == null) {
            return total;
        }
        for (HYR0005DTO item : shuJuList) {
            total = total.add(item.getOwe_tg());
        }
        return total;
    }

    public BigDecimal getTotalGratis1() {
        BigDecimal total = BigDecimal.ZERO;
        if (shuJuList == null) {
            return total;
        }
        for (HYR0005DTO item : shuJuList) {
            total = total.add(item.getGratis1());
        }
        return total;
    }

    public BigDecimal getTotalZnjmoney() {
        BigDecimal total = BigDecimal.ZERO;
        if (shuJuList == null) {
            return total;
        }
        for (HYR0005DTO item : shuJuList) {
            total = total.add(item.getZnjmoney());
        }
        return total;
    }

    public BigDecimal getTotalZsfy() {
        BigDecimal total = BigDecimal.ZERO;
        if (shuJuList == null) {
            return total;
        }
        for (HYR0005DTO item : shuJuList) {
            total = total.add(item.getZsfy());
        }
        return total;
    }

//    public BigDecimal getTotalSfl() {
//        BigDecimal total = BigDecimal.ZERO;
//        if (shuJuList == null) {
//            return total;
//        }
//        for (HYR0005DTO item : shuJuList) {
//            total = total.add(item.getSfl());
//        }
//        return total;
//    }

    public BigDecimal getTotalHs() {
        BigDecimal total = BigDecimal.ZERO;
        if (shuJuList == null) {
            return total;
        }
        for (HYR0005DTO item : shuJuList) {
            total = total.add(item.getHs());
        }
        return total;
    }
}
