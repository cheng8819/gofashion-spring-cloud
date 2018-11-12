package com.gofashion.gofashionspringcloudordersdetails.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.gofashion.gofashionspringcloudordersdetails.dao.IGfsDetailMapper;
import com.gofashion.gofashionspringcloudordersdetails.dao.IGfsOrdersMapper;
import com.gofashion.gofashionspringcloudordersdetails.entity.GfsDetail;
import com.gofashion.gofashionspringcloudordersdetails.entity.GfsOrders;
import com.gofashion.gofashionspringcloudordersdetails.service.GfsOrdersByIdService;
import com.gofashion.gofashionspringcloudordersdetails.uilt.redisulit.RedisUtil;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GfsOrdersByIdServiceImpl implements GfsOrdersByIdService {
    protected static Logger logger = Logger.getLogger(GfsOrdersByIdServiceImpl.class);
    @Autowired
    private IGfsOrdersMapper iGfsOrdersMapper;
    public IGfsOrdersMapper getiGfsOrdersMapper() { return iGfsOrdersMapper; }
    public void setiGfsOrdersMapper(IGfsOrdersMapper iGfsOrdersMapper) { this.iGfsOrdersMapper = iGfsOrdersMapper; }
    @Autowired
    private IGfsDetailMapper iGfsDetailMapper;
    public IGfsDetailMapper getiGfsDetailMapper() { return iGfsDetailMapper; }
    public void setiGfsDetailMapper(IGfsDetailMapper iGfsDetailMapper) { this.iGfsDetailMapper = iGfsDetailMapper; }
    @Autowired
    private RedisUtil redisUtil;
    public RedisUtil getRedisUtil() { return redisUtil; }
    public void setRedisUtil(RedisUtil redisUtil) { this.redisUtil = redisUtil; }

    @Override
    public String selectUserId(Integer orders_userId) {
        if(orders_userId == null){
            logger.error("传入用户" + orders_userId);
            return "用户不存在";
        }
        //订单表根据用户id查询    因为用户id不唯一
        Page<GfsOrders> gfsOrders = new Page<>();    //订单表
        List<GfsOrders> gfsOrders1 = iGfsOrdersMapper.selectUserId(orders_userId);
        for (GfsOrders gfsOrder : gfsOrders1) {
            //如果显示状态gfsOrder.getOrders_show()   为0 不显示
            if(gfsOrder.getOrders_show() == 0){
                continue;
            }
            //通过订单信息id   查询详细信息表
            List<GfsDetail> gfsDetails = iGfsDetailMapper.selectByOrdersId(gfsOrder.getOrders_id());       //详情表
            gfsOrder.setListgfsdetail(gfsDetails);
            gfsOrders.add(gfsOrder);
        }

        boolean set = redisUtil.set(JSON.toJSONString(orders_userId), JSON.toJSONString(gfsOrders));
        logger.error("传入redis------------" + set);
        return JSON.toJSONString(gfsOrders);
    }
}
