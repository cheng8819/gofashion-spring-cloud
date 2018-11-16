package com.gofashion.gofashionspringcloudordersproducer.uilt.dynamicsql;

import com.gofashion.gofashionspringcloudordersproducer.entity.Logistics;
import org.apache.ibatis.jdbc.SQL;

public class LogisticsDynaSqlProvider {
    //insertEmployeeSql
    public String insertSql(Logistics logistics) {
        return new SQL() {
            {
                INSERT_INTO("logistics");
                if (logistics.getLogistics_id()!=null) {
                    VALUES("logistics_id","#{logistics_id}");
                }
                if(logistics.getLogistics_status()!=null) {
                    VALUES("logistics_status","#{logistics_status}");
                }
                if(logistics.getLogistics_recipients()!=null) {
                    VALUES("logistics_recipients","#{logistics_recipients}");
                }
                if(logistics.getLogistics_phone()!=null) {
                    VALUES("logistics_phone","#{logistics_phone}");
                }
                if(logistics.getLogistics_address()!=null) {
                    VALUES("logistics_address","#{logistics_address}");
                }
                if(logistics.getLogistics_DHL()!=null) {
                    VALUES("logistics_DHL","#{logistics_DHL}");
                }
                if(logistics.getLogistics_oddNumbers()!=null) {
                    VALUES("logistics_oddNumbers","#{logistics_oddNumbers}");
                }
                if(logistics.getLogistics_leaveWord()!=null) {
                    VALUES("logistics_leaveWord","#{logistics_leaveWord}");
                }
                if(logistics.getLogistics_deliverTime()!=null) {
                    VALUES("logistics_deliverTime","#{logistics_deliverTime}");
                }
                if(logistics.getLogistics_informationID()!=null) {
                    VALUES("logistics_informationID","#{logistics_informationID}");
                }
                if(logistics.getLogistics_a()!=null) {
                    VALUES("logistics_a","#{logistics_a}");
                }
                if(logistics.getLogistics_b()!=null) {
                    VALUES("logistics_b","#{logistics_b}");
                }
                if(logistics.getLogistics_c()!=null) {
                    VALUES("logistics_c","#{logistics_c}");
                }
            }
        }.toString();
    }
    //updateUserSql
    public String updateSql(Logistics logistics) {
        return new SQL() {
            {
                UPDATE("logistics");
                if(logistics.getLogistics_status()!=null) {
                    SET("logistics_status=#{logistics_status}");
                }
                if(logistics.getLogistics_recipients()!=null) {
                    SET("logistics_recipients=#{logistics_recipients}");
                }
                if(logistics.getLogistics_phone()!=null) {
                    SET("logistics_phone=#{logistics_phone}");
                }
                if(logistics.getLogistics_address()!=null) {
                    SET("logistics_address=#{logistics_address}");
                }
                if(logistics.getLogistics_DHL()!=null) {
                    SET("logistics_DHL=#{logistics_DHL}");
                }
                if(logistics.getLogistics_oddNumbers()!=null) {
                    SET("logistics_oddNumbers=#{logistics_oddNumbers}");
                }
                if(logistics.getLogistics_leaveWord()!=null) {
                    SET("logistics_leaveWord=#{logistics_leaveWord}");
                }
                if(logistics.getLogistics_deliverTime()!=null) {
                    SET("logistics_deliverTime=#{logistics_deliverTime}");
                }
                if(logistics.getLogistics_informationID()!=null) {
                    SET("logistics_informationID=#{logistics_informationID}");
                }
                if(logistics.getLogistics_a()!=null) {
                    SET("logistics_a=#{logistics_a}");
                }
                if(logistics.getLogistics_b()!=null) {
                    SET("logistics_b=#{logistics_b}");
                }
                if(logistics.getLogistics_c()!=null) {
                    SET("logistics_c=#{logistics_c}");
                }
                WHERE("logistics_id=#{logistics_id}");
            }
        }.toString();
    }
}
