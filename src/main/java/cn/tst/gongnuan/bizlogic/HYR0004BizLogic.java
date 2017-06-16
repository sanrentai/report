/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.bizlogic;

import cn.tst.gongnuan.viewmodel.HYR0004ViewModel;

/**
 *
 * @author Aaron
 */
public interface HYR0004BizLogic {
    /**
     * 初始化ViewModel
     *
     * @param vm 视图模型
     */
    void loadHYR0004ViewModel(HYR0004ViewModel vm);

    /**
     * 初始化ViewModel
     *
     * @param vm 视图模型
     */
    void chaXun(HYR0004ViewModel vm);

    public void daoChuExcel();

    void changeCompany(HYR0004ViewModel vm);

    void changeHuanReZhan(HYR0004ViewModel vm);

    void changeXiaoQu(HYR0004ViewModel vm);
}
