package com.gofashion.gofashionspringcloudordersproducer.service.commonality.impl;

import com.gofashion.gofashionspringcloudordersproducer.config.RabbitConfig;
import com.gofashion.gofashionspringcloudordersproducer.service.SplitDataService;
import com.gofashion.gofashionspringcloudordersproducer.service.commonality.GenerateSeckillFormService;
import com.gofashion.gofashionspringcloudordersproducer.service.redisservice.RedisSaveService;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

@Service
public class GenerateSeckillFormServiceImpl implements GenerateSeckillFormService {
    @Resource
    private SplitDataService splitDataService;
    @Resource
    private RedisSaveService redisSaveService;
    @Override
    @RabbitListener(queues = {RabbitConfig.QUEUE_ANSWER_ORDER}, containerFactory = "rabbitListenerContainerFactory")
    public Boolean GenerateForm(String message, Channel channel, Message messages) {
        System.out.println(message);
        Boolean falge = false;
        try {
            //消息消费成功
            String s = splitDataService.splitTake(message);
            Boolean save = redisSaveService.save(s);
            falge = save;
            channel.basicAck(messages.getMessageProperties().getDeliveryTag(), falge);
            System.out.println("消费成功");
        } catch (Exception e) {
            //消息消费失败
            try {
                channel.basicReject(messages.getMessageProperties().getDeliveryTag(), !falge);
                System.out.println("消费失败");
            } catch (IOException e1) {
                e1.printStackTrace();
                System.out.println("消息返回失败");
            }
        }
        return null;
    }
}
