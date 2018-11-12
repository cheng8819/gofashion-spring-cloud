package com.gofashion.gofashionspringcloudordersorder.uilt.uuidulit;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * 生成UUID       32位
 */
public class UUIDTest {
    public synchronized static String uuid(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            System.out.println(UUIDTest.uuid());
        }

    }






}
