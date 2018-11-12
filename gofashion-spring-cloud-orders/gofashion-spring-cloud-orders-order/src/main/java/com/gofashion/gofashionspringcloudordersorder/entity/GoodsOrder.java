package com.gofashion.gofashionspringcloudordersorder.entity;

public class GoodsOrder {
    private Integer goods_orderID;
    //商品id
    private Integer goods_id;
    //sku
    private String goods_sku;
    //单价
    private Double goods_money;
    //数量
    private Integer goods_quantity;
    //订单状态
    //
    //交易成功(0),
    //交易关闭(1)
    //待付款(3)
    //待发货(4)
    //待收货(5)
    //待评价(6)
    private Integer goods_orderStatus;
    //接受状态
    //（普通0、秒杀1、拼团2、闪购3、）
    private Integer goods_takeStatus;
    //默认0显示   1不显示
    private Integer goods_show;
    // 评价
    private String goods_estimate;
    //关联订单信息（外键id）
    private Integer goods_informationID;

    private Integer goods_shopID;

    private String goods_a;

    private String goods_b;

    private String goods_c;

    public String getGoods_a() {
        return goods_a;
    }

    public void setGoods_a(String goods_a) {
        this.goods_a = goods_a;
    }

    public Integer getGoods_orderID() {
        return goods_orderID;
    }

    public void setGoods_orderID(Integer goods_orderID) {
        this.goods_orderID = goods_orderID;
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

    public Integer getGoods_show() {
        return goods_show;
    }

    public void setGoods_show(Integer goods_show) {
        this.goods_show = goods_show;
    }

    public String getGoods_estimate() {
        return goods_estimate;
    }

    public void setGoods_estimate(String goods_estimate) {
        this.goods_estimate = goods_estimate;
    }

    public Integer getGoods_informationID() {
        return goods_informationID;
    }

    public void setGoods_informationID(Integer goods_informationID) {
        this.goods_informationID = goods_informationID;
    }

    public Integer getGoods_shopID() {
        return goods_shopID;
    }

    public void setGoods_shopID(Integer goods_shopID) {
        this.goods_shopID = goods_shopID;
    }

    public String getGoods_b() {
        return goods_b;
    }

    public void setGoods_b(String goods_b) {
        this.goods_b = goods_b;
    }

    public String getGoods_c() {
        return goods_c;
    }

    public void setGoods_c(String goods_c) {
        this.goods_c = goods_c;
    }
}