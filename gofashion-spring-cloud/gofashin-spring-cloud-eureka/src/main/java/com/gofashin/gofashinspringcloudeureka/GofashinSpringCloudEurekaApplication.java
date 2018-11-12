package com.gofashin.gofashinspringcloudeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class GofashinSpringCloudEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(GofashinSpringCloudEurekaApplication.class, args);
    }
}
