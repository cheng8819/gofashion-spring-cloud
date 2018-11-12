package com.gofashion.gofashionspringcloudordersorder.service.impl;

import com.alibaba.fastjson.JSON;
import com.gofashion.gofashionspringcloudordersorder.service.SplitDataService;
import com.gofashion.gofashionspringcloudordersorder.service.vo.LogisticsEntity;
import com.gofashion.gofashionspringcloudordersorder.uilt.ergodiclist.Ergodic;
import com.gofashion.gofashionspringcloudordersorder.uilt.uuidulit.IDUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 拆分数据
 */
@Service
public class SplitDataServiceImpl implements SplitDataService {

    @Override
    public String splitTake(String take) {
        /*
        *店铺id             goods_shopID
        * * 商品id          goods_id
         * sku             goods_sku
         * 金额            goods_money
         * 数量            goods_quantity
         * 用户id          logistics_userId;
         * 接受状态        goods_takeStatus
         * 收件人         logistics_recipients
         * 手机号         logistics_phonewo
         * 地址            logistics_address
         * 创建时间         information_foundTime*/

        List<LogisticsEntity> logisticsEntityList1 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            LogisticsEntity logisticsEntity = new LogisticsEntity();
            logisticsEntity.setGoods_shopID(1);
            logisticsEntity.setGoods_id(2);
            logisticsEntity.setGoods_sku("AAAAAAAAAAA");
            logisticsEntity.setGoods_money(2.0);
            logisticsEntity.setGoods_quantity(6);
            logisticsEntity.setGoods_takeStatus(0);
            logisticsEntity.setLogistics_recipients("张");
            logisticsEntity.setLogistics_phone("12323156");
            logisticsEntity.setLogistics_address("sbdgytswvuqav");
            logisticsEntity.setLogistics_userId(1);
            logisticsEntity.setInformation_foundTime(new Date());
            logisticsEntityList1.add(logisticsEntity);
        }
        for (int i = 0; i < 2; i++) {
            LogisticsEntity logisticsEntity = new LogisticsEntity();
            logisticsEntity.setGoods_shopID(2);
            logisticsEntity.setGoods_id(2);
            logisticsEntity.setGoods_sku("AAAAAAAAAAA");
            logisticsEntity.setGoods_money(2.0);
            logisticsEntity.setGoods_quantity(6);
            logisticsEntity.setGoods_takeStatus(0);
            logisticsEntity.setLogistics_recipients("张");
            logisticsEntity.setLogistics_phone("12323156");
            logisticsEntity.setLogistics_address("sbdgytswvuqav");
            logisticsEntity.setLogistics_userId(1);
            logisticsEntity.setInformation_foundTime(new Date());
            logisticsEntityList1.add(logisticsEntity);
        }

        String string = JSON.toJSONString(logisticsEntityList1);

        List<LogisticsEntity> logisticsEntityList = JSON.parseArray(string, LogisticsEntity.class);
        Double money = 0.0;  //总金额
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < logisticsEntityList.size(); i++) {
            LogisticsEntity logisticsEntity = logisticsEntityList.get(i);
            money = money + (logisticsEntity.getGoods_money() * logisticsEntity.getGoods_quantity());
            //订单状态    交易成功(0),交易关闭(1),待付款(3),待发货(4),待收货(5),待评价(6)
            logisticsEntity.setGoods_orderStatus(3);
            //* 支付宝交易号     information_deal
            //* 付款时间        information_paymentTime
            stringList.add(JSON.toJSONString(logisticsEntity.getGoods_shopID()));
        }
        //遍历键
        List<String> ergodic = Ergodic.ergodic(stringList);
        System.out.println(ergodic.size());
        for (int i = 0; i < ergodic.size(); i++) {
            //生成订单id
            String id = IDUtils.createID();
            for (int j = 0; j < logisticsEntityList.size(); j++) {
                if((logisticsEntityList.get(j).getGoods_shopID()) == Integer.parseInt(ergodic.get(i))){
                    // goodsOrder.getGoods_a()暂时存放订单编号
                    logisticsEntityList.get(j).setInformation_orderNumber(id);
                }
            }
        }

        System.out.println(JSON.toJSONString(logisticsEntityList));
        return JSON.toJSONString(logisticsEntityList);
    }

}
