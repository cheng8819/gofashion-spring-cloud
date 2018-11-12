package com.gofashion.gofashionspringcloudordersproducer.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitSender {
    @Autowired
    private AmqpTemplate amqpTemplate;
    //发送添加库存的队列
    public void sendAddInventoryQueue(String message) {
        this.amqpTemplate.convertAndSend(RabbitConfig.QUEUE_SEND_ADDINVENTORY, message);
        System.out.println("发送添加订单信息");
    }
}
