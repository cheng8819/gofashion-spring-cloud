package com.gofashion.gofashionspringcloudzuul.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class JwtTokenProvider {
    private JwtConfiguration configuration;

    public JwtTokenProvider(JwtConfiguration configuration) {
        this.setConfiguration(configuration);
    }

    /**
     * 生成token
     *
     * @return
     */
    public String createToken(String sub) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE,7);
        String compactJws = Jwts.builder().setExpiration(c.getTime())
                .setSubject(sub)
                .compressWith(CompressionCodecs.DEFLATE)
                .signWith(SignatureAlgorithm.HS512, configuration.getSecretKeySpec())
                .compact();

        return compactJws;
    }

    /**
     * token校验
     */
    public Claims validataToken(String token) {
        return Jwts.parser().setSigningKey(configuration.getSecretKeySpec())
                .parseClaimsJws(token).getBody();
    }

    /**
     * @return the configuration
     */
    public JwtConfiguration getConfiguration() {
        return configuration;
    }

    /**
     * @param configuration the configuration to set
     */
    public void setConfiguration(JwtConfiguration configuration) {
        this.configuration = configuration;
    }
}
