package com.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author song
 * @description 时间
 * @date 2020/5/7
 **/
public class DateUtil {
    /**
     * 格式转换类型: yyyy-MM-dd HH:mm:ss
     */
    public final static String FORMAT_STRING1 = "yyyy-MM-dd HH:mm:ss";
    /**
     * 格式转换类型: yyyy-MM-dd
     */
    public final static String FORMAT_STRING2 = "yyyy-MM-dd";
    /**
     * 格式转换类型: HH:mm:ss
     */
    public final static String FORMAT_STRING3 = "HH:mm:ss";
    /**
     * 格式转换类型: yyyy-MM-dd HH:mm
     */
    public final static String FORMAT_STRING4 = "yyyy-MM-dd HH:mm";
    /**
     * 格式转换类型: HH:mm
     */
    public final static String FORMAT_STRING5 = "HH:mm";

    /**
     * 格式转换类型: yyyyMMddHHmmss
     */
    public final static String FORMAT_STRING6 = "yyyyMMddHHmmss";
    /**
     * 格式转换类型: yyyy-MM
     */
    public final static String FORMAT_STRING7 = "yyyy-MM";
    /**
     * 格式转换类型: yyyyMMddHHmmss
     */
    public final static String FORMAT_STRING8 = "yyyyMMddHHmmssS";
    /**
     * 格式转换类型: yyyy-MM-dd
     */
    public final static String FORMAT_STRING9 = "yyyyMMdd";

    /**
     * @param date
     * @param formatString
     * @return
     * @Title: dateToString
     * @Description:日期转换
     * @author gengyongqiang
     * @since 2017年6月5日
     */
    public static String dateToString(Date date, String formatString) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatString);
        return sdf.format(date);
    }

    /**
     * @param dateStr
     * @param format
     * @return
     * @Title: strToDate
     * @Description:时间字符串转日期类型
     * @author gengyongqiang
     * @since 2017年7月5日
     */
    public static Date strToDate(String dateStr, String format) {
        Date ret = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            ret = formatter.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * @param minutes
     * @return
     * @Title: getDateNMinutes
     * @Description:
     * @author gengyongqiang
     * @since 2017年7月1日
     */
    public static Date getDateNMinutes(int minutes) {
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, minutes);
        return nowTime.getTime();
    }

    /**
     * 获取当前时间后几分钟，min为正数表示获取后几分钟，为负数表示前几分钟
     *
     * @param day
     * @param min
     * @return
     */
    public static String getDateMin(Date day, int min) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date;

        Calendar cal = Calendar.getInstance();
        cal.setTime(day);
        cal.add(Calendar.MINUTE, min);
        date = cal.getTime();
        return format.format(date);
    }

    /**
     * @param hour
     * @return
     * @Title: getDateNDay
     * @Description:获取当前时间后几个小时，hour为正数表示获取后几小时，为负数表示前几小时
     * @author songshuai
     * @since 2017年7月5日
     */
    public static String getDateHour(Date day, int hour) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date;

        Calendar cal = Calendar.getInstance();
        cal.setTime(day);
        cal.add(Calendar.HOUR, hour);
        date = cal.getTime();
        return format.format(date);
    }

    /**
     * @param days
     * @return
     * @Title: getDateNDay
     * @Description:获取当前时间前几天或后几天，days为正数表示获取后几天，为负数表示前几天
     * @author gengyongqiang
     * @since 2017年7月5日
     */
    public static Date getDateNDay(int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, days);
        return c.getTime();
    }

    /**
     * @param month
     * @return
     * @Title: getDateNMonth
     * @Description:获取当前时间前几个月（负数）或后几个月（正数）
     * @author gengyongqiang
     * @since 2017年7月5日
     */
    public static Date getDateNMonth(int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, month);
        return c.getTime();
    }

    /**
     * @param month
     * @return
     * @Title: getDateNMonth
     * @Description:增加日期（月）
     * @author gengyongqiang
     * @since 2017年7月5日
     */
    public static Date getDateNMonth(Date date, int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, month);
        return c.getTime();
    }

    /**
     * @param years
     * @return
     * @Title: getDateNYear
     * @Description: 当前时间前几年（负数）或后几年（正数）
     * @author gengyongqiang
     * @since 2017年7月5日
     */
    public static Date getDateNYear(int years) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.YEAR, years);
        return c.getTime();
    }

    /**
     * @param DATE1 对比时间
     * @param DATE2 当前时间
     * @return 1 大于当前时间 -1 小于当前时间
     * @Title: compare_date
     * @Description: 比较时间大小
     * @author gengyongqiang
     * @since 2017年7月5日
     */
    public static int compare_date(String DATE1, String DATE2) {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
//				System.out.println("dt1在dt2前");
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
//				System.out.println("dt1在dt2后");
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    /**
     * @param DATE1 对比时间
     * @param DATE2 当前时间
     * @return 1 大于当前时间 -1小于当前时间
     * @Title: compare_date
     * @Description: 比较时间大小
     * @author gengyongqiang
     * @since 2017年7月5日
     */
    public static int compare_oneDay_date(String DATE1, String DATE2) {

        DateFormat df = new SimpleDateFormat("hh:mm");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
//				System.out.println("dt1在dt2后");
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
//				System.out.println("dt1在dt2前");
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }


    /**
     * @return Timestamp
     * @Title: getNowTimestamp
     * @Description: 获取当前时间戳 （yyyy-MM-dd HH:mm:ss）
     * @author gengyongqiang
     * @since 2017年7月5日
     */
    public static Timestamp getNowTimestamp() {
        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());
        return timeStamp;
    }

    /**
     * 指定月份的天数
     *
     * @param year  年份
     * @param month 月份
     * @return
     */
    public static int getDaysByYearMonth(int year, int month) {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;

    }

    /**
     * 根据两个日期 计算分钟差
     */
    public static long getMinutes(Date Start, Date end) {
        long from = Start.getTime();
        long to = end.getTime();
        long minutes = (to - from) / (1000 * 60);
        return minutes;
    }


}
