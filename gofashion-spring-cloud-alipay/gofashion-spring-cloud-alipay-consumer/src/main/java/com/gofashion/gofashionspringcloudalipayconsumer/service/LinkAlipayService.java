package com.gofashion.gofashionspringcloudalipayconsumer.service;

import com.gofashion.gofashionspringcloudalipayconsumer.feign.FeignClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value = "gofashion-spring-cloud-alipay-producer",fallback = FeignClientFallback.class)
public interface LinkAlipayService {
    //交 易 关 闭
    @RequestMapping(value = "close",method = RequestMethod.POST,produces = "text/html; charset=utf-8")
    @ResponseBody
    String close(@RequestParam("WIDTCout_trade_no") String WIDTCout_trade_no, @RequestParam("WIDTCtrade_no") String WIDTCtrade_no);

    //付款
    @RequestMapping(value = "pay",method = RequestMethod.POST,produces = "text/html; charset=utf-8")
    String pay(@RequestParam("WIDout_trade_no") String WIDout_trade_no,@RequestParam("WIDtotal_amount") String WIDtotal_amount,@RequestParam("WIDsubject") String WIDsubject,@RequestParam("WIDbody") String WIDbody);

    //服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    @RequestMapping(value = "notify_url",method = RequestMethod.GET,produces = "text/html; charset=utf-8")
    String notify_url(@RequestParam("out_trade_no") String out_trade_no,@RequestParam("trade_no") String trade_no,@RequestParam("trade_status") String trade_status,@RequestParam("parameterMap") String parameterMap);

    //交 易 查 询
    @RequestMapping(value = "query",method = RequestMethod.POST,produces = "text/html; charset=utf-8")
    @ResponseBody          //没有responseboby  返回不到
    String Query(@RequestParam("WIDTQout_trade_no") String WIDTQout_trade_no,@RequestParam("WIDTQtrade_no") String WIDTQtrade_no);

    //退 款
    @RequestMapping(value = "refund",method = RequestMethod.POST,produces = "text/html; charset=utf-8")
    @ResponseBody
    String refund(@RequestParam("WIDTRout_trade_no") String WIDTRout_trade_no,@RequestParam("WIDTRtrade_no") String WIDTRtrade_no,@RequestParam("WIDTRrefund_amount") String WIDTRrefund_amount,@RequestParam("WIDTRrefund_reason") String WIDTRrefund_reason,@RequestParam("WIDTRout_request_no") String WIDTRout_request_no);

    //退 款 查 询
    @RequestMapping(value = "refundQuery",method = RequestMethod.POST,produces = "text/html; charset=utf-8")
    @ResponseBody
    String refundQuery(@RequestParam("WIDRQout_trade_no") String WIDRQout_trade_no,@RequestParam("WIDRQtrade_no") String WIDRQtrade_no,@RequestParam("WIDRQout_request_no") String WIDRQout_request_no);

    //页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    @RequestMapping(value = "return_url",method = RequestMethod.GET,produces = "text/html; charset=utf-8")
    String alipayReturn_url(@RequestParam("out_trade_no") String out_trade_no,@RequestParam("trade_no") String trade_no,@RequestParam("total_amount") String total_amount,@RequestParam("parameterMap")String parameterMap);
}
