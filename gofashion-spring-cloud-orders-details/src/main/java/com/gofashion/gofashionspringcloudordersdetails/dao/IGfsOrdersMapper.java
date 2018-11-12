package com.gofashion.gofashionspringcloudordersdetails.dao;

import com.github.pagehelper.Page;
import com.gofashion.gofashionspringcloudordersdetails.entity.GfsOrders;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IGfsOrdersMapper {

    //分页
    @Select("select orders_id,orders_userId,orders_transactionNumber,orders_orderTime,orders_creationTime,orders_paidTime,orders_deliveryTime,orders_status,orders_receiveStatus,orders_show from gfs_orders")
    Page<GfsOrders> gfsordersPageing();

    //根据用户id查询   用户ID不唯一
    @Select("select orders_id,orders_userId,orders_transactionNumber,orders_orderTime,orders_creationTime,orders_paidTime,orders_deliveryTime,orders_status,orders_receiveStatus,orders_show from gfs_orders where orders_userId=#{orders_userId}")
    List<GfsOrders> selectUserId(@Param("orders_userId") Integer orders_userId);


    //动态sql
    //动态查询
    @SelectProvider(type= com.gofashion.gofashionspringcloudordersdetails.uilt.GfsOrdersDynaSqlProvider.class ,method="selectGfsOrdersSql")
    List<GfsOrders> selectDsGfsOrders(GfsOrders gfsOrders);

    //动态插入
    @InsertProvider(type = com.gofashion.gofashionspringcloudordersdetails.uilt.GfsOrdersDynaSqlProvider.class  ,method="insertGfsOrdersSql")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertDsGfsGfsOrders(GfsOrders gfsOrders);

    //动态更新
    @UpdateProvider(type = com.gofashion.gofashionspringcloudordersdetails.uilt.GfsOrdersDynaSqlProvider.class  ,method="updateGfsOrdersSql")
    int updateDsGfsOrders(GfsOrders gfsOrders);
}