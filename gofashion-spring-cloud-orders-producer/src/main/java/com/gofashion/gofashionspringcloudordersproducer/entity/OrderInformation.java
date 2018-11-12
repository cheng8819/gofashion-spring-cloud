package com.gofashion.gofashionspringcloudordersproducer.entity;

import java.util.Date;

public class OrderInformation {
    private Integer information_id;
    //订单编号
    private String information_orderNumber;
    //支付宝交易号
    private String information_deal;
    //创建时间
    private Date information_foundTime;
    //付款时间
    private Date information_paymentTime;
    //成交时间
    private Date information_clinchTime;
//    //物流id(外键)
//    private Integer information_logisticsID;

    private String information_a;

    private String information_b;

    private String information_c;

    public Integer getInformation_id() {
        return information_id;
    }

    public void setInformation_id(Integer information_id) {
        this.information_id = information_id;
    }

    public String getInformation_orderNumber() {
        return information_orderNumber;
    }

    public void setInformation_orderNumber(String information_orderNumber) {
        this.information_orderNumber = information_orderNumber;
    }

    public String getInformation_deal() {
        return information_deal;
    }

    public void setInformation_deal(String information_deal) {
        this.information_deal = information_deal;
    }

    public Date getInformation_foundTime() {
        return information_foundTime;
    }

    public void setInformation_foundTime(Date information_foundTime) {
        this.information_foundTime = information_foundTime;
    }

    public Date getInformation_paymentTime() {
        return information_paymentTime;
    }

    public void setInformation_paymentTime(Date information_paymentTime) {
        this.information_paymentTime = information_paymentTime;
    }

    public Date getInformation_clinchTime() {
        return information_clinchTime;
    }

    public void setInformation_clinchTime(Date information_clinchTime) {
        this.information_clinchTime = information_clinchTime;
    }

//    public Integer getInformation_logisticsID() {
//        return information_logisticsID;
//    }
//
//    public void setInformation_logisticsID(Integer information_logisticsID) {
//        this.information_logisticsID = information_logisticsID;
//    }

    public String getInformation_a() {
        return information_a;
    }

    public void setInformation_a(String information_a) {
        this.information_a = information_a;
    }

    public String getInformation_b() {
        return information_b;
    }

    public void setInformation_b(String information_b) {
        this.information_b = information_b;
    }

    public String getInformation_c() {
        return information_c;
    }

    public void setInformation_c(String information_c) {
        this.information_c = information_c;
    }
}