package com.gofashion.gofashionspringcloudordersorder;

import com.gofashion.gofashionspringcloudordersorder.service.SplitDataService;
import com.gofashion.gofashionspringcloudordersorder.service.redisservice.RedisFetchOrRemoveService;
import com.gofashion.gofashionspringcloudordersorder.service.redisservice.RedisSaveService;
import com.gofashion.gofashionspringcloudordersorder.uilt.dateulit.FormatDateTime;
import com.gofashion.gofashionspringcloudordersorder.uilt.redisulit.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GofashionSpringCloudOrdersOrderApplicationTests {
    @Resource
    private RedisUtil redisUtil;
    @Resource
    private SplitDataService splitDataService;
    @Resource
    private RedisSaveService redisSaveService;
    @Resource
    private FormatDateTime formatDateTime;
    @Resource
    private RedisFetchOrRemoveService redisRemoveService;
    @Test
    public void contextLoads() {
//
//        String s = splitDataService.splitTake(null);
//        String save = redisSaveService.save(s);
//        System.out.println(save.length());
//        String substring = save.substring(7);
//        System.out.println(substring);System.out.println(save);
//
//        long l = Long.parseLong(substring);
//
//        long l1 = System.currentTimeMillis();
//
//        try {
//            Thread.sleep(4*1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//
//        if((l1-l) < 3*1000){
//            String fetch = redisFetchService.fetch(Long.parseLong(substring));
//            System.out.println(fetch);
//        }
//        1541764372522
//        redisRemoveService.remove(Long.parseLong("1541764372522"));
        System.out.println("删除了么？？？？？？？？？？？？？？？？？？？？？？？？？");

    }

}
