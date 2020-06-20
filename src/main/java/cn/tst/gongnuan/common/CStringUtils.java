package cn.tst.gongnuan.common;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 字符串处�?
 *
 * @author ps_xy@pscp.co.jp
 */
public class CStringUtils {

    /**
     * 数字格式�?
     *
     * @param value�?対象数�??
     * @return 格式化后字符�?
     */
    public static String formatNumber(Object value) {

        if (value == null) {
            return CConst.BLANK;
        }

        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(0);
        nf.setMinimumFractionDigits(0);
        return nf.format(value);
    }

    /**
     * 日期格式�?
     *
     * @param date 日期对象
     * @return 格式化后字符�?
     */
    public static String formatDate(Date date) {
        return formatDate(date, SepC.FORMAT_DATE_TYPE);
    }

    /**
     * 日期格式�?
     *
     * @param date 日期对象
     * @param format 格式
     * @return 格式化后字符�?
     */
    public static String formatDate(Date date, String format) {

        if (date == null && org.apache.commons.lang3.StringUtils.isEmpty(format)) {
            return CConst.BLANK;
        }

        return DateFormatUtils.format(date, format);
    }

    /**
     * 邮编格式�?
     *
     * @param zip 邮编
     * @return 格式化后字符�?
     */
    public static String formatZip(String zip) {

        if (zip != null && zip.matches(SepC.Regex.ZIP_PATTERN)) {
            return zip.replaceAll(SepC.Regex.ZIP_PATTERN, "$1-$2");
        }

        return zip;
    }

    /**
     * 电话号码格式�?
     *
     * @param mobileNo 电话号码
     * @return 格式化后字符�?
     */
    public static String formatMobileNo(String mobileNo) {

        if (org.apache.commons.lang3.StringUtils.isEmpty(mobileNo)) {
            return "";
        }

        if (mobileNo.matches(SepC.Regex.MOBILE_PATTERN1)) {
            return mobileNo.replaceAll(SepC.Regex.MOBILE_PATTERN1, "$1-$2-$3");
        } else if (mobileNo.matches(SepC.Regex.MOBILE_PATTERN2)) {
            return mobileNo.replaceAll(SepC.Regex.MOBILE_PATTERN2, "$1-$2-$3");
        } else if (mobileNo.matches(SepC.Regex.MOBILE_PATTERN3)) {
            return mobileNo.replaceAll(SepC.Regex.MOBILE_PATTERN3, "$1-$2");
        }

        return mobileNo;
    }

    /**
     * 月份�?0
     *
     * @param month 月份
     * @return 格式化后字符�?
     */
    public static String zeroPadMonth(String month) {
        return zeroPadMonth(Integer.valueOf(month));
    }

    /**
     * 份补0
     *
     * @param month 月份
     * @return 格式化后字符�?
     */
    public static String zeroPadMonth(int month) {
        return month < 10 ? "0" + String.valueOf(month) : String.valueOf(month);
    }

    /**
     * 移除特殊字符
     *
     * @param target 对象字符�?
     * @return 替换后的结果
     */
    public static String removeSpecialCharater(String target) {

        if (StringUtils.isEmpty(target)) {
            return target;
        }

        return target.replace(CConst.ASTERISK, CConst.BLANK)
                .replace(CConst.D_QUOTATION, CConst.BLANK)
                .replace(CConst.QUOTATION, CConst.BLANK)
                .replace(CConst.QUS, CConst.BLANK)
                .replace(CConst.PERCENT, CConst.BLANK)
                .replace(CConst.GT, CConst.BLANK)
                .replace(CConst.LT, CConst.BLANK)
                .replace(CConst.UNDERBAR, CConst.BLANK);

    }

    public static boolean isBigDecimal(String str) {
        try {
            BigDecimal bigDecimal = new BigDecimal(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
