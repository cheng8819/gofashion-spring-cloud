package com.gofashion.gofashionspringcloudordersproducer.service.redisservice.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gofashion.gofashionspringcloudordersproducer.service.redisservice.RedisFetchOrRemoveService;
import com.gofashion.gofashionspringcloudordersproducer.service.vo.LogisticsEntity;
import com.gofashion.gofashionspringcloudordersproducer.service.vo.RedisTimeEntity;
import com.gofashion.gofashionspringcloudordersproducer.uilt.redisulit.RedisUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 0 查询全部    1  删除
 * 根据时间戳   查询或删除
 */
@Service
public class RedisFetchOrRemoveServiceImpl implements RedisFetchOrRemoveService {
    @Resource
    private RedisUtil redisUtil;
    public RedisUtil getRedisUtil() { return redisUtil; }
    public void setRedisUtil(RedisUtil redisUtil) { this.redisUtil = redisUtil; }

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public String removeorfetch(long time, int state) {
        List<Object> timeList = redisUtil.lGet(RedisSaveServiceImpl.ORDERS_TIME, 0, 10);
        System.out.println(JSON.toJSONString(timeList));
        List<RedisTimeEntity> redisTimeEntityList = JSON.parseArray(timeList.toString(), RedisTimeEntity.class);
        System.out.println(redisTimeEntityList);
        for (RedisTimeEntity redisTimeEntity : redisTimeEntityList) {
            System.out.println(redisTimeEntity);
        }




        RedisTimeEntity redisTimeEntitys = new RedisTimeEntity();
        for (int i = 0; i < timeList.size(); i++) {
//            String string = JSON.toJSONString(timeList.get(i));
//            String substring = string.substring(1,string.length() - 1);
//            System.out.println(substring);
            System.out.println((timeList.get(i)).getClass());
            RedisTimeEntity redisTimeEntity = JSONObject.parseObject(timeList.get(i).toString(), (Type) RedisTimeEntity.class);

            System.out.println(redisTimeEntity);
//            Date time1 = redisTimeEntity.getTime();
//            System.out.println(time1);
//            Long time2 = time1.getTime() + time;
//            System.out.println(time2);
//
//            System.out.println(time2 + "------------------" + (new Date()).getTime());
//            if (time2.equals((new Date()).getTime())) {
//                System.out.println("BBBBBBBBBBB");
////                redisTimeEntitys = redisTimeEntity;
//            } else {
//                return "400";
//            }
        }
        System.out.println(redisTimeEntitys);
        System.out.println(redisTimeEntitys.getUserid());
        List<String> numberlist = (List<String>)redisUtil.hget(RedisSaveServiceImpl.ORDERS_USER, redisTimeEntitys.getUserid().toString());

        List<LogisticsEntity> logisticsEntityList = new ArrayList<>();
        for (int i = 0; i < numberlist.size(); i++) {
            String s = numberlist.get(i);
            LogisticsEntity logisticsEntity = JSON.parseObject(redisUtil.hget(RedisSaveServiceImpl.ORDERS_ORDER, s).toString(), LogisticsEntity.class);
            logisticsEntityList.add(logisticsEntity);
        }

        if (state == 0) {
            return JSON.toJSONString(logisticsEntityList);
        } else if (state == 1) {
            //删除
            RedisTimeEntity redisTimeEntity1 = null;
            for (int i = 0; i < timeList.size(); i++) {
                RedisTimeEntity redisTimeEntity = JSON.parseObject(timeList.get(i).toString(),RedisTimeEntity.class);
                Date time1 = redisTimeEntity.getTime();
                Long time2 = time1.getTime() + time;
                if (time2.equals((new Date()).getTime())) {
                    redisTimeEntity1 = redisTimeEntity;
                } else {
                    return "400";
                }
            }
            redisUtil.hdel(RedisSaveServiceImpl.ORDERS_TIME, redisTimeEntity1.getTime());
            redisUtil.hdel(RedisSaveServiceImpl.ORDERS_USER, redisTimeEntitys.getUserid());
            for (int i = 0; i < numberlist.size(); i++) {
                redisUtil.hdel(RedisSaveServiceImpl.ORDERS_ORDER, JSON.toJSONString(numberlist.get(i)));
            }
        } else {
            return "500";
        }
        return null;
    }
    /**
     * 获取list缓存的内容
     * @param key 键
     */
    public List<String> lGet(String key){
        try {
            return (List<String>) redisTemplate.opsForList().leftPop(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
