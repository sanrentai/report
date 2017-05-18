/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.viewmodel;

import cn.tst.gongnuan.service.dto.HYR0007DTO;
import cn.tst.gongnuan.service.dto.YearNumDTO;
import java.math.BigDecimal;
import java.util.List;

/**
 * 各公司年度供热费减免费用汇总表
 * @author CaoChun
 */
public class TST0007ViewModel extends BaseViewModel {

    private String yearnum;
    private String type;
    private List<YearNumDTO> yearnumList;
    private List<HYR0007DTO> shuJuList;

    public TST0007ViewModel() {
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

    public List<HYR0007DTO> getShuJuList() {
        return shuJuList;
    }

    public void setShuJuList(List<HYR0007DTO> shuJuList) {
        this.shuJuList = shuJuList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getTotalJe() {
        BigDecimal total = BigDecimal.ZERO;
        if (shuJuList == null) {
            return total;
        }
        for (HYR0007DTO item : shuJuList) {
            total = total.add(item.getJe());
        }
        return total;
    }

}
