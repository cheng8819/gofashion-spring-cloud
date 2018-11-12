package com.gofashion.gofashionspringcloudzuul.token;

import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.UUID;

@Component
public class JwtConfiguration {
    private SecretKey secretKey;

    private JwtConfiguration() {
        this.secretKey = createKey();
    }

    public SecretKeySpec getSecretKeySpec() {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), SignatureAlgorithm.HS512.getJcaName());
        return secretKeySpec;
    }

    private SecretKey createKey() {
        SecretKey secretKey = null;
        try {
            //生成密钥生成器
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            //根据随机源数初始化密钥生成器，根据传入的种子生成128位随机源，种子一致生成的也一致
            kgen.init(128);
            //产生原始对称密钥
            secretKey = kgen.generateKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return secretKey;
    }
}
