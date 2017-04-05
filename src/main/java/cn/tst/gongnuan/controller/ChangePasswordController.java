package cn.tst.gongnuan.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import cn.tst.gongnuan.bizlogic.ChangePasswordBizLogic;
import cn.tst.gongnuan.common.SepC;
import cn.tst.gongnuan.controller.login.LoginInfo;
import cn.tst.gongnuan.entity.Employee;
import cn.tst.gongnuan.viewmodel.ChangePasswordViewModel;
import cn.tst.gongnuan.viewmodel.ExecuteResult;

/**
 * 密码变更控制器
 *
 * @author ps_xy@pscp.co.jp
 */
@Named(SepC.ControllerID.CHANGE_PASSWORD)
@RequestScoped
public class ChangePasswordController extends BusinessBaseController {

    private ChangePasswordViewModel vm;

    @EJB
    private ChangePasswordBizLogic bizLogic;

    @PostConstruct
    public void init() {
        this.vm = new ChangePasswordViewModel();
    }

    /**
     * 保存密码变更
     */
    public String onSaveModify() {

        ///如果两次输入的密码不一致
        if (!this.vm.isSameInputValueBetween2Password()) {
            this.addMessage(new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "两次输入的密码不一致"));
            return null;
        }

        Employee employee = this.accountManager.getEmployee();

        ///更新密码
        ExecuteResult result = this.bizLogic.saveChange(employee, this.vm.getPassword());

        this.addMessage(result.createMessage());

//        if (result.isSuccess()) {
//            employee.setIsFirstTimeLogin(false);
//            return "/views/index.xhtml?faces-redirect=true";
//        }

        return "/views/index.xhtml?faces-redirect=true";
    }

    public ChangePasswordViewModel getVm() {
        return vm;
    }

    public void setVm(ChangePasswordViewModel vm) {
        this.vm = vm;
    }
}
