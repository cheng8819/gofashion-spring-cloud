package com.gofashion.gofashionspringcloudordersproducer.service.commonrabbitmqservcer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;

public interface ReceptionAlipayService {
    Boolean GenerateForm(String message, Channel channel, Message messages);
}
