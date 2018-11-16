package com.gofashion.gofashionspringcloudordersproducer.service.common.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gofashion.gofashionspringcloudordersproducer.dao.GoodsOrderMapper;
import com.gofashion.gofashionspringcloudordersproducer.dao.LogisticsMapper;
import com.gofashion.gofashionspringcloudordersproducer.dao.OrderInformationMapper;
import com.gofashion.gofashionspringcloudordersproducer.entity.GoodsOrder;
import com.gofashion.gofashionspringcloudordersproducer.entity.OrderInformation;
import com.gofashion.gofashionspringcloudordersproducer.service.common.SelectStateService;
import com.gofashion.gofashionspringcloudordersproducer.service.redisservcer.RedisGetByUserIdService;
import org.springframework.stereotype.Service;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class SelectStateServiceImpl implements SelectStateService {
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
    private RedisGetByUserIdService redisGetByUserIdService;
    public RedisGetByUserIdService getRedisGetByUserIdService() { return redisGetByUserIdService; }
    public void setRedisGetByUserIdService(RedisGetByUserIdService redisGetByUserIdService) { this.redisGetByUserIdService = redisGetByUserIdService; }

    /**
     * 根据状态查询
     * @param information_userId
     * @param state
     * @return
     */
    @Override
    public String selectStatus(Integer information_userId, Integer state) {
        //String take, Integer state
        /*订单状态    交易成功(0),交易关闭(1) 待付款(3) 待发货(4) 待收货(5)  待评价(6)*/
//        String take1 = "{" +
//                "\"logistics_userId\":\"0\"" +
//                "}";
//        JSONObject jsonObject = JSON.parseObject(take1);
//        String logistics_userId = (String) jsonObject.get("logistics_userId");

        if (state == 3){   //待付款
            String getbyuserid = redisGetByUserIdService.getbyuserid(information_userId);
            return getbyuserid;
        }

        List<OrderInformation> orderInformations = orderInformationMapper.selectOrderInformationById(information_userId);
        List<List<GoodsOrder>> listList = new ArrayList<>();
        for (OrderInformation orderInformation : orderInformations) {
            Integer information_id = orderInformation.getInformation_id();
            List<GoodsOrder> goodsOrderList = goodsOrderMapper.selectGoodsStateByInformationID(state, information_id);
            listList.add(goodsOrderList);
        }
        return JSON.toJSONString(listList);
    }
}
