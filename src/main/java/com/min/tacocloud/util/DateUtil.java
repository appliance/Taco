package com.min.tacocloud.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    /***
     * 获取当前时间
     * @return
     */
    public static String getCurrentDate(){
        Date date = new Date();
        SimpleDateFormat fomatter = new SimpleDateFormat("yyyy:MM:dd");
        return fomatter.format(date);
    }
}
