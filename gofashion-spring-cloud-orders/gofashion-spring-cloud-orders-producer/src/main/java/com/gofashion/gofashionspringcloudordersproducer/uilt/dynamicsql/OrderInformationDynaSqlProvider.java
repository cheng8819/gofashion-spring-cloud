package com.gofashion.gofashionspringcloudordersproducer.uilt.dynamicsql;

import com.gofashion.gofashionspringcloudordersproducer.entity.OrderInformation;
import org.apache.ibatis.jdbc.SQL;

public class OrderInformationDynaSqlProvider {
    //insertEmployeeSql
    public String insertSql(OrderInformation orderInformation) {
        return new SQL() {
            {
                INSERT_INTO("order_information");
                if(orderInformation.getInformation_id()!=null) {
                    VALUES("information_id","#{information_id}");
                }
                if(orderInformation.getInformation_orderNumber()!=null) {
                    VALUES("information_orderNumber", "#{information_orderNumber}");
                }
                if(orderInformation.getInformation_deal()!=null) {
                    VALUES("information_deal", "#{information_deal}");
                }
                if(orderInformation.getInformation_foundTime()!=null) {
                    VALUES("information_foundTime", "#{information_foundTime}");
                }
                if(orderInformation.getInformation_paymentTime()!=null) {
                    VALUES("information_paymentTime", "#{information_paymentTime}");
                }
                if(orderInformation.getInformation_clinchTime()!=null) {
                    VALUES("information_clinchTime", "#{information_clinchTime}");
                }
                if(orderInformation.getInformation_userId()!=null) {
                    VALUES("information_userId", "#{information_userId}");
                }
                if(orderInformation.getInformation_a()!=null) {
                    VALUES("information_a", "#{information_a}");
                }
                if(orderInformation.getInformation_b()!=null) {
                    VALUES("information_b", "#{information_b}");
                }
                if(orderInformation.getInformation_c()!=null) {
                    VALUES("information_c", "#{information_c}");
                }
            }
        }.toString();
    }

    //updateUserSql
    public String updateSql(OrderInformation orderInformation) {
        return new SQL() {
            {
                UPDATE("order_information");
                if(orderInformation.getInformation_orderNumber()!=null) {
                    SET("information_orderNumber=#{information_orderNumber}");
                }
                if(orderInformation.getInformation_deal()!=null) {
                    SET("information_deal=#{information_deal}");
                }
                if(orderInformation.getInformation_foundTime()!=null) {
                    SET("information_foundTime=#{information_foundTime}");
                }
                if(orderInformation.getInformation_paymentTime()!=null) {
                    SET("information_paymentTime=#{information_paymentTime}");
                }
                if(orderInformation.getInformation_clinchTime()!=null) {
                    SET("information_clinchTime=#{information_clinchTime}");
                }
                if(orderInformation.getInformation_userId()!=null) {
                    SET("information_userId=#{information_userId}");
                }
                if(orderInformation.getInformation_a()!=null) {
                    SET("information_a=#{information_a}");
                }
                if(orderInformation.getInformation_b()!=null) {
                    SET("information_b=#{information_b}");
                }
                if(orderInformation.getInformation_c()!=null) {
                    SET("information_c=#{information_c}");
                }
                WHERE("information_id=#{information_id}");
            }
        }.toString();
    }
}
