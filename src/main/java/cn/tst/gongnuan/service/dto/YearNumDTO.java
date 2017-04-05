/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 * 收费年度表按公司
 *
 * @author CaoChun
 */
@Entity
public class YearNumDTO implements Serializable {
    @Id
    private String yearnum;

    public YearNumDTO() {
    }

    public YearNumDTO(String yearnum) {
        this.yearnum = yearnum;
    }

    public String getYearnum() {
        return yearnum;
    }

    public void setYearnum(String yearnum) {
        this.yearnum = yearnum;
    }

}
