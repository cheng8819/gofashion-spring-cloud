package com.gofashion.gofashionspringcloudordersorder.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.gofashion.gofashionspringcloudordersorder.dao.GoodsOrderMapper;
import com.gofashion.gofashionspringcloudordersorder.dao.LogisticsMapper;
import com.gofashion.gofashionspringcloudordersorder.dao.OrderInformationMapper;
import com.gofashion.gofashionspringcloudordersorder.entity.GoodsOrder;
import com.gofashion.gofashionspringcloudordersorder.entity.Logistics;
import com.gofashion.gofashionspringcloudordersorder.service.SelectStateService;
import com.gofashion.gofashionspringcloudordersorder.uilt.redisulit.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 *根据订单状态   查询
 */
@Service
public class SelectStateServiceImpl implements SelectStateService {
    @Resource
    private RedisUtil redisUtil;
    public RedisUtil getRedisUtil() { return redisUtil; }
    public void setRedisUtil(RedisUtil redisUtil) { this.redisUtil = redisUtil; }
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
    @Override
    public String selectStatus(String take,Integer state) {

        /*订单状态    交易成功(0),交易关闭(1) 待付款(3) 待发货(4) 待收货(5)  待评价(6)*/
        if(state == 3){
            return JSON.toJSONString(redisUtil.get("logistics_userId"));
        }else if (state == 4){
            return splitstate(take, state);
        }else if(state == 5){
            return splitstate(take, state);
        }else if(state == 6){
            return splitstate(take, state);
        }
        return "查询不存在";
    }



    private String splitstate(String take,Integer state){
        take = "{" +
                "\"logistics_userId\":\"0\"" +
                "}";
        JSONObject jsonObject = JSON.parseObject(take);
        String logistics_userId1 = (String) jsonObject.get("logistics_userId");
        List<Logistics> logistics_userId = logisticsMapper.selectInformationIDById(Integer.parseInt(logistics_userId1));
        List<List<GoodsOrder>> goodsorderls = new ArrayList<>();
        for (int i = 0; i < logistics_userId.size(); i++) {
            Integer logistics_informationID = (logistics_userId.get(i)).getLogistics_informationID();
            List<GoodsOrder> goodsOrderList = goodsOrderMapper.selectAllById(logistics_informationID);
            goodsorderls.add(goodsOrderList);
        }

        Page<GoodsOrder> takegoodsorder = new Page<>();
        for (List<GoodsOrder> goodsOrderList : goodsorderls) {
            for (GoodsOrder goodsOrder : goodsOrderList) {
                /*订单状态    交易成功(0),交易关闭(1) 待付款(3) 待发货(4) 待收货(5)  待评价(6)*/
                Integer goods_orderStatus = goodsOrder.getGoods_orderStatus();
                if(goods_orderStatus == state){
                    takegoodsorder.add(goodsOrder);
                }
            }
        }
        return JSON.toJSONString(takegoodsorder);
    }
}
