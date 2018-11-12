package com.gofashion.gofashionspringcloudordersorder.dao;

import com.gofashion.gofashionspringcloudordersorder.entity.OrderInformation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface OrderInformationMapper {

    //根据订单编号去查询订单信息id
    @Select("SELECT information_id FROM order_information WHERE information_orderNumber=#{information_orderNumber}")
    OrderInformation selectinformationOrderNumberById(@Param("information_orderNumber") String information_orderNumber);

    @Select("SELECT information_id,information_orderNumber,information_deal,information_foundTime,information_paymentTime,information_clinchTime FROM order_information WHERE information_id=#{information_id}")
    LogisticsMapper selectInfoByInformationId(@Param("information_id") Integer information_id);

    //动态sql
    //动态插入
    @InsertProvider(type = com.gofashion.gofashionspringcloudordersorder.uilt.dynamicsql.OrderInformationDynaSqlProvider.class  ,method="insertSql")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertOrderInformation(OrderInformation orderInformation);

    //动态更新
    @UpdateProvider(type = com.gofashion.gofashionspringcloudordersorder.uilt.dynamicsql.OrderInformationDynaSqlProvider.class  ,method="updateSql")
    int updateOrderInformation(OrderInformation orderInformation);
}