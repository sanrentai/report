/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.bizlogic;

import cn.tst.gongnuan.common.SepE;
import cn.tst.gongnuan.viewmodel.ExecuteResult;
import java.util.Date;
import java.util.List;
import cn.tst.gongnuan.viewmodel.MST0001ViewModel;

/**
 * 系统用户
 *
 * @author CaoChun
 */
public interface MST0001BizLogic {

    void loadMST0001ViewModel(MST0001ViewModel vm);

    /**
     * 保存违章记录
     *
     * @param mode 执行模式
     * @param vm 视图模型
     * @return 执行结果
     */
    ExecuteResult saveEmployeeJiLu(SepE.ExecuteMode mode, MST0001ViewModel vm);
    
    void refreshEmployee(MST0001ViewModel vm);
    
}
