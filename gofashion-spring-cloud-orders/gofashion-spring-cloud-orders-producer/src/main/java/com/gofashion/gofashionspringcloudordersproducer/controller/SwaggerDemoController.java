package com.gofashion.gofashionspringcloudordersproducer.controller;

import com.alibaba.fastjson.JSON;
import com.gofashion.gofashionspringcloudordersproducer.service.SplitDataService;
import com.gofashion.gofashionspringcloudordersproducer.service.impl.SplitDataServiceImpl;
import com.gofashion.gofashionspringcloudordersproducer.service.redisservice.RedisFetchOrRemoveService;
import com.gofashion.gofashionspringcloudordersproducer.service.redisservice.RedisSaveService;
import com.gofashion.gofashionspringcloudordersproducer.service.redisservice.impl.RedisFetchOrRemoveServiceImpl;
import com.gofashion.gofashionspringcloudordersproducer.service.redisservice.impl.RedisSaveServiceImpl;
import com.gofashion.gofashionspringcloudordersproducer.service.vo.LogisticsEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/9/13.
 */
@RestController
@RequestMapping("api")
@Api(tags = "swaggerDemoController相关的api")
public class SwaggerDemoController {
    @Resource
    private SplitDataService splitDataService;
    @Resource
    private RedisSaveService redisSaveService;
    @Resource
    private RedisFetchOrRemoveService redisFetchOrRemoveService;

    @ApiOperation(value = "根据id查询学生信息", notes = "查询数据库中某个的学生信息")
    @ApiImplicitParam(name = "id", value = "学生ID", paramType = "path", required = true, dataType = "Integer")//required是否必须传
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getStudent(@PathVariable int id) {
       return "进来了么--------\t\t" + id;
    }

    @RequestMapping(value = "/testrabbitmq",method = RequestMethod.POST)
    public String test(){
        List<LogisticsEntity> logisticsEntityList1 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            LogisticsEntity logisticsEntity = new LogisticsEntity();
            logisticsEntity.setGoods_shopID(1);
            logisticsEntity.setGoods_id(2);
            logisticsEntity.setGoods_sku("AAAAAAAAAAA");
            logisticsEntity.setGoods_money(2.0);
            logisticsEntity.setGoods_quantity(6);
            logisticsEntity.setGoods_takeStatus(0);
            logisticsEntity.setLogistics_recipients("张");
            logisticsEntity.setLogistics_phone("12323156");
            logisticsEntity.setLogistics_address("sbdgytswvuqav");
            logisticsEntity.setLogistics_userId(1);
            logisticsEntity.setInformation_foundTime(new Date());
            logisticsEntityList1.add(logisticsEntity);
        }
        for (int i = 0; i < 2; i++) {
            LogisticsEntity logisticsEntity = new LogisticsEntity();
            logisticsEntity.setGoods_shopID(2);
            logisticsEntity.setGoods_id(2);
            logisticsEntity.setGoods_sku("AAAAAAAAAAA");
            logisticsEntity.setGoods_money(2.0);
            logisticsEntity.setGoods_quantity(6);
            logisticsEntity.setGoods_takeStatus(0);
            logisticsEntity.setLogistics_recipients("张");
            logisticsEntity.setLogistics_phone("12323156");
            logisticsEntity.setLogistics_address("sbdgytswvuqav");
            logisticsEntity.setLogistics_userId(1);
            logisticsEntity.setInformation_foundTime(new Date());
            logisticsEntityList1.add(logisticsEntity);
        }
//        String string1 = UUID.randomUUID().toString();
        String string = JSON.toJSONString(logisticsEntityList1);
        String s = splitDataService.splitTake(string);
        Boolean save = redisSaveService.save(s);
        System.out.println("AAAAAAAAAAAAAA\t" + save);
        redisFetchOrRemoveService.removeorfetch(3*1000,0);
        return "你猜";
    }
}
