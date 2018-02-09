package cn.tst.gongnuan.controller.login;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import cn.tst.gongnuan.common.SepC;
import cn.tst.gongnuan.entity.Employee;

@Named
@SessionScoped
public class AccountManager implements Serializable {

    private EntityManager em = null;

    private final Map<String, EntityManager> emMap = new HashMap<>();

    /// 登录信息
    Employee employee = new Employee();
    private boolean superMan;
    private boolean loginIsSuccess;
    private String multiLoginMsg;

    public void setMultiLoginMsg(String msg) {
        this.multiLoginMsg = msg;
    }

    public String getMultiLoginMsg() {
        return multiLoginMsg;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public boolean isLoginIsSuccess() {
        return loginIsSuccess;
    }

    public void setLoginIsSuccess(boolean loginIsSuccess) {
        this.loginIsSuccess = loginIsSuccess;
    }

    public EntityManager getEntityManager(String persistenceUnitName) {
        return emMap.get(persistenceUnitName);
    }

    public EntityManager getEntityManager() {

        String persistenceUnitName;

        persistenceUnitName = SepC.PERSISTENCE_UNIT;
        em = getEntityManager(persistenceUnitName);

        return em;
    }

    public boolean isSuperMan() {
        return superMan;
    }

    public void setSuperMan(boolean superMan) {
        this.superMan = superMan;
    }

}
