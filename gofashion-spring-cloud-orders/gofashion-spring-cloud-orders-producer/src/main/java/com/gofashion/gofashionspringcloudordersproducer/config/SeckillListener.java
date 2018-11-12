package com.gofashion.gofashionspringcloudordersproducer.config;

import com.gofashion.gofashionspringcloudordersproducer.service.AdditionService;
import com.gofashion.gofashionspringcloudordersproducer.service.SplitDataService;
import org.apache.commons.lang.SerializationUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class SeckillListener {
    @Resource
    private SplitDataService splitDataService;
    @Resource
    private AdditionService additionService;
    @RabbitListener(queues = {RabbitConfig.QUEUE_ANSWER_ORDER})
    public void receive(Message msg){

/*        String s = splitDataService.splitTake();
        String s1 = additionService.addAllGoodsOrder(s);*/

    }
}
