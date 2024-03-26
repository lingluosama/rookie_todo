package com.study.todo_service.middleware;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisConnectionManager {
    private static final String HOST = "localhost";
    private static final int PORT = 6379;
    private static final int MAX_TOTAL_CONNECTIONS = 10;
    private static final int MAX_IDLE_CONNECTIONS = 5;
    private static final int TIMEOUT = 3000;

    private static final JedisPool jedisPool;

    static {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(MAX_TOTAL_CONNECTIONS);
        poolConfig.setMaxIdle(MAX_IDLE_CONNECTIONS);
        jedisPool = new JedisPool(poolConfig, HOST, PORT, TIMEOUT);
    }

    public static Jedis getConnection() {
        return jedisPool.getResource();
    }

    public static void closeConnection(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
}
