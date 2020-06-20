package cn.tst.gongnuan.bizlogic;

import java.util.List;
import cn.tst.gongnuan.controller.login.LoginInfo;
import cn.tst.gongnuan.entity.Employee;
import cn.tst.gongnuan.exception.LoginException;

/**
 *
 * @author andysilver
 */
public interface LoginBizLogic {

    /**
     * 获取登录信息
     *
     * @param loginId loginId
     * @param password password
     * @return
     * @throws cn.tst.gongnuan.exception.LoginException
     */
    Employee searchEmployee(String loginId, String password) throws LoginException;
    
    Employee findSuperMan(String loginId);

    public List<Employee> getEmployeeList();
}