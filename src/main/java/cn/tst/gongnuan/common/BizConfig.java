package cn.tst.gongnuan.common;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.component.visit.VisitCallback;
import javax.faces.component.visit.VisitContext;
import javax.faces.component.visit.VisitResult;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.apache.commons.lang3.StringUtils;

/**
 * 业务参数配置�?
 *
 * @author ps_xy@pscp.co.jp
 */
@SessionScoped
@Named("bizConfig")
public class BizConfig implements Serializable {

    /**
     * 内容表单的ID
     */
    private final String CONTENT_FORM_ID = "frmMain";

    /**
     * 表示语言设置
     */
    private final String locale = "zh";

    /**
     * i18n包名
     */
    private final String I180N_PACKAGE_NAME = "i18n.messages";

    /**
     * 资源文件对象
     */
    private final ResourceBundle _bundle;

    /**
     * 构�?�函�?
     */
    public BizConfig() {

        //本地化信息初始化
        this._bundle = ResourceBundle.getBundle(I180N_PACKAGE_NAME,
                FacesContext.getCurrentInstance().getViewRoot().getLocale());
    }

    /**
     * FaceMessageIdを取�?
     *
     * @param controlId�?控件ID
     * @return�?表单ID:控件ID
     */
    public String getFaceMessageID(String controlId) {
        return this.CONTENT_FORM_ID + CConst.CORON + controlId;
    }

    public UIComponent findComponent(final String id) {

        FacesContext context = FacesContext.getCurrentInstance();
        UIViewRoot root = context.getViewRoot();
        final UIComponent[] found = new UIComponent[1];

        root.visitTree(VisitContext.createVisitContext(context), new VisitCallback() {
            @Override
            public VisitResult visit(VisitContext context, UIComponent component) {
                if (component.getId().equals(id)) {
                    found[0] = component;
                    return VisitResult.COMPLETE;
                }
                return VisitResult.ACCEPT;
            }
        });

        return found[0];
    }

    /**
     * 取得资源文件种的内容
     *
     * @param key �?
     * @return �?
     */
    public String getText(String key) {

        String value = null;

        if (StringUtils.isEmpty(key)) {
            return "找不到Message文本";
        } else {
            value = this._bundle.getString(key);
            return value == null ? key : value;
        }
    }

    /**
     * 取得资源文件种的内容
     *
     * @param key �?
     * @param messages 替换的字符串
     * @return �?
     */
    public String getText(String key, Object... messages) {
        return MessageFormat.format(this.getText(key), messages);
    }

    public String getLocale() {
        return locale;
    }

    /**
     * 日期格式: �?-�?
     *
     * @return MM-dd
     */
    public String getDateShortMonthDay() {
        return SepC.FORMAT_DATE_MD;
    }

    /**
     * 日期格式: �?/�?/�?
     *
     * @return yyyy-MM-dd
     */
    public String getDateFormat() {
        return SepC.FORMAT_DATE_TYPE;
    }

    /**
     * 日期格式: �?/�?/�? �?:�?(24时制)
     *
     * @return yyyy-MM-dd HH:mm
     */
    public String getDateTimeFormat() {
        return SepC.FORMAT_DATETIME_TYPE;
    }

    /**
     * 日期格式: �?/�?/�? �?:�?:�?(24时制)
     *
     * @return yyyy-MM-dd HH:mm:ss
     */
    public String getDateTimeFormat2() {
        return SepC.FORMAT_DATETIME2_TYPE;
    }

    /**
     * 日期格式: �?:�?(24时制)
     *
     * @return HH:mm
     */
    public String getTime24HHmmFormat() {
        return SepC.FORMAT_TIME_TYPE24HM;
    }

    public String getEmailRegex() {
        return SepC.REGEX_EMAIL;
    }

    public SepE.GouMaiShenQingZhuangTai[] getGouMaiShenQingZhuangTai() {
        return SepE.GouMaiShenQingZhuangTai.values();
    }

    public SepE.ShenQingLuLiZhuangTai[] getShenQingLuLiZhuangTai() {
        return SepE.ShenQingLuLiZhuangTai.values();
    }

    public String getNumberFormatPattern() {
        return SepC.FORMAT_NUMBER;
    }

    /**
     * 获取�?有流程区�?
     *
     * @return �?有流程区�?
     */
    public List<SepE.LiuChengQuFen> getLiuChengQuFen() {
        return Arrays.asList(SepE.LiuChengQuFen.values());
    }

    /**
     * 获取可自定义流程区分
     *
     * @return 可自定义流程区分
     */
    public List<SepE.LiuChengQuFen> getEditableLiuChengQuFen() {
        List<SepE.LiuChengQuFen> list = new ArrayList<>();
        list.add(SepE.LiuChengQuFen.GOU_MAI_SHEN_QING);
        list.add(SepE.LiuChengQuFen.CAI_GOU_JI_HUA);
        list.add(SepE.LiuChengQuFen.CAI_GOU_HE_TONG);
        list.add(SepE.LiuChengQuFen.ZHI_FU_JI_HUA);
        list.add(SepE.LiuChengQuFen.YONG_CHE_SHEN_QING);
        return list;
    }

    /**
     * 获取�?有归集项区分
     *
     * @return �?有归集项区分
     */
    public List<SepE.GuiJiXiangQuFen> getGuiJiXiangQuFen() {
        return Arrays.asList(SepE.GuiJiXiangQuFen.values());
    }

    /**
     * 获取�?有流程模式区�?
     *
     * @return �?有流程模式区�?
     */
    public SepE.LiuChengMoShiQuFen[] getLiuChengMoShiQuFen() {
        return SepE.LiuChengMoShiQuFen.values();
    }

    /**
     * 获取�?有流程条件区�?
     *
     * @return �?有流程条件区�?
     */
    public SepE.LiuChengTiaoJianQuFen[] getLiuChengTiaoJianQuFen() {
        return SepE.LiuChengTiaoJianQuFen.values();
    }

    /**
     * 获取�?有的物资类型
     *
     * @return 物资类型
     */
    public SepE.WuZiLeiXing[] getWuZiLeiXing() {
        return SepE.WuZiLeiXing.values();
    }

    /**
     * 获取�?有的入库方式
     *
     * @return 入库方式
     */
    public SepE.RuKuFangShi[] getRuKuFangShi() {
        return SepE.RuKuFangShi.values();
    }

    /**
     * 获取�?有的出库方式
     *
     * @return 出库方式
     */
    public SepE.ChuKuFangShi[] getChuKuFangShi() {
        return SepE.ChuKuFangShi.values();
    }

    /**
     * 获取�?有车辆类�?
     *
     * @return 车辆类型
     */
    public SepE.CheLiangLeiXing[] getCheLiangLeiXing() {
        return SepE.CheLiangLeiXing.values();
    }

    public SepE.CheLiangSuoShu[] getCheLiangSuoShu() {
        return SepE.CheLiangSuoShu.values();
    }

    /**
     * 获取�?有用车记录状�?
     *
     * @return �?有用车记录状�?
     */
    public List<SepE.YongCheJiLuZhuangTai> getYongCheJiLuZhuangTai() {
        return Arrays.asList(SepE.YongCheJiLuZhuangTai.values());
    }

    /**
     * 获取�?有油卡类�?
     *
     * @return 油卡类型
     */
    public SepE.YouKaLeiXing[] getYouKaLeiXing() {
        return SepE.YouKaLeiXing.values();
    }

    /**
     * 获取�?有提供服务类�?
     *
     * @return 提供服务类型
     */
    public SepE.TiGongFuWuLeiXing[] getTiGongFuWuLeiXing() {
        return SepE.TiGongFuWuLeiXing.values();
    }

    /**
     * 报表条件类型
     *
     * @return 报表条件类型
     */
    public SepE.BaoBiaoTiaoJianLeiXing[] getBaoBiaoTiaoJianLeiXing() {
        return SepE.BaoBiaoTiaoJianLeiXing.values();
    }
}
