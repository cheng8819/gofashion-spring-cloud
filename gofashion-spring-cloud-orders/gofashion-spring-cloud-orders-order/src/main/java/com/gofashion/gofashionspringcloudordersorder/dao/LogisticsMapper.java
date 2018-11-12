package com.gofashion.gofashionspringcloudordersorder.dao;

import com.gofashion.gofashionspringcloudordersorder.entity.Logistics;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface LogisticsMapper {

    //根据用户id去查询订单信息   的id     根据id去查询商品订单   的全部信息
    @Select("SELECT logistics_informationID FROM logistics WHERE logistics_userId=#{logistics_userId}")
    List<Logistics> selectInformationIDById(@Param("logistics_userId") Integer userid);

    //  订单信息  查询   订单物流信息
    @Select("SELECT logistics_id,logistics_status,logistics_recipients,logistics_phone,logistics_address,logistics_DHL,logistics_oddNumbers,logistics_leaveWord,logistics_deliverTime,logistics_informationID,logistics_userId FROM logistics WHERE logistics_informationID=#{logistics_informationID}")
    Logistics selectInfoByInformationID(@Param("logistics_informationID")Integer logistics_informationID);

    //动态sql
    //动态插入
    @InsertProvider(type = com.gofashion.gofashionspringcloudordersorder.uilt.dynamicsql.LogisticsDynaSqlProvider.class  ,method="insertSql")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertLogistics(Logistics logistics);

    //动态更新
    @UpdateProvider(type = com.gofashion.gofashionspringcloudordersorder.uilt.dynamicsql.LogisticsDynaSqlProvider.class  ,method="updateSql")
    int updateLogistics(Logistics logistics);
}