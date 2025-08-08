package com.cy.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class Jwt {
    @Value("${config.jwt.secret}")
    private String secret;
    @Value("${config.jwt.expire}")
    private long expire;
    @Value("${config.jwt.header}")
    private String header;

    // 生成token
    public String createToken(String subject) {
        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);  // 过期时间
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")   // 设置token类型为jwt
                .setSubject(subject)    // 设置载荷（通常是用户ID或用户名）
                .setIssuedAt(nowDate)   // 设置签发时间
                .setExpiration(expireDate)    // 设置过期时间
                .signWith(SignatureAlgorithm.HS512, secret) // 使用HS512签名算法和密钥签名
                .compact();
    }

    // 获取token中的注册信息
    public Claims getTokenClaim(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            return null;
        }
    }

    // 验证token是否过期
    public boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }

    // 获取token中的用户信息
    public String getUsernameFromToken(String token) {
        return getTokenClaim(token).getSubject();
    }

    // 获取jwt发布时间
    public Date getIssuedAtDateFromToken(String token) {
        return getTokenClaim(token).getIssuedAt();
    }
}
