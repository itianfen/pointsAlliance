package com.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Pattern;

/**
 * @author b
 */
public class StringUtils{

    private static final Logger log = LoggerFactory.getLogger(StringUtils.class);

    /**
     * 判断字符串是否为空或者NULL
     *
     * @param str          : 需要判断的字符串
     * @return String
     * @author b
     */
    public static String convertXssCharacter(String str) {
        if (isEmpty(str)) {
            return "";
        }
        return str.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
    }

    /**
     * 对象转成字符串
     * @param obj 对象
     * @return 字符串 空则返回空字符串
     */
    public static String parseString(Object obj){
        return obj == null ? "" :obj.toString();
    }

    public static String empty2DefaultValue(String str, String defaultValue) {
        if (isEmpty(str)) {
            return defaultValue;
        }
        return str;
    }

    /**
     * 字符串 转 布尔类型
     *
     * @param booleanStr   : 需要强制转换的字符串
     * @param defaultValue : 转换失败时返回的布尔值
     * @return boolean
     * @author b
     */
    public static boolean toBoolean(String booleanStr, boolean defaultValue) {
        try {
            return Boolean.valueOf(booleanStr);
        } catch (Exception e) {
            for (StackTraceElement ele : e.getStackTrace()) {
                if (ele.toString().indexOf(Thread.currentThread().getStackTrace()[1].getClassName()) > -1) {
                    log.error(ele.toString());
                }
            }
            log.error(e.toString());
        }
        return defaultValue;
    }

    /**
     * 字符串 转 长整型
     *
     * @param longStr      : 需要强制转换的字符串
     * @param defaultValue : 转换失败时返回的长整型
     * @return long
     * @author b
     */
    public static long toLong(String longStr, long defaultValue) {
        try {
            return Long.valueOf(longStr == null ? "0" : longStr);
        } catch (Exception e) {
            for (StackTraceElement ele : e.getStackTrace()) {
                if (ele.toString().indexOf(Thread.currentThread().getStackTrace()[1].getClassName()) > -1) {
                    log.error(ele.toString());
                }
            }
            log.error(e.toString());
        }
        return defaultValue;
    }

    /**
     * 字符串 转 整型
     *
     * @param intStr       : 需要强制转换的字符串
     * @param defaultValue : 转换失败时返回的整型
     * @return int
     * @author b
     */
    public static int toInt(String intStr, int defaultValue) {
        try {
            return Integer.valueOf(intStr);
        } catch (Exception e) {
            for (StackTraceElement ele : e.getStackTrace()) {
                if (ele.toString().indexOf(Thread.currentThread().getStackTrace()[1].getClassName()) > -1) {
                    log.error(ele.toString());
                }
            }
            log.error(e.toString());
        }
        return defaultValue;
    }

    /**
     * 字符串 转 浮点型
     *
     * @param floatStr     : 需要强制转换的字符串
     * @param defaultValue : 转换失败时返回的浮点型
     * @return float
     * @author b
     */
    public static float toFloat(String floatStr, Float defaultValue) {
        try {
            return Float.valueOf(floatStr);
        } catch (Exception e) {
            for (StackTraceElement ele : e.getStackTrace()) {
                if (ele.toString().indexOf(Thread.currentThread().getStackTrace()[1].getClassName()) > -1) {
                    log.error(ele.toString());
                }
            }
            log.error(e.toString());
        }
        return defaultValue;
    }

    /**
     * 字符串 转 Double
     *
     * @param doubleStr    : 需要强制转换的字符串
     * @param defaultValue : 转换失败时返回的Double
     * @return double
     * @author b
     */
    public static double toDouble(String doubleStr, double defaultValue) {
        try {
            return Double.valueOf(isEmpty(doubleStr) ? "0" : doubleStr);
        } catch (Exception e) {
            for (StackTraceElement ele : e.getStackTrace()) {
                if (ele.toString().indexOf(Thread.currentThread().getStackTrace()[1].getClassName()) > -1) {
                    log.error(ele.toString());
                }
            }
            log.error(e.toString());
        }
        return defaultValue;
    }

    /**
     * null 转 "" 并且 去除空格
     *
     * @param str : 需要处理的字符串
     * @return String
     * @author b
     */
    public static String null2empty(String str) {
        if (str == null) {
            str = "";
        }
        return str.trim();
    }

    /**
     * 判断对象是不是NULL 是 返回 "" 否则返回 String
     *
     * @param obj : 需要处理的字符串
     * @return String
     * @author 赵松
     */
    public static String null2String(Object obj) {
        if (obj == null) {
            return "";
        }
        return obj.toString();
    }

    /**
     * 判断是否为空
     *
     * @param str : 需要判断的字符串
     * @return boolean
     * @author b
     */
    public static boolean isNull(String str) {
        return str == null;
    }

    /**
     * 判断字符串是否为空
     *
     * @param str : 需要判断的字符串
     * @return boolean
     * @author b
     */
    public static boolean isEmpty(String str) {
        return (str == null) || (str.trim().length() == 0);
    }

    /**
     * 判断String数组是否为空
     *
     * @param strs : 需要判断的String数组
     * @return boolean
     * @author b
     */
    public static boolean isEmpty(String... strs) {
        if (strs != null && strs.length > 0) {
            for (String s : strs) {
                if (isEmpty(s)){
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    /**
     * 判断String数组是否全部为空
     *
     * @param strs : 需要判断的String数组
     * @return boolean
     * @author b
     */
    public static boolean isAllEmpty(String... strs) {
        if (strs != null && strs.length > 0) {
            for (String s : strs) {
                if (!isEmpty(s)){
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    /**
     * 判断String数组是否不为空
     *
     * @param strs : 需要判断的String数组
     * @return boolean
     * @author b
     */
    public static boolean isNotEmpty(String... strs) {
        if (strs != null && strs.length > 0) {
            for (String s : strs) {
                if (isEmpty(s)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * 判断字符串是否整数
     *
     * @param str
     * @return boolean
     * @author zhaos
     */
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    /**
     * 数字字符串相加
     *
     * @param strA 第一个
     * @param strB 第二个
     * @return String 返回整数形式的字符串
     */
    public static String addStr(String strA, String strB) {
        return addStr(strA, strB, 0, 1);
    }

    /**
     * 数字字符串相加
     *
     * @param strA 第一个
     * @param strB 第二个
     * @param scale  保留几位小数 必须大于等于0
     * @param policy 策略 4:四舍五入 1:删除小数 0:直接进位
     * @return String
     * @author 赵松
     */
    public static String addStr(String strA, String strB, int scale, int policy) {
        String r = "0";
        if (scale < 0) {
            System.out.print("小数点位数不能小于0");
            return "error";
        }
        if (policy != 0 && policy != 4 && policy != 1) {
            policy = 4;
        }
        if (scale == 0) {
            policy = 1;
        }
        if (StringUtils.isEmpty(strA)) {
            strA = "0";
        }
        if (StringUtils.isEmpty(strB)) {
            strB = "0";
        }
        try {
            r = (new java.math.BigDecimal(strA).add(new java.math.BigDecimal(strB))).setScale(scale, policy).toString();
        } catch (Exception e) {
            r = "error";
            for (StackTraceElement ele : e.getStackTrace()) {
                if (ele.toString().indexOf(Thread.currentThread().getStackTrace()[1].getClassName()) > -1) {
                    log.error(ele.toString());
                }
            }
            log.error(e.toString());
        }
        return r;
    }

    /**
     * 数字字符串相减
     *
     * @param strMinuend    被减数
     * @param strSubtrahend 减数
     * @return String 返回整数形式的字符串
     */
    public static String subtractStr(String strMinuend, String strSubtrahend) {
        return subtractStr(strMinuend, strSubtrahend, 0, 1);
    }

    /**
     * 数字字符串相减
     *
     * @param strMinuend    被减数
     * @param strSubtrahend 减数
     * @param scale         保留几位小数 必须大于等于0
     * @param policy        策略 4:四舍五入 1:删除小数 0:直接进位
     * @return String
     * @author 赵松
     */
    public static String subtractStr(String strMinuend, String strSubtrahend, int scale, int policy) {
        String r = "0";
        if (scale < 0) {
            System.out.print("小数点位数不能小于0");
            return "error";
        }
        if (policy != 0 && policy != 4 && policy != 1) {
            policy = 4;
        }
        if (scale == 0) {
            policy = 1;
        }
        if (StringUtils.isEmpty(strMinuend)) {
            strMinuend = "0";
        }
        if (StringUtils.isEmpty(strSubtrahend)) {
            strSubtrahend = "0";
        }
        try {
            r = (new java.math.BigDecimal(strMinuend).subtract(new java.math.BigDecimal(strSubtrahend))).setScale(scale, policy).toString();
        } catch (Exception e) {
            r = "error";
            for (StackTraceElement ele : e.getStackTrace()) {
                if (ele.toString().indexOf(Thread.currentThread().getStackTrace()[1].getClassName()) > -1) {
                    log.error(ele.toString());
                }
            }
            log.error(e.toString());
        }
        return r;
    }

    /**
     * 数字字符串相乘
     *
     * @param strA 第一个
     * @param strB 第二个
     * @param scale  保留几位小数 必须大于等于0
     * @param policy 策略 4:四舍五入 1:删除小数 0:直接进位
     * @return String
     * @author 赵松
     */
    public static String multiplyStr(String strA, String strB, int scale, int policy) {
        String r = "0";
        if (scale < 0) {
            System.out.print("小数点位数不能小于0");
            return "error";
        }
        if (policy != 0 && policy != 4 && policy != 1) {
            policy = 4;
        }
        if (scale == 0) {
            policy = 1;
        }
        if (StringUtils.isEmpty(strA)) {
            strA = "0";
        }
        if (StringUtils.isEmpty(strB)) {
            strB = "0";
        }
        try {
            r = (new java.math.BigDecimal(strA).multiply(new java.math.BigDecimal(strB))).setScale(scale, policy).toString();
        } catch (Exception e) {
            r = "error";
            for (StackTraceElement ele : e.getStackTrace()) {
                if (ele.toString().indexOf(Thread.currentThread().getStackTrace()[1].getClassName()) > -1) {
                    log.error(ele.toString());
                }
            }
            log.error(e.toString());
        }
        return r;
    }

    /**
     * 数字字符串相除
     *
     * @param strDividend  被除数
     * @param strDivisor 除数
     * @param scale        保留几位小数 必须大于等于0
     * @param policy       策略 4:四舍五入 1:删除小数 0:直接进位
     * @return String
     * @author 赵松
     */
    public static String divideStr(String strDividend, String strDivisor, int scale, int policy) {
        String r = "0";
        if (scale < 0) {
            System.out.print("小数点位数不能小于0");
            return "error";
        }
        if (policy != 0 && policy != 4 && policy != 1) {
            policy = 4;
        }
        if (scale == 0) {
            policy = 1;
        }
        if (StringUtils.isEmpty(strDividend)) {
            strDividend = "0";
            return r;
        }// 0除以任何数都是0
        if (StringUtils.isEmpty(strDivisor)) {
            strDivisor = "0";
            return r;
        }// 除数不能为0
        try {
            r = new java.math.BigDecimal(strDividend).divide(new java.math.BigDecimal(strDivisor), scale, policy).toString();
        } catch (Exception e) {
            r = "error";
            for (StackTraceElement ele : e.getStackTrace()) {
                if (ele.toString().indexOf(Thread.currentThread().getStackTrace()[1].getClassName()) > -1) {
                    log.error(ele.toString());
                }
            }
            log.error(e.toString());
        }
        return r;
    }

    public static String emojiFilter(String originalString, String changeFor) {
        //return originalString.replaceAll("[^\\u0000-\\uFFFF]", "");
        return originalString.replaceAll("\uD83C[\uDF00-\uDFFF]|\uD83D[\uDC00-\uDE4F]|[\u2600-\u27ff]|\\<span[0-9a-zA-Z=\"\\<\\>/ ]*span\\>", changeFor);
    }

    public static String emojiFilter(String originalString) {
        return emojiFilter(originalString, "");
    }
	/*
	// 将汉字转换为全拼  
    public static String getPinYin(String src) {  
        char[] t1 = null;  
        t1 = src.toCharArray();  
        String[] t2 = new String[t1.length];  
        HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();  
          
        t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);  
        t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);  
        t3.setVCharType(HanyuPinyinVCharType.WITH_V);  
        
        String t4 = "";  
        int t0 = t1.length;  
        try {  
            for (int i = 0; i < t0; i++) {  
                // 判断是否为汉字字符  
                if (java.lang.Character.toString(t1[i]).matches(  
                        "[\\u4E00-\\u9FA5]+")) {  
                    t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);  
                    t4 += t2[0];  
                } else  
                    t4 += java.lang.Character.toString(t1[i]);  
            }  
            // System.out.println(t4);  
            return t4;  
        } catch (BadHanyuPinyinOutputFormatCombination e1) {  
            e1.printStackTrace();  
        }  
        return t4;  
    }  
  
    // 返回中文的首字母  
    public static String getPinYinHeadChar(String str) {  
  
        String convert = "";  
        for (int j = 0; j < str.length(); j++) {  
            char word = str.charAt(j);  
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);  
            if (pinyinArray != null) {  
                convert += pinyinArray[0].charAt(0);  
            } else {  
                convert += word;  
            }  
        }  
        return convert;  
    }*/

    // 将字符串转移为ASCII码  
    public static String getCnASCII(String cnStr) {
        StringBuffer strBuf = new StringBuffer();
        byte[] bGBK = cnStr.getBytes();
        for (int i = 0; i < bGBK.length; i++) {
            strBuf.append(Integer.toHexString(bGBK[i] & 0xff));
        }
        return strBuf.toString();
    }

    /**
     * <p>Checks if a String is whitespace, empty ("") or null.</p>
     *
     * <pre>
     * StringUtils.isBlank(null)      = true
     * StringUtils.isBlank("")        = true
     * StringUtils.isBlank(" ")       = true
     * StringUtils.isBlank("bob")     = false
     * StringUtils.isBlank("  bob  ") = false
     * </pre>
     *
     * @param str the String to check, may be null
     * @return <code>true</code> if the String is null, empty or whitespace
     * @since 2.0
     */
    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 集合 用指定符号分割
     * @param var0 集合
     * @param var1 分割符号
     * @return 分割好的字符串
     */
    public static String join(Collection var0, String var1) {
        StringBuilder var2 = new StringBuilder();
        for(Iterator var3 = var0.iterator(); var3.hasNext(); var2.append((String)var3.next())) {
            if (var2.length() != 0) {
                var2.append(var1);
            }
        }
        return var2.toString();
    }
}
