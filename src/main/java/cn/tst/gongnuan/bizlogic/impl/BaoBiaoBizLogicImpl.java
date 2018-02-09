/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.bizlogic.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import cn.tst.gongnuan.viewmodel.BaoBiaoViewModel;
import org.apache.log4j.Logger;
import cn.tst.gongnuan.service.impl.BaoBiaoFacade;
import cn.tst.gongnuan.bizlogic.BaoBiaoBizLogic;
import cn.tst.gongnuan.common.FreeMarkerUtils;
import cn.tst.gongnuan.common.SepC;
import cn.tst.gongnuan.entity.RepBiao;
import cn.tst.gongnuan.service.impl.RepBiaoFacade;
import com.google.common.base.Charsets;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.persistence.internal.sessions.ArrayRecord;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 * 出库入库统计实现类
 *
 * @author CaoChun
 */
@Stateless
public class BaoBiaoBizLogicImpl extends BaseBizLogic implements BaoBiaoBizLogic {

    private static final Logger LOG = Logger.getLogger(BaoBiaoBizLogicImpl.class.getName());

    @EJB
    private BaoBiaoFacade suJuDao;

    @EJB
    private RepBiaoFacade biaoDao;

    @Override
    public void loadBaoBiaoViewModel(BaoBiaoViewModel vm) {
//        List<CcFenZu> fenZuList = fenZuDao.findAll();
//        vm.setFenZuList(fenZuList);
    }

    @Override
    public RepBiao huoQuBaoBiao(String biaoMing) {
        return biaoDao.findByBiaoMing(biaoMing);
    }

    @Override
    public void chaXun(BaoBiaoViewModel vm) {
        List<ArrayRecord> shuJuList;

        shuJuList
                = suJuDao.getShuJuList(vm.getBiao(), vm.getTjMap());

        List<Map<String, Object>> mapList = new ArrayList<>();
        List<String> heads = new ArrayList<>();
        for (ArrayRecord arrayRecord : shuJuList) {
            Map<String, Object> map = new HashMap<>();
            for (Object field : arrayRecord.getFields()) {
                map.put(field.toString(), arrayRecord.get(field));
                if (!heads.contains(field.toString())) {
                    heads.add(field.toString());
                }
            }
            mapList.add(map);
        }
        vm.setHeads(heads);
        vm.setShuJuList(mapList);

    }

    @Override
    public List<Map<String, Object>> chaMeiJu(String sql) {

        List<ArrayRecord> shuJuList;

        shuJuList = suJuDao.chaMeiJu(sql);

        List<Map<String, Object>> mapList = new ArrayList<>();
//        List<String> heads = new ArrayList<>();
        for (ArrayRecord arrayRecord : shuJuList) {
            Map<String, Object> map = new HashMap<>();
            for (Object field : arrayRecord.getFields()) {
                map.put(field.toString(), arrayRecord.get(field));
            }
            mapList.add(map);
        }
        return mapList;
    }

    @Override
    public List<Map<String, Object>> chaMeiJuByTiaoJian(String sql, String gl, BaoBiaoViewModel vm) {
        List<Map<String, Object>> mapList = new ArrayList<>();
        List<ArrayRecord> shuJuList;
        if (!StringUtils.isEmpty(gl)) {
            String[] split = gl.split(",");
            Map<Integer, String> tjMap = new TreeMap<>();
            for (int i = 1; i <= split.length; i++) {
                String s = split[i - 1];
                if (StringUtils.isEmpty((String) vm.getTjMap().get(s))) {
                    return mapList;
                }
                tjMap.put(i, (String) vm.getTjMap().get(s));
            }
            shuJuList = suJuDao.chaMeiJuByTiaoJian(sql, tjMap);
        } else {
            shuJuList = suJuDao.chaMeiJu(sql);
        }

//        List<String> heads = new ArrayList<>();
        for (ArrayRecord arrayRecord : shuJuList) {
            Map<String, Object> map = new HashMap<>();
            for (Object field : arrayRecord.getFields()) {
                map.put(field.toString(), arrayRecord.get(field));
            }
            mapList.add(map);
        }
        return mapList;
    }

    @Override
    public void daoChuExcel(BaoBiaoViewModel vm) {

        ///word保存目录
        final String FILE_UPLOAD_PATH
                = this.getServletContext().getInitParameter(SepC.INIT_PARAM_UPLOAD_DIRECTORY) + "/ftl/";

        //文件路径
        String filePath = FILE_UPLOAD_PATH;

        //文件唯一名称
        String fileOnlyName = "baobiao" + am.getEmployee().getEmpId() + ".xls";
        File file = new File(filePath + "\\" + fileOnlyName);
        if (file.exists()) {
            file.delete();
        }
        if (!file.exists()) {
//            List<BaoBiaoDTO> shuJuList = vm.getShuJuList();
            /**
             * 用于组装页面需要的数据
             */
            Map<String, Object> dataMap = new HashMap<>();

            /**
             * 组装数据
             */
            dataMap.put("tjzq", vm.getTongJiZhouQi());
//            dataMap.put("hjs", vm.getZongShu());
            dataMap.put("biaoti", vm.getBiao().getCnBiaoMing());
            dataMap.put("zbsj", vm.getZhiBiaoShiJian());
            dataMap.put("zbbm", "集团报表系统");
            dataMap.put("heads", vm.getHeads());
            dataMap.put("shuJuList", vm.getShuJuList());
            Map<String, Object> hjMap = new HashMap<>();
            for (String head : vm.getHeads()) {
                try {
                    hjMap.put(head, vm.getTotal(head));
                } catch (NoSuchFieldException ex) {
                    java.util.logging.Logger.getLogger(BaoBiaoBizLogicImpl.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchMethodException ex) {
                    java.util.logging.Logger.getLogger(BaoBiaoBizLogicImpl.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(BaoBiaoBizLogicImpl.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    java.util.logging.Logger.getLogger(BaoBiaoBizLogicImpl.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    java.util.logging.Logger.getLogger(BaoBiaoBizLogicImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            dataMap.put("hjMap", hjMap);
            try {
                /// 生成word
                file = FreeMarkerUtils.getInstance().createWord(dataMap, "baobiao.xml", filePath, fileOnlyName);
            } catch (Exception ex) {
                LOG.error(ex.getMessage(), ex);
                throw new RuntimeException("创建word文件失败");
            }
        }
        try {
            InputStream stream = new FileInputStream(file);
//            new DefaultStreamedContent
            LOG.info(fileOnlyName);

            StreamedContent wordfile = new DefaultStreamedContent(stream, "application/vnd.ms-excel", fileOnlyName, Charsets.UTF_8.name());
            vm.setWordfile(wordfile);
        } catch (FileNotFoundException ex) {
            LOG.error(ex.getMessage(), ex);
            throw new RuntimeException("读取word文件失败");
        }
    }

}
