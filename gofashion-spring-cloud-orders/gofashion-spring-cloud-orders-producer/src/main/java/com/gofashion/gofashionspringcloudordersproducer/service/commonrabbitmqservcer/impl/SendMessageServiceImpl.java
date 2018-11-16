package com.gofashion.gofashionspringcloudordersproducer.service.commonrabbitmqservcer.impl;

import com.gofashion.gofashionspringcloudordersproducer.rabbitconfig.RabbitConfig;
import com.gofashion.gofashionspringcloudordersproducer.service.commonrabbitmqservcer.SendMessageService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class SendMessageServiceImpl implements SendMessageService {
    @Resource
    private RabbitTemplate amqpTemplate;
    @Override
    public Boolean GenerateForm(String message) {
        this.amqpTemplate.convertAndSend(RabbitConfig.QUEUE_FORWARD_ORDER,message);
        System.out.println("发送成功--------------小鹏");
        return null;
    }
}
