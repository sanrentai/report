package cn.tst.gongnuan.common;

import cn.tst.gongnuan.common.SepC.GouMaiFangShiConst;

/**
 * 枚举定义
 *
 * @author ps_xy@pscp.co.jp
 */
public class SepE {

    /**
     * 画面状態
     */
    public static enum PageStatus {

        /**
         * 初期
         */
        INIT,
        /**
         * 編集�?
         */
        EDITING,
        /**
         * 只读
         */
        READONLY,
    }

    /**
     * 画面编辑模式
     */
    public static enum EditMode {

        /**
         * 未使�?
         */
        NONE,
        /**
         * 新規
         */
        INSERT,
        /**
         * 更新
         */
        UPDATE,
        /**
         * 検索
         */
        SELECT,
        /**
         * 削除
         */
        DELETE
    }

    /**
     * �?索内容类�?
     */
    public static enum SearchContentTypeEnum {

        /**
         * 件数
         */
        COUNT,
        /**
         * �?
         */
        COLUMNS
    }

    /**
     * Yes Or No 标志枚举类型
     * <p>
     * �?:1 �?:0,数据库中对应有效无效之类的标志位<br/>
     * Entity中的标志位均使用此枚�?
     * </p>
     */
    public static enum Flag {

        YES("1"),
        NO("0");

        private final String value;

        Flag(String value) {
            this.value = value;
        }

        public final String getValue() {
            return value;
        }

        public static Flag parse(String v) {

            switch (v) {
                case "0":
                    return NO;
                case "1":
                    return YES;
                default:
                    return null;
            }
        }
    }

    /**
     * 物资申请状�??
     */
    public static enum TiaoPeiZhuangTai {
        /**
         * 草稿
         */
        CAO_GAO(0),
        /**
         * 物资申请�? (物资申请提出�?)
         */
        SHENQINGZHONG(1),
        /**
         * 物资申请驳回 (审批驳回)
         */
        SHENQING_BOHUI(2),
        /**
         * 物资调配 (仓库分配�?)
         */
        SHENQING_TIAOPEI(3),
        /**
         * 购买申请 (仓库库存不足，提出购买申请后)
         */
        GOUMAI_SHENQING(4),
        /**
         * 购买申请驳回 (审批未�?�过，购买申请被驳回)
         */
        GOUMAI_BOHUI(5),
        /**
         * 计划采购 (购买申请审批通过)
         */
        JIHUACAIGOU(6),
        /**
         * 采购方案提出 (采购部门制定采购方案�?)
         */
        CAIGOUFANGAN_TICHU(7),
        /**
         * 采购方案驳回 (采购方案审批未�?�过)
         */
        CAIGOUFANGAN_BOHUI(8),
        /**
         * 资金调配 (采购方案审批通过)
         */
        ZIJINTIAOPEI(9),
        /**
         * 采购�? (资金调配完毕)
         */
        CAIGOUZHONG(10),
        /**
         * 入库 (购买完成，物品入�?)
         */
        RUKU(11),
        /**
         * 调配结束 (仓库将库存物品分配给申请�?)
         */
        TIAOPEIJIESHU(12),
        /**
         * 废止
         */
        FEI_ZHI(13),
        /**
         * 已撤�?
         */
        CHE_XIAO(14);

        private final int value;

        TiaoPeiZhuangTai(int value) {
            this.value = value;
        }

        public final int getValue() {
            return value;
        }

        public static TiaoPeiZhuangTai parse(int v) {

            switch (v) {
                case 0:
                    return CAO_GAO;
                case 1:
                    return SHENQINGZHONG;
                case 2:
                    return SHENQING_BOHUI;
                case 3:
                    return SHENQING_TIAOPEI;
                case 4:
                    return GOUMAI_SHENQING;
                case 5:
                    return GOUMAI_BOHUI;
                case 6:
                    return JIHUACAIGOU;
                case 7:
                    return CAIGOUFANGAN_TICHU;
                case 8:
                    return CAIGOUFANGAN_BOHUI;
                case 9:
                    return ZIJINTIAOPEI;
                case 10:
                    return CAIGOUZHONG;
                case 11:
                    return RUKU;
                case 12:
                    return TIAOPEIJIESHU;
                case 13:
                    return FEI_ZHI;
                case 14:
                    return CHE_XIAO;
                default:
                    return null;
            }
        }

        public String getMessage() {
            switch (this) {
                case CAO_GAO:
                    return "草稿";
                case SHENQINGZHONG:
                    return "物资申请�?";
                case SHENQING_BOHUI:
                    return "物资申请被驳�?";
                case CAIGOUFANGAN_BOHUI:
                    return "采购计划被驳�?";
                case GOUMAI_BOHUI:
                    return "购买申请被驳�?";
                case CAIGOUZHONG:
                    return "采购�?";
                case SHENQING_TIAOPEI:
                    return "物资调配�?";
                case GOUMAI_SHENQING:
                    return "购买申请�?";
                case JIHUACAIGOU:
                    return "计划采购�?";
                case CAIGOUFANGAN_TICHU:
                    return "采购方案提出";
                case ZIJINTIAOPEI:
                    return "资金调配�?";
                case RUKU:
                    return "入库完成";
                case TIAOPEIJIESHU:
                    return "调配结束";
                case FEI_ZHI:
                    return "已废�?";
                case CHE_XIAO:
                    return "已撤�?";
                default:
                    return "错误状�??";
            }
        }
    }

    /**
     * 审批结果
     */
    public static enum ShenPiJieGuo {
        /**
         * 审批结果：中间OK
         */
        ZHONG_JIAN_OK(1),
        /**
         * 审批结果：中间NG
         */
        ZHONG_JIAN_NG(2),
        /**
         * 审批结果：最终OK
         */
        ZUI_ZHONG_OK(3),
        /**
         * 审批结果：最终NG
         */
        ZUI_ZHONG_NG(4),
        /**
         * 审批结果：废�?
         */
        FEI_ZHI(5);

        private final int value;

        ShenPiJieGuo(int value) {
            this.value = value;
        }

        public final int getValue() {
            return value;
        }

        public static ShenPiJieGuo parse(int v) {

            switch (v) {
                case 1:
                    return ZHONG_JIAN_OK;
                case 2:
                    return ZHONG_JIAN_NG;
                case 3:
                    return ZUI_ZHONG_OK;
                case 4:
                    return ZUI_ZHONG_NG;
                case 5:
                    return FEI_ZHI;
                default:
                    return null;
            }
        }

        public String getMessage() {
            switch (this) {
                case ZHONG_JIAN_OK:
                    return "中间OK";
                case ZHONG_JIAN_NG:
                    return "中间NG";
                case ZUI_ZHONG_OK:
                    return "�?终OK";
                case ZUI_ZHONG_NG:
                    return "�?终NG";
                case FEI_ZHI:
                    return "废止";
                default:
                    return null;
            }
        }
    }

    /**
     * 在职状�??
     */
    public static enum ZaiZhiZhuangTai {
        /**
         * 在职状�?�：在职
         */
        ZAI_ZHI("1"),
        /**
         * 在职状�?�：卸任
         */
        XIE_REN("0");

        private final String value;

        ZaiZhiZhuangTai(String value) {
            this.value = value;
        }

        public final String getValue() {
            return value;
        }

        public static ZaiZhiZhuangTai parse(String v) {

            switch (v) {
                case "0":
                    return XIE_REN;
                case "1":
                    return ZAI_ZHI;
                default:
                    return null;
            }
        }
    }

    /**
     * 責任行使状�??
     */
    public static enum ZeRenZhuangTai {
        /**
         * 1:行使�?
         */
        XING_SHI_ZHONG("1"),
        /**
         * 0:未行�?
         */
        WEI_XING_SHI("0");

        private final String value;

        ZeRenZhuangTai(String value) {
            this.value = value;
        }

        public final String getValue() {
            return value;
        }

        public static ZeRenZhuangTai parse(String v) {

            switch (v) {
                case "0":
                    return WEI_XING_SHI;
                case "1":
                    return XING_SHI_ZHONG;
                default:
                    return null;
            }
        }

        public String getMessage() {
            switch (this) {
                case WEI_XING_SHI:
                    return "未行�?";
                case XING_SHI_ZHONG:
                    return "行使�?";
                default:
                    return "";
            }
        }
    }

    /**
     * 物类标识
     */
    public static enum WuLeiQuFen {
        /**
         * 物品标识
         */
        WUPIN("W"),
        /**
         * 类别标识
         */
        LEIBIE("L"),
        /**
         * 物品和类别标�?
         */
        WUPIN_AND_LEIBIE("J");

        private String value;

        WuLeiQuFen(String value) {
            this.value = value;
        }

        public final String getValue() {
            return value;
        }

        public final void setValue(String v) {
            this.value = v;
        }

        /**
         * 表示名を取得する
         *
         * @return
         */
        public String getName() {
            switch (this) {
                case LEIBIE:
                    return "类别";
                case WUPIN:
                    return "物品";
                case WUPIN_AND_LEIBIE:
                    return "物品和类�?";
                default:
                    return CConst.BLANK;
            }
        }

        public static WuLeiQuFen parse(String v) {

            switch (v) {
                case "W":
                    return WUPIN;
                case "L":
                    return LEIBIE;
                case "J":
                    return WUPIN_AND_LEIBIE;
                default:
                    return null;
            }
        }
    }

    /**
     * 审批区分
     */
    public static enum ShenPiQuFen {
        /**
         * 中间审批
         */
        ZHONG_JIAN(0),
        /**
         * �?终审�?
         */
        ZUI_ZHONG(1);

        private final int value;

        ShenPiQuFen(int value) {
            this.value = value;
        }

        public final int getValue() {
            return value;
        }

        public static ShenPiQuFen parse(int v) {

            switch (v) {
                case 0:
                    return ZHONG_JIAN;
                case 1:
                    return ZUI_ZHONG;
                default:
                    return null;
            }
        }

        public String getMessage() {
            switch (this) {
                case ZHONG_JIAN:
                    return "中间审批";
                case ZUI_ZHONG:
                    return "�?终审�?";
            }
            return null;
        }
    }

    /**
     * 审批区分
     */
    public static enum ChuRuKuQuFen {
        /**
         * 中间审批
         */
        Ru_KU("0"),
        /**
         * �?终审�?
         */
        CHU_KU("1");

        private final String value;

        ChuRuKuQuFen(String value) {
            this.value = value;
        }

        public final String getValue() {
            return value;
        }

        public static ChuRuKuQuFen parse(String v) {

            switch (v) {
                case "0":
                    return Ru_KU;
                case "1":
                    return CHU_KU;
                default:
                    return null;
            }
        }

        public String getMessage() {
            switch (value) {
                case "0":
                    return "入库";
                case "1":
                    return "出库";
                default:
                    return null;
            }
        }
    }

    /**
     * 物资分配明细状�??
     */
    public static enum WuZiFenPeiZhuangTai {
        /**
         * 分配，等待库房备�?
         */
        FEN_PEI(0),
        /**
         * 向调度中心发出请�? 1：直接指定仓库发�?
         */
        ZHI_JIE_CHU_KU(1),
        /**
         * 向调度中心发出请�? 2：制定仓库调出相应的数量
         */
        DIAO_BO(2),
        /**
         * 申请出库
         */
        SHEN_QING_CHU_KU(3),
        /**
         * 购买申请NG
         */
        SHEN_QING_NG(4),
        /**
         * 出库
         */
        CHU_KU(5),
        /**
         * 备货完毕
         */
        BEI_HUO_WAN_BI(6),
        /**
         * 废止
         */
        FEI_ZHI(7);

        private final int value;

        WuZiFenPeiZhuangTai(int value) {
            this.value = value;
        }

        public final int getValue() {
            return value;
        }

        public static WuZiFenPeiZhuangTai parse(int v) {

            switch (v) {
                case 0:
                    return FEN_PEI;
                case 1:
                    return ZHI_JIE_CHU_KU;
                case 2:
                    return DIAO_BO;
                case 3:
                    return SHEN_QING_CHU_KU;
                case 4:
                    return SHEN_QING_NG;
                case 5:
                    return CHU_KU;
                case 6:
                    return BEI_HUO_WAN_BI;
                case 7:
                    return FEI_ZHI;
                default:
                    return null;
            }
        }
    }

    /**
     * 购买申请明细状�??
     */
    public static enum GouMaiShenQingZhuangTai {
        /**
         * 已申�?
         */
        SHEN_QING(0),
        /**
         * 审批OK
         */
        SHEN_PI_OK(1),
        /**
         * 审批NG
         */
        SHEN_PI_NG(2),
        /**
         * 完成
         */
        WAN_CHENG(3),
        /**
         * 采购部已受理
         */
        CAI_GOU_BU_YI_SHOU_LI(4),
        /**
         * 采购�?
         */
        CAI_GOU_ZHONG(5),
        /**
         * 废止
         */
        FEI_ZHI(6);

        private final int value;

        GouMaiShenQingZhuangTai(int value) {
            this.value = value;
        }

        public final int getValue() {
            return value;
        }

        public static GouMaiShenQingZhuangTai parse(int v) {

            switch (v) {
                case 0:
                    return SHEN_QING;
                case 1:
                    return SHEN_PI_OK;
                case 2:
                    return SHEN_PI_NG;
                case 3:
                    return WAN_CHENG;
                case 4:
                    return CAI_GOU_BU_YI_SHOU_LI;
                case 5:
                    return CAI_GOU_ZHONG;
                case 6:
                    return FEI_ZHI;
                default:
                    return null;
            }
        }

        public String getMessage() {
            switch (value) {
                case 0:
                    return "已申�?";
                case 1:
                    return "审批通过";
                case 2:
                    return "审批驳回";
                case 3:
                    return "完成";
                case 4:
                    return "采购部已受理";
                case 5:
                    return "采购�?";
                case 6:
                    return "废止";
                default:
                    return null;
            }
        }
    }

    /**
     * 调拨申请明细状�??
     */
    public static enum DiaoBoShenQingZhuangTai {
        /**
         * 已申�?
         */
        SHEN_QING(0),
        /**
         * 申请OK
         */
        SHEN_QING_OK(1),
        /**
         * 申请NG
         */
        SHEN_QING_NG(2),
        /**
         * 等待出库
         */
        DENG_DAI_CHU_KU(3),
        /**
         * 等待入库
         */
        DENG_DAI_RU_KU(4),
        /**
         * 完成
         */
        WAN_CHENG(5);

        private final int value;

        DiaoBoShenQingZhuangTai(int value) {
            this.value = value;
        }

        public final int getValue() {
            return value;
        }

        public static DiaoBoShenQingZhuangTai parse(int v) {

            switch (v) {
                case 0:
                    return SHEN_QING;
                case 1:
                    return SHEN_QING_OK;
                case 2:
                    return SHEN_QING_NG;
                case 3:
                    return DENG_DAI_CHU_KU;
                case 4:
                    return DENG_DAI_RU_KU;
                case 5:
                    return WAN_CHENG;
                default:
                    return null;
            }
        }

        public String getMessage() {
            switch (value) {
                case 0:
                    return "已申�?";
                case 1:
                    return "申请通过";
                case 2:
                    return "申请驳回";
                case 3:
                    return "等待出库";
                case 4:
                    return "等待入库";
                case 5:
                    return "完成";
                default:
                    return null;
            }
        }
    }

    /**
     * 购买计划明细状�??
     */
    public static enum GouMaiJiHuaZhuangTai {
        /**
         * 申请
         */
        SHEN_QING(0),
        /**
         * 申请审批OK
         */
        SHEN_QING_OK(1),
        /**
         * 申请审批NG
         */
        SHEN_QING_NG(2),
        /**
         * 采购�?
         */
        CAI_GOU_ZHONG(3),
        /**
         * 采购完成（等待入库）
         */
        CAI_GOU_WAN_CHENG(4),
        /**
         * 入库
         */
        RU_KU(5),
        /**
         * 废止
         */
        FEI_ZHI(7);

        private final int value;

        GouMaiJiHuaZhuangTai(int value) {
            this.value = value;
        }

        public final int getValue() {
            return value;
        }

        public static GouMaiJiHuaZhuangTai parse(int v) {

            switch (v) {
                case 0:
                    return SHEN_QING;
                case 1:
                    return SHEN_QING_OK;
                case 2:
                    return SHEN_QING_NG;
                case 3:
                    return CAI_GOU_ZHONG;
                case 4:
                    return CAI_GOU_WAN_CHENG;
                case 5:
                    return RU_KU;
                case 7:
                    return FEI_ZHI;
                default:
                    return null;
            }
        }

        public String getMessage() {
            switch (this) {
                case SHEN_QING:
                    return "申请�?";
                case SHEN_QING_OK:
                    return "申请审批OK";
                case SHEN_QING_NG:
                    return "申请审批NG";
                case CAI_GOU_ZHONG:
                    return "采购�?";
                case CAI_GOU_WAN_CHENG:
                    return "采购完成";
                case RU_KU:
                    return "入库";
                case FEI_ZHI:
                    return "废止";
                default:
                    return "错误状�??";
            }
        }
    }

    /**
     * 物资提供计划状�??
     */
    public static enum WuZiTiGongJiHuaZhuangTai {
        /**
         * 申请�? (申请提出�?)
         */
        SHENQING_TICHU(1),
        /**
         * 申请驳回 (审批驳回)
         */
        SHENQING_BOHUI(2),
        /**
         * 物资调配 (仓库分配�?)(审批通过)
         */
        SHENQING_TONGGUO(3),
        /**
         * 购买申请 (仓库库存不足，提出购买申请后)
         */
        GOUMAI_TICHU(4),
        /**
         * 购买申请驳回 (审批未�?�过，购买申请被驳回)
         */
        GOUMAI_BOHUI(5),
        /**
         * 计划采购 (购买申请审批通过)
         */
        GOUMAI_TONGGUO(6),
        /**
         * 采购方案提出 (采购部门制定采购方案�?)
         */
        CAIGOUFANGAN_TICHU(7),
        /**
         * 采购方案驳回 (采购方案审批未�?�过)
         */
        CAIGOUFANGAN_BOHUI(8),
        /**
         * 资金调配 (采购方案审批通过)
         */
        CAIGOUFANGAN_TONGGUO(9),
        /**
         * 采购�? (资金调配完毕)
         */
        CAIGOUZHONG(10),
        /**
         * 入库 (购买完成，物品入�?)
         */
        RUKU(11),
        /**
         * 调配结束 (仓库将库存物品分配给申请�?)
         */
        TIAOPEIJIESHU(12),
        /**
         * 分配，等待出�?
         */
        FENPEI_DENGDAICHUKU(13),
        /**
         * 调度中心确定该物资可以分�?
         */
        KEYIFENPEI(14),
        /**
         * 废止
         */
        FEI_ZHI(15),
        /**
         * 已撤�?
         */
        CHE_XIAO(16),
        /**
         * 已受�?
         */
        YI_SHOU_LI(17),
        /**
         * 调拨申请
         */
        DIAO_BO_SHEN_QING(18),
        /**
         * 拒绝调拨
         */
        DIAO_BO_BO_HUI(19),
        /**
         * 申请出库
         */
        SHEN_QING_CHU_KU(20);

        private final int value;

        WuZiTiGongJiHuaZhuangTai(int value) {
            this.value = value;
        }

        public final int getValue() {
            return value;
        }

        public static WuZiTiGongJiHuaZhuangTai parse(int v) {

            switch (v) {
                case 1:
                    return SHENQING_TICHU;
                case 2:
                    return SHENQING_BOHUI;
                case 3:
                    return SHENQING_TONGGUO;
                case 4:
                    return GOUMAI_TICHU;
                case 5:
                    return GOUMAI_BOHUI;
                case 6:
                    return GOUMAI_TONGGUO;
                case 7:
                    return CAIGOUFANGAN_TICHU;
                case 8:
                    return CAIGOUFANGAN_BOHUI;
                case 9:
                    return CAIGOUFANGAN_TONGGUO;
                case 10:
                    return CAIGOUZHONG;
                case 11:
                    return RUKU;
                case 12:
                    return TIAOPEIJIESHU;
                case 13:
                    return FENPEI_DENGDAICHUKU;
                case 14:
                    return KEYIFENPEI;
                case 15:
                    return FEI_ZHI;
                case 16:
                    return CHE_XIAO;
                case 17:
                    return YI_SHOU_LI;
                case 18:
                    return DIAO_BO_SHEN_QING;
                case 19:
                    return DIAO_BO_BO_HUI;
                case 20:
                    return SHEN_QING_CHU_KU;
                default:
                    return null;
            }
        }

        public String getMessage() {
            switch (this) {
                case SHENQING_TICHU:
                    return "申请�?";
                case SHENQING_BOHUI:
                    return "申请被驳�?";
                case CAIGOUFANGAN_BOHUI:
                    return "申请被驳�?";
                case GOUMAI_BOHUI:
                    return "申请被驳�?";
                case CAIGOUZHONG:
                    return "采购�?";
                case SHENQING_TONGGUO:
                    return "物资调配�?";
                case GOUMAI_TICHU:
                    return "购买申请�?";
                case GOUMAI_TONGGUO:
                    return "计划采购�?";
                case CAIGOUFANGAN_TICHU:
                    return "采购方案提出";
                case CAIGOUFANGAN_TONGGUO:
                    return "资金调配�?";
                case RUKU:
                    return "入库完成";
                case TIAOPEIJIESHU:
                    return "调配结束";
                case FENPEI_DENGDAICHUKU:
                    return "分配等待出库";
                case KEYIFENPEI:
                    return "可以分配";
                case FEI_ZHI:
                    return "已废�?";
                case CHE_XIAO:
                    return "已撤�?";
                case YI_SHOU_LI:
                    return "已受�?";
                case DIAO_BO_SHEN_QING:
                    return "调拨申请";
                case DIAO_BO_BO_HUI:
                    return "拒绝调拨";
                case SHEN_QING_CHU_KU:
                    return "申请出库";
                default:
                    return "错误状�??";
            }
        }
    }

    /**
     * 枚举:属�?�列举类�?
     */
    public static enum ShuXingLieJuLeiXing {
        /**
         * 可数
         */
        KESHU(SepC.ShuXingLieJuLeiXing.KESHU),
        /**
         * 列举
         */
        LIEJU(SepC.ShuXingLieJuLeiXing.LIEJU),
        /**
         * 描述�?
         */
        MIAOSHU(SepC.ShuXingLieJuLeiXing.MIAOSHU);

        private final String value;

        ShuXingLieJuLeiXing(String value) {
            this.value = value;
        }

        public final String getValue() {
            return value;
        }

        public static ShuXingLieJuLeiXing parse(String v) throws Exception {
            switch (v) {
                case SepC.ShuXingLieJuLeiXing.KESHU:
                    return KESHU;
                case SepC.ShuXingLieJuLeiXing.LIEJU:
                    return LIEJU;
                case SepC.ShuXingLieJuLeiXing.MIAOSHU:
                    return MIAOSHU;
                default:
                    throw new Exception("ShuXingLieJuLeiXing: 属�?��?�不正确");
            }
        }

        public String getMessage() {
            switch (this) {
                case KESHU:
                    return "可数";
                case LIEJU:
                    return "列举";
                case MIAOSHU:
                    return "描述�?";
                default:
                    return "";
            }
        }
    }

    /**
     * 执行模式
     */
    public static enum ExecuteMode {
        /**
         * 插入
         */
        INSERT,
        /**
         * 更新
         */
        UPDATE,
        /**
         * 删除
         */
        DELETE
    }

    /**
     * 入库申请状�??
     */
    public static enum RuKuShenQingZhuangTai {
        /**
         * 申请�?
         */
        SHEN_QING(0),
        /**
         * 确认
         */
        QUE_REN(1),
        /**
         * 入库
         */
        RU_KU(2),
        /**
         * 撤销
         */
        CHE_XIAO(3);

        private final int value;

        RuKuShenQingZhuangTai(int value) {
            this.value = value;
        }

        public final int getValue() {
            return value;
        }

        public static RuKuShenQingZhuangTai parse(int v) {

            switch (v) {
                case 0:
                    return SHEN_QING;
                case 1:
                    return QUE_REN;
                case 2:
                    return RU_KU;
                case 3:
                    return CHE_XIAO;
                default:
                    return null;
            }
        }

        public String getMessage() {
            switch (this) {
                case SHEN_QING:
                    return "发起申请";
                case QUE_REN:
                    return "确认完成";
                case RU_KU:
                    return "入库完成";
                case CHE_XIAO:
                    return "已撤�?";
                default:
                    return "错误状�??";
            }
        }
    }

    /**
     * 出库申请状�??
     */
    public static enum ChuKuShenQingZhuangTai {
        /**
         * 申请�?
         */
        SHEN_QING(0),
        /**
         * 确认
         */
        QUE_REN(1),
        /**
         * 出库
         */
        CHU_KU(2),
        /**
         * 撤销
         */
        CHE_XIAO(3),
        /**
         * 被驳�?
         */
        BEI_BO_HUI(4);

        private final int value;

        ChuKuShenQingZhuangTai(int value) {
            this.value = value;
        }

        public final int getValue() {
            return value;
        }

        public static ChuKuShenQingZhuangTai parse(int v) {

            switch (v) {
                case 0:
                    return SHEN_QING;
                case 1:
                    return QUE_REN;
                case 2:
                    return CHU_KU;
                case 3:
                    return CHE_XIAO;
                case 4:
                    return BEI_BO_HUI;
                default:
                    return null;
            }
        }

        public String getMessage() {
            switch (this) {
                case SHEN_QING:
                    return "发起申请";
                case QUE_REN:
                    return "确认完成";
                case CHU_KU:
                    return "入库完成";
                case CHE_XIAO:
                    return "已撤�?";
                case BEI_BO_HUI:
                    return "被驳�?";
                default:
                    return "错误状�??";
            }
        }
    }

    /**
     * 性别
     */
    public static enum Sex {
        /**
         * �?
         */
        MALE(SepC.Sex.MALE),
        /**
         * �?
         */
        FEMALE(SepC.Sex.FEMALE);

        private final String value;

        Sex(String value) {
            this.value = value;
        }

        public final String getValue() {
            return value;
        }

        public final String getName() {
            switch (this) {
                case MALE:
                    return "�?";
                case FEMALE:
                    return "�?";
            }
            return "";
        }

        public static Sex parse(String v) {
            switch (v) {
                case SepC.Sex.MALE:
                    return MALE;
                case SepC.Sex.FEMALE:
                    return FEMALE;
            }
            return null;
        }
    }

    /**
     * 权限
     */
    public static enum QuanXian {
        /**
         * 有权�?
         */
        YES(1),
        /**
         * 无权�?
         */
        NO(0);

        private final int value;

        public final int getValue() {
            return value;
        }

        QuanXian(int value) {
            this.value = value;
        }
    }

    /**
     * 邮件类型
     */
    public static enum MailType {

        /**
         * 创建新的登录用户
         */
        CREATE_NEW_LOGIN_USER,
        /**
         * 重置密码
         */
        RESET_PASSWORD,
        /**
         * 自由内容
         */
        FREE
    }

    /**
     * 审批模式
     */
    public static enum ShenPiMoShi {
        /**
         * 通过
         */
        TONG_GUO(0),
        /**
         * 驳回
         */
        BO_HUI(1),
        /**
         * 废止
         */
        FEI_ZHI(2),
        /**
         * 直接通过
         */
        ZHI_JIE_TONG_GUO(3);

        private final int value;

        ShenPiMoShi(int value) {
            this.value = value;
        }

        public final int getValue() {
            return value;
        }

        public static ShenPiMoShi parse(int v) {

            switch (v) {
                case 0:
                    return TONG_GUO;
                case 1:
                    return BO_HUI;
                case 2:
                    return FEI_ZHI;
                case 3:
                    return ZHI_JIE_TONG_GUO;
                default:
                    return null;
            }
        }
    }

    /**
     * 申请数量与在库数量比�?
     */
    public static enum ManZuFlag {
        /**
         * 在库数量能满足申请量
         */
        MAN_ZU,
        /**
         * 在库数量不能满足申请�?
         */
        BU_MAN_ZU;

        public String getMessage() {
            switch (this) {
                case MAN_ZU:
                    return "满足";
                case BU_MAN_ZU:
                    return "不满�?";
                default:
                    return null;
            }
        }
    }

    /**
     * 申请历史状�??
     */
    public static enum ShenQingLuLiZhuangTai {
        /**
         * 申请
         */
        SHEN_QING(0),
        /**
         * 草稿
         */
        CAO_GAO(1),
        /**
         * 审批通过
         */
        SHEN_PI_OK(2),
        /**
         * 审批驳回
         */
        SHEN_PI_NG(3),
        /**
         * 审批废止
         */
        SHEN_PI_FEI_ZHI(4),
        /**
         * 结束
         */
        JIE_SHU(5),
        /**
         * 已受�?
         */
        YI_SHOU_LI(6),
        /**
         * 审批驳回-已处�?
         */
        SHEN_PI_NG_YI_CHU_LI(7);

        private final int value;

        ShenQingLuLiZhuangTai(int value) {
            this.value = value;
        }

        public final int getValue() {
            return value;
        }

        public static ShenQingLuLiZhuangTai parse(int v) {

            switch (v) {
                case 0:
                    return SHEN_QING;
                case 1:
                    return CAO_GAO;
                case 2:
                    return SHEN_PI_OK;
                case 3:
                    return SHEN_PI_NG;
                case 4:
                    return SHEN_PI_FEI_ZHI;
                case 5:
                    return JIE_SHU;
                case 6:
                    return YI_SHOU_LI;
                case 7:
                    return SHEN_PI_NG_YI_CHU_LI;
                default:
                    return null;
            }
        }

        public String getMessage() {
            switch (this) {
                case SHEN_QING:
                    return "申请�?";
                case CAO_GAO:
                    return "草稿";
                case SHEN_PI_OK:
                    return "审批通过";
                case SHEN_PI_NG:
                    return "审批驳回";
                case SHEN_PI_FEI_ZHI:
                    return "审批废止";
                case JIE_SHU:
                    return "结束";
                case YI_SHOU_LI:
                    return "已受�?";
                case SHEN_PI_NG_YI_CHU_LI:
                    return "审批驳回-已处�?";
            }
            return null;
        }
    }

    /**
     * 流程条件区分
     */
    public static enum LiuChengTiaoJianQuFen {
        /**
         * �?
         */
        WU(0),
        /**
         * 单价
         */
        DAN_JIA(1),
        /**
         * 总价
         */
        ZONG_JIA(2);
        /**
         * 日常用品
         */
//        RI_CHANG_YONG_PIN(3);

        private final int value;

        LiuChengTiaoJianQuFen(int value) {
            this.value = value;
        }

        public final int getValue() {
            return value;
        }

        public static LiuChengTiaoJianQuFen parse(int v) {

            switch (v) {
                case 0:
                    return WU;
                case 1:
                    return DAN_JIA;
                case 2:
                    return ZONG_JIA;
//                case 3:
//                    return RI_CHANG_YONG_PIN;
                default:
                    return null;
            }
        }

        public String getMessage() {
            switch (this) {
                case WU:
                    return "默认";
                case DAN_JIA:
                    return "单价";
                case ZONG_JIA:
                    return "总价";
//                case RI_CHANG_YONG_PIN:
//                    return "日常用品";
            }
            return null;
        }
    }

    /**
     * 流程区分
     */
    public static enum LiuChengQuFen {
        /**
         * 物资申请审批
         */
        WU_ZI_SHEN_QING(0),
        /**
         * 购买申请审批
         */
        GOU_MAI_SHEN_QING(1),
        /**
         * 采购计划审批
         */
        CAI_GOU_JI_HUA(2),
        /**
         * 采购合同审批
         */
        CAI_GOU_HE_TONG(3),
        /**
         * 支付计划审批
         */
        ZHI_FU_JI_HUA(4),
        /**
         * 用车申请审批
         */
        YONG_CHE_SHEN_QING(5);

        private final int value;

        LiuChengQuFen(int value) {
            this.value = value;
        }

        public final int getValue() {
            return value;
        }

        public static LiuChengQuFen parse(int v) {

            switch (v) {
                case 0:
                    return WU_ZI_SHEN_QING;
                case 1:
                    return GOU_MAI_SHEN_QING;
                case 2:
                    return CAI_GOU_JI_HUA;
                case 3:
                    return CAI_GOU_HE_TONG;
                case 4:
                    return ZHI_FU_JI_HUA;
                case 5:
                    return YONG_CHE_SHEN_QING;
                default:
                    return null;
            }
        }

        public String getMessage() {
            switch (this) {
                case WU_ZI_SHEN_QING:
                    return "物资申请审批";
                case GOU_MAI_SHEN_QING:
                    return "购买申请审批";
                case CAI_GOU_JI_HUA:
                    return "采购计划审批";
                case CAI_GOU_HE_TONG:
                    return "采购合同审批";
                case ZHI_FU_JI_HUA:
                    return "支付计划审批";
                case YONG_CHE_SHEN_QING:
                    return "用车申请审批";
                default:
                    return "错误";
            }
        }
    }

    /**
     * 购买方式
     */
    public static enum GouMaiFangShi {

        /**
         * 厂家订购
         */
        DING_GOU(GouMaiFangShiConst.DING_GOU),
        /**
         * 网购
         */
        WANG_GOU(GouMaiFangShiConst.WANG_GOU),
        /**
         * 商店购买
         */
        SHANG_GOU(GouMaiFangShiConst.SHANG_GOU);

        private final int value;

        GouMaiFangShi(int v) {
            this.value = v;
        }

        public static GouMaiFangShi parse(int v) {
            switch (v) {
                case GouMaiFangShiConst.DING_GOU:
                    return DING_GOU;
                case GouMaiFangShiConst.WANG_GOU:
                    return WANG_GOU;
                case GouMaiFangShiConst.SHANG_GOU:
                    return SHANG_GOU;
                default:
                    return DING_GOU;
            }
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 流程模式区分
     */
    public static enum LiuChengMoShiQuFen {
        /**
         * 全部符合
         */
        ALL_MATCH(0),
        /**
         * 任意符合
         */
        ANY_MATCH(1);

        private final int value;

        LiuChengMoShiQuFen(int value) {
            this.value = value;
        }

        public final int getValue() {
            return value;
        }

        public static LiuChengMoShiQuFen parse(int v) {

            switch (v) {
                case 0:
                    return ALL_MATCH;
                case 1:
                    return ANY_MATCH;
                default:
                    return null;
            }
        }

        public String getMessage() {
            switch (this) {
                case ALL_MATCH:
                    return "全部符合";
                case ANY_MATCH:
                    return "任意符合";
            }
            return null;
        }
    }

    /**
     * 出库方式
     */
    public static enum ChuKuFangShi {
        /**
         * 调拨取货
         */
        DIAO_BO_QU_HUO(0),
        /**
         * 请求领货
         */
        QING_QIU_LING_HUO(1),
        /**
         * 紧�?�出库（特批出库�?
         */
        JIN_JI_CHU_KU(2),
        /**
         * 换货申请
         */
        HUAN_HUO_SHEN_QING(3),
        /**
         * �?货申�?
         */
        TUI_HUO_SHEN_QING(4),
        /**
         * 非正常品处理
         */
        FEI_ZHENG_CHANG_CHU_LI(5),
        /**
         * 油卡购油
         */
        YOU_KA_GOU_YOU(6),
        /**
         * 无计划出�?
         */
        WU_JI_HUA_CHU_KU(7);

        private final int value;

        ChuKuFangShi(int value) {
            this.value = value;
        }

        public final int getValue() {
            return value;
        }

        public static ChuKuFangShi parse(int v) {

            switch (v) {
                case 0:
                    return DIAO_BO_QU_HUO;
                case 1:
                    return QING_QIU_LING_HUO;
                case 2:
                    return JIN_JI_CHU_KU;
                case 3:
                    return HUAN_HUO_SHEN_QING;
                case 4:
                    return TUI_HUO_SHEN_QING;
                case 5:
                    return FEI_ZHENG_CHANG_CHU_LI;
                case 6:
                    return YOU_KA_GOU_YOU;
                case 7:
                    return WU_JI_HUA_CHU_KU;
                default:
                    return null;
            }
        }

        public String getMessage() {
            switch (this) {
                case DIAO_BO_QU_HUO:
                    return "调拨取货";
                case QING_QIU_LING_HUO:
                    return "请求领货";
                case JIN_JI_CHU_KU:
                    return "紧�?�出库（特批出库�?";
                case HUAN_HUO_SHEN_QING:
                    return "换货申请";
                case TUI_HUO_SHEN_QING:
                    return "�?货申�?";
                case FEI_ZHENG_CHANG_CHU_LI:
                    return "非正常品处理";
                case YOU_KA_GOU_YOU:
                    return "油卡购油";
                case WU_JI_HUA_CHU_KU:
                    return "无计划出�?";
                default:
                    return null;
            }
        }
    }

    /**
     * 入库方式
     */
    public static enum RuKuFangShi {
        /**
         * 调拨入库
         */
        DIAO_BO_RU_KU(0),
        /**
         * 购买入库
         */
        GOU_MAI_RU_KU(1),
        /**
         * 物资归还
         */
        GUI_HUAN_WU_ZI(2),
        /**
         * 换货入库
         */
        HUAN_HUO_RU_KU(3),
        /**
         * 无计划入�?
         */
        WU_JI_HUA_RU_KU(4),
        /**
         * 油卡购油
         */
        YOU_KA_GOU_YOU(5),
        /**
         * 物资�?�?
         */
        WU_ZI_TUI_KU(6);

        private final int value;

        RuKuFangShi(int value) {
            this.value = value;
        }

        public final int getValue() {
            return value;
        }

        public static RuKuFangShi parse(int v) {

            switch (v) {
                case 0:
                    return DIAO_BO_RU_KU;
                case 1:
                    return GOU_MAI_RU_KU;
                case 2:
                    return GUI_HUAN_WU_ZI;
                case 3:
                    return HUAN_HUO_RU_KU;
                case 4:
                    return WU_JI_HUA_RU_KU;
                case 5:
                    return YOU_KA_GOU_YOU;
                case 6:
                    return WU_ZI_TUI_KU;
                default:
                    return null;
            }
        }

        public String getMessage() {
            switch (this) {
                case DIAO_BO_RU_KU:
                    return "调拨入库";
                case GOU_MAI_RU_KU:
                    return "购买入库";
                case GUI_HUAN_WU_ZI:
                    return "物资归还";
                case WU_ZI_TUI_KU:
                    return "物资�?�?";
                case HUAN_HUO_RU_KU:
                    return "换货入库";
                case WU_JI_HUA_RU_KU:
                    return "无计划入�?";
                case YOU_KA_GOU_YOU:
                    return "油卡购油";
                default:
                    return null;
            }
        }
    }

    /**
     * 领用模式
     */
    public static enum LingYongMoShi {
        /**
         * 分批领用
         */
        FEN_PI_LING_YONG(0),
        /**
         * �?起领�?
         */
        YI_QI_LING_YONG(1);

        private final int value;

        LingYongMoShi(int value) {
            this.value = value;
        }

        public final int getValue() {
            return value;
        }

        public static LingYongMoShi parse(int v) {

            switch (v) {
                case 0:
                    return FEN_PI_LING_YONG;
                case 1:
                    return YI_QI_LING_YONG;
                default:
                    return null;
            }
        }

        public String getMessage() {
            switch (this) {
                case FEN_PI_LING_YONG:
                    return "分批领用";
                case YI_QI_LING_YONG:
                    return "�?起领�?";
                default:
                    return null;
            }
        }
    }

    /**
     * 归集项区�?
     */
    public static enum GuiJiXiangQuFen {
        /**
         * 工程
         */
        GONG_CHENG(1),
        /**
         * 员工
         */
        YUAN_GONG(2),
        /**
         * 部门
         */
        BU_MEN(3);

        private final int value;

        GuiJiXiangQuFen(int value) {
            this.value = value;
        }

        public final int getValue() {
            return value;
        }

        public static GuiJiXiangQuFen parse(int v) {

            switch (v) {
                case 1:
                    return GONG_CHENG;
                case 2:
                    return YUAN_GONG;
                case 3:
                    return BU_MEN;
                default:
                    return null;
            }
        }

        public String getMessage() {
            switch (this) {
                case GONG_CHENG:
                    return "工程";
                case YUAN_GONG:
                    return "员工";
                case BU_MEN:
                    return "部门";
                default:
                    return null;
            }
        }
    }

    /**
     * 盘库历史状�??
     */
    public static enum PanKuLuLiZhuangTai {
        /**
         * 草稿
         */
        CAO_GAO(1),
        /**
         * 提交
         */
        TI_JIAO(2),
        /**
         * 已审�?
         */
        SHEN_HE_WAN_CHENG(3);

        private final int value;

        PanKuLuLiZhuangTai(int value) {
            this.value = value;
        }

        public final int getValue() {
            return value;
        }

        public static PanKuLuLiZhuangTai parse(int v) {

            switch (v) {
                case 1:
                    return CAO_GAO;
                case 2:
                    return TI_JIAO;
                case 3:
                    return SHEN_HE_WAN_CHENG;
                default:
                    return null;
            }
        }

        public String getMessage() {
            switch (this) {
                case CAO_GAO:
                    return "草稿";
                case TI_JIAO:
                    return "已提�?";
                case SHEN_HE_WAN_CHENG:
                    return "审核完成";
                default:
                    return null;
            }
        }
    }

    /**
     * 物资类型
     */
    public static enum WuZiLeiXing {
        /**
         * 领用
         */
        LING_YONG(0),
        /**
         * 借用
         */
        JIE_YONG(1);

        private final int value;

        WuZiLeiXing(int value) {
            this.value = value;
        }

        public final int getValue() {
            return value;
        }

        public static WuZiLeiXing parse(int v) {

            switch (v) {
                case 0:
                    return LING_YONG;
                case 1:
                    return JIE_YONG;
                default:
                    return null;
            }
        }

        public String getMessage() {
            switch (this) {
                case LING_YONG:
                    return "领用";
                case JIE_YONG:
                    return "借用";
                default:
                    return null;
            }
        }
    }

    /**
     * 采购合同状�??
     */
    public static enum CaiGouHeTongZhuangTai {
        /**
         * 申请
         */
        SHEN_QING(0),
        /**
         * 审批OK
         */
        SHEN_PI_OK(1),
        /**
         * 审批NG
         */
        SHEN_PI_NG(2),
        /**
         * 废止
         */
        FEI_ZHI(3);

        private final int value;

        CaiGouHeTongZhuangTai(int value) {
            this.value = value;
        }

        public final int getValue() {
            return value;
        }

        public static CaiGouHeTongZhuangTai parse(int v) {

            switch (v) {
                case 0:
                    return SHEN_QING;
                case 1:
                    return SHEN_PI_OK;
                case 2:
                    return SHEN_PI_NG;
                case 3:
                    return FEI_ZHI;
                default:
                    return null;
            }
        }

        public String getMessage() {
            switch (this) {
                case SHEN_QING:
                    return "申请";
                case SHEN_PI_OK:
                    return "审批通过";
                case SHEN_PI_NG:
                    return "审批驳回";
                case FEI_ZHI:
                    return "已废�?";
                default:
                    return "错误";
            }
        }
    }

    /**
     * 车辆类型
     */
    public static enum CheLiangLeiXing {
        /**
         * 普�?�车
         */
        PU_TONG(0),
        /**
         * 工程�?
         */
        GONG_CHENG(1);

        private final int value;

        CheLiangLeiXing(int value) {
            this.value = value;
        }

        public final int getValue() {
            return value;
        }

        public static CheLiangLeiXing parse(int v) {

            switch (v) {
                case 0:
                    return PU_TONG;
                case 1:
                    return GONG_CHENG;
                default:
                    return null;
            }
        }

        public String getMessage() {
            switch (this) {
                case PU_TONG:
                    return "普�?�车";
                case GONG_CHENG:
                    return "工程�?";
                default:
                    return null;
            }
        }

        public String getCode() {
            switch (this) {
                case PU_TONG:
                    return "PuTongChe";
                case GONG_CHENG:
                    return "GongChengChe";
                default:
                    return null;
            }
        }
    }

    /**
     * 耗油报表库存类型
     */
    public static enum HaoYouKuCunLeiXing {
        /**
         * 油卡
         */
        YOU_KA(0),
        /**
         * 油罐
         */
        YOU_GUAN(1);

        private final int value;

        HaoYouKuCunLeiXing(int value) {
            this.value = value;
        }

        public final int getValue() {
            return value;
        }

        public static HaoYouKuCunLeiXing parse(int v) {

            switch (v) {
                case 0:
                    return YOU_KA;
                case 1:
                    return YOU_GUAN;
                default:
                    return null;
            }
        }

        public String getMessage() {
            switch (this) {
                case YOU_KA:
                    return "油卡";
                case YOU_GUAN:
                    return "油罐";
                default:
                    return null;
            }
        }
    }

    /**
     * 车辆类型
     */
    public static enum ShenQingCheLiangLeiXing {
        /**
         * 小车
         */
        XIAO_CHE(0),
        /**
         * 客车
         */
        KE_CHE(1),
        /**
         * 货车
         */
        HUO_CHE(2),
        /**
         * 工程�?
         */
        GONG_CHENG_CHE(3);

        private final int value;

        ShenQingCheLiangLeiXing(int value) {
            this.value = value;
        }

        public final int getValue() {
            return value;
        }

        public static ShenQingCheLiangLeiXing parse(int v) {

            switch (v) {
                case 0:
                    return XIAO_CHE;
                case 1:
                    return KE_CHE;
                case 2:
                    return HUO_CHE;
                case 3:
                    return GONG_CHENG_CHE;
                default:
                    return null;
            }
        }

        public String getMessage() {
            switch (this) {
                case XIAO_CHE:
                    return "小车";
                case KE_CHE:
                    return "客车";
                case HUO_CHE:
                    return "货车";
                case GONG_CHENG_CHE:
                    return "工程�?";
                default:
                    return null;
            }
        }
    }

    /**
     * 用车记录状�??
     */
    public static enum YongCheJiLuZhuangTai {
        /**
         * 已备�?
         */
        YI_BEI_CHE(0),
        /**
         * 已使�?
         */
        YI_SHI_YONG(1),
        /**
         * 已结�?
         */
        YI_JIE_ZHANG(2);

        private final int value;

        YongCheJiLuZhuangTai(int value) {
            this.value = value;
        }

        public final int getValue() {
            return value;
        }

        public static YongCheJiLuZhuangTai parse(int v) {

            switch (v) {
                case 0:
                    return YI_BEI_CHE;
                case 1:
                    return YI_SHI_YONG;
                case 2:
                    return YI_JIE_ZHANG;
                default:
                    return null;
            }
        }

        public String getMessage() {
            switch (this) {
                case YI_BEI_CHE:
                    return "已备�?";
                case YI_SHI_YONG:
                    return "已使�?";
                case YI_JIE_ZHANG:
                    return "已结�?";
                default:
                    return null;
            }
        }
    }

    /**
     * 油卡类型
     */
    public static enum YouKaLeiXing {
        /**
         * 主卡
         */
        ZHU_KA(0),
        /**
         * 分卡
         */
        FEN_KA(1);

        private final int value;

        YouKaLeiXing(int value) {
            this.value = value;
        }

        public final int getValue() {
            return value;
        }

        public static YouKaLeiXing parse(int v) {

            switch (v) {
                case 0:
                    return ZHU_KA;
                case 1:
                    return FEN_KA;
                default:
                    return null;
            }
        }

        public String getMessage() {
            switch (this) {
                case ZHU_KA:
                    return "主卡";
                case FEN_KA:
                    return "分卡";
                default:
                    return null;
            }
        }

        public boolean isZhuKa() {
            return this == ZHU_KA;
        }
    }

    /**
     * 车辆�?�?
     */
    public static enum CheLiangSuoShu {
        /**
         * 内部�?
         */
        NEI_BU_CHE(0),
        /**
         * 外部�?
         */
        WAI_BU_CHE(1);

        private final Integer value;

        CheLiangSuoShu(Integer value) {
            this.value = value;
        }

        public final Integer getValue() {
            return this.value;
        }

        public static CheLiangSuoShu parse(Integer v) {

            switch (v) {
                case 0:
                    return NEI_BU_CHE;
                case 1:
                    return WAI_BU_CHE;
                default:
                    return null;
            }
        }

        public String getMessage() {
            switch (this) {
                case NEI_BU_CHE:
                    return "内部�?";
                case WAI_BU_CHE:
                    return "外部�?";
                default:
                    return null;
            }
        }
    }

    /**
     * 提供服务类型
     */
    public static enum TiGongFuWuLeiXing {
        /**
         * 物资
         */
        WU_ZI("0"),
        /**
         * 车辆
         */
        CHE_LIANG("1"),
        /**
         * 司机
         */
        SI_JI("2"),
        /**
         * 保险
         */
        BAO_XIAN("3"),
        /**
         * 维修
         */
        WEI_XIU("4"),
        /**
         * 保养
         */
        BAO_YANG("5");

        private final String value;

        TiGongFuWuLeiXing(String value) {
            this.value = value;
        }

        public final String getValue() {
            return value;
        }

        public static TiGongFuWuLeiXing parse(String v) {

            switch (v) {
                case "WU_ZI":
                    return WU_ZI;
                case "1":
                    return CHE_LIANG;
                case "2":
                    return SI_JI;
                case "3":
                    return BAO_XIAN;
                case "4":
                    return WEI_XIU;
                case "5":
                    return BAO_YANG;
                default:
                    return null;
            }
        }

        public String getMessage() {
            switch (this) {
                case WU_ZI:
                    return "物资";
                case CHE_LIANG:
                    return "车辆";
                case SI_JI:
                    return "司机";
                case BAO_XIAN:
                    return "保险";
                case WEI_XIU:
                    return "维修";
                case BAO_YANG:
                    return "保养";
                default:
                    return null;
            }
        }
    }

    /**
     * 报表条件类型
     */
    public static enum BaoBiaoTiaoJianLeiXing {

        /**
         * 数字
         */
        SHU_ZI(0),
        /**
         * 日期
         */
        RI_QI(1),
        /**
         * 文本
         */
        WEN_BEN(2),
        /**
         * 枚举
         */
        MEI_JU(3);

        private final int value;

        BaoBiaoTiaoJianLeiXing(int value) {
            this.value = value;
        }

        public final int getValue() {
            return value;
        }

        public static BaoBiaoTiaoJianLeiXing parse(int v) {

            switch (v) {
                case 0:
                    return SHU_ZI;
                case 1:
                    return RI_QI;
                case 2:
                    return WEN_BEN;
                case 3:
                    return MEI_JU;
                default:
                    return WEN_BEN;
            }
        }

        public String getMessage() {
            switch (this) {
                case SHU_ZI:
                    return "数字";
                case RI_QI:
                    return "日期";
                case WEN_BEN:
                    return "文本";
                case MEI_JU:
                    return "枚举";
                default:
                    return "文本";
            }
        }
    }

    public static enum YesOrNo {

        YES(1),
        NO(0);

        private final int value;

        YesOrNo(int value) {
            this.value = value;
        }

        public final int getValue() {
            return value;
        }

        public static YesOrNo parse(int v) {

            switch (v) {
                case 0:
                    return NO;
                case 1:
                    return YES;
                default:
                    return null;
            }
        }

        public String getMessage() {
            switch (this) {
                case YES:
                    return "�?";
                case NO:
                    return "�?";
                default:
                    return null;
            }
        }
    }
}
