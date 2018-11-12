package com.gofashion.gofashionspringcloudordersproducer.service.commonality;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;

public interface GenerateSeckillFormService {
    /**
     * 添加订单
     * @param message 队列消息
     * @return 成功或者失败
     */
    Boolean GenerateForm(String message, Channel channel, Message messages);
}
