package com.gofashion.gofashionspringcloudordersproducer.rabbitconfig;

import com.gofashion.gofashionspringcloudordersproducer.service.common.SplitCallbackService;
import com.gofashion.gofashionspringcloudordersproducer.service.redisservcer.RedisRemoveService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class DelayReve {
    @Resource
    private RedisRemoveService redisRemoveService;
    public RedisRemoveService getRedisRemoveService() { return redisRemoveService; }
    public void setRedisRemoveService(RedisRemoveService redisRemoveService) { this.redisRemoveService = redisRemoveService; }
    @Resource
    private RabbitSender rabbitSender;
    public RabbitSender getRabbitSender() { return rabbitSender; }
    public void setRabbitSender(RabbitSender rabbitSender) { this.rabbitSender = rabbitSender; }
    @Resource
    private SplitCallbackService splitCallbackService;
    public SplitCallbackService getSplitCallbackService() { return splitCallbackService; }
    public void setSplitCallbackService(SplitCallbackService splitCallbackService) { this.splitCallbackService = splitCallbackService; }

    @RabbitListener(queues = {RabbitConfig.ACCEPT_QUEUE_30M})
    public void accept30M(String msg){
        System.out.println("ABCD---------消费者30M----------" + msg);
        remove(msg);
    }

    @RabbitListener(queues = {RabbitConfig.ACCEPT_QUEUE_24H})
    public void accept24H(String msg){
        System.out.println("ABCD---------消费者24H----------" + msg);
        remove(msg);
    }

    @RabbitListener(queues = {RabbitConfig.ACCEPT_QUEUE_6H})
    public void accept6H(String msg){
        System.out.println("ABCD---------消费者6H----------" + msg);
        remove(msg);
    }

    private String remove(String msg){
        Boolean redisremove = redisRemoveService.redisremove(msg);
        System.out.println("redis删除---" + redisremove);
        String callback = splitCallbackService.callback(msg);
        System.out.println("分解数据");
        rabbitSender.sendAddInventoryQueue(callback);
        System.out.println("给小鹏发送");
        return "发送";
    }
}
