package cn.leekoko.common.utils;

import java.text.SimpleDateFormat;
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
}
