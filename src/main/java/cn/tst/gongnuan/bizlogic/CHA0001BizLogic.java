/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.bizlogic;

import java.util.Date;
import java.util.List;
import cn.tst.gongnuan.viewmodel.CHA0001ViewModel;

/**
 * 出库入库统计
 *
 * @author CaoChun
 */
public interface CHA0001BizLogic {

    /**
     * 初始化ViewModel
     *
     * @param vm 视图模型
     */
    void loadCHA0001ViewModel(CHA0001ViewModel vm);

    void chaXun(CHA0001ViewModel vm);

    public void daoChuExcel();

}
