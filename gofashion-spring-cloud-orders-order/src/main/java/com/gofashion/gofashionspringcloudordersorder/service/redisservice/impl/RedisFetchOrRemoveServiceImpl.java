package com.gofashion.gofashionspringcloudordersorder.service.redisservice.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.gofashion.gofashionspringcloudordersorder.service.redisservice.RedisFetchOrRemoveService;
import com.gofashion.gofashionspringcloudordersorder.service.vo.LogisticsEntity;
import com.gofashion.gofashionspringcloudordersorder.uilt.ergodiclist.Ergodic;
import com.gofashion.gofashionspringcloudordersorder.uilt.redisulit.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    @Override
    public String remove(long time,int state) {
        List<Map<String,Object>> mapList = (List<Map<String, Object>>) redisUtil.hget(RedisSaveServiceImpl.ORDERS_TIME, String.valueOf(time));

        List<String> stringList = new ArrayList<>();
        List<String> useridlist = new ArrayList<>();
        for (int i = 0; i < mapList.size(); i++) {
            String ordernumber = (String) mapList.get(i).get("ordernumber");
            String userid = (String) mapList.get(i).get("userid");
            stringList.add(ordernumber);
            useridlist.add(userid);
        }
        //遍历键
        List<String> ergodic = Ergodic.ergodic(useridlist);
        if(ergodic.size() != 1){
            return "错误";
        }
        List<String> parse = null;
        String id = "";
        for (String s : ergodic) {
            parse = (List<String>) JSONArray.parse(redisUtil.hget(RedisSaveServiceImpl.ORDERS_USER, s).toString());
            break;
        }
        
        
        List<LogisticsEntity> logisticsEntityList = new ArrayList<>();
        for (int i = 0; i < parse.size(); i++) {
            String s = parse.get(i);
            LogisticsEntity logisticsEntity = JSON.parseObject(redisUtil.hget(RedisSaveServiceImpl.ORDERS_ORDER, s).toString(), LogisticsEntity.class);
            logisticsEntityList.add(logisticsEntity);
        }

        if(state == 0){
            return JSON.toJSONString(logisticsEntityList);
        }else if(state == 1){
            //删除
            redisUtil.hdel(RedisSaveServiceImpl.ORDERS_TIME,String.valueOf(time));
            redisUtil.hdel(RedisSaveServiceImpl.ORDERS_USER,JSON.toJSONString(id));
            for (int i = 0; i < parse.size(); i++) {
                redisUtil.hdel(RedisSaveServiceImpl.ORDERS_ORDER,JSON.toJSONString(parse.get(i)));
            }
        }else {
            return "状态不符";
        }
        return "1";
    }
}
