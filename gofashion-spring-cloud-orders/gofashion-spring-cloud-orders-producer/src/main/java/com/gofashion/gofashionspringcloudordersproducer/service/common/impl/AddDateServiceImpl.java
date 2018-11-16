package com.gofashion.gofashionspringcloudordersproducer.service.common.impl;

import com.alibaba.fastjson.JSON;
import com.gofashion.gofashionspringcloudordersproducer.dao.GoodsOrderMapper;
import com.gofashion.gofashionspringcloudordersproducer.dao.LogisticsMapper;
import com.gofashion.gofashionspringcloudordersproducer.dao.OrderInformationMapper;
import com.gofashion.gofashionspringcloudordersproducer.entity.GoodsOrder;
import com.gofashion.gofashionspringcloudordersproducer.entity.Logistics;
import com.gofashion.gofashionspringcloudordersproducer.entity.OrderInformation;
import com.gofashion.gofashionspringcloudordersproducer.service.common.AddDateService;
import com.gofashion.gofashionspringcloudordersproducer.service.vo.RedisOrderEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class AddDateServiceImpl implements AddDateService {
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
    /*  private String information_deal;             //支付宝交易号
       private Date information_paymentTime;       //付款时间
       private String information_orderNumber;     //提交支付的编号****/

    /**
     *  添加数据库
     * @param date
     * @param state   0 普通待发货   1 取消订单  交易关闭
     * @param information_deal
     * @param information_paymentTime
     * @return
     */
    @Override
    public Boolean adddate(String date,int state,String information_deal,Date information_paymentTime) {
        List<RedisOrderEntity> redisOrderEntityList = JSON.parseArray(date, RedisOrderEntity.class);
        for (RedisOrderEntity redisOrderEntity : redisOrderEntityList) {
            //订单信息
            OrderInformation orderInformation = new OrderInformation();
            orderInformation.setInformation_orderNumber(redisOrderEntity.getInformation_orderNumber());
            orderInformation.setInformation_foundTime(redisOrderEntity.getInformation_foundTime());  //创建时间
            orderInformation.setInformation_userId(redisOrderEntity.getInformation_userId());
            orderInformation.setInformation_deal(information_deal); //支付宝交易号
            orderInformation.setInformation_paymentTime(information_paymentTime);  //付款时间
            int i = orderInformationMapper.insertOrderInformation(orderInformation);
            if(i != 1){
                return false;
            }
        }
        for (RedisOrderEntity redisOrderEntity : redisOrderEntityList) {
            OrderInformation orderInformation1 = orderInformationMapper.selectinformationOrderNumberById(redisOrderEntity.getInformation_orderNumber());
            if((orderInformation1.getInformation_orderNumber()).equals(redisOrderEntity.getInformation_orderNumber())){
                Logistics logistics = redisOrderEntity.getLogistics();
                logistics.setLogistics_informationID(orderInformation1.getInformation_id());
                int i = logisticsMapper.insertLogistics(logistics);
                if(i != 1){
                    return false;
                }
                List<GoodsOrder> goodsOrderList = redisOrderEntity.getGoodsOrderList();
                for (GoodsOrder goodsOrder : goodsOrderList) {
                    goodsOrder.setGoods_informationID(orderInformation1.getInformation_id());
                    /*订单状态    交易成功(0),交易关闭(1) 待付款(3) 待发货(4) 待收货(5)  待评价(6)*/
                    if(state == 0){
                        goodsOrder.setGoods_orderStatus(4);
                    }else{
                        goodsOrder.setGoods_orderStatus(1);
                    }
                    int i1 = goodsOrderMapper.insertGoodsOrder(goodsOrder);
                    if(i != 1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
