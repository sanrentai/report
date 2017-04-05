package cn.tst.gongnuan.controller.wuyefei;

import java.util.Calendar;
import org.apache.log4j.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import cn.tst.gongnuan.bizlogic.WYB0001BizLogic;
import cn.tst.gongnuan.common.SepC;
import cn.tst.gongnuan.controller.BusinessBaseController;
import cn.tst.gongnuan.service.dto.YiYunSouFuWuYeFeiHuiZongBiaoDTO;
import cn.tst.gongnuan.viewmodel.WYB0001ViewModel;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 物资信息查看
 *
 * @author CaoChun
 */
@ViewScoped
@Named(SepC.ControllerID.WYB0001)
public class WYB0001Controller extends BusinessBaseController {

    private static final Logger LOG = Logger.getLogger(WYB0001Controller.class.getName());

    @EJB
    private WYB0001BizLogic bizLogic;

    /**
     * 物资信息查看视图模型
     */
    private WYB0001ViewModel vm;

    @PostConstruct
    public void init() {
        vm = new WYB0001ViewModel();
//        vm.setPayDate(new Date());
        bizLogic.loadWYB0001ViewModel(vm);
    }

    public void daoChuExcel() {
        //bizLogic.daoChuExcel();

    }

    public void chaXun() {
        LOG.info(new Date());
        bizLogic.chaXun(vm);
        LOG.info(new Date());
        heJi();
    }

    public void heJi() {
        LOG.info(new Date());
        for (YiYunSouFuWuYeFeiHuiZongBiaoDTO item : vm.getShuJuList()) {
            //住宅
            if (vm.getJk_zzMap().get(item.getMonth()) == null) {
                vm.getJk_zzMap().put(item.getMonth(), item.getJk_zz());
            } else {
                vm.getJk_zzMap().put(item.getMonth(), item.getJk_zz().add((BigDecimal) vm.getJk_zzMap().get(item.getMonth())));
            }
            //回迁
            if (vm.getJk_hqMap().get(item.getMonth()) == null) {
                vm.getJk_hqMap().put(item.getMonth(), item.getJk_hq());
            } else {
                vm.getJk_hqMap().put(item.getMonth(), item.getJk_hq().add((BigDecimal) vm.getJk_hqMap().get(item.getMonth())));
            }
            //公寓
            if (vm.getJk_gyMap().get(item.getMonth()) == null) {
                vm.getJk_gyMap().put(item.getMonth(), item.getJk_gy());
            } else {
                vm.getJk_gyMap().put(item.getMonth(), item.getJk_gy().add((BigDecimal) vm.getJk_gyMap().get(item.getMonth())));
            }
            //网点
            if (vm.getJk_wdMap().get(item.getMonth()) == null) {
                vm.getJk_wdMap().put(item.getMonth(), item.getJk_wd());
            } else {
                vm.getJk_wdMap().put(item.getMonth(), item.getJk_wd().add((BigDecimal) vm.getJk_wdMap().get(item.getMonth())));
            }
            //车库
            if (vm.getJk_ckMap().get(item.getMonth()) == null) {
                vm.getJk_ckMap().put(item.getMonth(), item.getJk_ck());
            } else {
                vm.getJk_ckMap().put(item.getMonth(), item.getJk_ck().add((BigDecimal) vm.getJk_ckMap().get(item.getMonth())));
            }
            //车位
            if (vm.getJk_cwMap().get(item.getMonth()) == null) {
                vm.getJk_cwMap().put(item.getMonth(), item.getJk_cw());
            } else {
                vm.getJk_cwMap().put(item.getMonth(), item.getJk_cw().add((BigDecimal) vm.getJk_cwMap().get(item.getMonth())));
            }
            //仓房
            if (vm.getJk_cfMap().get(item.getMonth()) == null) {
                vm.getJk_cfMap().put(item.getMonth(), item.getJk_cf());
            } else {
                vm.getJk_cfMap().put(item.getMonth(), item.getJk_cf().add((BigDecimal) vm.getJk_cfMap().get(item.getMonth())));
            }
            //合计
            if (vm.getJk_hjMap().get(item.getMonth()) == null) {
                vm.getJk_hjMap().put(item.getMonth(), item.getJk_hj());
            } else {
                vm.getJk_hjMap().put(item.getMonth(), item.getJk_hj().add((BigDecimal) vm.getJk_hjMap().get(item.getMonth())));
            }
            //住宅户数
            if (vm.getHs_zzMap().get(item.getMonth()) == null) {
                vm.getHs_zzMap().put(item.getMonth(), item.getHs_zz());
//                LOG.info(item.getHs_zz());
            } else {
//                LOG.info(item.getHs_zz());
                vm.getHs_zzMap().put(item.getMonth(), item.getHs_zz() + (int) vm.getHs_zzMap().get(item.getMonth()));
            }
            //回迁户数
            if (vm.getHs_hqMap().get(item.getMonth()) == null) {
                vm.getHs_hqMap().put(item.getMonth(), item.getHs_hq());
            } else {
                vm.getHs_hqMap().put(item.getMonth(), item.getHs_hq() + (int) vm.getHs_hqMap().get(item.getMonth()));
            }
            //公寓户数
            if (vm.getHs_gyMap().get(item.getMonth()) == null) {
                vm.getHs_gyMap().put(item.getMonth(), item.getHs_gy());
            } else {
                vm.getHs_gyMap().put(item.getMonth(), item.getHs_gy() + (int) vm.getHs_gyMap().get(item.getMonth()));
            }
            //网点户数
            if (vm.getHs_wdMap().get(item.getMonth()) == null) {
                vm.getHs_wdMap().put(item.getMonth(), item.getHs_wd());
            } else {
                vm.getHs_wdMap().put(item.getMonth(), item.getHs_wd() + (int) vm.getHs_wdMap().get(item.getMonth()));
            }
            //车库户数
            if (vm.getHs_ckMap().get(item.getMonth()) == null) {
                vm.getHs_ckMap().put(item.getMonth(), item.getHs_ck());
            } else {
                vm.getHs_ckMap().put(item.getMonth(), item.getHs_ck() + (int) vm.getHs_ckMap().get(item.getMonth()));
            }
            //车位户数
            if (vm.getHs_cwMap().get(item.getMonth()) == null) {
                vm.getHs_cwMap().put(item.getMonth(), item.getHs_cw());
            } else {
                vm.getHs_cwMap().put(item.getMonth(), item.getHs_cw() + (int) vm.getHs_cwMap().get(item.getMonth()));
            }
            //仓房户数
            if (vm.getHs_cfMap().get(item.getMonth()) == null) {
                vm.getHs_cfMap().put(item.getMonth(), item.getHs_cf());
            } else {
                vm.getHs_cfMap().put(item.getMonth(), item.getHs_cf() + (int) vm.getHs_cfMap().get(item.getMonth()));
            }
            //合计户数
            if (vm.getHs_hjMap().get(item.getMonth()) == null) {
                vm.getHs_hjMap().put(item.getMonth(), item.getHs_hj());
            } else {
                vm.getHs_hjMap().put(item.getMonth(), item.getHs_hj() + (int) vm.getHs_hjMap().get(item.getMonth()));
            }
            vm.setTotal_hs_zz(item.getHs_zz() + vm.getTotal_hs_zz());
            vm.setTotal_hs_hq(item.getHs_hq() + vm.getTotal_hs_hq());
            vm.setTotal_hs_gy(item.getHs_gy() + vm.getTotal_hs_gy());
            vm.setTotal_hs_wd(item.getHs_wd() + vm.getTotal_hs_wd());
            vm.setTotal_hs_ck(item.getHs_ck() + vm.getTotal_hs_ck());
            vm.setTotal_hs_cw(item.getHs_cw() + vm.getTotal_hs_cw());
            vm.setTotal_hs_cf(item.getHs_cf() + vm.getTotal_hs_cf());
            vm.setTotal_hs_hj(item.getHs_hj() + vm.getTotal_hs_hj());
            vm.setTotal_jk_zz(item.getJk_zz().add(vm.getTotal_jk_zz()));
            vm.setTotal_jk_hq(item.getJk_hq().add(vm.getTotal_jk_hq()));
            vm.setTotal_jk_gy(item.getJk_gy().add(vm.getTotal_jk_gy()));
            vm.setTotal_jk_wd(item.getJk_wd().add(vm.getTotal_jk_wd()));
            vm.setTotal_jk_ck(item.getJk_ck().add(vm.getTotal_jk_ck()));
            vm.setTotal_jk_cw(item.getJk_cw().add(vm.getTotal_jk_cw()));
            vm.setTotal_jk_cf(item.getJk_cf().add(vm.getTotal_jk_cf()));
            vm.setTotal_jk_hj(item.getJk_hj().add(vm.getTotal_jk_hj()));
        }
        LOG.info(new Date());
    }

    //*****************************************************************
    //                        Getter Setter
    //*****************************************************************
    public WYB0001ViewModel getVm() {
        return vm;
    }

    public void setVm(WYB0001ViewModel vm) {
        this.vm = vm;
    }

}
