package com.gofashion.gofashionspringcloudordersproducer.service.commonrabbitmqservcer.impl;

import com.alibaba.fastjson.JSON;
import com.gofashion.gofashionspringcloudordersproducer.rabbitconfig.RabbitConfig;
import com.gofashion.gofashionspringcloudordersproducer.service.common.AddDateService;
import com.gofashion.gofashionspringcloudordersproducer.service.commonrabbitmqservcer.ReceptionAlipayService;
import com.gofashion.gofashionspringcloudordersproducer.service.vo.ReceiveAlipay;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

@Component
public class ReceptionAlipayServiceImpl implements ReceptionAlipayService {
    @Resource
    private AddDateService addDateService;
    public AddDateService getAddDateService() { return addDateService; }
    public void setAddDateService(AddDateService addDateService) { this.addDateService = addDateService; }

    @Override
    @RabbitListener(queues = {RabbitConfig.ALIPAY_SEND_ORDER_QUEUE})
    public Boolean GenerateForm(String message, Channel channel, Message messages) {
        System.out.println(message);
        Boolean falge = false;
        try {
            //消息消费成功
           /** String out_trade_no = (String) jsonObject.get("out_trade_no");   //订单号
            String total_amount = (String) jsonObject.get("total_amount");  //支付金额
            String trade_no = (String) jsonObject.get("trade_no");  //支付宝交易号
            String timestamp = (String) jsonObject.get("timestamp");  //支付时间
        SendOrderService sendOrderService = new SendOrderService();*/
//timeout_express      该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m

            ReceiveAlipay receiveAlipay = JSON.parseObject(message, ReceiveAlipay.class);
            if(receiveAlipay == null){
                falge = false;
            }

            channel.basicAck(messages.getMessageProperties().getDeliveryTag(), falge);
            System.out.println("消费成功");
        } catch (Exception e) {
            //消息消费失败
            try {
                channel.basicReject(messages.getMessageProperties().getDeliveryTag(), !falge);
                System.out.println("消费失败");
            } catch (IOException e1) {
                e1.printStackTrace();
                System.out.println("消息返回失败");
            }
        }
        return null;
    }
}
