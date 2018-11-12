package com.gofashion.gofashionspringcloudordersconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient      //服务
@EnableFeignClients     //  feign调服务
@EnableCircuitBreaker    //
//微服务 通过EnableFeignClients调用其他服务的api
public class GofashionSpringCloudOrdersConsumerApplication {
    //消费者
    public static void main(String[] args) {
        SpringApplication.run(GofashionSpringCloudOrdersConsumerApplication.class, args);
    }
}
