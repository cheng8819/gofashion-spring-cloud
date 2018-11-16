package com.gofashion.gofashionspringcloudordersproducer.service.common.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gofashion.gofashionspringcloudordersproducer.dao.GoodsOrderMapper;
import com.gofashion.gofashionspringcloudordersproducer.dao.OrderInformationMapper;
import com.gofashion.gofashionspringcloudordersproducer.entity.GoodsOrder;
import com.gofashion.gofashionspringcloudordersproducer.entity.OrderInformation;
import com.gofashion.gofashionspringcloudordersproducer.service.common.RemoveOrderService;
import com.gofashion.gofashionspringcloudordersproducer.service.vo.OrderReceptionEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class RemoveOrderServiceImpl implements RemoveOrderService {
    @Resource
    private GoodsOrderMapper goodsOrderMapper;
    public GoodsOrderMapper getGoodsOrderMapper() { return goodsOrderMapper; }
    public void setGoodsOrderMapper(GoodsOrderMapper goodsOrderMapper) { this.goodsOrderMapper = goodsOrderMapper; }
    @Resource
    private OrderInformationMapper orderInformationMapper;
    public OrderInformationMapper getOrderInformationMapper() { return orderInformationMapper; }
    public void setOrderInformationMapper(OrderInformationMapper orderInformationMapper) { this.orderInformationMapper = orderInformationMapper; }

    /**
     * 删除订单
     * @param
     * @return
     */
    @Override
    public Boolean removeorder(Integer information_userId,Integer goods_informationID) {
//        String take = "{" +
//                "\"userid\": 1," +
//                "\"orderid\": 3" +
//                "}";
//        JSONObject jsonObject = JSON.parseObject(take);
//        Integer userid = (Integer) jsonObject.get("userid");
//        Integer orderid = (Integer) jsonObject.get("orderid");
        if(information_userId == null && goods_informationID == null){
            return false;
        }
        List<OrderInformation> orderInformations = orderInformationMapper.selectOrderInformationById(information_userId);
        Boolean reslut = false;
        for (OrderInformation orderInformation : orderInformations) {
            List<GoodsOrder> goodsOrderList = goodsOrderMapper.selectGoodsOrderByInformationID(orderInformation.getInformation_id());
            for (GoodsOrder goodsOrder : goodsOrderList) {
                if(goods_informationID == goodsOrder.getGoods_id()){
                    int i = goodsOrderMapper.updateOneOrderDate(goods_informationID);
                    if(i == 0){
                        return reslut;
                    }
                }
            }
        }
        return true;
    }
}
