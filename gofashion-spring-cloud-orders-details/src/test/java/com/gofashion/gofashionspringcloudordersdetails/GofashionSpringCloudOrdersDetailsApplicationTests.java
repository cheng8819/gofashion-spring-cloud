package com.gofashion.gofashionspringcloudordersdetails;

import com.gofashion.gofashionspringcloudordersdetails.uilt.redisulit.RedisUtil;
import com.gofashion.gofashionspringcloudordersdetails.uilt.uuidulit.IDUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GofashionSpringCloudOrdersDetailsApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisUtil redisUtil;
    @Test
    public void contextLoads() {
        redisTemplate.opsForValue().set("key" ,"zzzzzzzzzzzzzzzzzzzzzzzz");
        
        Boolean key = redisUtil.expire("key", System.currentTimeMillis() + 3*1000);
        Long l = System.currentTimeMillis();
        String a = l.toString();
        Boolean test = true;
        while (test){
            System.out.println(a);
            long key1 = redisUtil.getExpire("key");
            System.out.println(key1);
            String key2 = (String) redisTemplate.opsForValue().get("key");
            if("".equals(key)){
                test = false;
            }
        }
    }

    public void show(){

    }
    public static void main(String[] args) {
/*        Long l = FormatDateTime.dateToLong(new Date());
        System.out.println("1-------------" + l);
*//*        try {
            String s = FormatDateTime.dateToStamp(l.toString());
            System.out.println("2--------------" + s);
        } catch (ParseException e) {
            e.printStackTrace();
        }*//*

        String ss = FormatDateTime.DateToStr(new Date());
        System.out.println("3--------------" + ss);
        try {
            System.out.println(FormatDateTime.dateToStamp(ss) + "--------------3-4");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(FormatDateTime.longzhuandate() + "-------------4");*/
        String id = IDUtils.createID();
        System.out.println(id);
    }
}
