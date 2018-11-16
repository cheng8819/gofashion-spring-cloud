package com.gofashion.gofashionspringcloudordersproducer.rabbitconfig;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Send {
    @Autowired
    private RabbitTemplate amqpTemplate;
    public void SendDelay30M(String message) {
        this.amqpTemplate.convertAndSend(RabbitConfig.DELAY_QUEUE_30M, message);
    }

    public void SendDelay24H(String message) {
        this.amqpTemplate.convertAndSend(RabbitConfig.DELAY_QUEUE_24H, message);
    }

    public void SendDelay6H(String message) {
        this.amqpTemplate.convertAndSend(RabbitConfig.DELAY_QUEUE_6H, message);
    }
}
