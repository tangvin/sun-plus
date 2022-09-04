package com.example.order.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

/**
 * @author tangyin@belink.com
 * @version V1.0
 * @title
 * @description
 * @date 2022-09-03 21:04
 */
public class RedisLock {

    RedisTemplate redisTemplate;

    public Boolean tryGetLock(String key , String value) {
        return tryGetLock(key, value, -1, TimeUnit.DAYS);
    }
    public Boolean tryGetLock(String key , String value, Integer expire) {
        return tryGetLock(key, value, expire, TimeUnit.SECONDS);
    }
    public Boolean tryGetLock(String key , String value, Integer expire , TimeUnit timeUnit) {
        ValueOperations operations = redisTemplate.opsForValue();
        if (operations.setIfAbsent(key, value)) {
            //说明 redis没有该key , 换言之 加锁成功  设置过期时间防止死锁
            if (expire > 0) {
                redisTemplate.expire(key, expire, timeUnit);
            }
            return true;
        }
        return false;
    }

    public Boolean unLock(String key) {
        return redisTemplate.delete(key);
    }
}
