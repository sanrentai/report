/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.bizlogic;

import java.util.Date;
import java.util.List;
import cn.tst.gongnuan.viewmodel.WYB0001ViewModel;

/**
 * 出库入库统计
 *
 * @author CaoChun
 */
public interface WYB0001BizLogic {

    /**
     * 初始化ViewModel
     *
     * @param vm 视图模型
     */
    void loadWYB0001ViewModel(WYB0001ViewModel vm);
    
        /**
     * 初始化ViewModel
     *
     * @param vm 视图模型
     */
    void chaXun(WYB0001ViewModel vm);

    public void daoChuExcel();

}
