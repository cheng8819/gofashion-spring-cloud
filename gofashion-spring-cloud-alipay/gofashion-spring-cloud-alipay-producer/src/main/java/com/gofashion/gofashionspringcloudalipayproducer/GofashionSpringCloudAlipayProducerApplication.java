package com.gofashion.gofashionspringcloudalipayproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GofashionSpringCloudAlipayProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(GofashionSpringCloudAlipayProducerApplication.class, args);
    }
}
