/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.viewmodel;

import cn.tst.gongnuan.entity.VCompany;
import cn.tst.gongnuan.service.dto.BuildingDTO;
import cn.tst.gongnuan.service.dto.HYR0003DTO;
import cn.tst.gongnuan.service.dto.HuanReZhanDTO;
import cn.tst.gongnuan.service.dto.RoomTypeDTO;
import cn.tst.gongnuan.service.dto.XiaoQuDTO;
import cn.tst.gongnuan.service.dto.YearNumDTO;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author CaoChun
 */
public class HYR0003ViewModel extends BaseViewModel {

    private Date payDate;
    //公司名
    private String companyName;
    //换热站id
    private String huanRenZhanId;
    //小区id
    private String xiaoQuId;
    //大楼id
    private String buildingId;
    ///类型编号
    private String typeId;
    private String yearnum;
    private List<VCompany> companyList;

    private List<HuanReZhanDTO> huanReZhanList;
    private List<XiaoQuDTO> xiaoQuList;
    private List<BuildingDTO> buildingList;
    private List<RoomTypeDTO> roomTypeList;
    private List<HYR0003DTO> shuJuList;

    private List<YearNumDTO> yearnumList;
    
    private String headerText;

    public String getHeaderText() {
        return headerText;
    }

    public void setHeaderText(String headerText) {
        this.headerText = headerText;
    }

    public HYR0003ViewModel() {
        this.companyName = "全部";
        this.huanRenZhanId = "全部";
        this.xiaoQuId = "全部";
        this.buildingId = "全部";
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public List<HYR0003DTO> getShuJuList() {
        return shuJuList;
    }

    public void setShuJuList(List<HYR0003DTO> shuJuList) {
        this.shuJuList = shuJuList;
    }

    public List<VCompany> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<VCompany> companyList) {
        this.companyList = companyList;
    }

    public List<YearNumDTO> getYearnumList() {
        return yearnumList;
    }

    public void setYearnumList(List<YearNumDTO> yearnumList) {
        this.yearnumList = yearnumList;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getHuanRenZhanId() {
        return huanRenZhanId;
    }

    public void setHuanRenZhanId(String huanRenZhanId) {
        this.huanRenZhanId = huanRenZhanId;
    }

    public String getXiaoQuId() {
        return xiaoQuId;
    }

    public void setXiaoQuId(String xiaoQuId) {
        this.xiaoQuId = xiaoQuId;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public List<HuanReZhanDTO> getHuanReZhanList() {
        return huanReZhanList;
    }

    public void setHuanReZhanList(List<HuanReZhanDTO> huanReZhanList) {
        this.huanReZhanList = huanReZhanList;
    }

    public List<XiaoQuDTO> getXiaoQuList() {
        return xiaoQuList;
    }

    public void setXiaoQuList(List<XiaoQuDTO> xiaoQuList) {
        this.xiaoQuList = xiaoQuList;
    }

    public List<BuildingDTO> getBuildingList() {
        return buildingList;
    }

    public void setBuildingList(List<BuildingDTO> buildingList) {
        this.buildingList = buildingList;
    }

    public String getYearnum() {
        return yearnum;
    }

    public void setYearnum(String yearnum) {
        this.yearnum = yearnum;
    }

    public BigDecimal getTotalAreaJz() {
        BigDecimal result = new BigDecimal(0.0);
        for(HYR0003DTO value : shuJuList) {
            result = result.add(value.getArea_jz());
        }
        return result;
    }

    public BigDecimal getTotalArea() {
        BigDecimal result = new BigDecimal(0.0);
        for(HYR0003DTO value : shuJuList) {
            result = result.add(value.getArea());
        }
        return result;
    }

    public BigDecimal getTotalAreaJk() {
        BigDecimal result = new BigDecimal(0.0);
        for(HYR0003DTO value : shuJuList) {
            result = result.add(value.getArea_jk());
        }
        return result;
    }

    public BigDecimal getTotalAreaTg() {
        BigDecimal result = new BigDecimal(0.0);
        for(HYR0003DTO value : shuJuList) {
            result = result.add(value.getArea_tg());
        }
        return result;
    }

    public BigDecimal getTotalAreaWjk() {
        BigDecimal result = new BigDecimal(0.0);
        for(HYR0003DTO value : shuJuList) {
            result = result.add(value.getArea_wjk());
        }
        return result;
    }

    public List<RoomTypeDTO> getRoomTypeList() {
        return roomTypeList;
    }

    public void setRoomTypeList(List<RoomTypeDTO> roomTypeList) {
        this.roomTypeList = roomTypeList;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
    
    
}
