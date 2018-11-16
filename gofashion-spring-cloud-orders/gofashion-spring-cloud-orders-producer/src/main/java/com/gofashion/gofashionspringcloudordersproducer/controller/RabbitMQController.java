package com.gofashion.gofashionspringcloudordersproducer.controller;

import com.gofashion.gofashionspringcloudordersproducer.rabbitconfig.RabbitSender;
import com.gofashion.gofashionspringcloudordersproducer.service.common.impl.SplitCallbackServiceImpl;
import com.gofashion.gofashionspringcloudordersproducer.service.common.impl.SplitTakeDateServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

@Controller
public class RabbitMQController {
    @Resource
    private RabbitSender rabbitSender;

    @RequestMapping("/take")
    @ResponseBody
    public String take(){
        SplitTakeDateServiceImpl s = new SplitTakeDateServiceImpl();
        String splitdate = s.splitdate(null);
        SplitCallbackServiceImpl ss = new SplitCallbackServiceImpl();
        String callback = ss.callback(splitdate);
        rabbitSender.sendAddInventoryQueue(callback);
        return "AAA";
    }
}
