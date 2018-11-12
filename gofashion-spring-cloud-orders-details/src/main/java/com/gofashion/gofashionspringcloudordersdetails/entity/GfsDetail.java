package com.gofashion.gofashionspringcloudordersdetails.entity;

import org.springframework.stereotype.Component;

@Component
public class GfsDetail {
    private Integer detail_id;

    private String detail_name;

    private String detail_sku;

    private Integer detail_number;

    private Double detail_cost;

    private String detail_shop;

    private String detail_ordersId;

    private String detail_a;

    private String detail_b;

    private String detail_c;

    private GfsOrders gfsOrders = new GfsOrders();

    public GfsOrders getGfsOrders() {
        return gfsOrders;
    }

    public void setGfsOrders(GfsOrders gfsOrders) {
        this.gfsOrders = gfsOrders;
    }

    public Integer getDetail_id() {
        return detail_id;
    }

    public void setDetail_id(Integer detail_id) {
        this.detail_id = detail_id;
    }

    public String getDetail_name() {
        return detail_name;
    }

    public void setDetail_name(String detail_name) {
        this.detail_name = detail_name;
    }

    public String getDetail_sku() {
        return detail_sku;
    }

    public void setDetail_sku(String detail_sku) {
        this.detail_sku = detail_sku;
    }

    public Integer getDetail_number() {
        return detail_number;
    }

    public void setDetail_number(Integer detail_number) {
        this.detail_number = detail_number;
    }

    public Double getDetail_cost() {
        return detail_cost;
    }

    public void setDetail_cost(Double detail_cost) {
        this.detail_cost = detail_cost;
    }

    public String getDetail_shop() {
        return detail_shop;
    }

    public void setDetail_shop(String detail_shop) {
        this.detail_shop = detail_shop;
    }

    public String getDetail_ordersId() {
        return detail_ordersId;
    }

    public void setDetail_ordersId(String detail_ordersId) {
        this.detail_ordersId = detail_ordersId;
    }

    public String getDetail_a() {
        return detail_a;
    }

    public void setDetail_a(String detail_a) {
        this.detail_a = detail_a;
    }

    public String getDetail_b() {
        return detail_b;
    }

    public void setDetail_b(String detail_b) {
        this.detail_b = detail_b;
    }

    public String getDetail_c() {
        return detail_c;
    }

    public void setDetail_c(String detail_c) {
        this.detail_c = detail_c;
    }
}