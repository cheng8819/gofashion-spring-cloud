package com.gofashion.gofashionspringcloudordersproducer.service.common.impl;

import com.alibaba.fastjson.JSON;
import com.gofashion.gofashionspringcloudordersproducer.dao.GoodsOrderMapper;
import com.gofashion.gofashionspringcloudordersproducer.dao.OrderInformationMapper;
import com.gofashion.gofashionspringcloudordersproducer.entity.GoodsOrder;
import com.gofashion.gofashionspringcloudordersproducer.entity.OrderInformation;
import com.gofashion.gofashionspringcloudordersproducer.service.common.SelectAllGetByIdService;
import com.gofashion.gofashionspringcloudordersproducer.service.redisservcer.impl.RedisSaveServiceImpl;
import com.gofashion.gofashionspringcloudordersproducer.service.vo.RedisOrderEntity;
import com.gofashion.gofashionspringcloudordersproducer.uilt.redisulit.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *          返回状态   400   查询不到
 *          查询到   返回商品信息的数据
 */
@Service
public class SelectAllGetByIdServiceImpl implements SelectAllGetByIdService {
    @Resource
    private RedisUtil redisUtil;
    public RedisUtil getRedisUtil() { return redisUtil; }
    public void setRedisUtil(RedisUtil redisUtil) { this.redisUtil = redisUtil; }

    @Resource
    private GoodsOrderMapper goodsOrderMapper;
    public GoodsOrderMapper getGoodsOrderMapper() { return goodsOrderMapper; }
    public void setGoodsOrderMapper(GoodsOrderMapper goodsOrderMapper) { this.goodsOrderMapper = goodsOrderMapper; }

    @Resource
    private OrderInformationMapper orderInformationMapper;
    public OrderInformationMapper getOrderInformationMapper() { return orderInformationMapper; }
    public void setOrderInformationMapper(OrderInformationMapper orderInformationMapper) { this.orderInformationMapper = orderInformationMapper; }

    @Override
    public String selectGetAllById(Integer information_userId) {
//        String show = show();
//        OrderInformation orderInformation = JSON.parseObject(show, OrderInformation.class);
//        if(orderInformation == null){
//            return "400";
//        }
//        Integer information_userId = orderInformation.getInformation_userId();
        if (information_userId == null){
            return "400";
        }
        Map<Object, Object> hmget = redisUtil.hmget(RedisSaveServiceImpl.OREDRS_USERID);
        List<RedisOrderEntity> redisOrderEntityList = (List<RedisOrderEntity>) hmget.get(information_userId);
        //redisOrderEntityList       redis中用户的信息
        if(redisOrderEntityList == null){
            return "400";
        }

        List<OrderInformation> orderInformations = orderInformationMapper.selectOrderInformationById(information_userId);

        List<List<GoodsOrder>> goodsorderlists = new ArrayList<>();
        //goodsorderlists         数据库中的详情
        for (OrderInformation information : orderInformations) {
            List<GoodsOrder> goodsOrderList = goodsOrderMapper.selectGoodsOrderByInformationID(information.getInformation_id());
            goodsorderlists.add(goodsOrderList);
        }

        return JSON.toJSONString(goodsorderlists) + JSON.toJSONString(redisOrderEntityList);
    }

    public static void main(String[] args) {
        /*SelectAllGetByIdServiceImpl s = new SelectAllGetByIdServiceImpl();
        s.selectGetAllById(null);*/


        Map<String,Object> stringObjectMap = new HashMap<>();
        List<String> stringList = new ArrayList<>();
        stringList.add("AAAAAAAAAAAAA");
        stringObjectMap.put("1",stringList);
        List<String> a = (List<String>) stringObjectMap.get("A");
        System.out.println(a == null);
    }
    public String show(){
        OrderInformation o = new OrderInformation();
        o.setInformation_userId(0);
        return JSON.toJSONString(o);
    }
}
