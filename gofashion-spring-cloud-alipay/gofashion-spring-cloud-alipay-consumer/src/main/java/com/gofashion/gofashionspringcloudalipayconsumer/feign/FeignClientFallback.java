package com.gofashion.gofashionspringcloudalipayconsumer.feign;

import com.gofashion.gofashionspringcloudalipayconsumer.service.LinkAlipayService;
import org.springframework.stereotype.Component;

@Component
public class FeignClientFallback implements LinkAlipayService {
    @Override
    public String close(String WIDTCout_trade_no, String WIDTCtrade_no) {
        return "Exception";
    }

    @Override
    public String pay(String WIDout_trade_no, String WIDtotal_amount, String WIDsubject, String WIDbody) {
        return "Exception";
    }

    @Override
    public String notify_url(String out_trade_no, String trade_no, String trade_status, String parameterMap) {
        return "Exception";
    }

    @Override
    public String Query(String WIDTQout_trade_no, String WIDTQtrade_no) {
        return "Exception";
    }

    @Override
    public String refund(String WIDTRout_trade_no, String WIDTRtrade_no, String WIDTRrefund_amount, String WIDTRrefund_reason, String WIDTRout_request_no) {
        return "Exception";
    }

    @Override
    public String refundQuery(String WIDRQout_trade_no, String WIDRQtrade_no, String WIDRQout_request_no) {
        return "Exception";
    }

    @Override
    public String alipayReturn_url(String out_trade_no, String trade_no, String total_amount,String parameterMap) {
        return "Exception";
    }
}
