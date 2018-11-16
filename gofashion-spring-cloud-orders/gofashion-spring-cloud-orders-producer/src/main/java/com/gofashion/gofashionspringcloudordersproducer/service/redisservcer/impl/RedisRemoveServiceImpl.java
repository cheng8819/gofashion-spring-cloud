package com.gofashion.gofashionspringcloudordersproducer.service.redisservcer.impl;

import com.alibaba.fastjson.JSON;
import com.gofashion.gofashionspringcloudordersproducer.service.common.AddDateService;
import com.gofashion.gofashionspringcloudordersproducer.service.redisservcer.RedisRemoveService;
import com.gofashion.gofashionspringcloudordersproducer.service.vo.RedisOrderEntity;
import com.gofashion.gofashionspringcloudordersproducer.uilt.redisulit.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class RedisRemoveServiceImpl implements RedisRemoveService {
    @Resource
    private RedisUtil redisUtil;
    public RedisUtil getRedisUtil() { return redisUtil; }
    public void setRedisUtil(RedisUtil redisUtil) { this.redisUtil = redisUtil; }

    @Resource
    private AddDateService addDateService;
    public AddDateService getAddDateService() { return addDateService; }
    public void setAddDateService(AddDateService addDateService) { this.addDateService = addDateService; }

    @Override
    public Boolean redisremove(String removedate) {
        //删除redis操作
        List<RedisOrderEntity> redisOrderEntityList = JSON.parseArray(removedate, RedisOrderEntity.class);
        Integer information_userId = redisOrderEntityList.get(0).getInformation_userId();

        Boolean or = false;

        Map<Object, Object> hmget = redisUtil.hmget(RedisSaveServiceImpl.OREDRS_USERID);

        List<RedisOrderEntity> redisOrderEntityList1 = (List<RedisOrderEntity>) hmget.get(information_userId);
        if(redisOrderEntityList1 == null){
            or = false;
        }
        for (RedisOrderEntity redisOrderEntity : redisOrderEntityList) {
            for (int i = 0; i < redisOrderEntityList1.size(); i++) {
                RedisOrderEntity redisOrderEntity1 = redisOrderEntityList1.get(i);
                if((redisOrderEntity.getInformation_orderNumber()).equals(redisOrderEntity1.getInformation_orderNumber())){
                    RedisOrderEntity remove = redisOrderEntityList1.remove(i);
                    or = true;
                }
            }
        }
        return or;
    }
}
