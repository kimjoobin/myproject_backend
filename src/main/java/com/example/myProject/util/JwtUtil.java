package com.example.myProject.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SecurityException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private static final Logger log = LoggerFactory.getLogger(JwtUtil.class);
    private String secretKey;

    /**
     * access token 생성 메서드
     * */
    public String generateAccessToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + 3600000))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    /**
     * JWT 검증
     * */
    public Boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            log.info("Expired JWT Token: {}", e);
        } catch (SecurityException | MalformedJwtException e) {
            log.info("Invalid JWT Token: {}", e);
        } catch (UnsupportedJwtException e) {
            log.info("Unsupported JWT Token: {}", e);
        } catch (IllegalArgumentException e) {
            log.info("JWT claims string is empty: {}", e);
        }
        return false;
    }

    /**
     * JWT Claims 추출
     * */
    public Claims getClaimsFromToken(String accessToken) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(accessToken)
                    .getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }
}
