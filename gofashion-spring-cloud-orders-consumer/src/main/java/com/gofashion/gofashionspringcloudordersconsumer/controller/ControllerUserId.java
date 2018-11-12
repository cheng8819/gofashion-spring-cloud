/*package com.gofashion.gofashionspringcloudordersconsumer.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.gofashion.gofashionspringcloudordersconsumer.service.ServiceByUserId;
import jdk.nashorn.internal.runtime.JSONFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ControllerUserId {
    @Resource
    private ServiceByUserId serviceByUserId;
    public ServiceByUserId getServiceByUserId() { return serviceByUserId; }
    public void setServiceByUserId(ServiceByUserId serviceByUserId) { this.serviceByUserId = serviceByUserId; }

    @RequestMapping("/sss")
    public String ByUserId(Integer orders_userId){
        String s = serviceByUserId.byId(orders_userId);
        return JSON.toJSONString(s);
    }
}*/
