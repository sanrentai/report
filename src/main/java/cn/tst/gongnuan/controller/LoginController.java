package cn.tst.gongnuan.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;
import cn.tst.gongnuan.bizlogic.LoginBizLogic;
import cn.tst.gongnuan.common.BizConfig;
import cn.tst.gongnuan.common.SepC;
import cn.tst.gongnuan.controller.login.GlobalLoginManager;
import cn.tst.gongnuan.entity.Employee;
import cn.tst.gongnuan.exception.LoginException;
import org.apache.log4j.Logger;

/**
 * 登录页面控制�?
 *
 * @author ps_xy@pscp.co.jp
 */
@Named(SepC.ControllerID.LOGIN)
//@RequestScoped
@SessionScoped
public class LoginController extends BusinessBaseController {

    private static final Logger LOG = Logger.getLogger(LoginController.class.getName());

    ///用户�?
    private String loginId;
    ///密码
    private String password;
    ///登录次数计数
    private int loginCounter = 0;
    ///错误信息
    private String loginErrorMsg;

    private List<Employee> employeeList;

    @Inject
    private BizConfig bizConfig;

    @EJB
    private LoginBizLogic bizLogic;

    @Inject
    private GlobalLoginManager glm;

//    private List<MstGongChengXiangMu> buMenXiangMuList;
    private String selectedSysId;

    private String selectedBuMenId;

    /**
     * 页面初始�?
     */
    @PostConstruct
    public void init() {
        employeeList = bizLogic.getEmployeeList();
    }

    /**
     * 登录处理
     *
     * @return
     */
    public String login() {

        // ログインエラーメッセージの初期化
        this.loginErrorMsg = "";

        try {

            Employee employee;
            if ("000000".equals(this.loginId) && "admin8548!".equals(this.password)) {

                employee = bizLogic.findSuperMan(this.loginId);
                this.accountManager.setSuperMan(employee != null);
            } else {
                employee = bizLogic.searchEmployee(this.loginId, this.password);
                this.accountManager.setSuperMan(false);
            }

            ///Login成功 or 失败
            this.accountManager.setLoginIsSuccess(employee != null);

            ///Login�?
            this.accountManager.setEmployee(employee);

        } catch (LoginException ex) {
            this.loginErrorMsg = "[" + ex.getErrorCode() + "]: " + ex.getErrorMessage();
            this.accountManager.setLoginIsSuccess(false);
            return null;
        }

        // ユーザID,パスワードがミスの場�?
        LOG.info(this.accountManager.isLoginIsSuccess());
        if (!this.accountManager.isLoginIsSuccess()) {
            this.loginErrorMsg = bizConfig.getText("login_id_or_pass_miss");
            this.addMessage(new FacesMessage(FacesMessage.SEVERITY_ERROR, null, this.getLoginResultMessage()));
            LOG.info("--------------登录失败-------------用户名密码错�?");
            return null;
        }

        /// 是否为冻结的用户
        if (this.accountManager.getEmployee().isIsLockUser()) {
            this.loginErrorMsg = bizConfig.getText("login_is_locked");
            this.addMessage(new FacesMessage(FacesMessage.SEVERITY_ERROR, null, this.getLoginResultMessage()));
            LOG.info("--------------登录失败-------------用户被冻�?,无法使用");
            return null;
        }

        LOG.info("--------------登录成功-------------");

        return "/views/index.xhtml?faces-redirect=true";
    }

    /**
     * 登出处理
     *
     * @return 登入路径
     */
    public String logOut() {

        LOG.info("セッション破棄する前");
        this.getExternalContext().invalidateSession();
        LOG.info("セッション破棄した後");

        return "/login.xhtml?faces-redirect=true";
    }

    public int getLoginCounter() {
        return loginCounter;
    }

    /**
     * ログイン回数をカウントす�?
     *
     * @param loginCounter
     */
    public void setLoginCounter(int loginCounter) {
        this.loginCounter = loginCounter + 1;
    }

    /**
     * ログイン結果の取�?
     *
     * @return
     */
    private String getLoginResultMessage() {
        String resultMsg = this.loginErrorMsg;
        if (this.loginCounter > 0 && !this.accountManager.isLoginIsSuccess()) {

            // ログイン回数と残ログイン可能回数の設�?
            resultMsg = "\n" + bizConfig.getText("loginResultMsg",
                    this.loginCounter,
                    "" + (SepC.MAX_ERROR_LOGIN_COUNT - this.loginCounter));
        }
        return resultMsg;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginId() {
        return this.loginId;
    }

    public String getPassword() {
        return this.password;
    }

    public String getSelectedBuMenId() {
        return selectedBuMenId;
    }

    public void setSelectedBuMenId(String selectedBuMenId) {
        this.selectedBuMenId = selectedBuMenId;
    }

    public String getSelectedSysId() {
        return selectedSysId;
    }

    public void setSelectedSysId(String selectedSysId) {
        this.selectedSysId = selectedSysId;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

}
