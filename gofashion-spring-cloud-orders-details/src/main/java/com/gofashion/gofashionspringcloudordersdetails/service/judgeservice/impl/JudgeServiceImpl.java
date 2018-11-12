package com.gofashion.gofashionspringcloudordersdetails.service.judgeservice.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gofashion.gofashionspringcloudordersdetails.service.judgeservice.JudgeService;
import com.gofashion.gofashionspringcloudordersdetails.uilt.redisulit.RedisUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class JudgeServiceImpl implements JudgeService {
    @Resource
    private RedisUtil redisUtil;
    public RedisUtil getRedisUtil() { return redisUtil; }
    public void setRedisUtil(RedisUtil redisUtil) { this.redisUtil = redisUtil; }
    @Resource
    private RedisTemplate redisTemplate;
    public RedisTemplate getRedisTemplate() { return redisTemplate; }
    public void setRedisTemplate(RedisTemplate redisTemplate) { this.redisTemplate = redisTemplate; }

    @Override
    public Boolean ifTime(String take,Long time) {
        JSONObject jsonObject = JSON.parseObject(take);
        String orders_userId = (String) jsonObject.get("orders_userId");
        redisTemplate.opsForValue().set(orders_userId,take);
        Long l = System.currentTimeMillis();
        Long ls = l + time;
        return redisUtil.expire(orders_userId,ls);
    }
}
