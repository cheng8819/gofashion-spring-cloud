package com.gofashion.gofashionspringcloudordersproducer.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gofashion.gofashionspringcloudordersproducer.dao.GoodsOrderMapper;
import com.gofashion.gofashionspringcloudordersproducer.entity.GoodsOrder;
import com.gofashion.gofashionspringcloudordersproducer.service.UpdateStateService;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单删除
 */
@Service
public class UpdateStateServiceImpl implements UpdateStateService {
    @Resource
    private GoodsOrderMapper goodsOrderMapper;
    public GoodsOrderMapper getGoodsOrderMapper() { return goodsOrderMapper; }
    public void setGoodsOrderMapper(GoodsOrderMapper goodsOrderMapper) { this.goodsOrderMapper = goodsOrderMapper; }

    @Override
    @Transactional(propagation = Propagation.REQUIRED , rollbackFor = Exception.class)
    public String updatestate(String take) {
        /*List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        System.out.println(JSON.toJSONString(integerList));
        take = JSON.toJSONString(integerList);*/
/*        JSONObject jsonObject = JSON.parseObject(take);
        String goods_orderID = (String) jsonObject.get("goods_orderID");
        GoodsOrder goodsOrder = goodsOrderMapper.selectInformationIDById(Integer.parseInt(goods_orderID));
        List<GoodsOrder> selectgoodsorderlist = goodsOrderMapper.selectgoodsorderlist(goodsOrder.getGoods_informationID());
        Integer count = 0;
        for (GoodsOrder order : selectgoodsorderlist) {
            int updatestate = goodsOrderMapper.updatestate(order.getGoods_orderID());
            count = count+updatestate;
        }
        if(count == selectgoodsorderlist.size()){
            return "删除成功";
        }*/
        List<Integer> parse = (List<Integer>) JSON.parse(take);
        Integer count = 0;
        for (int i = 0; i < parse.size(); i++) {
            int updatestate = goodsOrderMapper.updatestate(parse.get(i));
            count = count + updatestate;
        }
        if(count == parse.size()){
            return "删除成功";
        }
        return "删除失败";
    }

    public static void main(String[] args) {
        UpdateStateServiceImpl updateStateService = new UpdateStateServiceImpl();
        updateStateService.updatestate(new String());
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        System.out.println(JSON.toJSONString(integerList));
    }
}


/*{"goods_orderID":1}{"goods_orderID":1}{"goods_orderID":1}{"goods_orderID":1}*/