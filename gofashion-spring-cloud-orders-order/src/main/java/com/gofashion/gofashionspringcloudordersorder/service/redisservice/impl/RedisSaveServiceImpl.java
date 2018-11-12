package com.gofashion.gofashionspringcloudordersorder.service.redisservice.impl;

import com.alibaba.fastjson.JSON;
import com.gofashion.gofashionspringcloudordersorder.entity.GoodsOrder;
import com.gofashion.gofashionspringcloudordersorder.service.redisservice.RedisSaveService;
import com.gofashion.gofashionspringcloudordersorder.service.vo.LogisticsEntity;
import com.gofashion.gofashionspringcloudordersorder.uilt.ergodiclist.Ergodic;
import com.gofashion.gofashionspringcloudordersorder.uilt.redisulit.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String save(String take) {
        List<LogisticsEntity> logisticsEntityList = JSON.parseArray(take, LogisticsEntity.class);
        List<String> numberlist = new ArrayList<>();
        List<String> useridList = new ArrayList<>();

        for (int i = 0; i < logisticsEntityList.size(); i++) {
            LogisticsEntity logisticsEntity = logisticsEntityList.get(i);
            String information_orderNumber = logisticsEntity.getInformation_orderNumber();
            Integer logistics_userId = logisticsEntity.getLogistics_userId();
            numberlist.add(information_orderNumber);
            useridList.add(logistics_userId.toString());
        }

        boolean hset = false;
        for (int i = 0; i < logisticsEntityList.size(); i++) {
            LogisticsEntity logisticsEntity = logisticsEntityList.get(i);
            hset = redisUtil.hset(ORDERS_ORDER, logisticsEntity.getInformation_orderNumber(), JSON.toJSONString(logisticsEntity));
        }

        //遍历键
        List<String> ergodic = Ergodic.ergodic(useridList);
        if(ergodic.size() != 1){
            return "用户id不一致";
        }
        String userid = "";
        boolean hset1 = false;
        for (String s : ergodic) {
            userid = s;
            hset1 = redisUtil.hset(ORDERS_USER, s, JSON.toJSONString(numberlist));
            break;
        }

        List<Map<String,Object>> list = new ArrayList<>();
        for (int i = 0; i < numberlist.size(); i++) {
            Map<String,Object> mapList = new HashMap<>();
            mapList.put("ordernumber",numberlist.get(i));
            mapList.put("userid",userid);
            list.add(mapList);
        }
        Long l = System.currentTimeMillis();
        String string = l.toString();
        boolean hset2 = redisUtil.hset(ORDERS_TIME,string, list);
        if(hset && hset1 && hset2){
            return "添加数据库成功" + string;
        }
        return "添加数据库失败";
    }
}
