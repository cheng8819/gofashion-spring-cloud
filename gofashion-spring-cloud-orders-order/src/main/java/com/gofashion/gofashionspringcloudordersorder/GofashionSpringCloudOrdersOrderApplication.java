package com.gofashion.gofashionspringcloudordersorder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gofashion.gofashionspringcloudordersorder.dao")
public class GofashionSpringCloudOrdersOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(GofashionSpringCloudOrdersOrderApplication.class, args);
    }
}
