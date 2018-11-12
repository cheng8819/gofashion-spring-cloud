package com.gofashion.gofashionspringcloudordersdetails.uilt;

import com.gofashion.gofashionspringcloudordersdetails.entity.GfsOrders;
import org.apache.ibatis.jdbc.SQL;

public class GfsOrdersDynaSqlProvider {
    //selectWhitEmployeeSql
    public String selectGfsOrdersSql(GfsOrders gfsOrders) {
        return new SQL() {
            {
                SELECT("*");
                FROM("GfsOrders");
                if (gfsOrders.getOrders_id()!=null) {
                    WHERE("orders_id=#{ordersId}");
                }
                if(gfsOrders.getOrders_userId()!=null) {
                    WHERE("orders_userId=#{orders_userId}");
                }
                if(gfsOrders.getOrders_transactionNumber()!=null) {
                    WHERE("orders_transactionNumber=#{orders_transactionNumber}");
                }
                if(gfsOrders.getOrders_orderTime()!=null) {
                    WHERE("orders_orderTime=#{orders_orderTime}");
                }
                if(gfsOrders.getOrders_creationTime()!=null) {
                    WHERE("orders_creationTime=#{orders_creationTime}");
                }
                if(gfsOrders.getOrders_paidTime()!=null) {
                    WHERE("orders_paidTime=#{orders_paidTime}");
                }
                if(gfsOrders.getOrders_deliveryTime()!=null) {
                    WHERE("orders_deliveryTime=#{orders_deliveryTime}");
                }
                if(gfsOrders.getOrders_status()!=null) {
                    WHERE("orders_status=#{orders_status}");
                }
                if(gfsOrders.getOrders_receiveStatus()!=null) {
                    WHERE("orders_receiveStatus=#{orders_receiveStatus}");
                }
                if(gfsOrders.getOrders_coupon()!=null) {
                    WHERE("orders_coupon=#{orders_coupon}");
                }
                if(gfsOrders.getOrders_show()!=null) {
                    WHERE("orders_show=#{orders_show}");
                }
                if(gfsOrders.getOrders_b()!=null) {
                    WHERE("orders_b=#{orders_b}");
                }
                if(gfsOrders.getOrders_c()!=null) {
                    WHERE("orders_c=#{orders_c}");
                }
            }
        }.toString();
    }

    //insertEmployeeSql
    public String insertGfsOrdersSql(GfsOrders gfsOrders) {
        return new SQL() {
            {
                INSERT_INTO("GfsOrders");
                if (gfsOrders.getOrders_id()!=null) {
                    VALUES("orders_id","#{orders_id}");
                }
                if(gfsOrders.getOrders_userId()!=null) {
                    VALUES("orders_userId","#{orders_userId}");
                }
                if(gfsOrders.getOrders_transactionNumber()!=null) {
                    VALUES("orders_transactionNumber","#{orders_transactionNumber}");
                }
                if(gfsOrders.getOrders_orderTime()!=null) {
                    VALUES("orders_orderTime","#{orders_orderTime}");
                }
                if(gfsOrders.getOrders_creationTime()!=null) {
                    VALUES("orders_creationTime","#{orders_creationTime}");
                }
                if(gfsOrders.getOrders_paidTime()!=null) {
                    VALUES("orders_paidTime","#{orders_paidTime}");
                }
                if(gfsOrders.getOrders_deliveryTime()!=null) {
                    VALUES("orders_deliveryTime","#{orders_deliveryTime}");
                }
                if(gfsOrders.getOrders_status()!=null) {
                    VALUES("orders_status","#{orders_status}");
                }
                if(gfsOrders.getOrders_receiveStatus()!=null) {
                    VALUES("orders_receiveStatus","#{orders_receiveStatus}");
                }
                if(gfsOrders.getOrders_coupon()!=null) {
                    VALUES("orders_coupon","#{orders_coupon}");
                }
                if(gfsOrders.getOrders_show()!=null) {
                    VALUES("orders_show","#{orders_show}");
                }
                if(gfsOrders.getOrders_b()!=null) {
                    VALUES("orders_b","#{orders_b}");
                }
                if(gfsOrders.getOrders_c()!=null) {
                    VALUES("orders_c","#{orders_c}");
                }
            }
        }.toString();
    }

    //updateUserSql
    public String updateGfsOrdersSql(GfsOrders gfsOrders) {
        return new SQL() {
            {
                UPDATE("GfsOrders");
                if(gfsOrders.getOrders_userId()!=null) {
                    SET("orders_userId=#{orders_userId}");
                }
                if(gfsOrders.getOrders_transactionNumber()!=null) {
                    SET("orders_transactionNumber=#{orders_transactionNumber}");
                }
                if(gfsOrders.getOrders_orderTime()!=null) {
                    SET("orders_orderTime=#{orders_orderTime}");
                }
                if(gfsOrders.getOrders_creationTime()!=null) {
                    SET("orders_creationTime=#{orders_creationTime}");
                }
                if(gfsOrders.getOrders_paidTime()!=null) {
                    SET("orders_paidTime=#{orders_paidTime}");
                }
                if(gfsOrders.getOrders_deliveryTime()!=null) {
                    SET("orders_deliveryTime=#{orders_deliveryTime}");
                }
                if(gfsOrders.getOrders_status()!=null) {
                    SET("orders_status=#{orders_status}");
                }
                if(gfsOrders.getOrders_receiveStatus()!=null) {
                    SET("orders_receiveStatus=#{orders_receiveStatus}");
                }
                if(gfsOrders.getOrders_coupon()!=null) {
                    SET("orders_coupon=#{orders_coupon}");
                }
                if(gfsOrders.getOrders_show()!=null) {
                    SET("orders_show=#{orders_show}");
                }
                if(gfsOrders.getOrders_b()!=null) {
                    SET("orders_b=#{orders_b}");
                }
                if(gfsOrders.getOrders_c()!=null) {
                    SET("orders_c=#{orders_c}");
                }
                WHERE("orders_id=#{orders_id}");
            }
        }.toString();
    }
}
