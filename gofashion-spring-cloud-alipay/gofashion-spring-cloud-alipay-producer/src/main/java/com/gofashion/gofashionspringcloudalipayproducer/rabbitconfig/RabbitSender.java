package com.gofashion.gofashionspringcloudalipayproducer.rabbitconfig;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//
@Component
public class RabbitSender {
    @Autowired
    private AmqpTemplate amqpTemplate;
    //发送订单的队列
    public void sendAddInventoryQueue(String message) {
        this.amqpTemplate.convertAndSend(RabbitConfig.ALIPAY_SEND_ORDER_QUEUE, message);
    }
}
