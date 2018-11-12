package com.gofashion.gofashionspringcloudordersproducer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String QUEUE_SEND_ADDINVENTORY = "Queue_Send_AddInventory";//发送添加库存的队列
    public static final String QUEUE_ANSWER_ORDER = "Queue_Answer_Order";//监听订单队列
    @Bean
    public Queue sendAddInventoryQueue(){
        return new Queue(QUEUE_SEND_ADDINVENTORY);
    }
    @Bean
    public Queue ordinaryAnswerQueue(){
        return new Queue(QUEUE_ANSWER_ORDER);
    }
}
