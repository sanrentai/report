package cn.tst.gongnuan.bizlogic.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import cn.tst.gongnuan.bizlogic.LoginBizLogic;
import cn.tst.gongnuan.common.BizConfig;
import cn.tst.gongnuan.common.SepC;
import cn.tst.gongnuan.common.SepE;
import cn.tst.gongnuan.controller.login.AccountManager;
import cn.tst.gongnuan.controller.login.LoginInfo;
import cn.tst.gongnuan.entity.Employee;
import cn.tst.gongnuan.exception.LoginException;
import cn.tst.gongnuan.service.impl.EmployeeFacade;

/**
 *
 * @author andysilver
 */
@Stateless
public class LoginBizLogicImpl implements LoginBizLogic {

    @Inject
    private BizConfig bizConfig;

    @EJB
    private EmployeeFacade yuanGongService;      ///员工
    
    @Inject
    protected AccountManager am;

    @Override
    public Employee searchEmployee(String loginId, String password) throws LoginException {
        ///获取LoginInfo
        Employee employee = null;
        employee = yuanGongService.findLoginInfo( loginId, password);
        ///不存在login信息
        if (employee == null) {
            return null;
        }
//        LoginInfo result=new LoginInfo();
//        ///员工信息
//        result.setLoginId(employee.getEmpId());
        return employee;
    }

    @Override
    public List<Employee> getEmployeeList() {
        return yuanGongService.findAll();
    }


}
