/*package com.gofashion.gofashionspringcloudordersproducer.config;

import cn.taoba.taobaspringcloudseckillproducer.seckillproducer.server.HandleListenerService;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RabbitFactory {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void killRedisQueue(String redisQueueName, Integer psc) {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(rabbitTemplate.getConnectionFactory());
        Map<String, Object> map = new HashMap<>();
        map.put("x-max-length-bytes", psc);
        rabbitAdmin.declareQueue(new Queue(redisQueueName, false, false, true, map));
    }

    public void mqMessageContainer(HandleListenerService handleListenerService,String[] queueNames){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(rabbitTemplate.getConnectionFactory());
        container.setQueueNames(queueNames);
        container.setExposeListenerChannel(true);
        container.setPrefetchCount(1);//设置每个消费者获取的最大的消息数量
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);//设置确认模式为手工确认
        container.setMessageListener(handleListenerService);//监听处理类
    }

}*/
