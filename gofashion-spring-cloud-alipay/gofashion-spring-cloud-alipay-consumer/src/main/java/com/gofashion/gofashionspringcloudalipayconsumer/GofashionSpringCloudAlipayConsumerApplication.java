package com.gofashion.gofashionspringcloudalipayconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableDiscoveryClient      //服务
@EnableFeignClients     //  feign调服务
@EnableCircuitBreaker    //熔断
@SpringBootApplication
public class GofashionSpringCloudAlipayConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GofashionSpringCloudAlipayConsumerApplication.class, args);
    }
}
