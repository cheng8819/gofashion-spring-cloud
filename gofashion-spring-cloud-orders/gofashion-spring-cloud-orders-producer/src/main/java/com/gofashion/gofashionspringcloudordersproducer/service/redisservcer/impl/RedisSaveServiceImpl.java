package com.gofashion.gofashionspringcloudordersproducer.service.redisservcer.impl;

import com.alibaba.fastjson.JSON;
import com.gofashion.gofashionspringcloudordersproducer.service.redisservcer.RedisSaveService;
import com.gofashion.gofashionspringcloudordersproducer.service.vo.RedisOrderEntity;
import com.gofashion.gofashionspringcloudordersproducer.uilt.redisulit.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 *
 */
@Service
public class RedisSaveServiceImpl implements RedisSaveService {
    public static final String OREDRS_USERID = "OREDRS_USERID";
    @Resource
    private RedisUtil redisUtil;
    @Override
    public Boolean redisSave(String savedate) {
        List<RedisOrderEntity> redisOrderEntityList = JSON.parseArray(savedate, RedisOrderEntity.class);
        Integer information_userId = redisOrderEntityList.get(0).getInformation_userId();
        Map<Object, Object> hmget = redisUtil.hmget(OREDRS_USERID);
        Iterator<Object> iterator = hmget.keySet().iterator();
        Map<String,Object> stringObjectMap = new HashMap<>();
        boolean hmset = false;
        while (iterator.hasNext()){
            String next = (String) iterator.next();
            if(Integer.parseInt(next) == information_userId){
                List<RedisOrderEntity> redisOrderEntityList2 = (List<RedisOrderEntity>) hmget.get(next);
                for (RedisOrderEntity redisOrderEntity : redisOrderEntityList) {
                    redisOrderEntityList2.add(redisOrderEntity);
                }
                stringObjectMap.put(information_userId.toString(),redisOrderEntityList2);
                return redisUtil.hmset(OREDRS_USERID, stringObjectMap);
            }else{

                List<RedisOrderEntity> redisOrderEntityList1 = new ArrayList<>();
                for (RedisOrderEntity redisOrderEntity : redisOrderEntityList) {
                    redisOrderEntityList1.add(redisOrderEntity);
                }
                stringObjectMap.put(information_userId.toString(),redisOrderEntityList1);
                return redisUtil.hmset(OREDRS_USERID, stringObjectMap);
            }

        }
        return hmset;
    }
}
