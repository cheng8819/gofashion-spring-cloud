package com.gofashion.gofashionspringcloudordersorder.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gofashion.gofashionspringcloudordersorder.dao.GoodsOrderMapper;
import com.gofashion.gofashionspringcloudordersorder.entity.GoodsOrder;
import com.gofashion.gofashionspringcloudordersorder.service.UpdateStateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
        take = "{" +
                "\"goods_orderID\":\"1\"," +
                "}";
        JSONObject jsonObject = JSON.parseObject(take);
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
        }
        return "删除失败";
    }
}
