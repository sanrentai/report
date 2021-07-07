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
import cn.tst.gongnuan.viewmodel.HYC0001ViewModel;
import org.apache.log4j.Logger;
import cn.tst.gongnuan.bizlogic.HYC0001BizLogic;
import cn.tst.gongnuan.service.dto.HySouFeiMingXiDTO;
import cn.tst.gongnuan.service.impl.HySouFeiMingXiFacade;

/**
 * 出库入库统计实现类
 *
 * @author CaoChun
 */
@Stateless
public class HYC0001BizLogicImpl extends BaseBizLogic implements HYC0001BizLogic {

    private static final Logger LOG = Logger.getLogger(HYC0001BizLogicImpl.class.getName());

    @EJB
    private HySouFeiMingXiFacade shuJuDao;

    @Override
    public void loadHYC0001ViewModel(HYC0001ViewModel vm) {
        vm.setPayDate(new Date());
    }

    @Override
    public void chaXun(HYC0001ViewModel vm) {
        List<HySouFeiMingXiDTO> shuJuList = shuJuDao.getShuJu(vm.getPayDate());
        vm.setShuJuList(shuJuList);
    }

    @Override
    public void daoChuExcel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
