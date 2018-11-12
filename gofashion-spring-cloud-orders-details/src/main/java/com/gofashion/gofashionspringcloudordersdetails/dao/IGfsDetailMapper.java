package com.gofashion.gofashionspringcloudordersdetails.dao;

import com.github.pagehelper.Page;
import com.gofashion.gofashionspringcloudordersdetails.entity.GfsDetail;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGfsDetailMapper {
    //根据String detailOrdersid查询
    @Select("select detail_id,detail_name,detail_sku,detail_number,detail_cost,detail_shop,detail_ordersId from gfs_detail")
//    @Select("select * from gfs_detail")
    Page<GfsDetail> gfsDetailPaging();

    //根据订单ID查询
    @Select("select detail_id,detail_name,detail_sku,detail_number,detail_cost,detail_shop,detail_ordersId from gfs_detail where detail_ordersId=#{detail_ordersId}")
    List<GfsDetail> selectByOrdersId(@Param("detail_ordersId") String detail_ordersId);

    //动态sql
    //动态查询
    @SelectProvider(type= com.gofashion.gofashionspringcloudordersdetails.uilt.GfsDetailDynaSqlProvider.class ,method="selectGfsDetailSql")
    List<GfsDetail> selectDsGfsDetail(GfsDetail gfsDetail);

    //动态插入
    @InsertProvider(type = com.gofashion.gofashionspringcloudordersdetails.uilt.GfsDetailDynaSqlProvider.class  ,method="insertGfsDetailSql")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertDsGfsDetail(GfsDetail gfsDetail);

    //动态更新
    @UpdateProvider(type = com.gofashion.gofashionspringcloudordersdetails.uilt.GfsDetailDynaSqlProvider.class  ,method="updateGfsDetailSql")
    int updateDsGfsDetail(GfsDetail gfsDetail);
}