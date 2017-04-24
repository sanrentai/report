/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.bizlogic;

import java.util.Date;
import java.util.List;
import cn.tst.gongnuan.viewmodel.TST0001ViewModel;

/**
 * 出库入库统计
 *
 * @author CaoChun
 */
public interface TST0001BizLogic {

    /**
     * 初始化ViewModel
     *
     * @param vm 视图模型
     */
    void loadTST0001ViewModel(TST0001ViewModel vm);

    /**
     * 初始化ViewModel
     *
     * @param vm 视图模型
     */
    void chaXun(TST0001ViewModel vm);

    public void daoChuExcel();

    void changeCompany(TST0001ViewModel vm);

    void changeHuanReZhan(TST0001ViewModel vm);

    void changeXiaoQu(TST0001ViewModel vm);

}
