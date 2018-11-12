package com.gofashion.gofashionspringcloudordersproducer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient      //要想将一个微服务注册到Eureka Server（或其他服务发现组件，例如Zookeeper、Consul等），Eureka 2.0闭源之后，Consul慢慢会成为主流。
@MapperScan("com.gofashion.gofashionspringcloudordersproducer.dao")
public class GofashionSpringCloudOrdersProducerApplication {
    //生产者
    public static void main(String[] args) {
        SpringApplication.run(GofashionSpringCloudOrdersProducerApplication.class, args);
    }
}
