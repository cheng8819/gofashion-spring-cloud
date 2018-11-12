package com.gofashion.gofashionspringcloudordersproducer;

import com.alibaba.fastjson.JSON;
import com.gofashion.gofashionspringcloudordersproducer.service.redisservice.impl.RedisSaveServiceImpl;
import com.gofashion.gofashionspringcloudordersproducer.service.vo.RedisTimeEntity;
import com.gofashion.gofashionspringcloudordersproducer.uilt.redisulit.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import zipkin.reporter.Sender;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GofashionSpringCloudOrdersProducerApplicationTests {
    @Resource
    private RedisUtil redisUtil;
    @Resource
    private RedisTemplate redisTemplate;
    @Test
    public void contextLoads() {
        List<String> redisTimeEntityList = new ArrayList<>();
        RedisTimeEntity redisTimeEntity = new RedisTimeEntity();
        RedisTimeEntity redisTimeEntity1 = new RedisTimeEntity();
        RedisTimeEntity redisTimeEntity2 = new RedisTimeEntity();
        redisTimeEntityList.add(redisTimeEntity.toString());
        redisTimeEntityList.add(redisTimeEntity1.toString());
        redisTimeEntityList.add(redisTimeEntity2.toString());
//        redisUtil.lSet("ORDERS_TIME",redisTimeEntityList.toString());
        Long orders_time1 = redisTemplate.opsForList().leftPush(RedisSaveServiceImpl.ORDERS_TIME,null);
        System.out.println(orders_time1);
       /* List<String> orders_time = (List<String>) redisTemplate.opsForList().rightPop("ORDERS_TIME");
        for (String s : orders_time) {
            System.out.println(s);
        }*/
        System.out.println("1111111111111");


/*
        List<String> list1=new ArrayList<String>();
        list1.add("a1");
        list1.add("a2");
        list1.add("a3");

        List<String> list2=new ArrayList<String>();
        list2.add("b1");
        list2.add("b2");
        list2.add("b3");
        redisTemplate.opsForList().leftPush("listkey1",list1);
        redisTemplate.opsForList().rightPush("listkey2",list2);

        List<String> resultList1=(List<String>)redisTemplate.opsForList().leftPop("listkey1");
        List<String> resultList2=(List<String>)redisTemplate.opsForList().rightPop("listkey2");
        System.out.println("resultList1:"+resultList1);
        System.out.println("resultList2:"+resultList2);*/
    }

}
