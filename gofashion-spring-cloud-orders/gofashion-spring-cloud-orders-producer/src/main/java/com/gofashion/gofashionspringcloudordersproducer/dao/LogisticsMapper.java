package com.gofashion.gofashionspringcloudordersproducer.dao;

import com.gofashion.gofashionspringcloudordersproducer.entity.Logistics;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LogisticsMapper {
    //查询  根据物流id查
    @Select("SELECT logistics_id,logistics_status,logistics_recipients,logistics_phone,logistics_address,logistics_DHL,logistics_oddNumbers,logistics_leaveWord,logistics_deliverTime,logistics_informationID FROM logistics WHERE logistics_id=#{logistics_id}")
    Logistics selectGetSingleBylogisticsid(@Param("logistics_id") Integer logistics_id);

    //查询  根据物流id查
    @Select("SELECT logistics_id,logistics_status,logistics_recipients,logistics_phone,logistics_address,logistics_DHL,logistics_oddNumbers,logistics_leaveWord,logistics_deliverTime,logistics_informationID FROM logistics WHERE logistics_informationID=#{logistics_informationID}")
    Logistics selectGetSingleByinformationID(@Param("logistics_informationID") Integer logistics_informationID);
    //动态sql       logistics_informationID
    //动态插入
    @InsertProvider(type = com.gofashion.gofashionspringcloudordersproducer.uilt.dynamicsql.LogisticsDynaSqlProvider.class  ,method="insertSql")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertLogistics(Logistics logistics);

    //动态更新
    @UpdateProvider(type = com.gofashion.gofashionspringcloudordersproducer.uilt.dynamicsql.GoodsOrderDynaSqlProvider.class  ,method="updateSql")
    int updateLogistics(Logistics logistics);
}