/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.bizlogic.impl;


import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import cn.tst.gongnuan.viewmodel.CHA0001ViewModel;
import org.apache.log4j.Logger;
import cn.tst.gongnuan.bizlogic.CHA0001BizLogic;
import cn.tst.gongnuan.service.dto.SouFeiMingXiDTO;
import cn.tst.gongnuan.service.impl.SouFeiMingXiFacade;

/**
 * 出库入库统计实现类
 *
 * @author CaoChun
 */
@Stateless
public class CHA0001BizLogicImpl extends BaseBizLogic implements CHA0001BizLogic {

    private static final Logger LOG = Logger.getLogger(CHA0001BizLogicImpl.class.getName());

    @EJB
    private SouFeiMingXiFacade shuJuDao;

    @Override
    public void loadCHA0001ViewModel(CHA0001ViewModel vm) {
        vm.setPayDate(new Date());
    }

    @Override
    public void chaXun(CHA0001ViewModel vm) {
        List<SouFeiMingXiDTO> shuJuList = shuJuDao.getShuJu(vm.getPayDate());
        vm.setShuJuList(shuJuList);
    }

    @Override
    public void daoChuExcel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
