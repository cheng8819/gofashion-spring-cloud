package com.gofashion.gofashionspringcloudzuul;

import com.gofashion.gofashionspringcloudzuul.filters.post.TokenFilter;
import com.gofashion.gofashionspringcloudzuul.filters.pre.LoginFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class GofashionSpringCloudZuulApplication {

    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }
    @Bean
    public LoginFilter loginFilter() {
        return new LoginFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(GofashionSpringCloudZuulApplication.class, args);
    }
}
