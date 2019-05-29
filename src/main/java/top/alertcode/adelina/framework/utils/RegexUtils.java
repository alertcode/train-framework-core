package top.alertcode.adelina.framework.utils;


import top.alertcode.adelina.framework.exception.FrameworkUtilException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gizmo on 15/12/13.
 *
 * @author Bob
 * @version $Id: $Id
 */
public final class RegexUtils {
    /**
     * 匹配图象
     * 格式: /相对路径/文件�?.后缀 (后缀为gif,dmp,png)
     * 匹配 : /forum/head_icon/admini2005111_ff.gif �? admini2005111.dmp
     * 不匹�?: c:/admins4512.gif
     */
    public static final String ICON_REGEXP = "^(/{0,1}\\w){1,}\\.(gif|dmp|png|jpg)$|^\\w{1,}\\.(gif|dmp|png|jpg)$";
    /**
     * 匹配email地址
     * 格式: XXX@XXX.XXX.XX
     * 匹配 : foo@bar.com �? foobar@foobar.com.au
     * 不匹�?: foo@bar �? $$$@bar.com
     */
    public static final String EMAIL_REGEXP = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
    /**
     * 匹配匹配并提取url
     * 格式: XXXX://XXX.XXX.XXX.XX/XXX.XXX?XXX=XXX
     * 匹配 : http://www.suncer.com 或news://www
     * 不匹�?: c:/window
     */
    public static final String URL_REGEXP = "(\\w+)://([^/:]+)(:\\d*)?([^#\\s]*)";
    /**
     * 匹配并提取http
     * 格式: http://XXX.XXX.XXX.XX/XXX.XXX?XXX=XXX �? ftp://XXX.XXX.XXX �?
     * https://XXX
     * 匹配 : http://www.suncer.com:8080/index.html?login=true
     * 不匹�?: news://www
     */
    public static final String HTTP_REGEXP = "(http|https|ftp)://([^/:]+)(:\\d*)?([^#\\s]*)";
    /**
     * 匹配日期
     * 格式(首位不为0): XXXX-XX-XX�? XXXX-X-X
     * 范围:1900--2099
     * 匹配 : 2005-04-04
     * 不匹�?: 01-01-01
     */
    public static final String DATE_BARS_REGEXP = "^((((19){1}|(20){1})\\d{2})|\\d{2})-[0,1]?\\d{1}-[0-3]?\\d{1}$";
    /**
     * 匹配日期
     * 格式: XXXX/XX/XX
     * 范围:
     * 匹配 : 2005/04/04
     * 不匹�?: 01/01/01
     */
    public static final String DATE_SLASH_REGEXP = "^[0-9]{4}/(((0[13578]|(10|12))/(0[1-9]|[1-2][0-9]|3[0-1]))|(02-(0[1-9]|[1-2][0-9]))|((0[469]|11)/(0[1-9]|[1-2][0-9]|30)))$";
    /**
     * 匹配电话
     * 格式�?: 0XXX-XXXXXX(10-13位首位必须为0) �?0XXX XXXXXXX(10-13位首位必须为0) �?
     * (0XXX)XXXXXXXX(11-14位首位必须为0) �? XXXXXXXX(6-8位首位不�?0) �?
     * XXXXXXXXXXX(11位首位不�?0)
     * 匹配 : 0371-123456 �? (0371)1234567 �? (0371)12345678 �? 010-123456 �?
     * 010-12345678 �? 12345678912
     * 不匹�?: 1111-134355 �? 0123456789
     */
    public static final String PHONE_REGEXP = "^(?:0[0-9]{2,3}[-\\s]{1}|\\(0[0-9]{2,4}\\))[0-9]{6,8}$|^[1-9]{1}[0-9]{5,7}$|^[1-9]{1}[0-9]{10}$";
    /**
     * 匹配身份�?
     * 格式�?: XXXXXXXXXX(10�?) �? XXXXXXXXXXXXX(13�?) �? XXXXXXXXXXXXXXX(15�?) �?
     * XXXXXXXXXXXXXXXXXX(18�?)
     * 匹配 : 0123456789123
     * 不匹�?: 0123456
     */
    public static final String ID_CARD_REGEXP = "^\\d{15}|\\d{17}[a-zA-Z]|\\d{18}$";
    /**
     * 匹配邮编代码
     * 格式�?: XXXXXX(6�?)
     * 匹配 : 012345
     * 不匹�?: 0123456
     */
    public static final String ZIP_REGEXP = "^[0-9]{6}$";// 匹配邮编代码
    /**
     * 不包括特殊字符的匹配 (字符串中不包括符�? 数学次方号^ 单引�?' 双引�?" 分号; 逗号, 帽号: 数学减号- 右尖括号> 左尖括号< 反斜�?/
     * 即空�?,制表�?,回车符等 )
     * 格式�?: x �? �?个一上的字符
     * 匹配 : 012345
     * 不匹�?: 0123456 // ;,:-<>//s].+$";//
     */
    public static final String NON_SPECIAL_CHAR_REGEXP = "^[^'/";
    /**
     * 匹配非负整数（正整数 + 0)
     */
    public static final String NON_NEGATIVE_INTEGERS_REGEXP = "^\\d+$";
    /**
     * 匹配不包括零的非负整数（正整�? > 0)
     */
    public static final String NON_ZERO_NEGATIVE_INTEGERS_REGEXP = "^[1-9]+\\d*$";
    /**
     * 匹配正整�?
     */
    public static final String POSITIVE_INTEGER_REGEXP = "^[0-9]*[1-9][0-9]*$";
    /**
     * 匹配非正整数（负整数 + 0�?
     */
    public static final String NON_POSITIVE_INTEGERS_REGEXP = "^((-\\d+)|(0+))$";
    /**
     * 匹配负整�?
     */
    public static final String NEGATIVE_INTEGERS_REGEXP = "^-[0-9]*[1-9][0-9]*$";
    /**
     * 匹配整数
     */
    public static final String INTEGER_REGEXP = "^-?\\d+$";
    /**
     * 匹配非负浮点数（正浮点数 + 0�?
     */
    public static final String NON_NEGATIVE_RATIONAL_NUMBERS_REGEXP = "^\\d+(\\.\\d+)?$";
    /**
     * 匹配正浮点数
     */
    public static final String POSITIVE_RATIONAL_NUMBERS_REGEXP = "^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$";
    /**
     * 匹配非正浮点数（负浮点数 + 0�?
     */
    public static final String NON_POSITIVE_RATIONAL_NUMBERS_REGEXP = "^((-\\d+(\\.\\d+)?)|(0+(\\.0+)?))$";
    /**
     * 匹配负浮点数
     */
    public static final String NEGATIVE_RATIONAL_NUMBERS_REGEXP = "^(-(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*)))$";
    /**
     * 匹配浮点�?
     */
    public static final String RATIONAL_NUMBERS_REGEXP = "^(-?\\d+)(\\.\\d+)?$";
    /**
     * 匹配�?26个英文字母组成的字符�?
     */
    public static final String LETTER_REGEXP = "^[A-Za-z]+$";
    /**
     * 匹配�?26个英文字母的大写组成的字符串
     */
    public static final String UPWARD_LETTER_REGEXP = "^[A-Z]+$";
    /**
     * 匹配�?26个英文字母的小写组成的字符串
     */
    public static final String LOWER_LETTER_REGEXP = "^[a-z]+$";
    /**
     * 匹配由数字和26个英文字母组成的字符�?
     */
    public static final String LETTER_NUMBER_REGEXP = "^[A-Za-z0-9]+$";
    /**
     * 匹配由数字�??26个英文字母或者下划线组成的字符串
     */
    public static final String LETTER_NUMBER_UNDERLINE_REGEXP = "^\\w+$";
    /**
     * 匹配汉字
     */
    public static final String CHINESE_REGEXP = "^[\\u4e00-\\u9fa5]+$";

    /**
     * Constant <code>BANK_CARD_REGEXP="^\\d{16,20}$"</code>
     */
    public static final String BANK_CARD_REGEXP = "^\\d{16,20}$";

    /** Constant <code>MONEY_REGEXP="^[0]\\.([1-9]|[1-9][0-9]|[0-9][1-9])$|^"{trunked}</code> */
    public static final String MONEY_REGEXP = "^[0]\\.([1-9]|[1-9][0-9]|[0-9][1-9])$|^[1-9]\\d{0,11}(\\.{0}|\\.{1}[0-9]{1,2})$";

    /** Constant <code>TRADE_PASSWORD_REGEXP="^\\d{6}$"</code> */
    public static final String TRADE_PASSWORD_REGEXP = "^\\d{6}$";

    /** Constant <code>TRADE_PASSWORD_NON_REPEATABLE_REGEXP="^(\\d)(\\1{5})$"</code> */
    public static final String TRADE_PASSWORD_NON_REPEATABLE_REGEXP = "^(\\d)(\\1{5})$";

    private RegexUtils() {
    }

    /**
     * <p>isValidateIcon.</p>
     *
     * @param source a {@link java.lang.String} object.
     * @return a boolean.
     */
    public static boolean isValidateIcon(String source) {
        return isValidate(source, ICON_REGEXP);
    }

    /**
     * <p>isValidateEmail.</p>
     *
     * @param source a {@link java.lang.String} object.
     * @return a boolean.
     */
    public static boolean isValidateEmail(String source) {
        return isValidate(source, EMAIL_REGEXP);
    }

    /**
     * <p>isValidateUrl.</p>
     *
     * @param source a {@link java.lang.String} object.
     * @return a boolean.
     */
    public static boolean isValidateUrl(String source) {
        return isValidate(source, HTTP_REGEXP);
    }

    /**
     * <p>isValidateHttp.</p>
     *
     * @param source a {@link java.lang.String} object.
     * @return a boolean.
     */
    public static boolean isValidateHttp(String source) {
        return isValidate(source, HTTP_REGEXP);
    }

    /**
     * <p>isValidateDate.</p>
     *
     * @param source a {@link java.lang.String} object.
     * @return a boolean.
     */
    public static boolean isValidateDate(String source) {
        return isValidate(source, DATE_BARS_REGEXP);
    }

    /**
     * <p>isValidatePhone.</p>
     *
     * @param source a {@link java.lang.String} object.
     * @return a boolean.
     */
    public static boolean isValidatePhone(String source) {
        return isValidate(source, PHONE_REGEXP);
    }

    /**
     * <p>isValidateIdCard.</p>
     *
     * @param source a {@link java.lang.String} object.
     * @return a boolean.
     */
    public static boolean isValidateIdCard(String source) {
        return isValidate(source, ID_CARD_REGEXP);
    }

    /**
     * <p>isValidateZipCode.</p>
     *
     * @param source a {@link java.lang.String} object.
     * @return a boolean.
     */
    public static boolean isValidateZipCode(String source) {
        return isValidate(source, ZIP_REGEXP);
    }

    /**
     * <p>isValidateChinese.</p>
     *
     * @param source a {@link java.lang.String} object.
     * @return a boolean.
     */
    public static boolean isValidateChinese(String source) {
        return isValidate(source, CHINESE_REGEXP);
    }

    /**
     * <p>isValidateMoney.</p>
     *
     * @param source a {@link java.lang.String} object.
     * @return a boolean.
     */
    public static boolean isValidateMoney(String source) {
        return isValidate(source, MONEY_REGEXP);
    }

    /**
     * <p>isValidateTradePassword.</p>
     *
     * @param source a {@link java.lang.String} object.
     * @return a boolean.
     */
    public static boolean isValidateTradePassword(String source) {
        return isValidate(source, TRADE_PASSWORD_REGEXP);
    }

    /**
     * <p>isValidateNonRepeatableTradePassword.</p>
     *
     * @param source a {@link java.lang.String} object.
     * @return a boolean.
     */
    public static boolean isValidateNonRepeatableTradePassword(String source) {
        return isValidate(source, TRADE_PASSWORD_NON_REPEATABLE_REGEXP);
    }

    /**
     * <p>isValidateBankCard.</p>
     *
     * @param source a {@link java.lang.String} object.
     * @return a boolean.
     */
    public static boolean isValidateBankCard(String source) {
        return isValidate(source, BANK_CARD_REGEXP);
    }

    /**
     * <p>isValidateExpression.</p>
     *
     * @param source a {@link java.lang.String} object.
     * @param expression a {@link java.lang.String} object.
     * @return a boolean.
     */
    public static boolean isValidateExpression(String source, String expression) {
        return isValidate(source, expression);
    }

    private static boolean isValidate(String source, String expression) {
        try {
            Pattern pattern = Pattern.compile(expression);
            Matcher matcher = pattern.matcher(source);
            return matcher.matches();
        } catch (Exception e) {
            throw new FrameworkUtilException(e);
        }
    }

    /**
     * <p>isValidateInteger.</p>
     *
     * @param source a {@link java.lang.String} object.
     * @return a boolean.
     */
    public static boolean isValidateInteger(String source) {
        return isValidate(source, NON_ZERO_NEGATIVE_INTEGERS_REGEXP);
    }

    /**
     * <p>isValidateDouble.</p>
     *
     * @param source a {@link java.lang.String} object.
     * @return a boolean.
     */
    public static boolean isValidateDouble(String source) {
        return isValidate(source, NON_NEGATIVE_RATIONAL_NUMBERS_REGEXP);
    }
}
