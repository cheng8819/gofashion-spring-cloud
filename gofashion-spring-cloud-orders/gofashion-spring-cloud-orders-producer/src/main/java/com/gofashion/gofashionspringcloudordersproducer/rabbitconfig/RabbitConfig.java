package com.gofashion.gofashionspringcloudordersproducer.rabbitconfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitConfig {
    public static final String QUEUE_FORWARD_ORDER = "Queue.Forward.Order";  //发送给小鹏
    public static final String QUEUE_ANSWER_ORDER = "Queue.Answer.Order";//接收小鹏
    public static final String ALIPAY_SEND_ORDER_QUEUE = "Alipay.Send.Order.Queue";//接受支付的队列
    @Bean
    public Queue sendAddInventoryQueue(){ return new Queue(QUEUE_FORWARD_ORDER); }
    //延时队列
    public static final String DELAY_QUEUE_30M = "DELAY.QUEUE.30M";
    public static final String DELAY_QUEUE_24H = "DELAY.QUEUE.24H";
    public static final String DELAY_QUEUE_6H = "DELAY.QUEUE.6H";
    //延时队列要传输到的交换机 用户交换机
    public static final String USER_EXCHANGE1 = "order.exchange.30M";
    public static final String USER_EXCHANGE2 = "order.exchange.24H";
    public static final String USER_EXCHANGE3 = "order.exchange.6H";
    //真正要用的队列
    public static final String ACCEPT_QUEUE_30M = "ACCEPT.QUEUE.30M";
    public static final String ACCEPT_QUEUE_24H = "ACCEPT.QUEUE.24H";
    public static final String ACCEPT_QUEUE_6H = "ACCEPT.QUEUE.6H";
    //死信队列路由键 将删除的消息推送到指定交换机的指定路由键指定的队列中
    public final static String DEAD_KEY1="key.30M";    //延迟30分钟
    public final static String DEAD_KEY2="key.24H";   //延迟24小时
    public final static String DEAD_KEY3="key.6H";   //延迟6小时

    @Bean
    public Queue delayQueue1(){
        Map<String,Object> map = new HashMap<>();
        map.put("x-dead-letter-exchange",USER_EXCHANGE1);
        map.put("x-dead-letter-routing-key",DEAD_KEY1);
        map.put("x-message-ttl",30*60*1000);
        return new Queue(DELAY_QUEUE_30M,true,false,false,map);
    }
    @Bean
    public Queue delayQueue2(){
        Map<String,Object> map = new HashMap<>();
        map.put("x-dead-letter-exchange",USER_EXCHANGE2);
        map.put("x-dead-letter-routing-key",DEAD_KEY2);
        map.put("x-message-ttl",24*60*60*1000);
        return new Queue(DELAY_QUEUE_24H,true,false,false,map);
    }
    @Bean
    public Queue delayQueue3(){
        Map<String,Object> map = new HashMap<>();
        map.put("x-dead-letter-exchange",USER_EXCHANGE3);
        map.put("x-dead-letter-routing-key",DEAD_KEY3);
        map.put("x-message-ttl",6*60*60*1000);
        return new Queue(DELAY_QUEUE_6H,true,false,false,map);
    }
    @Bean
    public TopicExchange userExchange1(){ return new TopicExchange(USER_EXCHANGE1,true,false); }
    @Bean
    public TopicExchange userExchange2(){ return new TopicExchange(USER_EXCHANGE2,true,false); }
    @Bean
    public TopicExchange userExchange3(){ return new TopicExchange(USER_EXCHANGE3,true,false); }

    @Bean                                          //接收队列
    public Queue orderQueue1(){ return new Queue(ACCEPT_QUEUE_30M,true,false,false); }
    @Bean                                          //接收队列
    public Queue orderQueue2(){ return new Queue(ACCEPT_QUEUE_24H,true,false,false); }
    @Bean                                          //接收队列
    public Queue orderQueue3(){ return new Queue(ACCEPT_QUEUE_6H,true,false,false); }

    @Bean                                                 //接收队列         交换机               绑定键
    public Binding binding1(){ return BindingBuilder.bind(orderQueue1()).to(userExchange1()).with(DEAD_KEY1); }
    @Bean
    public Binding binding2(){ return BindingBuilder.bind(orderQueue2()).to(userExchange2()).with(DEAD_KEY2); }
    @Bean
    public Binding binding3(){ return BindingBuilder.bind(orderQueue3()).to(userExchange3()).with(DEAD_KEY3); }
    //普通的  30分    拼团24小时    闪购  6小时
}
