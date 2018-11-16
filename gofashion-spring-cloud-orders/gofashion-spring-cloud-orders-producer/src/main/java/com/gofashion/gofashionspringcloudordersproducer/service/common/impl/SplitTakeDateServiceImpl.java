package com.gofashion.gofashionspringcloudordersproducer.service.common.impl;

import com.alibaba.fastjson.JSON;
import com.gofashion.gofashionspringcloudordersproducer.entity.GoodsOrder;
import com.gofashion.gofashionspringcloudordersproducer.entity.Logistics;
import com.gofashion.gofashionspringcloudordersproducer.service.common.SplitTakeDateService;
import com.gofashion.gofashionspringcloudordersproducer.service.vo.OrderReceptionEntity;
import com.gofashion.gofashionspringcloudordersproducer.service.vo.RedisOrderEntity;
import com.gofashion.gofashionspringcloudordersproducer.uilt.ergodiclist.Ergodic;
import com.gofashion.gofashionspringcloudordersproducer.uilt.uuidulit.IDUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SplitTakeDateServiceImpl implements SplitTakeDateService {
    @Override
    public String splitdate(String take) {
        String show = show();
        OrderReceptionEntity orderReceptionEntity = JSON.parseObject(show, OrderReceptionEntity.class);
        List<GoodsOrder> goodsOrderList = orderReceptionEntity.getGoodsOrderList();

        List<String> stringList = new ArrayList<>(); // 收集店铺id
        Double money = 0.0;
        for (GoodsOrder goodsOrder : goodsOrderList) {
            money = money + (goodsOrder.getGoods_money() * goodsOrder.getGoods_quantity());
            stringList.add(goodsOrder.getGoods_shopID().toString());
        }
        List<String> ergodic = Ergodic.ergodic(stringList);  //店铺id  去重
        List<RedisOrderEntity> redisOrderEntityList = new ArrayList<>();//最大的集合
        for (int i = 0; i < ergodic.size(); i++) {
            String id = IDUtils.createID();
            RedisOrderEntity redisOrderEntity = new RedisOrderEntity();
            redisOrderEntity.setInformation_orderNumber(id);
            redisOrderEntity.setInformation_foundTime(orderReceptionEntity.getInformation_foundTime());   //创建时间
            redisOrderEntity.setInformation_userId(orderReceptionEntity.getInformation_userId());  //用户id

            Logistics logistics = new Logistics();
            logistics.setLogistics_recipients(orderReceptionEntity.getLogistics_recipients());
            logistics.setLogistics_phone(orderReceptionEntity.getLogistics_phone());
            logistics.setLogistics_address(orderReceptionEntity.getLogistics_address());
            redisOrderEntity.setLogistics(logistics);

            List<GoodsOrder> goodsOrderList1 = new ArrayList<>();
            for (GoodsOrder goodsOrder : goodsOrderList) {    //商品的集合
                if (Integer.parseInt(ergodic.get(i)) == goodsOrder.getGoods_shopID()) {
                    //goodsOrder.setGoods_a();  暂时存放订单编号
//                    goodsOrder.setGoods_a(id);
                    goodsOrder.setGoods_takeStatus(orderReceptionEntity.getGoods_takeStatus());
                    goodsOrderList1.add(goodsOrder);  //当前商品信息
                    redisOrderEntity.setGoodsOrderList(goodsOrderList1);
                }
            }
            redisOrderEntityList.add(redisOrderEntity);
        }
        System.out.println(JSON.toJSONString(redisOrderEntityList));
        //返回的是list的   RedisOrderEntity集合
        return JSON.toJSONString(redisOrderEntityList);
    }

    public static void main(String[] args) {
        SplitTakeDateServiceImpl s = new SplitTakeDateServiceImpl();
        s.splitdate(null);
    }
//        /*//商户订单号，商户网站订单系统中唯一订单号，必填
//        String out_trade_no = new String(request.getParameter("WIDout_trade_no").getBytes("ISO-8859-1"),"UTF-8");
//        //付款金额，必填
//        String total_amount = new String(request.getParameter("WIDtotal_amount").getBytes("ISO-8859-1"),"UTF-8");
//        //订单名称，必填
//        String subject = new String(request.getParameter("WIDsubject").getBytes("ISO-8859-1"),"UTF-8");
//        //商品描述，可空
//        String body = new String(request.getParameter("WIDbody").getBytes("ISO-8859-1"),"UTF-8");*/

    public String show(){
        OrderReceptionEntity orderReceptionEntity = new OrderReceptionEntity();
        List<GoodsOrder> goodsOrderList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            GoodsOrder goodsOrder = new GoodsOrder();
            goodsOrder.setGoods_shopID(1);//店铺id
            goodsOrder.setGoods_id(1);//商品id
            goodsOrder.setGoods_sku(1);//* sku
            goodsOrder.setGoods_money(3.0);//* 金额
            goodsOrder.setGoods_quantity(3);//* 数量
            goodsOrderList.add(goodsOrder);
        }
        for (int i = 0; i < 2; i++) {
            GoodsOrder goodsOrder1 = new GoodsOrder();
            goodsOrder1.setGoods_shopID(2);//店铺id
            goodsOrder1.setGoods_id(1);//商品id
            goodsOrder1.setGoods_sku(2);//* sku
            goodsOrder1.setGoods_money(3.0);//* 金额
            goodsOrder1.setGoods_quantity(3);//* 数量
            goodsOrderList.add(goodsOrder1);
        }
        orderReceptionEntity.setGoodsOrderList(goodsOrderList);
        orderReceptionEntity.setInformation_userId(1);
        orderReceptionEntity.setLogistics_recipients("zhang");
        orderReceptionEntity.setLogistics_phone("13663565840");
        orderReceptionEntity.setLogistics_address("太远");
        orderReceptionEntity.setGoods_takeStatus(0);
        orderReceptionEntity.setInformation_foundTime(new Date());
        return JSON.toJSONString(orderReceptionEntity);
    }
}
