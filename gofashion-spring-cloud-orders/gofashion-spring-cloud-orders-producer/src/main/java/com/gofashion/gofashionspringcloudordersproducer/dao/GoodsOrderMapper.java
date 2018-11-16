package com.gofashion.gofashionspringcloudordersproducer.dao;

import com.gofashion.gofashionspringcloudordersproducer.entity.GoodsOrder;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GoodsOrderMapper {
    //根据  订单信息外键   查询  信息
    @Select("SELECT goods_orderID,goods_id,goods_sku,goods_money,goods_quantity,goods_orderStatus,goods_show,goods_takeStatus,goods_estimate,goods_informationID,goods_shopID FROM goods_order WHERE goods_informationID=#{goods_informationID} AND goods_show=0")
    List<GoodsOrder> selectGoodsOrderByInformationID(@Param("goods_informationID") Integer goods_informationID);



    //查询状态
    @Select("SELECT goods_orderID,goods_id,goods_sku,goods_money,goods_quantity,goods_orderStatus,goods_show,goods_takeStatus,goods_estimate,goods_informationID,goods_shopID FROM goods_order WHERE goods_informationID=#{goods_informationID} AND goods_show=0 AND goods_orderStatus=#{goods_orderStatus}")
    List<GoodsOrder> selectGoodsStateByInformationID(@Param("goods_orderStatus")Integer goods_orderStatus ,@Param("goods_informationID") Integer goods_informationID);
//    UPDATE table_name SET field1=new-value1, field2=new-value2     [WHERE Clause]
    //   删除show   显示数据
    @Update("UPDATE goods_order SET goods_show=1 WHERE goods_orderID=#{goods_orderID}")
    int updateOneOrderDate(@Param("goods_orderID")Integer goods_orderID);

    //根据商品id查询  数据
    @Select("SELECT goods_orderID,goods_id,goods_sku,goods_money,goods_quantity,goods_orderStatus,goods_takeStatus,goods_estimate,goods_informationID,goods_shopID FROM goods_order WHERE goods_orderID=#{goods_orderID} AND goods_show=0")
    GoodsOrder selectgetByOrderId(@Param("goods_orderID")Integer goods_orderID);

    //动态sql
    //动态插入
    @InsertProvider(type = com.gofashion.gofashionspringcloudordersproducer.uilt.dynamicsql.GoodsOrderDynaSqlProvider.class  ,method="insertSql")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertGoodsOrder(GoodsOrder goodsOrder);

    //动态更新
    @UpdateProvider(type = com.gofashion.gofashionspringcloudordersproducer.uilt.dynamicsql.GoodsOrderDynaSqlProvider.class  ,method="updateSql")
    int updateGoodsOrder(GoodsOrder goodsOrder);
}