package com.gofashion.gofashionspringcloudordersproducer.service.vo;

import com.gofashion.gofashionspringcloudordersproducer.entity.GoodsOrder;
import com.gofashion.gofashionspringcloudordersproducer.entity.Logistics;
import io.swagger.models.auth.In;

import java.util.Date;
import java.util.List;

public class RedisOrderEntity {
    private String information_orderNumber;
    //创建时间
    private Date information_foundTime;
    private Logistics logistics;
    private List<GoodsOrder> goodsOrderList;
    private Integer information_userId;

    public Integer getInformation_userId() {
        return information_userId;
    }

    public void setInformation_userId(Integer information_userId) {
        this.information_userId = information_userId;
    }

    public String getInformation_orderNumber() {
        return information_orderNumber;
    }

    public void setInformation_orderNumber(String information_orderNumber) {
        this.information_orderNumber = information_orderNumber;
    }

    public Date getInformation_foundTime() {
        return information_foundTime;
    }

    public void setInformation_foundTime(Date information_foundTime) {
        this.information_foundTime = information_foundTime;
    }

    public Logistics getLogistics() {
        return logistics;
    }

    public void setLogistics(Logistics logistics) {
        this.logistics = logistics;
    }

    public List<GoodsOrder> getGoodsOrderList() {
        return goodsOrderList;
    }

    public void setGoodsOrderList(List<GoodsOrder> goodsOrderList) {
        this.goodsOrderList = goodsOrderList;
    }
}
