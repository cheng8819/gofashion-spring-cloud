package com.gofashion.gofashionspringcloudordersorder.dao;

import com.gofashion.gofashionspringcloudordersorder.entity.GoodsOrder;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GoodsOrderMapper {
    //根据订单id goods_informationID   查询全部信息   并且是显示的goods_show
    @Select("SELECT goods_id,goods_sku,goods_money,goods_quantity,goods_orderStatus,goods_takeStatus,goods_show,goods_estimate,goods_informationID,goods_shopID FROM goods_order WHERE goods_informationID=#{goods_informationID} AND goods_show=0")
    List<GoodsOrder> selectAllById(@Param("goods_informationID")Integer goods_informationID);

    //更改状态的
    //根据id查询 goods_orderID   订单信息外键  goods_informationID
    @Select("SELECT goods_informationID FROM goods_order WHERE goods_orderID=#{goods_orderID}")
    GoodsOrder selectInformationIDById(@Param("goods_orderID") Integer goods_orderID);
    //
    @Select("SELECT goods_orderID FROM goods_order WHERE goods_informationID=#{goods_informationID}")
    List<GoodsOrder> selectgoodsorderlist(@Param("goods_informationID")Integer goods_informationID);
    /*UPDATE table_name SET field1=new-value1, field2=new-value2
[WHERE Clause]*/
    //更具商品的id  更改状态为1   则不显示
    @Update("UPDATE goods_order SET goods_show=1 WHERE goods_orderID=#{goods_orderID}")
    int updatestate(@Param("goods_orderID")Integer goods_orderID);

    @Select("SELECT goods_orderID,goods_id,goods_sku,goods_money,goods_quantity,goods_orderStatus,goods_takeStatus,goods_show,goods_estimate,goods_informationID,goods_shopID FROM goods_order WHERE goods_orderID=#{goods_orderID} AND goods_show=0")
    GoodsOrder selectInfoByorderID(@Param("goods_orderID") Integer goods_orderID);

    //动态sql
    //动态插入
    @InsertProvider(type = com.gofashion.gofashionspringcloudordersorder.uilt.dynamicsql.GoodsOrderDynaSqlProvider.class  ,method="insertSql")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertGoodsOrder(GoodsOrder goodsOrder);

    //动态更新
    @UpdateProvider(type = com.gofashion.gofashionspringcloudordersorder.uilt.dynamicsql.GoodsOrderDynaSqlProvider.class  ,method="updateSql")
    int updateGoodsOrder(GoodsOrder goodsOrder);

}