package com.gofashion.gofashionspringcloudordersproducer.service.commonrabbitmqservcer.impl;

import com.alibaba.fastjson.JSON;
import com.gofashion.gofashionspringcloudordersproducer.entity.GoodsOrder;
import com.gofashion.gofashionspringcloudordersproducer.rabbitconfig.RabbitConfig;
import com.gofashion.gofashionspringcloudordersproducer.rabbitconfig.Send;
import com.gofashion.gofashionspringcloudordersproducer.service.common.SplitTakeDateService;
import com.gofashion.gofashionspringcloudordersproducer.service.commonrabbitmqservcer.ReceptionOrderService;
import com.gofashion.gofashionspringcloudordersproducer.service.redisservcer.RedisSaveService;
import com.gofashion.gofashionspringcloudordersproducer.service.vo.ReceiveAlipay;
import com.gofashion.gofashionspringcloudordersproducer.service.vo.RedisOrderEntity;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Component
public class ReceptionOrderServiceImpl implements ReceptionOrderService {
    @Resource
    private SplitTakeDateService splitTakeDateService;
    public SplitTakeDateService getSplitTakeDateService() { return splitTakeDateService; }
    public void setSplitTakeDateService(SplitTakeDateService splitTakeDateService) { this.splitTakeDateService = splitTakeDateService; }
    @Resource
    private RedisSaveService redisSaveService;
    public RedisSaveService getRedisSaveService() { return redisSaveService; }
    public void setRedisSaveService(RedisSaveService redisSaveService) { this.redisSaveService = redisSaveService; }
    @Resource
    private Send send;
    public Send getSend() { return send; }
    public void setSend(Send send) { this.send = send; }

    @Override
    @RabbitListener(queues = {RabbitConfig.QUEUE_ANSWER_ORDER}, containerFactory = "rabbitListenerContainerFactory")
    public Boolean GenerateForm(String message, Channel channel, Message messages) {
        System.out.println(message);
        Boolean falge = false;
        try {
            //消息消费成功
            String splitdate = splitTakeDateService.splitdate(message);
            Boolean aBoolean = redisSaveService.redisSave(splitdate);
            System.out.println("redis保存----" + aBoolean);

            List<RedisOrderEntity> redisOrderEntityList = JSON.parseArray(splitdate, RedisOrderEntity.class);
            RedisOrderEntity redisOrderEntity = redisOrderEntityList.get(0);
            List<GoodsOrder> goodsOrderList = redisOrderEntity.getGoodsOrderList();
            GoodsOrder goodsOrder = goodsOrderList.get(0);
            Integer goods_takeStatus = goodsOrder.getGoods_takeStatus();
            //（普通0、秒杀1、拼团2、闪购3、）
            if(goods_takeStatus == 0){
                send.SendDelay30M(splitdate);
            }else if(goods_takeStatus == 1){
                splitdate = "";
            }else if(goods_takeStatus == 2){
                send.SendDelay24H(splitdate);
            }else if(goods_takeStatus == 3){
                send.SendDelay6H(splitdate);
            }
            falge = aBoolean;
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
