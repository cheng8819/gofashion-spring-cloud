package com.gofashion.gofashionspringcloudordersdetails.controller;

import com.github.pagehelper.Page;
import com.gofashion.gofashionspringcloudordersdetails.entity.GfsDetail;
import com.gofashion.gofashionspringcloudordersdetails.service.GfsDetailService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class GfsDetailController {
    @Autowired
    private GfsDetailService gfsDetailService;
    @RequestMapping("/show")
    public Page<GfsDetail> show(){
        System.out.println("sjdis--------------------------");
        return gfsDetailService.getAll();
    }


    @RequestMapping("/sh")
    public String  z(){
        System.out.println("sjdis--------------------------");
        return "show";
    }

    //访问微博websocket页面
    @RequestMapping("/setwebsocket")
    public String setwebsocket(){
        return "websocket";
    }


    @RequestMapping("/getip")
    public String getIP(){
        return "getip";

    }
}
