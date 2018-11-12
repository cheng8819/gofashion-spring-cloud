package com.gofashion.gofashionspringcloudordersdetails.uilt.uuidulit;

import java.util.Date;

import static com.gofashion.gofashionspringcloudordersdetails.uilt.dateulit.FormatDateTime.dateToString;

/**
 * 时间戳加8位随机数
 */
public class IDUtils {
    private static byte[] lock = new byte[0];
    // 位数，默认是8位
    private final static long w = 100000000;

    public static String createID() {
        long r = 0;
        synchronized (lock) {
            r = (long) ((Math.random() + 1) * w);
        }
        String yyyyMMddHHmmss = dateToString((new Date(System.currentTimeMillis())), "yyyyMMddHHmmss");
        System.out.println(yyyyMMddHHmmss);
        System.out.println(String.valueOf(r).substring(1));
        return yyyyMMddHHmmss + String.valueOf(r).substring(1);
    }
}
