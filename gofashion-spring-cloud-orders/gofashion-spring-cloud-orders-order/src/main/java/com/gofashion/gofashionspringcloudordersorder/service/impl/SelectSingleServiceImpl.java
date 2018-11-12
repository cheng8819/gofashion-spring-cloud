package com.gofashion.gofashionspringcloudordersorder.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gofashion.gofashionspringcloudordersorder.dao.GoodsOrderMapper;
import com.gofashion.gofashionspringcloudordersorder.dao.LogisticsMapper;
import com.gofashion.gofashionspringcloudordersorder.dao.OrderInformationMapper;
import com.gofashion.gofashionspringcloudordersorder.entity.GoodsOrder;
import com.gofashion.gofashionspringcloudordersorder.entity.Logistics;
import com.gofashion.gofashionspringcloudordersorder.service.SelectSingleService;
import com.gofashion.gofashionspringcloudordersorder.uilt.expressulit.KdniaoTrackQueryAPI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 查询单条信息
 */
@Service
public class SelectSingleServiceImpl implements SelectSingleService {
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
    public String selectsingle(String take) {
        take = "{" +
                "\"goods_orderID\":\"1\"," +
                "}";
        JSONObject jsonObject = JSON.parseObject(take);
        String goods_orderID = (String) jsonObject.get("goods_orderID");


        GoodsOrder goodsOrder = goodsOrderMapper.selectInfoByorderID(Integer.parseInt(goods_orderID));
        Logistics logistics = logisticsMapper.selectInfoByInformationID(goodsOrder.getGoods_informationID());
        LogisticsMapper logisticsMapper = orderInformationMapper.selectInfoByInformationId(goodsOrder.getGoods_informationID());

        KdniaoTrackQueryAPI kdniaoTrackQueryAPI = new KdniaoTrackQueryAPI();
        String result = "";
        try {
            result = kdniaoTrackQueryAPI.getOrderTracesByJson(logistics.getLogistics_DHL(), logistics.getLogistics_oddNumbers().toString());
//            result = kdniaoTrackQueryAPI.getOrderTracesByJson("ZTO", "75105109223766");
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject jsonObject1 = JSON.parseObject(result);
        JSONArray traces = (JSONArray) jsonObject1.get("Traces");
//        jsonObject1.get("LogisticCode");
//        Integer state = (Integer) jsonObject1.get("State");
        /*订单状态    交易成功(0),交易关闭(1) 待付款(3) 待发货(4) 待收货(5)  待评价(6)*/
//        String status = "";
//        if(state == 2){
//            status = "待发货";
//        }
//        if(state == 3){
//            status = "已签收";
//        }
//        if(state == 4){
//            status = "问题件";
//        }
        return JSON.toJSONString(goodsOrder.toString() + logistics.toString() + logisticsMapper.toString() + traces);
    }


    public static void main(String[] args) {
        SelectSingleServiceImpl s = new SelectSingleServiceImpl();
        s.selectsingle(null);
    }
}
