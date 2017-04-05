package cn.tst.gongnuan.common;

import java.math.BigDecimal;

/**
 * 常量定义
 *
 * @author ps_xy@pscp.co.jp
 */
public final class SepC {

    /**
     * 系统ID
     */
    public static final String SYSTEM_ID = "material";

    /**
     * 图片上传路径配置KEY
     */
    public static final String INIT_PARAM_UPLOAD_DIRECTORY = "uploadDirectory";

    /**
     * 图片上传默认文件名
     */
    public static final class UploadFileDefaultName {

        /**
         * 物资
         */
        public static final String MATERIAL = "unselect-material.svg";
        /**
         * 个人头像
         */
        public static final String PROFILE = "unselect-profile.png";
        /**
         * 合同
         */
        public static final String CONTRACT = "unselect-contract.png";
    }

    /**
     * 图片上传路径类型
     */
    public static final class UploadFileType {

        /**
         * 原始照片路径
         */
        public static final String ORIGIN = "origin";
        /**
         * 压缩后照片路径
         */
        public static final String COMPRESSION = "compression";
        /**
         * 预览用照片路径
         */
        public static final String PREVIEW = "preview";
    }

    /**
     * 图片上传分类
     */
    public static final class UploadFileCategory {

        /**
         * 物资
         */
        public static final String MATERIAL = "material";
        /**
         * 员工头像
         */
        public static final String PROFILE = "profile";
        /**
         * 合同
         */
        public static final String CONTRACT = "contract";
    }

    /**
     * 性别
     */
    public static final class Sex {

        /**
         * 男
         */
        public static final String MALE = "1";
        /**
         * 女
         */
        public static final String FEMALE = "0";
    }

    /**
     * 默认创建者ID
     */
    public static final String DEFAULT_CREATOR_ID = "EMP0000000";

    /**
     * 持久化单元名称,参考: persistence.xml
     */
    public static final String PERSISTENCE_UNIT = "PSUT_heating";

    /**
     * 持久化单元名称,参考: persistence.xml
     */
    public static final String PERSISTENCE_UNIT2 = "subdb1";

    /**
     * 常量: msgKey
     */
    public static final String S_MSG_KEY = "msgKey";

    /**
     * Format: MM-dd
     */
    public static final String FORMAT_DATE_MD = "MM-dd";

    /**
     * Format: yyyy-MM
     */
    public static final String FORMAT_DATE_YM = "yyyy-MM";

    /**
     * Format: yyyy-MM-dd
     */
    public static final String FORMAT_DATE_TYPE = "yyyy-MM-dd";

    /**
     * Format: yyyy-MM-dd :mm
     */
    public static final String FORMAT_DATETIME_TYPE = "yyyy-MM-dd HH:mm";

    /**
     * Format: yyyy-MM-dd HH:mm:ss
     */
    public static final String FORMAT_DATETIME2_TYPE = "yyyy-MM-dd HH:mm:ss";

    /**
     * Format: HH:mm
     */
    public static final String FORMAT_TIME_TYPE24HM = "HH:mm";

    /**
     * 数量等显示格式
     */
    public static final String FORMAT_NUMBER = "#,##0.##";

    /**
     * 正規表現：Email
     */
    public static final String REGEX_EMAIL = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";

    /**
     * 模块ID常量
     */
    public static final class MoKuaiCategory {

        /**
         * 物资管理
         */
        public static final String WU_ZI = "wuzi";
        /**
         * 车辆管理
         */
        public static final String CHE_LIANG = "cheliang";
        /**
         * 能源管理
         */
        public static final String NENG_YUAN = "nengyuan";
        /**
         * 用油管理
         */
        public static final String YONG_YOU = "yongyou";
        /**
         * 用煤管理
         */
        public static final String YONG_MEI = "yongmei";
        /**
         * 系统维护
         */
        public static final String SETTINGS = "settings";
    }

    /**
     * 菜单ID常量
     */
    public static final class MenuCategory {

        /**
         * 申请使用
         */
        public static final String BIZ = "BIZ";
        /**
         * 审核
         */
        public static final String ARP = "ARP";
        /**
         * 库存管理
         */
        public static final String INV = "INV";
        /**
         * 采购计划
         */
        public static final String SUP = "SUP";
        /**
         * 系统维护
         */
        public static final String MST = "MST";
        /**
         * 车辆管理
         */
        public static final String CAR = "CAR";
    }

    /**
     * 控制器ID
     */
    public static final class ControllerID {

        /**
         * 系统登录
         */
        public static final String SYSTEM_CONFIG = "ctrlSystemConfig";

        /**
         * 登录
         */
        public static final String LOGIN = "ctrlLogin";

        /**
         * 模板页
         */
        public static final String MASTER = "ctrlMaster";

        /**
         * 菜单状态
         */
        public static final String MENU = "ctrlMenu";

        /**
         * 密码变更
         */
        public static final String CHANGE_PASSWORD = "ctrlPassChange";

        /**
         * 工作台信息
         */
        public static final String GONG_ZUO_TAI = "ctrlGongZuoTai";

        /**
         * 查看信息
         */
        public static final String CHA_KAN = "ctrlChaKan";

        /**
         * 各分公司收费明细表
         */
        public static final String CHA0001 = "ctrlCHA0001";
        /**
         * 公司年度统计表
         */
        public static final String CHA0002 = "ctrlCHA0002";
        /**
         * 楼年度统计表
         */
        public static final String CHA0003 = "ctrlCHA0003";

        /**
         * 依云首付物业费汇总表
         */
        public static final String WYB0001 = "ctrlWYB0001";
        
        /**
         * 测试项目1
         */
        public static final String TST0001 = "ctrlTST0001";

        /**
         * 员工管理
         */
        public static final String MST0001 = "ctrlMST0001";

    }

    /**
     * 品类关系根元素Code
     */
    public static final String PIN_LEI_GUAN_XI_ROOT = "GL0000000001";

    /**
     * 分类：油 用于车辆
     */
    public static final String FEN_LEI_YOU_ID = "PL00000001";

    /**
     * 分类：煤
     */
    public static final String FEN_LEI_MEI_ID = "PL00000002";

    /**
     * 油卡所在仓库
     */
    public static final String YOU_KA_CANG_KU = "CK000001";

    /**
     * 油卡物资ID
     */
    public static final String YOU_KA_WU_ZI_ID = "BH0000000001";

    /**
     * 综合仓库ID
     */
    public static final String ZONG_HE_CANG_KU_ID = "CK000001";

    /**
     * 物资调配状态：等待入库 (购买完成，等待入库)
     */
    public static final int STATUS_WUZISHENQING_DENGDAIRUKU = 14;

    /**
     * 物资调配状态：调拨申请中 (物资已申请调拨，等待出库)
     */
    public static final int STATUS_WUZIDIAOBO_SHENGQINGZHONG = 0;

    /**
     * 物资调配状态：调拨申请出库 (物资调拨申请，已出库，等待入库)
     */
    public static final int STATUS_WUZIDIAOBO_CHUKUZHONG = 1;

    /**
     * 物资调配状态：调拨申请入库 (物资调拨申请，已入库)
     */
    public static final int STATUS_WUZIDIAOBO_RUKU = 2;

    //すべて倉庫を選択するときLISTのIDに関するVALUE
    public static final String SUO_YOU_CANG_KU = "suoyoucangku";

    // 登录错误次数限制
    public static final int MAX_ERROR_LOGIN_COUNT = 3;

    /**
     * 全部選択
     */
    public static final String QUAN_XIANG = "all";
    /**
     * 全部選択
     */
    public static final Integer QUAN_BU = 10;

    /**
     * 空選
     */
    public static final String KONG_XIANG = "empty";

    /**
     * 默认供应商
     */
    public static final String MO_REN_GONGYINGSHANG = "GYS00000";

    /**
     * 列挙特性は列挙です
     */
    public static final String LIE_JU_XING = "1";

    /**
     * 基層、底層、0から
     */
    public static final int JI_CENG = 0;

    /**
     * 第一層
     */
    public static final int DI_YI_CENG = 1;

    /**
     * 新規
     */
    public static final int XIN_GUI = 1;

    /**
     * 追加
     */
    public static final int ZHUI_JIA = 2;

    /**
     * 刪除
     */
    public static final int SHAN_CHU = 3;

    /**
     * 常量:属性列举类型
     */
    public static final class ShuXingLieJuLeiXing {

        /**
         * 可数
         */
        public final static String KESHU = "0";
        /**
         * 列举
         */
        public final static String LIEJU = "1";
        /**
         * 描述性
         */
        public final static String MIAOSHU = "2";
    }

    /**
     * 常量:购买方式Code
     */
    public static final class GouMaiFangShi {

        /**
         * 厂家订购
         */
        public final static int CHANGJIA = 1;
        /**
         * 网购
         */
        public final static int WANGGOU = 2;
        /**
         * 商店购买
         */
        public final static int SHANGDIAN = 3;
    }

    /**
     * 默认采购周期（天）
     */
    public static final int CAI_GOU_ZHOU_QI = 15;

    /**
     * 默认最小单位
     */
    public static final BigDecimal WU_ZI_ZUI_XIAO_DAN_WEI = BigDecimal.ONE;

    /**
     * 三年的毫秒数
     */
    public static final long DATE_SAN_NIAN = 3 * 365 * 24 * 60 * 60 * 1000;

    /**
     * 员工默认初始密码（暂定）
     */
    public static final String DEFAULT_LOGIN_PASSWORD = "123456";

    /**
     * 正则常量
     */
    public static final class Regex {

        /**
         * 手机号码1
         */
        public static final String MOBILE_PATTERN1 = "^(\\d{3})(\\d{4})(\\d{4})$";
        /**
         * 手机号码2
         */
        public static final String MOBILE_PATTERN2 = "^(\\d{2})(\\d{4})(\\d{4})$";
        /**
         * 座机号码
         */
        public static final String MOBILE_PATTERN3 = "^(\\d{4})(\\d{4})$";
        /**
         * 邮编号码
         */
        public static final String ZIP_PATTERN = "^(\\d{3})(\\d{3})$";
        /**
         * 数字
         */
        public static final String NUMBER_ONLY_PATTERN = "^\\d+$";
        /**
         * 小数
         */
        public static final String FLOAT_NUMER_PATTERN = "^[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?$";
        /**
         * 邮箱地址
         */
        public static final String EMAIL_PATTERN = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
    }

    /**
     * 错误页面
     */
    public static final class ErrorPagePathConst {

        /**
         * 404（页面不存在）
         */
        public static final String CODE_404 = "views/error/404.xhtml";

        /**
         * 403（没有访问权限）
         */
        public static final String CODE_403 = "views/error/403.xhtml";

        /**
         * 500（服务器内部错误）
         */
        public static final String CODE_500 = "views/error/500.xhtml";
    }

    /**
     * 购买方式
     */
    public static final class GouMaiFangShiConst {

        /**
         * 厂家订购
         */
        public static final int DING_GOU = 1;
        /**
         * 网购
         */
        public static final int WANG_GOU = 2;
        /**
         * 商店购买
         */
        public static final int SHANG_GOU = 3;
    }

    /**
     * 员工角色
     */
    public static final class yuanGongRole {

        /**
         * 采购员
         */
        public static final String CAI_GOU_YUAN = "RL000007";
    }

    /**
     * 默认供应商
     */
    public static final class DEFAULT_GONG_YING_SHANG {

        /// 默认供应商ID
        public static final String ID = "GYS00000";
        /// 默认供应商名
        public static final String GONG_SI_MING = "默认供应商";
    }

    public static final int AUTO_COMPLETE_MAX_RESULTS = 10;
}
