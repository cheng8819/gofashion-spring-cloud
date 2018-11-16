package com.gofashion.gofashionspringcloudalipayconsumer.controller;

import com.alibaba.fastjson.JSON;
import com.gofashion.gofashionspringcloudalipayconsumer.service.LinkAlipayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("alipay")
@Api(tags = "支付业务")
public class GofashionAlipayController {
    @Resource
    private LinkAlipayService linkAlipayService;
    public LinkAlipayService getLinkAlipayService() { return linkAlipayService; }
    public void setLinkAlipayService(LinkAlipayService linkAlipayService) { this.linkAlipayService = linkAlipayService; }



    //支付
    @ApiOperation(value = "订单支付",notes = "调支付宝支付")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "WIDout_trade_no",value = "商户订单号，商户网站订单系统中唯一订单号，必填",paramType = "query",required = true,dataType = "String"),
            @ApiImplicitParam(name = "WIDtotal_amount",value = "付款金额，必填",paramType = "query",required = true,dataType = "String"),
            @ApiImplicitParam(name = "WIDsubject",value = "订单名称，必填",paramType = "query",required = true,dataType = "String"),
            @ApiImplicitParam(name = "WIDbody",value = "商品描述，可空",paramType = "query",required = false,dataType = "String")
    })
    @RequestMapping(value = "pay",method = RequestMethod.POST,produces = "text/html; charset=utf-8")
    @ResponseBody
    public String payment(String WIDout_trade_no,String WIDtotal_amount,String WIDsubject,String WIDbody,HttpServletRequest request){
        Map<String, String[]> parameterMap = request.getParameterMap();
        String pay = linkAlipayService.pay(WIDout_trade_no, WIDtotal_amount, WIDsubject, WIDbody);
        System.out.println(pay);
        return pay;
    }

    //交易查询
    @ApiOperation(value = "交易查询",notes = "交易查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "WIDTQout_trade_no",value = "商户订单号",paramType = "query",required = false,dataType = "String"),
            @ApiImplicitParam(name = "WIDTQtrade_no",value = "支付宝交易号",paramType = "query",required = false,dataType = "String")
    })
    @RequestMapping(value = "query", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
    @ResponseBody
    public String transactionquery(String WIDTQout_trade_no,String WIDTQtrade_no){
        String query = linkAlipayService.Query(WIDTQout_trade_no, WIDTQtrade_no);
        System.out.println("交易查询--" + query);
        return query;
    }

    //退款                 ***********************************
    ///*//商户订单号，商户网站订单系统中唯一订单号
    //        String out_trade_no = new String(request.getParameter("WIDTRout_trade_no").getBytes("ISO-8859-1"),"UTF-8");
    //        //支付宝交易号
    //        String trade_no = new String(request.getParameter("WIDTRtrade_no").getBytes("ISO-8859-1"),"UTF-8");
    //        //请二选一设置
    @ApiOperation(value = "退款",notes = "退款接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "WIDTRout_trade_no",value = "商户订单号，商户网站订单系统中唯一订单号",paramType = "query",required = true,dataType = "String"),
            @ApiImplicitParam(name = "WIDTRtrade_no",value = "支付宝交易号",paramType = "query",required = true,dataType = "String"),
            @ApiImplicitParam(name = "WIDTRrefund_amount",value = "需要退款的金额，该金额不能大于订单金额，必填",paramType = "query",required = true,dataType = "String"),
            @ApiImplicitParam(name = "WIDTRrefund_reason",value = "退款的原因说明",paramType = "query",required = false,dataType = "String"),
            @ApiImplicitParam(name = "WIDTRout_request_no",value = "标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传",paramType = "query",required = false,dataType = "String")
    })
    @RequestMapping(value = "refund", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
    @ResponseBody
    public String refund(String WIDTRout_trade_no,String WIDTRtrade_no,String WIDTRrefund_amount,String WIDTRrefund_reason,String WIDTRout_request_no){
        String refund = linkAlipayService.refund(WIDTRout_trade_no, WIDTRtrade_no, WIDTRrefund_amount, WIDTRrefund_reason, WIDTRout_request_no);
        return refund;
    }


    //退款查询
    @ApiOperation(value = "退款查询",notes = "退款查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "WIDRQout_trade_no",value = "商户订单号，商户网站订单系统中唯一订单号",paramType = "query",required = false,dataType = "String"),
            @ApiImplicitParam(name = "WIDRQtrade_no",value = "支付宝交易号",paramType = "query",required = false,dataType = "String"),
            @ApiImplicitParam(name = "WIDRQout_request_no",value = "请求退款接口时，传入的退款请求号，如果在退款请求时未传入，则该值为创建交易时的外部交易号，必填",paramType = "query",required = true,dataType = "String")
    })
    @RequestMapping(value = "refundQuery", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
    @ResponseBody
    public String refundQuery(String WIDRQout_trade_no,String WIDRQtrade_no,String WIDRQout_request_no){
        String s = linkAlipayService.refundQuery(WIDRQout_trade_no, WIDRQtrade_no, WIDRQout_request_no);
        return s;
    }

    //交易关闭
    @ApiOperation(value = "交易关闭",notes = "交易关闭,**参数请二选一设置")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "WIDTCout_trade_no",value = "商户订单号，商户网站订单系统中唯一订单号",paramType = "query",required = false,dataType = "String"),
            @ApiImplicitParam(name = "WIDTCtrade_no",value = "支付宝交易号",paramType = "query",required = false,dataType = "String")
    })
    @RequestMapping(value = "close", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
    @ResponseBody
    public String tradingclosed(String WIDTCout_trade_no,String WIDTCtrade_no){
        String close = linkAlipayService.close(WIDTCout_trade_no, WIDTCtrade_no);
        return close;
    }

    @ApiOperation(value = "页面跳转同步通知页面路径",notes = "必须外网可以正常访问")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "out_trade_no",value = "商户订单号",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "trade_no",value = "支付宝交易号",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "total_amount",value = "付款金额",paramType = "query",dataType = "String")
    })
    @RequestMapping(value = "return_url", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    @ResponseBody
    public String alipayReturn_url(String out_trade_no, String trade_no, String total_amount, HttpServletRequest request){
        Map<String, String[]> parameterMap = request.getParameterMap();
        String s = linkAlipayService.alipayReturn_url(out_trade_no, trade_no, total_amount,JSON.toJSONString(parameterMap));
        System.out.println("return_url--" + s);
        return s;
    }


    @ApiOperation(value = "服务器异步通知页面路径",notes = "必须外网可以正常访问")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "out_trade_no",value = "商户订单号",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "trade_no",value = "支付宝交易号",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "trade_status",value = "交易状态",paramType = "query",dataType = "String")
    })
    @RequestMapping(value = "notify_url", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    @ResponseBody
    public String notify_url(@RequestParam("out_trade_no")String out_trade_no,@RequestParam("trade_no") String trade_no,@RequestParam("trade_status") String trade_status, HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        String s = linkAlipayService.notify_url(out_trade_no, trade_no, trade_status,JSON.toJSONString(parameterMap));
        return s;
    }
}
