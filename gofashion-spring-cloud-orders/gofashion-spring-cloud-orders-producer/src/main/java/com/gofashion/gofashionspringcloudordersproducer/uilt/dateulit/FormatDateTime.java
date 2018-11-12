package com.gofashion.gofashionspringcloudordersproducer.uilt.dateulit;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class FormatDateTime {
    public static String toLongDateString(Date dt){
        SimpleDateFormat myFmt=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 E ");
        return myFmt.format(dt);
    }
    public static String toShortDateString(Date dt){
        SimpleDateFormat myFmt=new SimpleDateFormat("yy年MM月dd日 HH时mm分");
        return myFmt.format(dt);
    }
    public static String toLongTimeString(Date dt){
        SimpleDateFormat myFmt=new SimpleDateFormat("HH mm ss SSSS");
        return myFmt.format(dt);
    }
    public static String toShortTimeString(Date dt){
        SimpleDateFormat myFmt=new SimpleDateFormat("yy/MM/dd HH:mm");
        return myFmt.format(dt);
    }
    /**
     *
     * @param date
     * @return str   日期转换成字符串
     */
    public static String DateToStr(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(date);
        return str;
    }
    /**
     * 字符串转换成日期
     * @param str
     * @return date  字符串转换成日期
     */
    public static Date StrToDate(String str) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 将时间转换为时间戳
     * @param s
     * @return 将时间转换为时间戳
     * @throws ParseException
     */
    public static String dateToStamp(String s) throws ParseException{
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        System.out.println(date);
        long ts = date.getTime();
        System.out.println(ts);
        res = String.valueOf(ts);
        return res;
    }

    /**
     *
     * @param s
     * @return 将时间戳转换为时间
     */
    public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
    /**
     *
     * @param date
     * @return 将时间戳转换为时间
     */
    public static String stampToDate(Date date){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        res = simpleDateFormat.format(date);
        return res;
    }
    /**
     * 时间戳转换成日期格式字符串
     * @param seconds 精确到秒的字符串
     * @param
     * @return 时间戳转换成日期格式字符串
     */
    public static String timeStamp2Date(String seconds,String format) {
        if(seconds == null || seconds.isEmpty() || seconds.equals("null")){
            return "";
        }
        if(format == null || format.isEmpty()) format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds+"000")));
    }

    /**
     * @return 取得当前时间戳（精确到秒）转String
     */
    public static String timeStamp(){
        long time = System.currentTimeMillis();
        String t = String.valueOf(time/1000);
        return t;
    }

    /**
     *
     * @param time
     * @return  String转long
     */
    public static Long stringzhuanlong(String time){
        return Long.parseLong(time);
    }

    /**
     *
     * @return 当前时间戳转   date
     */
    public static String longzhuandate(){
        long ls = System.currentTimeMillis();
        System.out.println(ls);
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(ls));
        System.out.println(format);
        return format;
    }
    /*
    * Date、String、Long三种日期类型之间的相互转换
    * date类型转换为String类型
    * */
    // formatType格式为yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
    // data Date类型的时间
    public static String dateToString(Date data, String formatType) {
        return new SimpleDateFormat(formatType).format(data);
    }

//string类型转换为date类型
    // strTime要转换的string类型的时间，formatType要转换的格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日
    // HH时mm分ss秒，
    // strTime的时间格式必须要与formatType的时间格式相同
    public static Date stringToDate(String strTime, String formatType)
            throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date = null;
        date = formatter.parse(strTime);
        return date;
    }

    /**
     *
     * @param currentTime  时间戳
     * @param formatType   固定格式的时间字符串
     * @return     转date类型
     * @throws ParseException
     */
    public static Date longToDate(long currentTime, String formatType) throws ParseException {
        String sDateTime = dateToString((new Date(currentTime)), formatType); // 把date类型的时间转换为string
        Date date = stringToDate(sDateTime, formatType); // 把String类型转换为Date类型
        return date;
    }

    /**
     * @param date  date要转换的long类型的时间
     * @return date要转换的long类型的时间
     */
    public static long dateToLong(Date date) {
        return date.getTime();
    }
    public static void main(String[] args) {
        String longzhuandate = longzhuandate();
        System.out.println(longzhuandate);
    }
}
