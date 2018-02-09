/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.bizlogic;

import cn.tst.gongnuan.entity.RepBiao;
import cn.tst.gongnuan.viewmodel.BaoBiaoViewModel;
import java.util.List;
import java.util.Map;

/**
 * 出库入库统计
 *
 * @author CaoChun
 */
public interface BaoBiaoBizLogic {

    /**
     * 初始化ViewModel
     *
     * @param vm 视图模型
     */
    void loadBaoBiaoViewModel(BaoBiaoViewModel vm);

    /**
     * 初始化ViewModel
     *
     * @param vm 视图模型
     */
    void chaXun(BaoBiaoViewModel vm);
    
    List<Map<String, Object>> chaMeiJu(String sql);

    List<Map<String, Object>> chaMeiJuByTiaoJian(String sql,String gl,BaoBiaoViewModel vm);

    public void daoChuExcel(BaoBiaoViewModel vm);

    public RepBiao huoQuBaoBiao(String biaoMing);

}
