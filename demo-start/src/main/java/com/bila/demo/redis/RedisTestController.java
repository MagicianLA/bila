package com.bila.demo.redis;

import com.bila.demo.common.redis.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Magician
 * @Desc:
 * @Date: 2020/05/09
 * @Modify By:
 */
@RestController
@RequestMapping("/redis")
public class RedisTestController {

    @Autowired
    private RedisClient redisClient;

    @RequestMapping("/test")
    public Object set(String key, String value) {
        redisClient.set(key, value);
        Object o = redisClient.get(key);
        return o;
    }
}
