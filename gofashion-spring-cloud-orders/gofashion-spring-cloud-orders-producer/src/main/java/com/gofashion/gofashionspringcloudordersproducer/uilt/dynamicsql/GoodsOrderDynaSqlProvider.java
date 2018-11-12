package com.gofashion.gofashionspringcloudordersproducer.uilt.dynamicsql;

import com.gofashion.gofashionspringcloudordersproducer.entity.GoodsOrder;
import org.apache.ibatis.jdbc.SQL;

public class GoodsOrderDynaSqlProvider {
    //insertEmployeeSql
    public String insertSql(GoodsOrder goodsOrder) {
        return new SQL() {
            {
                INSERT_INTO("goods_order");
                if (goodsOrder.getGoods_orderID()!=null) {
                    VALUES("goods_orderID","#{goods_orderID}");
                }
                if(goodsOrder.getGoods_id()!=null) {
                    VALUES("goods_id","#{goods_id}");
                }
                if(goodsOrder.getGoods_sku()!=null) {
                    VALUES("goods_sku","#{goods_sku}");
                }
                if(goodsOrder.getGoods_money()!=null) {
                    VALUES("goods_money","#{goods_money}");
                }
                if(goodsOrder.getGoods_quantity()!=null) {
                    VALUES("goods_quantity","#{goods_quantity}");
                }
                if(goodsOrder.getGoods_orderStatus()!=null) {
                    VALUES("goods_orderStatus","#{goods_orderStatus}");
                }
                if(goodsOrder.getGoods_takeStatus()!=null) {
                    VALUES("goods_takeStatus","#{goods_takeStatus}");
                }
                if(goodsOrder.getGoods_show()!=null) {
                    VALUES("goods_show","#{goods_show}");
                }
                if(goodsOrder.getGoods_estimate()!=null) {
                    VALUES("goods_estimate","#{goods_estimate}");
                }
                if(goodsOrder.getGoods_informationID()!=null) {
                    VALUES("goods_informationID","#{goods_informationID}");
                }
                if(goodsOrder.getGoods_shopID()!=null) {
                    VALUES("goods_shopID","#{goods_shopID}");
                }
                if(goodsOrder.getGoods_a()!=null) {
                    VALUES("goods_a","#{goods_a}");
                }
                if(goodsOrder.getGoods_b()!=null) {
                    VALUES("goods_b","#{goods_b}");
                }
                if(goodsOrder.getGoods_c()!=null) {
                    VALUES("goods_c","#{goods_c}");
                }
            }
        }.toString();
    }

    //updateUserSql
    public String updateSql(GoodsOrder goodsOrder) {
        return new SQL() {
            {
                UPDATE("goods_order");
                if(goodsOrder.getGoods_id()!=null) {
                    SET("goods_id=#{goods_id}");
                }
                if(goodsOrder.getGoods_sku()!=null) {
                    SET("goods_sku=#{goods_sku}");
                }
                if(goodsOrder.getGoods_money()!=null) {
                    SET("goods_money=#{goods_money}");
                }
                if(goodsOrder.getGoods_quantity()!=null) {
                    SET("goods_quantity=#{goods_quantity}");
                }
                if(goodsOrder.getGoods_orderStatus()!=null) {
                    SET("goods_orderStatus=#{goods_orderStatus}");
                }
                if(goodsOrder.getGoods_takeStatus()!=null) {
                    SET("goods_takeStatus=#{goods_takeStatus}");
                }
                if(goodsOrder.getGoods_show()!=null) {
                    SET("goods_show=#{goods_show}");
                }
                if(goodsOrder.getGoods_estimate()!=null) {
                    SET("goods_estimate=#{goods_estimate}");
                }
                if(goodsOrder.getGoods_informationID()!=null) {
                    SET("goods_informationID=#{goods_informationID}");
                }
                if(goodsOrder.getGoods_shopID()!=null) {
                    SET("goods_shopID=#{goods_shopID}");
                }
                if(goodsOrder.getGoods_a()!=null) {
                    SET("goods_a=#{goods_a}");
                }
                if(goodsOrder.getGoods_b()!=null) {
                    SET("goods_b=#{goods_b}");
                }
                if(goodsOrder.getGoods_c()!=null) {
                    SET("goods_c=#{goods_c}");
                }
                WHERE("goods_orderID=#{goods_orderID}");
            }
        }.toString();
    }
}
