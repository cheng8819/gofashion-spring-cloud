package com.gofashion.gofashionspringcloudordersalipay.alipaymodule.entity;

public class Goods_detail {
    private String alipay_goods_id;
    private String goods_name;
    private Number quantity;
    private Integer price;

    public String getAlipay_goods_id() {
        return alipay_goods_id;
    }

    public void setAlipay_goods_id(String alipay_goods_id) {
        this.alipay_goods_id = alipay_goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public Number getQuantity() {
        return quantity;
    }

    public void setQuantity(Number quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
