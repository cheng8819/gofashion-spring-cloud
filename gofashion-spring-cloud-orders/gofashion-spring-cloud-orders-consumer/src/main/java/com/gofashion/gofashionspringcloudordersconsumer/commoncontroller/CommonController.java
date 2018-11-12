package com.gofashion.gofashionspringcloudordersconsumer.commoncontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CommonController {
    @Resource
    private Massages massage;
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String xxxAdd(String info){
        System.out.println("info = " + info);
        return massage.xxx(info);
    }




}
