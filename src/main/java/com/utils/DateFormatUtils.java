package com.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zhaos
 */
public class DateFormatUtils {

    public static String defaultFormat = "yyyy-MM-dd HH:mm:ss";
    public static String defaultFormat2 = "yyyy-MM-dd";

    /**
     * 获取今天零点
     *
     * @return 零点
     */
    public static Date getTodayBegin() {
        return DateFormatUtils.getCurrentDate("yyyy-MM-dd 00:00:00");
    }

    /**
     * 获取今天结束
     *
     * @return 结束
     */
    public static Date getTodayEnd() {
        String endStr = getCurrentDateString("yyyy-MM-dd 23:59:59");
        return parseDateString(endStr, defaultFormat);
    }

    /**
     * @return 当前系统时间 String yyyy-MM-dd HH:mm:ss
     */
    public static String getCurrentDateString() {
        SimpleDateFormat sdf = new SimpleDateFormat(defaultFormat);
        return sdf.format(new Date());
    }

    /**
     * @param format 时间格式
     * @return 当前系统时间 String
     */
    public static String getCurrentDateString(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }

    /**
     * 日期 转字符串
     *
     * @param date   时间
     * @param format 时间格式
     * @return 字符串
     */
    public static String getDateString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static String getDateString_yyyy_MM_dd_HH_mm_ss(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(defaultFormat);
        return sdf.format(date);
    }

    /**
     * @return 当前系统时间
     */
    public static Date getCurrentDate() {
        return new Date();
    }

    /**
     * @param format 格式
     * @return 当前系统时间
     */
    public static Date getCurrentDate(String format) {
        String dateStr = getDateString(new Date(), format);
        return parseDateString(dateStr, format);
    }

    /**
     * 字符串 转 日期
     *
     * @param date   时间
     * @param format 时间格式
     * @return 字符串
     */
    public static Date parseDateString(String date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

    /**
     * @return 当前系统时间 date yyyy-MM-dd
     */
    public static Date parseDateString_yyyy_MM_dd(String date) {
        return parseDateString(date, "yyyy-MM-dd");
    }

    /**
     * @return 当前系统时间 date yyyy-MM-dd HH:mm:ss
     */
    public static Date parseDateString_yyyy_MM_dd_HH_mm_ss(String date) {
        return parseDateString(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static java.sql.Date convert(Date date) {
        return new java.sql.Date(date.getTime());
    }

    public static java.sql.Date getSqlDate() {
        return convert(getCurrentDate());
    }

    public static java.sql.Date parseSqlDateString(String date, String format) {
        return convert(parseDateString(date, format));
    }

    public static java.sql.Date parseSqlDateString_yyyy_MM_dd(String date) {
        if (date.length() > 10) {
            date = date.substring(0, 10);
        }
        return parseSqlDateString(date, "yyyy-MM-dd");
    }

    public static java.sql.Date parseSqlDateString_yyyy_MM_dd_HH_mm_ss(String date) {
        if (date.length() == 10) {
            date += " 00:00:00";
        } else if (date.length() > 19) {
            date = date.substring(0, 19);
        }
        return parseSqlDateString(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static java.sql.Timestamp getSqlTimestamp() {
        return new java.sql.Timestamp(getCurrentDate().getTime());
    }

    public static java.sql.Timestamp parseSqlTimestampString(String date, String format) {
        return new java.sql.Timestamp(parseDateString(date, format).getTime());
    }

    public static java.sql.Timestamp parseSqlTimestampString_yyyy_MM_dd(String date) {
        if (date.length() > 10) {
            date = date.substring(0, 10);
        }
        return parseSqlTimestampString(date, "yyyy-MM-dd");
    }

    public static java.sql.Timestamp parseSqlTimestampString_yyyy_MM_dd_HH_mm_ss(String date) {
        if (date.length() == 10) {
            date += " 00:00:00";
        } else if (date.length() > 19) {
            date = date.substring(0, 19);
        }
        return parseSqlTimestampString(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String getCronExpression(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);//设置当前日期
        int year = calendar.get(Calendar.YEAR);//获取年份
        int month = calendar.get(Calendar.MONTH) + 1;//获取月份
        int day = calendar.get(Calendar.DATE);//获取日
        int hour = calendar.get(Calendar.HOUR_OF_DAY);//小时
        int minute = calendar.get(Calendar.MINUTE);//分           
        int second = calendar.get(Calendar.SECOND);//秒
        String cron = second + " " + minute + " " + hour + " " + day + " " + month + " ? " + year;
        return cron;
    }

    public static String addHours(String date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDateString(date, defaultFormat));
        calendar.add(Calendar.HOUR, hours);
        return getDateString(calendar.getTime(), defaultFormat);
    }

    public static String addMinutes(String date, int minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDateString(date, defaultFormat));
        calendar.add(Calendar.MINUTE, minutes);
        return getDateString(calendar.getTime(), defaultFormat);
    }

    public static String addDays(String date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDateString(date, defaultFormat));
        calendar.add(Calendar.DATE, days);
        return getDateString(calendar.getTime(), defaultFormat);
    }

    public static String addMonths(String date, int addMonths) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDateString(date, defaultFormat));
        calendar.add(Calendar.MONTH, addMonths);
        return getDateString(calendar.getTime(), defaultFormat);
    }

    public static String addYears(String date, int addYears) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDateString(date, defaultFormat2));
        calendar.add(Calendar.YEAR, addYears);
        return getDateString(calendar.getTime(), defaultFormat2);
    }

    public static int getDayOfWeek(String date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDateString(date, "yyyy-MM-dd"));
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    public static Date getCurrentMonthMax() {
        LocalDateTime time = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        LocalDateTime nowMonthMax = time.with(TemporalAdjusters.lastDayOfMonth());
        return Date.from(nowMonthMax.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date getCurrentMonthMin() {
        LocalDateTime time = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        LocalDateTime nowMonthMin = time.with(TemporalAdjusters.firstDayOfMonth());
        return Date.from(nowMonthMin.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date getLastMonthMin() {
        LocalDateTime time = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        LocalDateTime lastMonthTime = time.plusMonths(-1);
        LocalDateTime lastMonthStart = lastMonthTime.with(TemporalAdjusters.firstDayOfMonth());
        return Date.from(lastMonthStart.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date getCurrentYearMin() {
        LocalDateTime time = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        LocalDateTime nowYearMin = time.with(TemporalAdjusters.firstDayOfYear());
        return Date.from(nowYearMin.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date getCurrentYearMax() {
        LocalDateTime time = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        LocalDateTime nowYearMax = time.with(TemporalAdjusters.lastDayOfYear());
        return Date.from(nowYearMax.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date getCurrentDayMax() {
        LocalDateTime time = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date getCurrentDayMin() {
        LocalDateTime time = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date getLastDayMin() {
        LocalDateTime time = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        LocalDateTime lastTime = time.plusDays(-1);
        return Date.from(lastTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date getNextDay(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
        LocalDateTime nextLocalDateTime = localDateTime.plusDays(1L);
        instant = nextLocalDateTime.atZone(zoneId).toInstant();
        return Date.from(instant);
    }

    public static Date getLastDay(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
        LocalDateTime nextLocalDateTime = localDateTime.plusDays(-1L);
        instant = nextLocalDateTime.atZone(zoneId).toInstant();
        return Date.from(instant);
    }

    public static Date getNextMonth(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
        LocalDateTime nextLocalDateTime = localDateTime.plusMonths(1L);
        instant = nextLocalDateTime.atZone(zoneId).toInstant();
        return Date.from(instant);
    }

    public static Date getLastMonth(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
        localDateTime = localDateTime.plusMonths(-1L);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant2 = localDateTime.atZone(zone).toInstant();
        return Date.from(instant2);
    }

    /**
     * java 时间字符串格式转换
     * Thu Apr 02 18:48:58 CST 2020 -> yyyy-MM-dd HH:mm:ss
     *
     * @param dateStr Thu Apr 02 18:48:58 CST 2020 格式
     * @return yyyy-MM-dd HH:mm:ss 格式
     */
    public static String formatDate(String dateStr) {
        String[] aStrings = dateStr.split(" ");
        if ("Jan".equals(aStrings[1])) {
            aStrings[1] = "01";
        }
        if ("Feb".equals(aStrings[1])) {
            aStrings[1] = "02";
        }
        if ("Mar".equals(aStrings[1])) {
            aStrings[1] = "03";
        }
        if ("Apr".equals(aStrings[1])) {
            aStrings[1] = "04";
        }
        if ("May".equals(aStrings[1])) {
            aStrings[1] = "05";
        }
        if ("Jun".equals(aStrings[1])) {
            aStrings[1] = "06";
        }
        if ("Jul".equals(aStrings[1])) {
            aStrings[1] = "07";
        }
        if ("Aug".equals(aStrings[1])) {
            aStrings[1] = "08";
        }
        if ("Sep".equals(aStrings[1])) {
            aStrings[1] = "09";
        }
        if ("Oct".equals(aStrings[1])) {
            aStrings[1] = "10";
        }
        if ("Nov".equals(aStrings[1])) {
            aStrings[1] = "11";
        }
        if ("Dec".equals(aStrings[1])) {
            aStrings[1] = "12";
        }
        return aStrings[5] + "-" + aStrings[1] + "-" + aStrings[2] + " " + aStrings[3];
    }


    public static String formatDate(Date date) {
        return formatDate(date.toString());
    }


    public static void main(String[] args) {
        String s = formatDate("Thu Apr 02 18:48:58 CST 2020");
        System.out.println(s);
    }
}
