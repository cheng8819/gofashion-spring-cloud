package com.gofashion.gofashionspringcloudzuul;

import com.gofashion.gofashionspringcloudzuul.token.JwtTokenProvider;
import io.jsonwebtoken.Claims;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GofashionSpringCloudZuulApplicationTests {
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Test
    public void contextLoads() {
        String token = jwtTokenProvider.createToken("12345");
        Claims claims = jwtTokenProvider.validataToken(token);
        System.out.println("token = " + token);
        System.out.println("claims = " + claims);
    }

}
