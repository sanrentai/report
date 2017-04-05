/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.bizlogic;

import cn.tst.gongnuan.viewmodel.TST0004ViewModel;

/**
 *
 * @author Aaron
 */
public interface TST0004BizLogic {
    /**
     * 初始化ViewModel
     *
     * @param vm 视图模型
     */
    void loadTST0004ViewModel(TST0004ViewModel vm);

    /**
     * 初始化ViewModel
     *
     * @param vm 视图模型
     */
    void chaXun(TST0004ViewModel vm);

    public void daoChuExcel();

    void changeCompany(TST0004ViewModel vm);

    void changeHuanReZhan(TST0004ViewModel vm);

    void changeXiaoQu(TST0004ViewModel vm);
}
