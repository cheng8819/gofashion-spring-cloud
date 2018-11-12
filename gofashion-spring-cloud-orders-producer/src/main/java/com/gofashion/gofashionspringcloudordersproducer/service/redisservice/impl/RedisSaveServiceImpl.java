package com.gofashion.gofashionspringcloudordersproducer.service.redisservice.impl;

import com.alibaba.fastjson.JSON;
import com.gofashion.gofashionspringcloudordersproducer.service.redisservice.RedisSaveService;
import com.gofashion.gofashionspringcloudordersproducer.service.vo.LogisticsEntity;
import com.gofashion.gofashionspringcloudordersproducer.service.vo.RedisTimeEntity;
import com.gofashion.gofashionspringcloudordersproducer.uilt.ergodiclist.Ergodic;
import com.gofashion.gofashionspringcloudordersproducer.uilt.redisulit.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 保存redis
 */
@Service
public class RedisSaveServiceImpl implements RedisSaveService {
    public static final String ORDERS_ORDER = "ORDERS_ORDER";
    public static final String ORDERS_USER = "ORDERS_USER";
    public static final String ORDERS_TIME = "ORDERS_TIME";
    @Resource
    private RedisUtil redisUtil;
    public RedisUtil getRedisUtil() { return redisUtil; }
    public void setRedisUtil(RedisUtil redisUtil) { this.redisUtil = redisUtil; }

    @Override
    public Boolean save(String take) {
        List<LogisticsEntity> logisticsEntityList = JSON.parseArray(take, LogisticsEntity.class);
        List<String> numberlist = new ArrayList<>();
        List<String> useridList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < logisticsEntityList.size(); i++) {
            LogisticsEntity logisticsEntity = logisticsEntityList.get(i);
            String information_orderNumber = logisticsEntity.getInformation_orderNumber();
            Integer logistics_userId = logisticsEntity.getLogistics_userId();
            numberlist.add(information_orderNumber);
            useridList.add(logistics_userId.toString());
            integerList.add(logisticsEntity.getGoods_takeStatus());
        }

        boolean hset = false;
        for (int i = 0; i < logisticsEntityList.size(); i++) {
            LogisticsEntity logisticsEntity = logisticsEntityList.get(i);
            hset = redisUtil.hset(ORDERS_ORDER, JSON.toJSONString(logisticsEntity.getInformation_orderNumber()), JSON.toJSONString(logisticsEntity));
        }
        System.out.println("hset-------------" + hset);
        //遍历键
        List<String> ergodic = Ergodic.ergodic(useridList);
        if(ergodic.size() != 1){
            return false;
        }
        boolean hset1 = redisUtil.hset(ORDERS_USER, useridList.get(0), JSON.toJSONString(numberlist));
        System.out.println("hset1---------------" + hset1);
        RedisTimeEntity redisTimeEntity = new RedisTimeEntity();
        Date date = new Date();
        List<String> redisTimeEntitylist = new ArrayList<>();
        redisTimeEntity.setTime(date);
        redisTimeEntity.setUserid(Integer.parseInt(useridList.get(0)));
        redisTimeEntity.setOrderNumber(numberlist);
        redisTimeEntity.setType(integerList.get(0));
        redisTimeEntitylist.add(JSON.toJSONString(redisTimeEntity));
        boolean hset2 = redisUtil.lSet(ORDERS_TIME, JSON.toJSONString(redisTimeEntitylist));
        System.out.println("hset2-----------------" + hset2);
        if(hset && hset1 && hset2){
            return true;
        }
        return false;
    }
}
