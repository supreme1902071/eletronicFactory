package com.pctc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间的转换类
 * @author
 *
 */
public class DateUtil {

    private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    //private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

    public static Date string2Date(String dateString)
    {
        Date date=null;
        try {
            date=sdf.parse(dateString);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    }

    public static String date2String(Date date) {
        // TODO Auto-generated method stub
        return sdf.format(date);
    }

}

