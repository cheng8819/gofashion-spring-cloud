package com.gofashion.gofashionspringcloudalipayconsumer.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Api(tags = "访问页面")
public class ShowHTMLController {
    //支付
    @RequestMapping(value = "payment",method = RequestMethod.GET)
    @ApiOperation(value = "支付页面",notes = "http://192.168.51.248:8002/payment")
    public String show(){
        return "payment";
    }
    //交易查询
    @RequestMapping(value = "transactionquery",method = RequestMethod.GET)
    @ApiOperation(value = "交易查询页面",notes = "http://192.168.51.248:8002/transactionquery")
    public String show1(){
        return "transactionquery";
    }
    //退款
    @RequestMapping(value ="selectrefund",method = RequestMethod.GET)
    @ApiOperation(value = "退款页面",notes = "http://192.168.51.248:8002/selectrefund")
    public String show2(){ return "SelectRefund"; }
    //退款查询
    @RequestMapping(value ="refundquery",method = RequestMethod.GET)
    @ApiOperation(value = "退款查询页面",notes = "http://192.168.51.248:8002/refundquery")
    public String show3(){ return "refundquery"; }
    //交易关闭
    @RequestMapping(value ="alipayclose",method = RequestMethod.GET)
    @ApiOperation(value = "交易关闭页面",notes = "http://192.168.51.248:8002/alipayclose")
    public String show4(){ return "alipayclose"; }
}
