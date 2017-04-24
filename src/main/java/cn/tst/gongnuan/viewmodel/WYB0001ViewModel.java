/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.viewmodel;

import cn.tst.gongnuan.entity.VBuilding;
import cn.tst.gongnuan.entity.VCompany;
import cn.tst.gongnuan.entity.VYearnum;
import cn.tst.gongnuan.service.dto.YiYunSouFuWuYeFeiHuiZongBiaoDTO;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author CaoChun
 */
public class WYB0001ViewModel extends BaseViewModel {

    private int yearNum;

    private Map jk_zzMap;
    private Map jk_hqMap;
    private Map jk_gyMap;
    private Map jk_wdMap;
    private Map jk_ckMap;
    private Map jk_cwMap;
    private Map jk_cfMap;
    private Map jk_hjMap;
    private Map hs_zzMap;
    private Map hs_hqMap;
    private Map hs_gyMap;
    private Map hs_wdMap;
    private Map hs_ckMap;
    private Map hs_cwMap;
    private Map hs_cfMap;
    private Map hs_hjMap;
    private BigDecimal total_jk_zz = BigDecimal.ZERO;
    private BigDecimal total_jk_hq = BigDecimal.ZERO;
    private BigDecimal total_jk_gy = BigDecimal.ZERO;
    private BigDecimal total_jk_wd = BigDecimal.ZERO;
    private BigDecimal total_jk_ck = BigDecimal.ZERO;
    private BigDecimal total_jk_cw = BigDecimal.ZERO;
    private BigDecimal total_jk_cf = BigDecimal.ZERO;
    private BigDecimal total_jk_hj = BigDecimal.ZERO;
    private int total_hs_zz = 0;
    private int total_hs_hq = 0;
    private int total_hs_gy = 0;
    private int total_hs_wd = 0;
    private int total_hs_ck = 0;
    private int total_hs_cw = 0;
    private int total_hs_cf = 0;
    private int total_hs_hj = 0;

    public WYB0001ViewModel() {
        this.jk_zzMap = new HashMap<Integer, BigDecimal>();
        this.jk_hqMap = new HashMap<Integer, BigDecimal>();
        this.jk_gyMap = new HashMap<Integer, BigDecimal>();
        this.jk_wdMap = new HashMap<Integer, BigDecimal>();
        this.jk_ckMap = new HashMap<Integer, BigDecimal>();
        this.jk_cwMap = new HashMap<Integer, BigDecimal>();
        this.jk_cfMap = new HashMap<Integer, BigDecimal>();
        this.jk_hjMap = new HashMap<Integer, BigDecimal>();
        this.hs_zzMap = new HashMap<Integer, Integer>();
        this.hs_hqMap = new HashMap<Integer, Integer>();
        this.hs_gyMap = new HashMap<Integer, Integer>();
        this.hs_wdMap = new HashMap<Integer, Integer>();
        this.hs_ckMap = new HashMap<Integer, Integer>();
        this.hs_cwMap = new HashMap<Integer, Integer>();
        this.hs_cfMap = new HashMap<Integer, Integer>();
        this.hs_hjMap = new HashMap<Integer, Integer>();
    }

    public int getYearNum() {
        return yearNum;
    }

    public void setYearNum(int yearNum) {
        this.yearNum = yearNum;
    }

    private List<YiYunSouFuWuYeFeiHuiZongBiaoDTO> shuJuList;

    public List<YiYunSouFuWuYeFeiHuiZongBiaoDTO> getShuJuList() {
        return shuJuList;
    }

    public void setShuJuList(List<YiYunSouFuWuYeFeiHuiZongBiaoDTO> shuJuList) {
        this.shuJuList = shuJuList;
    }

    public Map getJk_zzMap() {
        return jk_zzMap;
    }

    public void setJk_zzMap(Map jk_zzMap) {
        this.jk_zzMap = jk_zzMap;
    }

    public Map getJk_hqMap() {
        return jk_hqMap;
    }

    public void setJk_hqMap(Map jk_hqMap) {
        this.jk_hqMap = jk_hqMap;
    }

    public Map getJk_gyMap() {
        return jk_gyMap;
    }

    public void setJk_gyMap(Map jk_gyMap) {
        this.jk_gyMap = jk_gyMap;
    }

    public Map getJk_wdMap() {
        return jk_wdMap;
    }

    public void setJk_wdMap(Map jk_wdMap) {
        this.jk_wdMap = jk_wdMap;
    }

    public Map getJk_ckMap() {
        return jk_ckMap;
    }

    public void setJk_ckMap(Map jk_ckMap) {
        this.jk_ckMap = jk_ckMap;
    }

    public Map getJk_cwMap() {
        return jk_cwMap;
    }

    public void setJk_cwMap(Map jk_cwMap) {
        this.jk_cwMap = jk_cwMap;
    }

    public Map getJk_cfMap() {
        return jk_cfMap;
    }

    public void setJk_cfMap(Map jk_cfMap) {
        this.jk_cfMap = jk_cfMap;
    }

    public Map getJk_hjMap() {
        return jk_hjMap;
    }

    public void setJk_hjMap(Map jk_hjMap) {
        this.jk_hjMap = jk_hjMap;
    }

    public Map getHs_zzMap() {
        return hs_zzMap;
    }

    public void setHs_zzMap(Map hs_zzMap) {
        this.hs_zzMap = hs_zzMap;
    }

    public Map getHs_hqMap() {
        return hs_hqMap;
    }

    public void setHs_hqMap(Map hs_hqMap) {
        this.hs_hqMap = hs_hqMap;
    }

    public Map getHs_gyMap() {
        return hs_gyMap;
    }

    public void setHs_gyMap(Map hs_gyMap) {
        this.hs_gyMap = hs_gyMap;
    }

    public Map getHs_wdMap() {
        return hs_wdMap;
    }

    public void setHs_wdMap(Map hs_wdMap) {
        this.hs_wdMap = hs_wdMap;
    }

    public Map getHs_ckMap() {
        return hs_ckMap;
    }

    public void setHs_ckMap(Map hs_ckMap) {
        this.hs_ckMap = hs_ckMap;
    }

    public Map getHs_cwMap() {
        return hs_cwMap;
    }

    public void setHs_cwMap(Map hs_cwMap) {
        this.hs_cwMap = hs_cwMap;
    }

    public Map getHs_cfMap() {
        return hs_cfMap;
    }

    public void setHs_cfMap(Map hs_cfMap) {
        this.hs_cfMap = hs_cfMap;
    }

    public Map getHs_hjMap() {
        return hs_hjMap;
    }

    public void setHs_hjMap(Map hs_hjMap) {
        this.hs_hjMap = hs_hjMap;
    }

    public BigDecimal getTotal_jk_zz() {
        return total_jk_zz;
    }

    public void setTotal_jk_zz(BigDecimal total_jk_zz) {
        this.total_jk_zz = total_jk_zz;
    }

    public BigDecimal getTotal_jk_hq() {
        return total_jk_hq;
    }

    public void setTotal_jk_hq(BigDecimal total_jk_hq) {
        this.total_jk_hq = total_jk_hq;
    }

    public BigDecimal getTotal_jk_gy() {
        return total_jk_gy;
    }

    public void setTotal_jk_gy(BigDecimal total_jk_gy) {
        this.total_jk_gy = total_jk_gy;
    }

    public BigDecimal getTotal_jk_wd() {
        return total_jk_wd;
    }

    public void setTotal_jk_wd(BigDecimal total_jk_wd) {
        this.total_jk_wd = total_jk_wd;
    }

    public BigDecimal getTotal_jk_ck() {
        return total_jk_ck;
    }

    public void setTotal_jk_ck(BigDecimal total_jk_ck) {
        this.total_jk_ck = total_jk_ck;
    }

    public BigDecimal getTotal_jk_cw() {
        return total_jk_cw;
    }

    public void setTotal_jk_cw(BigDecimal total_jk_cw) {
        this.total_jk_cw = total_jk_cw;
    }

    public BigDecimal getTotal_jk_cf() {
        return total_jk_cf;
    }

    public void setTotal_jk_cf(BigDecimal total_jk_cf) {
        this.total_jk_cf = total_jk_cf;
    }

    public BigDecimal getTotal_jk_hj() {
        return total_jk_hj;
    }

    public void setTotal_jk_hj(BigDecimal total_jk_hj) {
        this.total_jk_hj = total_jk_hj;
    }

    public int getTotal_hs_zz() {
        return total_hs_zz;
    }

    public void setTotal_hs_zz(int total_hs_zz) {
        this.total_hs_zz = total_hs_zz;
    }

    public int getTotal_hs_hq() {
        return total_hs_hq;
    }

    public void setTotal_hs_hq(int total_hs_hq) {
        this.total_hs_hq = total_hs_hq;
    }

    public int getTotal_hs_gy() {
        return total_hs_gy;
    }

    public void setTotal_hs_gy(int total_hs_gy) {
        this.total_hs_gy = total_hs_gy;
    }

    public int getTotal_hs_wd() {
        return total_hs_wd;
    }

    public void setTotal_hs_wd(int total_hs_wd) {
        this.total_hs_wd = total_hs_wd;
    }

    public int getTotal_hs_ck() {
        return total_hs_ck;
    }

    public void setTotal_hs_ck(int total_hs_ck) {
        this.total_hs_ck = total_hs_ck;
    }

    public int getTotal_hs_cw() {
        return total_hs_cw;
    }

    public void setTotal_hs_cw(int total_hs_cw) {
        this.total_hs_cw = total_hs_cw;
    }

    public int getTotal_hs_cf() {
        return total_hs_cf;
    }

    public void setTotal_hs_cf(int total_hs_cf) {
        this.total_hs_cf = total_hs_cf;
    }

    public int getTotal_hs_hj() {
        return total_hs_hj;
    }

    public void setTotal_hs_hj(int total_hs_hj) {
        this.total_hs_hj = total_hs_hj;
    }

}
