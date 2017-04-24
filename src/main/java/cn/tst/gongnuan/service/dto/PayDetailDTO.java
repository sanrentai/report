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
 * 出库情况DTO
 *
 * @author CaoChun
 */
@Entity
public class PayDetailDTO implements Serializable {
    @Id
    private String id;
    private String billId;
    private String roomId;
    private String yearNum;  
    private String paytype;
    private BigDecimal Thisaccount;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date payDate;
    public PayDetailDTO() {
    }

    public PayDetailDTO(String id, String billId, String roomId, String yearNum, String paytype, BigDecimal Thisaccount, Date payDate) {
        this.id = id;
        this.billId = billId;
        this.roomId = roomId;
        this.yearNum = yearNum;
        this.paytype = paytype;
        this.Thisaccount = Thisaccount;
        this.payDate = payDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getYearNum() {
        return yearNum;
    }

    public void setYearNum(String yearNum) {
        this.yearNum = yearNum;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public BigDecimal getThisaccount() {
        return Thisaccount;
    }

    public void setThisaccount(BigDecimal Thisaccount) {
        this.Thisaccount = Thisaccount;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }
    
    

}
