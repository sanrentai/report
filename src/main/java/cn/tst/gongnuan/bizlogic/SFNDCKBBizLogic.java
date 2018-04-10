/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.bizlogic;

import cn.tst.gongnuan.viewmodel.SFNDCKBViewModel;

/**
 * 收费年度查看表
 *
 * @author CaoChun
 */
public interface SFNDCKBBizLogic {

    /**
     * 初始化ViewModel
     *
     * @param vm 视图模型
     */
    void loadSFNDCKBViewModel(SFNDCKBViewModel vm);

    /**
     * 初始化ViewModel
     *
     * @param vm 视图模型
     */
    void chaXun(SFNDCKBViewModel vm);

    public void daoChuExcel();

    void changeCompany(SFNDCKBViewModel vm);

    void changeHuanReZhan(SFNDCKBViewModel vm);

//    void changeXiaoQu(SFNDCKBViewModel vm);

}
