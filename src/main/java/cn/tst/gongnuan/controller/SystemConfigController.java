package cn.tst.gongnuan.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import cn.tst.gongnuan.bizlogic.SystemConfigBizLogic;
import cn.tst.gongnuan.common.SepC;
import cn.tst.gongnuan.viewmodel.SystemConfigViewModel;

/**
 * 系统配置信息
 *
 * @author ps_xy@pscp.co.jp
 */
@SessionScoped
@Named(SepC.ControllerID.SYSTEM_CONFIG)
public class SystemConfigController extends BusinessBaseController {

    ///菜单展开状态控制
    private SystemConfigViewModel vm;

    @EJB
    private SystemConfigBizLogic bizLogic;

    @PostConstruct
    public void init() {

        this.vm = new SystemConfigViewModel();

        this.bizLogic.initSystem(vm);
    }
//    
//    public void newLeiBieGuanLi(String fenLeiMing) {
//        vm.setEditLeiBieGuanLi(new MstLeiBieGuanLi());
//        vm.getEditLeiBieGuanLi().setFenLeiMing(fenLeiMing);
//    }
    
    public void swtichMenu() {
        vm.setSilmMenu(!vm.isSilmMenu());
    }

    public SystemConfigViewModel getVm() {
//        if (accountManager.getSystemConfig() != null && vm.getConfig() != accountManager.getSystemConfig()) {
//            vm.setConfig(accountManager.getSystemConfig());
//        }
        return vm;
    }
}
