package com.bila.demo.common.redis;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author: Magician
 * @Desc:
 * @Date: 2020/05/09
 * @Modify By:
 */
@Service
public class RedisClient {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    /**
     *
     * @param key
     * @param value
     */
    public void set(String key, Object value){
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     *
     * @param key
     * @param value
     * @param timeout
     */
    public void set(String key, Object value,long timeout){
        redisTemplate.opsForValue().set(key, value,timeout, TimeUnit.SECONDS);
    }

    /**
     *
     * @param key
     * @return
     */
    public Object get(String key) {
        redisTemplate.getExpire(key);
        return redisTemplate.opsForValue().get(key);
    }
}
