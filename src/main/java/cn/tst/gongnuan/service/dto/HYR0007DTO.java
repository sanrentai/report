/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 各公司年度供热费减免费用汇总表
 *
 * @author CaoChun
 */
@Entity
public class HYR0007DTO implements Serializable {

    @Id
    private BigDecimal no;
    private String name;
    private String type;
    private BigDecimal je;


    public HYR0007DTO() {
    }

    public HYR0007DTO(BigDecimal no, String name, String type, BigDecimal je) {
        this.no = no;
        this.name = name;
        this.type = type;
        this.je = je;
    }

    public BigDecimal getNo() {
        return no;
    }

    public void setNo(BigDecimal no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getJe() {
        return je;
    }

    public void setJe(BigDecimal je) {
        this.je = je;
    }

}
