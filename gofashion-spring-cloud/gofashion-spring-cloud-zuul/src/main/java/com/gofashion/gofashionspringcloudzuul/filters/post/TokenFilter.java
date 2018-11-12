
package com.gofashion.gofashionspringcloudzuul.filters.post;

import com.alibaba.fastjson.JSONObject;
import com.gofashion.gofashionspringcloudzuul.pojo.LoginReturn;
import com.gofashion.gofashionspringcloudzuul.token.JwtTokenProvider;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * 验证token合法性。
 */
@Component
public class TokenFilter extends ZuulFilter {
    protected static final Logger logger = LoggerFactory.getLogger(TokenFilter.class);
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    private RequestContext ctx;
    private HttpServletRequest request;
    @Override
    public String filterType() {
        return "post";
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
        if ("/userinfos/login".equals(requestURI)) {
            return true;
        }
        return false;
    }

    @Override
    public Object run() {
        // 先获取token字段，如果没有，从Authentication获取
        String requestURI = request.getRequestURI();
        InputStream stream = ctx.getResponseDataStream();
            try {
                String s = StreamUtils.copyToString(stream, Charset.forName("UTF-8"));
                stream.close();
                LoginReturn loginReturn = null;
                if (s != null){
                    loginReturn = JSONObject.parseObject(s, LoginReturn.class);
                }
                if (loginReturn.getSateCode().equals("2000")) {
                    String token = jwtTokenProvider.createToken(String.valueOf(loginReturn.getUserId()));
                    Cookie cookie = new Cookie("token", token);
                    cookie.setPath("/");
                    cookie.setSecure(false);
                    cookie.setMaxAge(60*60*24*7);
                    ctx.getResponse().addCookie(cookie);
                    ctx.setResponseBody(s);
                }else if (loginReturn.getSateCode().equals("4000")){
                    ctx.setResponseBody("账号不存在");
                }else if (loginReturn.getSateCode().equals("4001")){
                    ctx.setResponseBody("密码错误");
                }
            } catch (IOException e) {
                logger.error(e.getLocalizedMessage());
            }
        return null;
    }

}
