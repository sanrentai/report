/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.bizlogic;

import java.util.Date;
import java.util.List;
import cn.tst.gongnuan.viewmodel.CHA0003ViewModel;

/**
 * 出库入库统计
 *
 * @author CaoChun
 */
public interface CHA0003BizLogic {

    /**
     * 初始化ViewModel
     *
     * @param vm 视图模型
     */
    void loadCHA0003ViewModel(CHA0003ViewModel vm);
    
        /**
     * 初始化ViewModel
     *
     * @param vm 视图模型
     */
    void chaXun(CHA0003ViewModel vm);
    
    void changeCompany(CHA0003ViewModel vm);

    public void daoChuExcel();

}
