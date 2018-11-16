package com.gofashion.gofashionspringcloudalipayproducer.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gofashion.gofashionspringcloudalipayproducer.rabbitconfig.RabbitSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SendOrderService {
    @Resource
    private RabbitSender rabbitSender;
    public RabbitSender getRabbitSender() { return rabbitSender; }
    public void setRabbitSender(RabbitSender rabbitSender) { this.rabbitSender = rabbitSender; }

    private  String out_trade_no;
    private  String total_amount;
    private  String trade_no;
    private  String timestamp;
    public String receive(String result){
        String take = show();
        JSONObject jsonObject = JSON.parseObject(result);
        String out_trade_no = (String) jsonObject.get("out_trade_no");   //订单号
        String total_amount = (String) jsonObject.get("total_amount");  //支付金额
        String trade_no = (String) jsonObject.get("trade_no");  //支付宝交易号
        String timestamp = (String) jsonObject.get("timestamp");  //支付时间
        SendOrderService sendOrderService = new SendOrderService();
        sendOrderService.setOut_trade_no(out_trade_no);
        sendOrderService.setTimestamp(timestamp);
        sendOrderService.setTotal_amount(total_amount);
        sendOrderService.setTrade_no(trade_no);
        rabbitSender.sendAddInventoryQueue(JSON.toJSONString(sendOrderService));
        System.out.println("已发送订单--" + out_trade_no);
        return "已发送订单";
    }

    public static void main(String[] args) {
        SendOrderService sendOrderService = new SendOrderService();
        sendOrderService.receive(null);
    }

    public String show(){
        return "{\n" +
                "\t\"charset\": \"utf-8\",\n" +
                "\t\"out_trade_no\": \"20181121680619\",\n" +
                "\t\"method\": \"alipay.trade.page.pay.return\",\n" +
                "\t\"total_amount\": \"0.01\",\n" +
                "\t\"sign\": \"FQZdfsSvMBNxfybk3UlYzXoMs89ueRmaP43jUdmsY3yAEivtv6AbLSvETWf0l+sp/gcwkw4yI3vST4GGe+F6aclmVtMVNiWZZmW6zsxnkxcWkzJPw/TsGrY8IqcS70gj5GhaYC6k2vzEsunVgfOoqBoOHGrUgpbKc/nLmJZtm7nxZOckd8hiK/MfWUEXe9gqNMc2wZaSv5cJ75InyOHPT9zoDUyHiMrvai41UaSXZmNE5Fm/GSWUbb1PmP3kf3zZVhyf3ttha0J1q/gKj0JfVZ+E0udL0qSc+DGV9crf4egJEs1rNXP5Dgwh8q24IW8cwR60uTo+3qJuoZ4sJMxSXA==\",\n" +
                "\t\"trade_no\": \"2018111622001466510500509470\",\n" +
                "\t\"auth_app_id\": \"2016092000557703\",\n" +
                "\t\"version\": \"1.0\",\n" +
                "\t\"app_id\": \"2016092000557703\",\n" +
                "\t\"sign_type\": \"RSA2\",\n" +
                "\t\"seller_id\": \"2088102176525782\",\n" +
                "\t\"timestamp\": \"2018-11-16 11:03:21\"\n" +
                "}";
    }


    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
