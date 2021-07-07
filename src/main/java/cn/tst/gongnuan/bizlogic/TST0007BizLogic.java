/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.bizlogic;

import cn.tst.gongnuan.viewmodel.TST0007ViewModel;

/**
 * 各公司年度供热费减免费用汇总表
 *
 * @author CaoChun
 */
public interface TST0007BizLogic {

    /**
     * 初始化ViewModel
     *
     * @param vm 视图模型
     */
    void loadTST0007ViewModel(TST0007ViewModel vm);

    /**
     * 初始化ViewModel
     *
     * @param vm 视图模型
     */
    void chaXun(TST0007ViewModel vm);

    public void daoChuExcel();

}
