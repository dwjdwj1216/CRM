package com.gmc.service;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 顾梦超 on 2016/5/2.
 */
public class Format {
    private static DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private static DateFormat format1 = new SimpleDateFormat("yyyyMMddhhmmss");
    private static DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
    private static DecimalFormat decimalFormat = new DecimalFormat("###,###,###.##");
    public static String dateTOString(Date date){
        return format.format(date);
    }
    public static String doubleToString (double s){
        return decimalFormat.format(s);
    }
    public static Date stringToDate(String string){
        try {
            return format.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String dateTOString1(Date date){
        return format1.format(date);
    }
    public static String dateTOString2(Date date){
        return format2.format(date);
    }
    public static Date stringToDate1(String string){
        try {
            return format1.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
