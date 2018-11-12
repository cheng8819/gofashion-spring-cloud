package com.gofashion.gofashionspringcloudordersalipay.alipaymodule.controller;

import com.gofashion.gofashionspringcloudordersalipay.alipaymodule.alipay.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class AlipayController {

        @RequestMapping("/show")
        public String show(){
            return "index";
        }


        @ResponseBody
        @RequestMapping(value = "close",method = RequestMethod.POST,produces = "text/html; charset=utf-8")
        public String close(String WIDTCout_trade_no, String WIDTCtrade_no) {
            Close c = new Close();
            String s = c.close(WIDTCout_trade_no, WIDTCtrade_no);
            return s;
        }
/*
    WIDTCtrade_no       支付宝交易号

    WIDTCout_trade_no    商户订单号
    WIDtotal_amount       付款金额
    WIDsubject     订单名称
    WIDbody         商品描述

    request
    WIDTRrefund_reason  退款原因
    WIDTRout_request_no   退款请求号*/


        @ResponseBody
        @RequestMapping(value = "pay",method = RequestMethod.POST,produces = "text/html; charset=utf-8")
        public String pay(String WIDout_trade_no, String WIDtotal_amount, String WIDsubject, String WIDbody, HttpServletRequest
        request) {
            Pay p = new Pay();
            System.out.println(WIDsubject);
            String result = p.pay(WIDout_trade_no,WIDtotal_amount,WIDsubject,WIDbody);
            return result;
        }
        @ResponseBody
        @RequestMapping(value = "notify_url",method = RequestMethod.GET,produces = "text/html; charset=utf-8")
        public String notify_url(String out_trade_no,String trade_no,String trade_status,HttpServletRequest request) {
            Map<String, String[]> requestParams = request.getParameterMap();
            Notify_url n = new Notify_url();
            String result = n.notify_url(requestParams, out_trade_no, trade_no, trade_status);
            return result;
        }
        @ResponseBody
        @RequestMapping(value = "query",method = RequestMethod.POST,produces = "text/html; charset=utf-8")
        public String Query(String WIDTQout_trade_no, String WIDTQtrade_no) {
            Query q = new Query();
            String s = q.query(WIDTQout_trade_no, WIDTQtrade_no);
            return s;
        }

        @ResponseBody
        @RequestMapping(value = "refund",method = RequestMethod.POST,produces = "text/html; charset=utf-8")
        public String refund(String WIDTRout_trade_no, String WIDTRtrade_no, String WIDTRrefund_amount, String WIDTRrefund_reason, String WIDTRout_request_no) {
            Refund r = new Refund();
            String s = r.refund(WIDTRout_trade_no, WIDTRtrade_no,WIDTRrefund_amount,WIDTRrefund_reason,WIDTRout_request_no);
            return s;
        }

        @ResponseBody
        @RequestMapping(value = "refundQuery",method = RequestMethod.POST,produces = "text/html; charset=utf-8")
        public String refundQuery(String WIDRQout_trade_no, String WIDRQtrade_no, String WIDRQout_request_no) {
            RefundQuery r = new RefundQuery();
            String s = r.refundQuery(WIDRQout_trade_no,WIDRQtrade_no,WIDRQout_request_no);
            return s;
        }

        @ResponseBody
        @RequestMapping(value = "return_url",method = RequestMethod.GET,produces = "text/html; charset=utf-8")
        public String alipayReturn_url(String out_trade_no, String trade_no, String total_amount,HttpServletRequest request) {
            Map<String, String[]> requestParams = request.getParameterMap();
            Return_url r = new Return_url();
            String s = r.return_url(requestParams,out_trade_no,trade_no,total_amount);
            return s;
        }

}
