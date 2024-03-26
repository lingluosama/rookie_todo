package com.study.todo_service;
import com.study.todo_service.middleware.JwtUtils;
import com.study.todo_service.middleware.MinioUtils;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SecureDigestAlgorithm;
import com.study.todo_service.mapper.UserMapper;
import com.study.todo_service.mapper.model.user;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.SecretKey;
import java.util.*;

import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Jwts;
import io.minio.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.Jedis;

@SpringBootTest
class TodoServiceApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JwtUtils jwtUtils;
   /* @Test
    public void test(){
        user user = new user();
        user.setPassword("114514");
        user.setName("kemonosenpaii");

        userMapper.CreateUser(user);

    }*/
    /*@Test
    public void testjwt(){
        String token = jwtUtils.create_token("name", 888, 10000);
        Jws<Claims> claimsJws = jwtUtils.verifer_token(token);
        System.out.println(claimsJws.getPayload().get("name"));
    }*/
    /*@Test
    public void testredis(){
        Jedis jedis=new Jedis("127.0.0.1",6379);
        String response = jedis.ping();
        System.out.println(response);
    }*/
    @Autowired
    UserMapper mapper;
    @Test
    public void fix(){
        Integer integer = mapper.QueryUserExist("dawidawpidbawbfabfafhawfh");
        System.out.println(integer);
    }



}
