package com.gofashion.gofashionspringcloudordersproducer.service.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RedisTimeEntity {
    private Date time;
    private Integer userid;
    private List<String> orderNumber = new ArrayList<>();
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public List<String> getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(List<String> orderNumber) {
        this.orderNumber = orderNumber;
    }
}
