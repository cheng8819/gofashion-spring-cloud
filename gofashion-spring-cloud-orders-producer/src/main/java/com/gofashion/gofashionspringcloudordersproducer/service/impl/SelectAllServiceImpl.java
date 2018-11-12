package com.gofashion.gofashionspringcloudordersproducer.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gofashion.gofashionspringcloudordersproducer.dao.GoodsOrderMapper;
import com.gofashion.gofashionspringcloudordersproducer.dao.LogisticsMapper;
import com.gofashion.gofashionspringcloudordersproducer.entity.GoodsOrder;
import com.gofashion.gofashionspringcloudordersproducer.entity.Logistics;
import com.gofashion.gofashionspringcloudordersproducer.service.SelectAllService;
import com.gofashion.gofashionspringcloudordersproducer.uilt.redisulit.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SelectAllServiceImpl implements SelectAllService {
    @Resource
    private RedisUtil redisUtil;
    public RedisUtil getRedisUtil() { return redisUtil; }
    public void setRedisUtil(RedisUtil redisUtil) { this.redisUtil = redisUtil; }

    @Resource
    private LogisticsMapper logisticsMapper;
    public LogisticsMapper getLogisticsMapper() { return logisticsMapper; }
    public void setLogisticsMapper(LogisticsMapper logisticsMapper) { this.logisticsMapper = logisticsMapper; }
    @Resource
    private GoodsOrderMapper goodsOrderMapper;
    public GoodsOrderMapper getGoodsOrderMapper() { return goodsOrderMapper; }
    public void setGoodsOrderMapper(GoodsOrderMapper goodsOrderMapper) { this.goodsOrderMapper = goodsOrderMapper; }

    @Override
    public String selectAllGoodsOrder(String take) {
        take = "{" +
                "\"logistics_userId\":\"0\"" +
                "}";
        JSONObject jsonObject = JSON.parseObject(take);
        String logistics_userId1 = (String) jsonObject.get("logistics_userId");
        List<Logistics> logistics_userId = logisticsMapper.selectInformationIDById(Integer.parseInt(logistics_userId1));
        List<List<GoodsOrder>> reslutgoodslist = new ArrayList<>();
        for (int i = 0; i < logistics_userId.size(); i++) {
            Integer logistics_informationID = (logistics_userId.get(i)).getLogistics_informationID();
            List<GoodsOrder> goodsOrderList = goodsOrderMapper.selectAllById(logistics_informationID);
            reslutgoodslist.add(goodsOrderList);
        }
        List<GoodsOrder> goodsOrderLists = new ArrayList<>();
        for (List<GoodsOrder> goodsOrderList : reslutgoodslist) {
            for (GoodsOrder goodsOrder : goodsOrderList) {
                goodsOrderLists.add(goodsOrder);
            }
        }
        //如果缓存内 有存储  调出存储的
        if(redisUtil.hasKey(logistics_userId1)){
            JSONArray o = (JSONArray) redisUtil.get(logistics_userId1);
            return JSON.toJSONString(goodsOrderLists) + JSON.toJSONString(o);

        }
        //没有直接返回
        return JSON.toJSONString(goodsOrderLists);
    }

    public static void main(String[] args) {
        SelectAllServiceImpl selectAllService = new SelectAllServiceImpl();
        selectAllService.show();
    }


    public void  show(){
        String set = "[{\"goods_a\":\"20181164003323847\",\"goods_id\":1,\"goods_money\":1.0,\"goods_orderStatus\":3,\"goods_quantity\":1,\"goods_shopID\":\"1\",\"goods_sku\":\"1\",\"goods_takeStatus\":0},\n" +
                "    {\"goods_a\":\"20181164003324557\",\"goods_id\":2,\"goods_money\":2.0,\"goods_orderStatus\":3,\"goods_quantity\":2,\"goods_shopID\":\"2\",\"goods_sku\":\"2\",\"goods_takeStatus\":0}]";
        JSONArray jsonArray = JSONArray.parseArray(set);
        System.out.println(jsonArray);
    }
}
