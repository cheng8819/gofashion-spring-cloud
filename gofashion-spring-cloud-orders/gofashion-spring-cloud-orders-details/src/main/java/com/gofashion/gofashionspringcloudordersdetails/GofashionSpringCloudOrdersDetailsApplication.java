package com.gofashion.gofashionspringcloudordersdetails;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gofashion.gofashionspringcloudordersdetails.dao")
public class GofashionSpringCloudOrdersDetailsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GofashionSpringCloudOrdersDetailsApplication.class, args);
    }
}
