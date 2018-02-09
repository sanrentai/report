/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.bizlogic;

import cn.tst.gongnuan.common.SepE;
import cn.tst.gongnuan.viewmodel.ExecuteResult;
import cn.tst.gongnuan.viewmodel.BaoBiaoGuanLiViewModel;

/**
 * 人员分组设置
 *
 * @author CaoChun
 */
public interface BaoBiaoGuanLiBizLogic {

    void loadrenYuanFenZuSheZhiViewModel(BaoBiaoGuanLiViewModel vm);

    /**
     * 保存报表
     *
     * @param mode 执行模式
     * @param vm 视图模型
     * @return 执行结果
     */
    ExecuteResult saveRepBiao(SepE.ExecuteMode mode, BaoBiaoGuanLiViewModel vm);

    void refresh(BaoBiaoGuanLiViewModel vm);

}
