package com.study.todo_service.middleware;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import com.google.gson.Gson;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


@Component
public class RedisUtils {
    private Gson gson = new Gson();

    public Void set(String key, Object value) {
        Jedis jedis = RedisConnectionManager.getConnection();
        try {
            jedis.set(key, gson.toJson(value));
        } finally {
            RedisConnectionManager.closeConnection(jedis);
        }
        return null;
    }

    public String query(String key) {
        Jedis jedis = RedisConnectionManager.getConnection();
        try {
            return jedis.get(key);
        } finally {
            RedisConnectionManager.closeConnection(jedis);
        }
    }
}
