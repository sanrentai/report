package cn.tst.gongnuan.bizlogic.impl;

import java.util.List;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.servlet.ServletContext;
import cn.tst.gongnuan.common.SepE;
import cn.tst.gongnuan.controller.login.AccountManager;

/**
 * 业务逻辑基类
 *
 * @author ps_xy@pscp.co.jp
 */
//@Interceptors(BizLogicInterceptor.class)
public class BaseBizLogic {
    @Inject
    protected AccountManager am;
    
    
    /**
     * FacesContext
     *
     * @return FacesContext的实例
     */
    protected FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    /**
     * ContextPath
     *
     * @return 请求对象物理Path
     */
    protected String getRequestContextPath() {
        return this.getExternalContext().getRequestContextPath();
    }

    /**
     * 是否为Postback处理
     *
     * @return true：是postback処理 false：非postback处理
     */
    protected boolean isPostBack() {
        return this.getFacesContext().isPostback();
    }

    /**
     * 取得当前ViewId
     *
     * @return ViewId
     */
    protected String getViewID() {
        return this.getFacesContext().getViewRoot().getViewId();
    }

    /**
     * 取得ExternalContext对象
     *
     * @return ExternalContext的实例
     */
    protected ExternalContext getExternalContext() {
        return this.getFacesContext().getExternalContext();
    }
    
    /**
     * 取得ServletContext对象
     *
     * @return ServletContext的实例
     */
    protected ServletContext getServletContext() {
        return (ServletContext) this.getExternalContext().getContext();
    }
    
}