package cn.bm.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTypeStringUtils {

    //日期转换成字符串
    public static String dateTypeString(Date date , String str){
        SimpleDateFormat sdf = new SimpleDateFormat(str);
        String string = sdf.format(date);
        return string;
    }

    //字符串转换成日期
    public static Date stringTypeDate(String string,String str) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(str);
        Date date = sdf.parse(string);
        return date;
    }

}
