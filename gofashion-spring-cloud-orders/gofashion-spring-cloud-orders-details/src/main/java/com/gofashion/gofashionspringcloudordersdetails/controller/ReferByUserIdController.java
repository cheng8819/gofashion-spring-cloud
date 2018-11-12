package com.gofashion.gofashionspringcloudordersdetails.controller;

import com.alibaba.fastjson.JSON;
import com.gofashion.gofashionspringcloudordersdetails.service.GfsOrdersByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//根据用户id查询信息
@Controller
@RequestMapping("/byid")
public class ReferByUserIdController {
    @Autowired
    private GfsOrdersByIdService gfsOrdersByIdService;
    public GfsOrdersByIdService getGfsOrdersByIdService() { return gfsOrdersByIdService; }
    public void setGfsOrdersByIdService(GfsOrdersByIdService gfsOrdersByIdService) { this.gfsOrdersByIdService = gfsOrdersByIdService; }

    @RequestMapping(value = "/userid",method = RequestMethod.GET)
    @ResponseBody
    public String byId(@RequestParam("userId") Integer orders_userId){
        return gfsOrdersByIdService.selectUserId(1);
    }
}
