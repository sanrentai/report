/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.bizlogic;

import java.util.Date;
import java.util.List;
import cn.tst.gongnuan.viewmodel.HYR0001ViewModel;

/**
 * 出库入库统计
 *
 * @author CaoChun
 */
public interface HYR0001BizLogic {

    /**
     * 初始化ViewModel
     *
     * @param vm 视图模型
     */
    void loadHYR0001ViewModel(HYR0001ViewModel vm);

    /**
     * 初始化ViewModel
     *
     * @param vm 视图模型
     */
    void chaXun(HYR0001ViewModel vm);

    public void daoChuExcel();

    void changeCompany(HYR0001ViewModel vm);

    void changeHuanReZhan(HYR0001ViewModel vm);

    void changeXiaoQu(HYR0001ViewModel vm);

}
