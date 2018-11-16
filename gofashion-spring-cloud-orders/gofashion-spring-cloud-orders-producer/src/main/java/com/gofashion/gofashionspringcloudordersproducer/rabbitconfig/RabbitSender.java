package com.gofashion.gofashionspringcloudordersproducer.rabbitconfig;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//发送者  小鹏
@Component
public class RabbitSender {
    @Autowired
    private AmqpTemplate amqpTemplate;
    //发送添加库存的队列
    public void sendAddInventoryQueue(String message) {
        this.amqpTemplate.convertAndSend(RabbitConfig.QUEUE_FORWARD_ORDER, message);
    }
}
