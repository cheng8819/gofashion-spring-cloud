package com.gofashion.gofashionspringcloudsleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class GofashionSpringCloudSleuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(GofashionSpringCloudSleuthApplication.class, args);
    }
}
