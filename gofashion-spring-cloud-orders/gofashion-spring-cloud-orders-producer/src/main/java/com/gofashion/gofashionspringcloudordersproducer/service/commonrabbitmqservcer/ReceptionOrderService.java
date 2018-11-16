package com.gofashion.gofashionspringcloudordersproducer.service.commonrabbitmqservcer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;

public interface ReceptionOrderService {

    Boolean GenerateForm(String message, Channel channel, Message messages);
}
