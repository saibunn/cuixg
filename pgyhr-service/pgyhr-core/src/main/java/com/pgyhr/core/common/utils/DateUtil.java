package com.pgyhr.core.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @Description: 日期处理类
 * @Author: xiaoguang cui
 * @Date: 2020/05/11 9:55
 */
public class DateUtil {

    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

    /**
     * 获得当前日期
     *
     * @param pattern
     * @return
     */
    public static String getCurrentDate(String pattern) {
        if (null == pattern) {
            return null;
        }
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 日期转字符串
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String getDate(Date date, String pattern) {
        if (null == date) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 字符串转日期
     *
     * @param str
     * @param pattern
     * @return
     */
    public static Date toDate(String str, String pattern) {
        if (null == str || "".equals(str)) {
            return null;
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.parse(str);
        } catch (Exception e) {
            logger.error("convert string to date error. str=" + str + "; pattern=" + pattern, e);
        }
        return null;
    }

    /**
     * 日期转字符串
     *
     * @param dt
     * @param pattern
     * @return
     */
    public static String toDateString(Date dt, String pattern) {
        if (dt == null) {
            return "";
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.format(dt);
        }
    }

    /**
     * 字符串转日期(yyyy-MM-dd)
     *
     * @param str
     * @return
     */
    public static Date toDate(String str) {
        return toDate(str, "yyyy-MM-dd");
    }

    /**
     * 获取时间
     *
     * @param date
     * @return
     */
    public static Integer getTime(Date date) {
        if (null == date) {
            return null;
        }
        return Integer.parseInt(getDate(date, "HHmm"));
    }

    /**
     *  获取两个日期相差的月数
     * @param d1    较大的日期
     * @param d2    较小的日期
     * @return  如果d1>d2返回 月数差 否则返回0
     */
    public static int getMonthDiff(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);
        if(c1.getTimeInMillis() < c2.getTimeInMillis()){
            return 0;
        }
        int year1 = c1.get(Calendar.YEAR);
        int year2 = c2.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH);
        int month2 = c2.get(Calendar.MONTH);
        int day1 = c1.get(Calendar.DAY_OF_MONTH);
        int day2 = c2.get(Calendar.DAY_OF_MONTH);
        // 获取年的差值 假设 d1 = 2015-8-16  d2 = 2011-9-30
        int yearInterval = year1 - year2;
        // 如果 d1的 月-日 小于 d2的 月-日 那么 yearInterval-- 这样就得到了相差的年数
        if(month1 < month2 || month1 == month2 && day1 < day2){
            yearInterval --;
        }
        // 获取月数差值
        int monthInterval =  (month1 + 12) - month2  ;
        if(day1 < day2){
            monthInterval --;
        }
        monthInterval %= 12;
        return yearInterval * 12 + monthInterval;
    }

    /**
     * 获取周
     *
     * @param date
     * @return
     */
    public static Integer getWeek(Date date) {
        if (null == date) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }


    /**
     * 获取年
     *
     * @return
     */
    public static int getCurrentYear() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.YEAR);
    }


    /**
     * 判断date是否在time1和time2之间
     *
     * @param date
     * @param time1
     * @param time2
     * @return
     */
    public static boolean isInTimes(Date date, int time1, int time2) {
        int time = Integer.parseInt(getDate(date, "HHmm"));
        return time >= time1 && time <= time2;
    }

    /**
     * 判断date是否在time之后
     *
     * @param date
     * @param time
     * @return
     */
    public static boolean isAfterTime(Date date, int time) {
        return (Integer.parseInt(getDate(date, "HHmm")) - time) >= 0;
    }

    /**
     * 获取date1到date2之间的小时数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getBetweenHours(Date date1, Date date2) {
        return (int) ((date1.getTime() - date2.getTime()) / (1000 * 60 * 60));
    }


    /**
     * 计算两个时间之间的小时数
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static float getHours(Date startTime, Date endTime) {
        long hourTimes = 60 * 60 * 1000;//1小时
        long minuteTimes = 60 * 1000;//1分钟
        long times = endTime.getTime() - startTime.getTime();//总时长
        Long hours = times / hourTimes;//小时数
        Long minute = (times - hours * hourTimes) / minuteTimes;//剩余分钟数
        float hour = hours.floatValue();
        if (minute > 0 && minute <= 15) {
            hour += 0.25f;
        } else if (minute > 15 && minute <= 30) {
            hour += 0.5f;
        } else if (minute > 30 && minute <= 45) {
            hour += 0.75f;
        } else if (minute > 45 && minute <= 60) {
            hour += 1f;
        }
        return hour;
    }

    /**
     * Date转换为LocalDateTime
     * @author ningkuilong
     * @date 2018/2/6
     * @param date
     * @return java.time.LocalDateTime
     */
    public static LocalDateTime convertDateToLDT(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     *LocalDateTime转换为Date
     * @author ningkuilong
     * @date 2018/2/6
     * @param time
     * @return java.util.Date
     */
    public static Date convertLDTToDate(LocalDateTime time) {
        return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 日期加几月
     */
    public static Date dateAddMonth(Date dt,int addCount){
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        rightNow.add(Calendar.MONTH, addCount);// 日期加
        return rightNow.getTime();
    }

    /**
     * 日期加几天
     */
    public static Date dateAddDay(Date dt,int addCount){
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        rightNow.add(Calendar.DAY_OF_MONTH, addCount);// 日期加
        return rightNow.getTime();
    }

    /**
     * 判断时间是否在时间段内
     *
     * @param nowTime
     * @param beginTime
     * @param endTime
     * @return
     */
    public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
        if(beginTime == null || endTime == null){
            return false;
        }
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);
        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);
        Calendar end = Calendar.getInstance();
        end.setTime(endTime);
        if (date.after(begin) && date.before(end)) {
            return true;
        } else if (nowTime.compareTo(beginTime) == 0 || nowTime.compareTo(endTime) == 0) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 当前日期向前或者向后移动日数
     */
    public static Date removeDate(Date dt,int removeDateNum){
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        rightNow.add(Calendar.DAY_OF_MONTH, removeDateNum);// 日期加
        return rightNow.getTime();
    }

    /**
     * 将日期进行强转
     * @param dateStr
     * @return
     */
    public static  Date toDateFromString(Object dateStr) {
        if (StringUtils.isEmpty(dateStr) || toString_(dateStr).startsWith("0")) {
            return null;
        }
        String str = toString_(dateStr).replace(".", "-");
        if(str!= null && str.length() < 8){
            str+="-01";
        }
        return DateUtil.toDate(str);
    }

    public static  String toString_(Object obj) {
        if (null == obj) {
            return "";
        }
        return String.valueOf(obj);
    }

    /**
     * TODO DELETE
     */
    public static void main(String[] args) {
        System.out.println(LocalDate.now());
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_H:m:s:SSS")));
        System.out.println(DateUtil.getCurrentDate("yyyyMMdd_HHmmssSSS"));
    }

    public static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate asLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDateTime asLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static String dealDateFormat(String oldDate) {
        Date date1 = null;
        DateFormat df2 = null;
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = df.parse(oldDate);
            SimpleDateFormat df1 = new SimpleDateFormat ("EEE MMM dd HH:mm:ss Z yyyy", Locale.CHINA);
            date1 = df1.parse(date.toString());
            df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        } catch (ParseException e) {

            e.printStackTrace();
        }
        return df2.format(date1);
    }

}
