package com.gofashion.gofashionspringcloudordersproducer.controller;

import com.gofashion.gofashionspringcloudordersproducer.service.common.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("order")
@Api(tags = "订单业务的controller层")
public class OrderServiceController {
    @Resource
    private CancelGoodsService cancelGoodsService;   //取消订单
    @Resource
    private RemoveOrderService removeOrderService;  //删除订单
    @Resource
    private SelectAllGetByIdService selectAllGetByIdService; //根据用户id查询全部信息
    @Resource
    private SelectSingleGoodsDetailsService selectSingleGoodsDetailsService; //查询单条订单的详情
    @Resource
    private SelectStateService selectStateService; // 根据状态查询
    //取消订单   传入用户id 和订单编号
    @ApiOperation(value = "取消订单",notes = "把redis的订单取消")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid",value = "用户id",paramType = "Query",required = true,dataType = "Integer"),
            @ApiImplicitParam(name = "orderNumber",value = "订单编号",paramType = "Query",required = true,dataType = "String")
    })
    @RequestMapping(value = "cancelorder",method = RequestMethod.GET)
    public String cancellationororder(@RequestParam("userid") Integer information_userId,@RequestParam("orderNumber") String information_orderNumber){
        Boolean cancelgoods = cancelGoodsService.cancelgoods(information_userId, information_orderNumber);
        return null;
    }

    //删除订单
    @ApiOperation(value = "删除订单",notes = "用户删除订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid",value = "用户id",paramType = "Query",required = true,dataType = "Integer"),
            @ApiImplicitParam(name = "informationID",value = "订单信息外键",paramType = "Query",required = true,dataType = "Integer")
    })
    @RequestMapping(value = "deleteorder",method = RequestMethod.GET)
    public String deleteorder(@RequestParam("userid") Integer information_userId,@RequestParam("informationID") Integer goods_informationID){
        Boolean removeorder = removeOrderService.removeorder(information_userId, goods_informationID);
        return "";
    }

    //用户查询全部订单
    @ApiOperation(value = "查询全部订单信息",notes = "根据用户id查询订单")
    @ApiImplicitParam(name = "userid",value = "用户id",paramType = "Query",required = true,dataType = "Integer")
    @RequestMapping(value = "userGetAll",method = RequestMethod.GET)
    public String userGetAll(@RequestParam("userid") Integer information_userId){
        String s = selectAllGetByIdService.selectGetAllById(information_userId);
        return s;
    }

    //查询单条订单的详情
    @ApiOperation(value = "查询单条订单详情",notes = "根据用户ID和订单编号查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid",value = "用户id",paramType = "Query",required = true,dataType = "Integer"),
            @ApiImplicitParam(name = "orderNumber",value = "订单编号",paramType = "Query",required = true,dataType = "String")
    })
    @RequestMapping(value = "selectSingleOrder",method = RequestMethod.GET)
    public String selectSingleOrder(@RequestParam("userid") Integer information_userId,@RequestParam("orderNumber") String information_orderNumber){
        String s = selectSingleGoodsDetailsService.selectSingleGoodsDetails(information_userId, information_orderNumber);
        return s;
    }

    //String take, Integer state
    /*订单状态    交易成功(0),交易关闭(1) 待付款(3) 待发货(4) 待收货(5)  待评价(6)*/
    @ApiOperation(value = "查询等待付款",notes = "传入用户id查询-待付款")
    @ApiImplicitParam(name = "userid",value = "用户id",paramType = "Query",required = true,dataType = "Integer")
    @RequestMapping(value = "selectAwaitPayment",method = RequestMethod.GET)
    public String selectAwaitPayment(@RequestParam("userid") Integer information_userId){
        String s = selectStateService.selectStatus(information_userId,3);
        return s;
    }

    @ApiOperation(value = "查询等待发货",notes = "传入用户id查询-待发货")
    @ApiImplicitParam(name = "userid",value = "用户id",paramType = "Query",required = true,dataType = "Integer")
    @RequestMapping(value = "selectAwaitDeliver",method = RequestMethod.GET)
    public String selectAwaitDeliver(@RequestParam("userid") Integer information_userId){
        String s = selectStateService.selectStatus(information_userId,4);
        return s;
    }

    @ApiOperation(value = "查询等待收货",notes = "传入用户id查询-待收货")
    @ApiImplicitParam(name = "userid",value = "用户id",paramType = "Query",required = true,dataType = "Integer")
    @RequestMapping(value = "selectAwaitTake",method = RequestMethod.GET)
    public String selectAwaitTake(@RequestParam("userid") Integer information_userId){
        String s = selectStateService.selectStatus(information_userId,5);
        return s;
    }

    @ApiOperation(value = "查询等待评价",notes = "传入用户id查询-待评价")
    @ApiImplicitParam(name = "userid",value = "用户id",paramType = "Query",required = true,dataType = "Integer")
    @RequestMapping(value = "selectAwaitEvaluate",method = RequestMethod.GET)
    public String selectAwaitEvaluate(@RequestParam("userid") Integer information_userId){
        String s = selectStateService.selectStatus(information_userId,6);
        return s;
    }

}
