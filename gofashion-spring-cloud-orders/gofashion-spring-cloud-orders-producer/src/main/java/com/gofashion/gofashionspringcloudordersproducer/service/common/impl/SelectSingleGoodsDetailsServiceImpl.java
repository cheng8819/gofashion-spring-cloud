package com.gofashion.gofashionspringcloudordersproducer.service.common.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gofashion.gofashionspringcloudordersproducer.dao.GoodsOrderMapper;
import com.gofashion.gofashionspringcloudordersproducer.dao.LogisticsMapper;
import com.gofashion.gofashionspringcloudordersproducer.dao.OrderInformationMapper;
import com.gofashion.gofashionspringcloudordersproducer.entity.GoodsOrder;
import com.gofashion.gofashionspringcloudordersproducer.entity.Logistics;
import com.gofashion.gofashionspringcloudordersproducer.entity.OrderInformation;
import com.gofashion.gofashionspringcloudordersproducer.service.common.SelectSingleGoodsDetailsService;
import com.gofashion.gofashionspringcloudordersproducer.service.redisservcer.impl.RedisSaveServiceImpl;
import com.gofashion.gofashionspringcloudordersproducer.service.vo.RedisOrderEntity;
import com.gofashion.gofashionspringcloudordersproducer.uilt.redisulit.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class SelectSingleGoodsDetailsServiceImpl implements SelectSingleGoodsDetailsService {
    @Resource
    private GoodsOrderMapper goodsOrderMapper;
    public GoodsOrderMapper getGoodsOrderMapper() { return goodsOrderMapper; }
    public void setGoodsOrderMapper(GoodsOrderMapper goodsOrderMapper) { this.goodsOrderMapper = goodsOrderMapper; }
    @Resource
    private LogisticsMapper logisticsMapper;
    public LogisticsMapper getLogisticsMapper() { return logisticsMapper; }
    public void setLogisticsMapper(LogisticsMapper logisticsMapper) { this.logisticsMapper = logisticsMapper; }
    @Resource
    private OrderInformationMapper orderInformationMapper;
    public OrderInformationMapper getOrderInformationMapper() { return orderInformationMapper; }
    public void setOrderInformationMapper(OrderInformationMapper orderInformationMapper) { this.orderInformationMapper = orderInformationMapper; }
    @Resource
    private RedisUtil redisUtil;
    public RedisUtil getRedisUtil() { return redisUtil; }
    public void setRedisUtil(RedisUtil redisUtil) { this.redisUtil = redisUtil; }

    /*
    * 查询 一条商品的订单详情
    *
    * 参数  用户id    订单标的id
    * */
    @Override
    public String selectSingleGoodsDetails(Integer information_userId,String information_orderNumber) {
//        String take = "{" +
//                "\"userid\": 1," +
//                "\"information_orderNumber\": 3" +
//                "}";
//        JSONObject jsonObject = JSON.parseObject(take);
//        Integer userid = (Integer) jsonObject.get("userid");
//        String information_orderNumber = (String) jsonObject.get("information_orderNumber");
        if(information_userId == null && information_orderNumber == null){
            return "400";
        }
        OrderInformation orderInformation = orderInformationMapper.selectinfoOrderNumberById(information_orderNumber,information_userId);
        List<RedisOrderEntity> redisOrderEntityList = null;

        if(orderInformation == null){
            Map<Object, Object> hmget = redisUtil.hmget(RedisSaveServiceImpl.OREDRS_USERID);
            redisOrderEntityList = (List<RedisOrderEntity>) hmget.get(information_userId);
            if(redisOrderEntityList == null){
                return "400";
            }else{
                for (RedisOrderEntity redisOrderEntity : redisOrderEntityList) {
                    if((redisOrderEntity.getInformation_orderNumber()).equals(information_orderNumber)){
                        return JSON.toJSONString(redisOrderEntity);
                    }
                }
            }
        }
        List<GoodsOrder> goodsOrderList = goodsOrderMapper.selectGoodsOrderByInformationID(orderInformation.getInformation_id());
        Logistics logistics = logisticsMapper.selectGetSingleByinformationID(orderInformation.getInformation_id());
        Integer logistics_status = logistics.getLogistics_status();

        OrderInformation orderInformation1 = null;

        if(logistics_status == 0){
            logistics.setLogistics_status(null);
            logistics.setLogistics_oddNumbers(null);
            logistics.setLogistics_DHL(null);
            logistics.setLogistics_deliverTime(null);
            orderInformation.setInformation_paymentTime(null);
            orderInformation1 = orderInformation;
            orderInformation1.setLogistics(logistics);
            orderInformation1.setGoodsOrderList(goodsOrderList);

            return JSON.toJSONString(orderInformation1);
        }
        orderInformation1 = orderInformation;
        orderInformation1.setLogistics(logistics);
        orderInformation1.setGoodsOrderList(goodsOrderList);
        return JSON.toJSONString(orderInformation1);
    }
}
