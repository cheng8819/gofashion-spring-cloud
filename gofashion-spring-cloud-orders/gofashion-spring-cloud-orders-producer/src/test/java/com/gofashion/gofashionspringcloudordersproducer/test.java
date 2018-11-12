package com.gofashion.gofashionspringcloudordersproducer;

import com.alibaba.fastjson.JSONArray;
import com.gofashion.gofashionspringcloudordersproducer.service.vo.RedisTimeEntity;

import java.util.List;

public class test {
    public static void main(String[] args) {
        String take = "[\"{\\\"orderNumber\\\":[\\\"20181102178033577\\\",\\\"20181102178033577\\\",\\\"20181102178033577\\\",\\\"20181102178033514\\\",\\\"20181102178033514\\\"],\\\"time\\\":1542021780337,\\\"type\\\":0,\\\"userid\\\":1}\"],[\"{\\\"orderNumber\\\":[\\\"20181102178786513\\\",\\\"20181102178786513\\\",\\\"20181102178786513\\\",\\\"20181102178786586\\\",\\\"20181102178786586\\\"],\\\"time\\\":1542021787867,\\\"type\\\":0,\\\"userid\\\":1}\"],[\"{\\\"orderNumber\\\":[\\\"20181102191544591\\\",\\\"20181102191544591\\\",\\\"20181102191544591\\\",\\\"20181102191544511\\\",\\\"20181102191544511\\\"],\\\"time\\\":1542021915450,\\\"type\\\":0,\\\"userid\\\":1}\"],[\"{\\\"orderNumber\\\":[\\\"20181102214481405\\\",\\\"20181102214481405\\\",\\\"20181102214481405\\\",\\\"20181102214481452\\\",\\\"20181102214481452\\\"],\\\"time\\\":1542022144820,\\\"type\\\":0,\\\"userid\\\":1}\"],[\"{\\\"orderNumber\\\":[\\\"20181102229114674\\\",\\\"20181102229114674\\\",\\\"20181102229114674\\\",\\\"20181102229114609\\\",\\\"20181102229114609\\\"],\\\"time\\\":1542022291152,\\\"type\\\":0,\\\"userid\\\":1}\"]";


        List<RedisTimeEntity> redisTimeEntityList = JSONArray.parseArray(take, RedisTimeEntity.class);
        for (RedisTimeEntity redisTimeEntity : redisTimeEntityList) {
            System.out.println(redisTimeEntity.getOrderNumber());
        }
    }
}
