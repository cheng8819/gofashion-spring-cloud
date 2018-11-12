package com.gofashion.gofashionspringcloudordersorder.entity;

import java.util.Date;

public class Logistics {
    //物流id
    private Integer logistics_id;
    //物流状态
    //已发货(1)
    //运输中(2)
    //已签收(3)
    private Integer logistics_status;
    //收件人
    private String logistics_recipients;
    //手机号
    private String logistics_phone;
    //地址
    private String logistics_address;
    //快递公司
    private String logistics_DHL;
    //快递单号
    private Integer logistics_oddNumbers;
    //留言备注
    private String logistics_leaveWord;
    //发货时间
    private Date logistics_deliverTime;
    //订单信息id(外键)
    private Integer logistics_informationID;

    public Integer getLogistics_informationID() {
        return logistics_informationID;
    }

    public void setLogistics_informationID(Integer logistics_informationID) {
        this.logistics_informationID = logistics_informationID;
    }

    private Integer logistics_userId;

    private String logistics_a;

    private String logistics_b;

    private String logistics_c;

    public Integer getLogistics_id() {
        return logistics_id;
    }

    public void setLogistics_id(Integer logistics_id) {
        this.logistics_id = logistics_id;
    }

    public Integer getLogistics_status() {
        return logistics_status;
    }

    public void setLogistics_status(Integer logistics_status) {
        this.logistics_status = logistics_status;
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

    public String getLogistics_DHL() {
        return logistics_DHL;
    }

    public void setLogistics_DHL(String logistics_DHL) {
        this.logistics_DHL = logistics_DHL;
    }

    public Integer getLogistics_oddNumbers() {
        return logistics_oddNumbers;
    }

    public void setLogistics_oddNumbers(Integer logistics_oddNumbers) {
        this.logistics_oddNumbers = logistics_oddNumbers;
    }

    public String getLogistics_leaveWord() {
        return logistics_leaveWord;
    }

    public void setLogistics_leaveWord(String logistics_leaveWord) {
        this.logistics_leaveWord = logistics_leaveWord;
    }

    public Date getLogistics_deliverTime() {
        return logistics_deliverTime;
    }

    public void setLogistics_deliverTime(Date logistics_deliverTime) {
        this.logistics_deliverTime = logistics_deliverTime;
    }

    public String getLogistics_a() {
        return logistics_a;
    }

    public void setLogistics_a(String logistics_a) {
        this.logistics_a = logistics_a;
    }

    public String getLogistics_b() {
        return logistics_b;
    }

    public void setLogistics_b(String logistics_b) {
        this.logistics_b = logistics_b;
    }

    public String getLogistics_c() {
        return logistics_c;
    }

    public void setLogistics_c(String logistics_c) {
        this.logistics_c = logistics_c;
    }

    public Integer getLogistics_userId() {
        return logistics_userId;
    }

    public void setLogistics_userId(Integer logistics_userId) {
        this.logistics_userId = logistics_userId;
    }
}