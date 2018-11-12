package com.gofashion.gofashionspringcloudordersorder.service.impl;

import com.alibaba.fastjson.JSON;
import com.gofashion.gofashionspringcloudordersorder.dao.GoodsOrderMapper;
import com.gofashion.gofashionspringcloudordersorder.dao.LogisticsMapper;
import com.gofashion.gofashionspringcloudordersorder.dao.OrderInformationMapper;
import com.gofashion.gofashionspringcloudordersorder.entity.GoodsOrder;
import com.gofashion.gofashionspringcloudordersorder.entity.Logistics;
import com.gofashion.gofashionspringcloudordersorder.entity.OrderInformation;
import com.gofashion.gofashionspringcloudordersorder.service.AdditionService;
import com.gofashion.gofashionspringcloudordersorder.service.vo.LogisticsEntity;
import com.gofashion.gofashionspringcloudordersorder.uilt.ergodiclist.Ergodic;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 添加数据
 */
@Service
public class AdditionServiceImpl implements AdditionService {
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

    /**
     * 商品id          goods_id
     * sku             goods_sku
     * 金额            goods_money
     * 数量            goods_quantity
     * 接受状态        goods_takeStatus
     * 收件人         logistics_recipients
     * 手机号         logistics_phone
     * 地址            logistics_address
     * 创建时间         information_foundTime
     * 解析后添加
     * 订单状态        goods_orderStatus
     * 订单编号         information_orderNumber
     * 支付宝交易号     information_deal
     * 付款时间        information_paymentTime   split data
     */


    @Override
    @Transactional(propagation = Propagation.REQUIRED , rollbackFor = Exception.class)
    public String addAllGoodsOrder(String take) {
/*         take = "{" +
                "\"goods_id\":\"1\"," +
                "\"goods_sku\":\"zbhsgvd\"," +
                "\"goods_money\":\"31\"," +
                "\"goods_quantity\":\"3\"," +
                "\"goods_orderStatus\":\"待付款\"," +
                "\"goods_takeStatus\":\"0\"," +
                "\"logistics_recipients\":\"张宝\"," +
                "\"logistics_phone\":\"1332\"," +
                "\"logistics_address\":\"小霸王hi百度\"," +
                "\"logistics_userId\":\"0\"," +
                "\"information_foundTime\":\"单位的去\"," +
                "\"information_orderNumber\":\"安慰芙蓉王\"," +
                "\"information_deal\":\"我的为人\"," +
                "\"information_paymentTime\":\"服务方她太\"," +
                "}";*/
        List<LogisticsEntity> logisticsEntityList = JSON.parseArray(take, LogisticsEntity.class);

        List<GoodsOrder> goodsOrderList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();   //订单编号
        for (int i = 0; i < logisticsEntityList.size(); i++) {
            LogisticsEntity logisticsEntity = logisticsEntityList.get(i);
            //商品
            GoodsOrder goodsOrder = new GoodsOrder();
            goodsOrder.setGoods_shopID(logisticsEntity.getGoods_shopID()); //店铺id
            goodsOrder.setGoods_id(logisticsEntity.getGoods_id());      //商品id
            goodsOrder.setGoods_sku(logisticsEntity.getGoods_sku());  //* sku
            goodsOrder.setGoods_money(logisticsEntity.getGoods_money());     //* 金额
            goodsOrder.setGoods_quantity(logisticsEntity.getGoods_quantity());   //* 数量
            goodsOrder.setGoods_orderStatus(3);       //订单状态   交易成功(0),交易关闭(1)待付款(3)待发货(4)待收货(5)待评价(6)
            goodsOrder.setGoods_takeStatus(logisticsEntity.getGoods_takeStatus());  //接受状态//（普通0、秒杀1、拼团2、闪购3、）
            goodsOrder.setGoods_estimate(logisticsEntity.getGoods_estimate());     // 评价*/
            goodsOrder.setGoods_a(logisticsEntity.getInformation_orderNumber());   // Goods_a暂定  订单编号
            goodsOrderList.add(goodsOrder);
            stringList.add(logisticsEntity.getInformation_orderNumber());
        }

        List<OrderInformation> orderInformationList = new ArrayList<>();
        List<Logistics> logisticsList = new ArrayList<>();
        //遍历键
        List<String> ergodic = Ergodic.ergodic(stringList);
        for (int i = 0; i < ergodic.size(); i++) {
            for (int j = 0; j < logisticsEntityList.size(); j++) {
                if((ergodic.get(i)).equals(logisticsEntityList.get(j).getInformation_orderNumber())){
                    /*
                    * 订单信息  和  物流  一对一          商品表多个
                    * */
                    LogisticsEntity logisticsEntity = logisticsEntityList.get(j);
                    //*订单信息*//*
                    OrderInformation orderInformation = new OrderInformation();
                    orderInformation.setInformation_orderNumber(logisticsEntity.getInformation_orderNumber());  //订单编号
                    orderInformation.setInformation_foundTime(logisticsEntity.getInformation_foundTime());   //创建时间
                    orderInformation.setInformation_deal(logisticsEntity.getInformation_deal());  //支付宝交易号
                    orderInformation.setInformation_paymentTime(logisticsEntity.getInformation_paymentTime()); //付款时间*
                    orderInformationList.add(orderInformation);
                    //*物流表*//*
                    Logistics logistics = new Logistics();
                    logistics.setLogistics_userId(logisticsEntity.getLogistics_userId()); //用户id
                    logistics.setLogistics_recipients(logisticsEntity.getLogistics_recipients());  //收件人
                    logistics.setLogistics_phone(logisticsEntity.getLogistics_phone());   //手机号
                    logistics.setLogistics_address(logisticsEntity.getLogistics_address());   //地址
                    logisticsList.add(logistics);
                }
            }
        }

        int count = 0;
        int a = 0,b = 0,c = 0;
        for (int i = 0; i < orderInformationList.size(); i++) {
            OrderInformation orderInformation = orderInformationList.get(i);
            int i1 = orderInformationMapper.insertOrderInformation(orderInformation);
            count = count + i1;
        }
        if(count == orderInformationList.size()){
            System.out.println("添加订单信息成功");
            a = 1;
        }

        count = 0;
        for (int i = 0; i < logisticsList.size(); i++) {
            OrderInformation orderInformation1 = orderInformationMapper.selectinformationOrderNumberById(orderInformationList.get(i).getInformation_orderNumber());
            Logistics logistics = logisticsList.get(i);
            logistics.setLogistics_informationID(orderInformation1.getInformation_id());
            int i1 = logisticsMapper.insertLogistics(logistics);
            count = count + i1;
        }
        if(count == logisticsList.size()){
            System.out.println("添加物流信息成功");
            b = 1;
        }

        count = 0;
        for (int i = 0; i < ergodic.size(); i++) {
            for (int j = 0; j < goodsOrderList.size(); j++) {
                if((ergodic.get(i)).equals(goodsOrderList.get(j).getGoods_a())){
                    OrderInformation orderInformation1 = orderInformationMapper.selectinformationOrderNumberById(goodsOrderList.get(j).getGoods_a());
                    GoodsOrder goodsOrder = goodsOrderList.get(j);
                    goodsOrder.setGoods_informationID(orderInformation1.getInformation_id());
                    int i1 = goodsOrderMapper.insertGoodsOrder(goodsOrder);
                    count = count + i1;
                }
            }
        }
        if(count == goodsOrderList.size()){
            System.out.println("添加商品信息成功");
            c = 1;
        }
        if(a == 1 && b == 1 && c == 1){
            return "成功";
        }
        return "失败";
    }



}
