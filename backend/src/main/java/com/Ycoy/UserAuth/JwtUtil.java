package com.Ycoy.UserAuth;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    // Generate a secure key for signing the JWT
    private final SecretKey key = Jwts.SIG.HS256.key().build();
    
    // Token validity: 24 hours (in milliseconds)
    private final long EXPIRATION_TIME = 86400000;

    public String generateToken(String email) {
        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }
}