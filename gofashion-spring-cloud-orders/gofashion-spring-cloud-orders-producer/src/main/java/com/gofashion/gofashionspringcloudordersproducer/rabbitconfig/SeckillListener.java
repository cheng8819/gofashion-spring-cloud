package com.gofashion.gofashionspringcloudordersproducer.rabbitconfig;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;


@Component
public class SeckillListener {
    @RabbitListener(queues = {RabbitConfig.QUEUE_ANSWER_ORDER})
    public void receive(Message msg){
        System.out.println();
    }
}
