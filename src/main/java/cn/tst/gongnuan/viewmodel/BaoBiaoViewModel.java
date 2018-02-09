/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.viewmodel;

import cn.tst.gongnuan.common.CStringUtils;
import cn.tst.gongnuan.entity.RepBiao;
import cn.tst.gongnuan.entity.RepBiaoTiaoJian;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author CaoChun
 *
 */
public class BaoBiaoViewModel extends BaseViewModel {

    private StreamedContent wordfile;

    private Map tjMap;

    private Date startDate;

    private Date endDate;

    private String jieDanBuMenMing;

    private List<Map<String, Object>> shuJuList;

    private List<String> heads;

    private String biaoMing;

    private RepBiao biao;

    private List<RepBiaoTiaoJian> tiaoJianList;

    public StreamedContent getWordfile() {
        return wordfile;
    }

    public void setWordfile(StreamedContent wordfile) {
        this.wordfile = wordfile;
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

    public List<Map<String, Object>> getShuJuList() {
        return shuJuList;
    }

    public void setShuJuList(List<Map<String, Object>> shuJuList) {
        this.shuJuList = shuJuList;
    }

    public String getZhiBiaoShiJian() {
//        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        return sdf.format(new Date());
    }

    public int getZongShu() {
        if (shuJuList == null) {
            return 0;
        } else {
            return shuJuList.size();
        }
    }

    public String getTongJiZhouQi() {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        if (startDate.equals(endDate)) {
            return sdf.format(startDate);
        } else {
            return sdf.format(startDate) + " - " + sdf.format(endDate);
        }
    }

    public String getJieDanBuMenMing() {
        return jieDanBuMenMing;
    }

    public void setJieDanBuMenMing(String jieDanBuMenMing) {
        this.jieDanBuMenMing = jieDanBuMenMing;
    }

    public List<String> getHeads() {
        return heads;
    }

    public void setHeads(List<String> heads) {
        this.heads = heads;
    }

    public String getTotal(String t)
            throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        BigDecimal total = BigDecimal.ZERO;
        if (shuJuList == null) {
            return total.toString();
        }
        for (Map<String, Object> map : shuJuList) {
            if ("序号".equals(t)) {
                return "合计";
            } else {
                if (CStringUtils.isBigDecimal(map.get(t).toString())) {
                    total = total.add(new BigDecimal(map.get(t).toString()));
                } else {
                    return "";
                }
            }
            map.get(t).toString();
        }

        return total.toString();
    }

    public String getBiaoMing() {
        return biaoMing;
    }

    public void setBiaoMing(String biaoMing) {
        this.biaoMing = biaoMing;
    }

    public Map getTjMap() {
        return tjMap;
    }

    public void setTjMap(Map tjMap) {
        this.tjMap = tjMap;
    }

    public RepBiao getBiao() {
        return biao;
    }

    public void setBiao(RepBiao biao) {
        this.biao = biao;
    }

    public List<RepBiaoTiaoJian> getTiaoJianList() {
        return tiaoJianList;
    }

    public void setTiaoJianList(List<RepBiaoTiaoJian> tiaoJianList) {
        this.tiaoJianList = tiaoJianList;
    }

}
