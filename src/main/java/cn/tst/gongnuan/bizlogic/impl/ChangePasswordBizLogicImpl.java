package cn.tst.gongnuan.bizlogic.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import cn.tst.gongnuan.bizlogic.ChangePasswordBizLogic;
import cn.tst.gongnuan.common.SepE;
import cn.tst.gongnuan.entity.Employee;
import cn.tst.gongnuan.service.impl.EmployeeFacade;
import cn.tst.gongnuan.viewmodel.ExecuteResult;

/**
 *
 * @author andysilver
 */
@Stateless
public class ChangePasswordBizLogicImpl extends BaseBizLogic implements ChangePasswordBizLogic {

    @EJB
    private EmployeeFacade loginService;

    @Override
    public ExecuteResult saveChange(Employee employee, String newPasswrod) {

        ExecuteResult result = new ExecuteResult(SepE.ExecuteMode.UPDATE);

        ///设置新密码
        employee.setEmpLoginpw(newPasswrod);

        ///更新密码
        loginService.edit(employee);

        result.setSuccess(true);

        return result;
    }

}
