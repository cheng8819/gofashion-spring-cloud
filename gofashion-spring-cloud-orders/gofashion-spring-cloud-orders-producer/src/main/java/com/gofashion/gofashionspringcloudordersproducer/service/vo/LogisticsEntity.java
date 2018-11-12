package com.gofashion.gofashionspringcloudordersproducer.service.vo;

import java.util.Date;

public class LogisticsEntity {
    private Integer goods_shopID;  //店铺id
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
    private String information_orderNumber;     //订单编号

    public Integer getGoods_shopID() {
        return goods_shopID;
    }

    public void setGoods_shopID(Integer goods_shopID) {
        this.goods_shopID = goods_shopID;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_sku() {
        return goods_sku;
    }

    public void setGoods_sku(String goods_sku) {
        this.goods_sku = goods_sku;
    }

    public Double getGoods_money() {
        return goods_money;
    }

    public void setGoods_money(Double goods_money) {
        this.goods_money = goods_money;
    }

    public Integer getGoods_quantity() {
        return goods_quantity;
    }

    public void setGoods_quantity(Integer goods_quantity) {
        this.goods_quantity = goods_quantity;
    }

    public Integer getGoods_orderStatus() {
        return goods_orderStatus;
    }

    public void setGoods_orderStatus(Integer goods_orderStatus) {
        this.goods_orderStatus = goods_orderStatus;
    }

    public Integer getGoods_takeStatus() {
        return goods_takeStatus;
    }

    public void setGoods_takeStatus(Integer goods_takeStatus) {
        this.goods_takeStatus = goods_takeStatus;
    }

    public String getGoods_estimate() {
        return goods_estimate;
    }

    public void setGoods_estimate(String goods_estimate) {
        this.goods_estimate = goods_estimate;
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

    public Integer getLogistics_userId() {
        return logistics_userId;
    }

    public void setLogistics_userId(Integer logistics_userId) {
        this.logistics_userId = logistics_userId;
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