package com.sales.demo.configs;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtSecurity {

    @Value("${jwt.secret}")
    private static String secret;

    public static String generateToken(Long userId) {
        return Jwts.builder().setSubject(String.valueOf(userId))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // Uma horinha,
                                                                               // né pai
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public static Long extractUserId(String token) {
        return Long.parseLong(Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject());
    }
}
