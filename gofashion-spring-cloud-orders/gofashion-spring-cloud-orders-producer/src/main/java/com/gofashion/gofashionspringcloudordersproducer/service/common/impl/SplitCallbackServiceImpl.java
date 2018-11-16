package com.gofashion.gofashionspringcloudordersproducer.service.common.impl;

import com.alibaba.fastjson.JSON;
import com.gofashion.gofashionspringcloudordersproducer.entity.GoodsOrder;
import com.gofashion.gofashionspringcloudordersproducer.service.common.SplitCallbackService;
import com.gofashion.gofashionspringcloudordersproducer.service.vo.RedisOrderEntity;
import com.gofashion.gofashionspringcloudordersproducer.service.vo.SendxiaopengEntity;
import com.gofashion.gofashionspringcloudordersproducer.uilt.ergodiclist.Ergodic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 返回小鹏数据
 */
@Service
public class SplitCallbackServiceImpl implements SplitCallbackService {
    @Override
    public String callback(String senddate) {
        List<RedisOrderEntity> redisOrderEntityList = JSON.parseArray(senddate, RedisOrderEntity.class);

        List<SendxiaopengEntity> sendxiaopengEntities = new ArrayList<>();
        for (RedisOrderEntity redisOrderEntity : redisOrderEntityList) {
            List<GoodsOrder> goodsOrderList = redisOrderEntity.getGoodsOrderList();
            for (GoodsOrder goodsOrder : goodsOrderList) {
                SendxiaopengEntity sendxiaopengEntity = new SendxiaopengEntity();
                sendxiaopengEntity.setGoods_sku(goodsOrder.getGoods_sku());
                sendxiaopengEntity.setGoods_quantity(goodsOrder.getGoods_quantity());
                sendxiaopengEntities.add(sendxiaopengEntity);
            }
        }
//        System.out.println(JSON.toJSONString(sendxiaopengEntities));
        return JSON.toJSONString(sendxiaopengEntities);
    }
}
