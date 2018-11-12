package com.gofashion.gofashionspringcloudordersdetails.uilt;

import com.gofashion.gofashionspringcloudordersdetails.entity.GfsDetail;
import org.apache.ibatis.jdbc.SQL;

public class GfsDetailDynaSqlProvider {
    //selectWhitEmployeeSql
    public String selectGfsDetailSql(GfsDetail gfsDetail) {
        return new SQL() {
            {
                SELECT("*");
                FROM("gfs_detail");
                if (gfsDetail.getDetail_id()!=null) {
                    WHERE("detail_id=#{detail_id}");
                }
                if(gfsDetail.getDetail_name()!=null) {
                    WHERE("detail_name=#{detail_name}");
                }
                if(gfsDetail.getDetail_sku()!=null) {
                    WHERE("detail_sku=#{detail_sku}");
                }
                if(gfsDetail.getDetail_number()!=null) {
                    WHERE("detail_number=#{detail_number}");
                }
                if(gfsDetail.getDetail_cost()!=null) {
                    WHERE("detail_cost=#{detail_cost}");
                }
                if(gfsDetail.getDetail_shop()!=null) {
                    WHERE("detail_shop=#{detail_shop}");
                }
                if(gfsDetail.getDetail_ordersId()!=null) {
                WHERE("detail_ordersId=#{detail_ordersId}");
                }
                if(gfsDetail.getDetail_a()!=null) {
                WHERE("detail_a=#{detail_a}");
                }
                if(gfsDetail.getDetail_b()!=null) {
                WHERE("detail_b=#{detail_b}");
                }
                if(gfsDetail.getDetail_c()!=null) {
                WHERE("detail_c=#{detail_c}");
                }
            }
        }.toString();
    }

    //insertEmployeeSql
    public String insertGfsDetailSql(GfsDetail gfsDetail) {
        return new SQL() {
            {
                INSERT_INTO("gfs_detail");
                if(gfsDetail.getDetail_id()!=null) {
                    VALUES("detail_id","#{detail_id}");
                }
                if(gfsDetail.getDetail_name()!=null) {
                    VALUES("detail_name", "#{detail_name}");
                }
                if(gfsDetail.getDetail_sku()!=null) {
                    VALUES("detail_sku", "#{detail_sku}");
                }
                if(gfsDetail.getDetail_number()!=null) {
                    VALUES("detail_number", "#{detail_number}");
                }
                if(gfsDetail.getDetail_cost()!=null) {
                    VALUES("detail_cost", "#{detail_cost}");
                }
                if(gfsDetail.getDetail_shop()!=null) {
                    VALUES("detail_shop", "#{detail_shop}");
                }
                if(gfsDetail.getDetail_ordersId()!=null) {
                    VALUES("detail_ordersid", "#{detail_ordersid}");
                }
                if(gfsDetail.getDetail_a()!=null) {
                    VALUES("detail_a", "#{detail_a}");
                }
                if(gfsDetail.getDetail_b()!=null) {
                    VALUES("detail_b", "#{detail_b}");
                }
                if(gfsDetail.getDetail_c()!=null) {
                    VALUES("detail_c", "#{detail_c}");
                }
            }
        }.toString();
    }

    //updateUserSql
    public String updateGfsDetailSql(GfsDetail gfsDetail) {
        return new SQL() {
            {
                UPDATE("gfs_detail");
                if(gfsDetail.getDetail_name()!=null) {
                    SET("detail_name=#{detail_name}");
                }
                if(gfsDetail.getDetail_sku()!=null) {
                    SET("detail_sku=#{detail_sku}");
                }
                if(gfsDetail.getDetail_number()!=null) {
                    SET("detail_number=#{detail_number}");
                }
                if(gfsDetail.getDetail_cost()!=null) {
                    SET("detail_cost=#{detail_cost}");
                }
                if(gfsDetail.getDetail_shop()!=null) {
                    SET("detail_shop=#{detail_shop}");
                }
                if(gfsDetail.getDetail_ordersId()!=null) {
                    SET("detail_ordersid=#{detail_ordersid}");
                }
                if(gfsDetail.getDetail_a()!=null) {
                    SET("detail_a=#{detail_a}");
                }
                if(gfsDetail.getDetail_b()!=null) {
                    SET("detail_b=#{detail_b}");
                }
                if(gfsDetail.getDetail_c()!=null) {
                    SET("detail_c=#{detail_c}");
                }
                WHERE("detail_id=#{detail_id}");
            }
        }.toString();
    }
}
