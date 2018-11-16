package com.gofashion.gofashionspringcloudordersproducer.service.vo;


import com.gofashion.gofashionspringcloudordersproducer.entity.GoodsOrder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderReceptionEntity {
/*    private Integer goods_shopID;  //店铺id
    private Integer goods_id;      //商品id
    private String goods_sku;      //* sku
    private Double goods_money;    //* 金额
    private Integer goods_quantity;   //* 数量
    private Integer goods_orderStatus; //  //订单状态   交易成功(0),交易关闭(1)待付款(3)待发货(4)待收货(5)待评价(6)
    private Integer goods_takeStatus;  //接受状态//（普通0、秒杀1、拼团2、闪购3、）
    private String goods_estimate;      // 评价

    private String logistics_recipients;    //收件人
    private String logistics_phone;          //手机号
    private String logistics_address;        //地址
    private Integer logistics_userId;         //用户id

    private Date information_foundTime;         //创建时间
    private String information_deal;             //支付宝交易号
    private Date information_paymentTime;       //付款时间
    private String information_orderNumber;     //订单编号*/

    //商品集合
    private List<GoodsOrder> goodsOrderList = new ArrayList<>();
    //用户id
    private Integer information_userId;
    //收件人
    private String logistics_recipients;
    //手机号
    private String logistics_phone;
    //地址
    private String logistics_address;
    //接受状态
    //（普通0、秒杀1、拼团2、闪购3、）
    private Integer goods_takeStatus;
    //创建时间
    private Date information_foundTime;         //创建时间

    private String information_deal;             //支付宝交易号
    private Date information_paymentTime;       //付款时间
    private String information_orderNumber;     //提交支付的编号***
//////////////////////////////////////////////////////////////////////////////
    public List<GoodsOrder> getGoodsOrderList() {
        return goodsOrderList;
    }

    public void setGoodsOrderList(List<GoodsOrder> goodsOrderList) {
        this.goodsOrderList = goodsOrderList;
    }

    public Integer getInformation_userId() {
        return information_userId;
    }

    public void setInformation_userId(Integer information_userId) {
        this.information_userId = information_userId;
    }

    public String getLogistics_recipients() {
        return logistics_recipients;
    }

    public void setLogistics_recipients(String logistics_recipients) {
        this.logistics_recipients = logistics_recipients;
    }

    public String getLogistics_phone() {
        return logistics_phone;
    }

    public void setLogistics_phone(String logistics_phone) {
        this.logistics_phone = logistics_phone;
    }

    public String getLogistics_address() {
        return logistics_address;
    }

    public void setLogistics_address(String logistics_address) {
        this.logistics_address = logistics_address;
    }

    public Integer getGoods_takeStatus() {
        return goods_takeStatus;
    }

    public void setGoods_takeStatus(Integer goods_takeStatus) {
        this.goods_takeStatus = goods_takeStatus;
    }

    public Date getInformation_foundTime() {
        return information_foundTime;
    }

    public void setInformation_foundTime(Date information_foundTime) {
        this.information_foundTime = information_foundTime;
    }

    public String getInformation_deal() {
        return information_deal;
    }

    public void setInformation_deal(String information_deal) {
        this.information_deal = information_deal;
    }

    public Date getInformation_paymentTime() {
        return information_paymentTime;
    }

    public void setInformation_paymentTime(Date information_paymentTime) {
        this.information_paymentTime = information_paymentTime;
    }

    public String getInformation_orderNumber() {
        return information_orderNumber;
    }

    public void setInformation_orderNumber(String information_orderNumber) {
        this.information_orderNumber = information_orderNumber;
    }
}