package cn.leekoko.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    /**
     * 获取当前日期时间Str
     * yyyy-MM-dd hh:mm:ss
     * @return
     */
    public static String getDateTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = sdf.format(new Date());
        return dateString;
    }
    /**
     * 获取当前日期Str
     * yyyy-MM-dd
     * @return
     */
    public static String getDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = sdf.format(new Date());
        return dateString;
    }
    /**
     * 当前日期减去一天
     * @throws ParseException
     */
    public static String reduceOneDay(String today){
        SimpleDateFormat sj = new SimpleDateFormat("yyyy-MM-dd");
        Date d = null;
        try {
            d = sj.parse(today);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.DATE, -1);
        return sj.format(calendar.getTime());
    }
    /**
     * 当前日期加上一天
     * @throws ParseException
     */
    public static String addOneDay(String today){
        SimpleDateFormat sj = new SimpleDateFormat("yyyy-MM-dd");
        Date d = null;
        try {
            d = sj.parse(today);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.DATE, 1);
        return sj.format(calendar.getTime());
    }
}
