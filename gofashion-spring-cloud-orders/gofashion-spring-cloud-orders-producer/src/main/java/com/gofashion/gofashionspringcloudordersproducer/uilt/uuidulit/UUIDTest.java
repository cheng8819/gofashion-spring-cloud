package com.gofashion.gofashionspringcloudordersproducer.uilt.uuidulit;

import java.util.Date;
import java.util.UUID;

import static com.gofashion.gofashionspringcloudordersproducer.uilt.dateulit.FormatDateTime.dateToString;

/**
 * 生成UUID       32位
 */
public class UUIDTest {
    public synchronized static String uuid(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            UUIDTest.id();

        }
    }

    public synchronized static String id(){
        String yyyyMMddHHmmss = dateToString((new Date(System.currentTimeMillis())), "yyyyMMddHHmmss");
        System.out.println(yyyyMMddHHmmss);
        String time = System.currentTimeMillis() + "";
        System.out.println(time);
        String substring = time.substring(6);
        System.out.println(substring);
        Integer x=(int)(Math.random()*100);
        String format = String.format("%02d", x);//如果不足两位，前面补0

        return yyyyMMddHHmmss + format;
    }
}
