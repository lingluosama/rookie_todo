package com.study.todo_service.middleware;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SecureDigestAlgorithm;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;
import java.util.UUID;


@Component
public class JwtUtils {
    private static final SecretKey KEY = Jwts.SIG.HS256.key().build();
    private static final SecureDigestAlgorithm<SecretKey, SecretKey> ALGORITHM = Jwts.SIG.HS256;
    private String create_jwt_id(){
        return UUID.randomUUID().toString();
    }
    public String create_token(String key,Object value,Integer time_day){
        String tid=this.create_jwt_id();
        return Jwts.builder().header().add("typ","jWT").add("alg","HS256")
                .and().claim(key,value).id(tid)
                .expiration(new Date(System.currentTimeMillis()+time_day* 24 * 60 * 60 * 1000))
                .issuedAt(new Date()).subject("114514").signWith(KEY,ALGORITHM).compact();
    }
    public Jws<Claims> verifer_token(String token){
       return Jwts.parser().verifyWith(KEY).build().parseSignedClaims(token);
    }
}