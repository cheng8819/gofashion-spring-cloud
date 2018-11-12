package com.gofashion.gofashionspringcloudordersdetails.entity;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class GfsOrders {
    private String orders_id;

    private Integer orders_userId;

    private String orders_transactionNumber;

    private String orders_orderTime;

    private String orders_creationTime;

    private String orders_paidTime;

    private String orders_deliveryTime;

    private Integer orders_status;

    private Integer orders_receiveStatus;

    private String orders_coupon;

    private Integer orders_show;

    private String orders_b;

    private String orders_c;

    public List<GfsDetail> getListgfsdetail() {
        return listgfsdetail;
    }

    public void setListgfsdetail(List<GfsDetail> listgfsdetail) {
        this.listgfsdetail = listgfsdetail;
    }

    private List<GfsDetail> listgfsdetail = new ArrayList<>();

    public String getOrders_id() {
        return orders_id;
    }

    public void setOrders_id(String orders_id) {
        this.orders_id = orders_id;
    }

    public Integer getOrders_userId() {
        return orders_userId;
    }

    public void setOrders_userId(Integer orders_userId) {
        this.orders_userId = orders_userId;
    }

    public String getOrders_transactionNumber() {
        return orders_transactionNumber;
    }

    public void setOrders_transactionNumber(String orders_transactionNumber) {
        this.orders_transactionNumber = orders_transactionNumber;
    }

    public String getOrders_orderTime() {
        return orders_orderTime;
    }

    public void setOrders_orderTime(String orders_orderTime) {
        this.orders_orderTime = orders_orderTime;
    }

    public String getOrders_creationTime() {
        return orders_creationTime;
    }

    public void setOrders_creationTime(String orders_creationTime) {
        this.orders_creationTime = orders_creationTime;
    }

    public String getOrders_paidTime() {
        return orders_paidTime;
    }

    public void setOrders_paidTime(String orders_paidTime) {
        this.orders_paidTime = orders_paidTime;
    }

    public String getOrders_deliveryTime() {
        return orders_deliveryTime;
    }

    public void setOrders_deliveryTime(String orders_deliveryTime) {
        this.orders_deliveryTime = orders_deliveryTime;
    }

    public Integer getOrders_status() {
        return orders_status;
    }

    public void setOrders_status(Integer orders_status) {
        this.orders_status = orders_status;
    }

    public Integer getOrders_receiveStatus() {
        return orders_receiveStatus;
    }

    public void setOrders_receiveStatus(Integer orders_receiveStatus) {
        this.orders_receiveStatus = orders_receiveStatus;
    }

    public String getOrders_coupon() {
        return orders_coupon;
    }

    public void setOrders_coupon(String orders_coupon) {
        this.orders_coupon = orders_coupon;
    }

    public Integer getOrders_show() {
        return orders_show;
    }

    public void setOrders_show(Integer orders_show) {
        this.orders_show = orders_show;
    }

    public String getOrders_b() {
        return orders_b;
    }

    public void setOrders_b(String orders_b) {
        this.orders_b = orders_b;
    }

    public String getOrders_c() {
        return orders_c;
    }

    public void setOrders_c(String orders_c) {
        this.orders_c = orders_c;
    }
}