package com.gofashion.gofashionspringcloudalipayproducer.rabbitconfig;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String ALIPAY_SEND_ORDER_QUEUE = "Alipay.Send.Order.Queue";//阿里支付发送到订单的队列
    static final String QUEUE_SECKILL_REFUND = "Queue_Seckill_refund";//发送退款队列
    @Bean
    public Queue sendAddInventoryQueue(){ return new Queue(ALIPAY_SEND_ORDER_QUEUE); }
}
