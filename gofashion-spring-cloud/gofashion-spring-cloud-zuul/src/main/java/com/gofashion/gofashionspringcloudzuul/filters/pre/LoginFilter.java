package com.gofashion.gofashionspringcloudzuul.filters.pre;

import com.alibaba.fastjson.JSON;
import com.gofashion.gofashionspringcloudzuul.token.JwtTokenProvider;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginFilter extends ZuulFilter {
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    private RequestContext ctx;
    private HttpServletRequest request;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        ctx = RequestContext.getCurrentContext();
        request = ctx.getRequest();
        String requestURI = request.getRequestURI();
        if (!"/userinfos/login".equals(requestURI) && !"/userinfos/signIn".equals(requestURI)) {
            System.out.println("shouldFilter");
            return true;
        }
        return false;
    }

    @Override
    public Object run() {
        Cookie[] cookies = request.getCookies();
        System.out.println("run");
        String token = "";
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    token = cookie.getValue();
                }
            }
            Claims claims = jwtTokenProvider.validataToken(token);
            Integer userId = Integer.parseInt((String) claims.get("sub"));
            System.out.println(userId);
            request.getParameterMap();
            Map<String, List<String>> requestQueryParams = ctx.getRequestQueryParams();
            if (requestQueryParams == null) {
                requestQueryParams = new HashMap<>();
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(userId + "");
            requestQueryParams.put("userId", arrayList);
            System.out.println(JSON.toJSONString(requestQueryParams));
            ctx.setRequestQueryParams(requestQueryParams);
        } else {
            System.out.println("else");
            ctx.setResponseBody("未登陆");
        }
        return null;
    }
}
