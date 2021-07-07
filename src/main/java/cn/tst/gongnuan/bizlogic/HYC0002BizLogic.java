/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.bizlogic;

import java.util.Date;
import java.util.List;
import cn.tst.gongnuan.viewmodel.HYC0002ViewModel;

/**
 * 出库入库统计
 *
 * @author CaoChun
 */
public interface HYC0002BizLogic {

    /**
     * 初始化ViewModel
     *
     * @param vm 视图模型
     */
    void loadHYC0002ViewModel(HYC0002ViewModel vm);
    
        /**
     * 初始化ViewModel
     *
     * @param vm 视图模型
     */
    void chaXun(HYC0002ViewModel vm);

    public void daoChuExcel();

}
