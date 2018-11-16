package com.gofashion.gofashionspringcloudordersproducer.dao;

import com.gofashion.gofashionspringcloudordersproducer.entity.OrderInformation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderInformationMapper {
    //根据用户id查询     订单编号
    @Select("SELECT information_id FROM order_information WHERE information_userId=#{information_userId}")
    List<OrderInformation> selectOrderInformationById(@Param("information_userId") Integer information_userId);
    //根据 订单表id查询          有支付的
    @Select("SELECT information_id,information_orderNumber,information_deal,information_foundTime,information_paymentTime,information_clinchTime,information_userId FROM order_information WHERE information_userId=#{information_userId}")
    List<OrderInformation> selectGetAllById(@Param("information_userId") Integer information_userId);


    //根据 订单表id查询          没支付的
    @Select("SELECT information_id,information_orderNumber,information_deal,information_foundTime,information_clinchTime,information_userId FROM order_information WHERE information_userId=#{information_userId}")
    List<OrderInformation> selectGetAllByIds(@Param("information_userId") Integer information_userId);

    //根据  订单id查
    @Select("SELECT information_id,information_orderNumber,information_deal,information_foundTime,information_paymentTime,information_clinchTime,information_userId FROM order_information WHERE information_id=#{information_id}")
    OrderInformation selectSingleGoods(@Param("information_id") Integer information_id);

    //根据订单编号去查询订单信息id
    @Select("SELECT information_id,information_orderNumber FROM order_information WHERE information_orderNumber=#{information_orderNumber}")
    OrderInformation selectinformationOrderNumberById(@Param("information_orderNumber") String information_orderNumber);

    @Select("SELECT information_id,information_orderNumber,information_userId FROM order_information WHERE information_orderNumber=#{information_orderNumber} AND information_userId=#{information_userId}")
    OrderInformation selectinfoOrderNumberById(@Param("information_orderNumber") String information_orderNumber,@Param("information_userId")Integer information_userId);
    //动态sql
    //动态插入
    @InsertProvider(type = com.gofashion.gofashionspringcloudordersproducer.uilt.dynamicsql.OrderInformationDynaSqlProvider.class  ,method="insertSql")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertOrderInformation(OrderInformation orderInformation);

    //动态更新
    @UpdateProvider(type = com.gofashion.gofashionspringcloudordersproducer.uilt.dynamicsql.OrderInformationDynaSqlProvider.class  ,method="updateSql")
    int updateOrderInformation(OrderInformation orderInformation);
}