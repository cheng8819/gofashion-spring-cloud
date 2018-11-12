package com.gofashion.gofashionspringcloudordersdetails.uilt.uuidulit;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 生成UUID       32位
 */
public class UUIDTest {
    public static String uuid(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            System.out.println(UUIDTest.uuid());
        }

    }
}
