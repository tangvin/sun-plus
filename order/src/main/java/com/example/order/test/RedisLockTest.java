package com.example.order.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author tangyin@belink.com
 * @version V1.0
 * @title
 * @description
 * @date 2022-09-04 10:42
 */
public class RedisLockTest {

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 就是进来一个先占位，当别的线程进来操作的时候，发现有人占位了，就会放弃或者稍后再试。
     *
     * 占位的实现：
     *
     * 在redis中的setnx命令来实现，
     * redis命令可以参考我这篇博客https://www.cnblogs.com/javazl/p/12657280.html，
     * 默认set命令就是存值，当key存在的时候，set就会覆盖key的value值，而setnx则不会。当没有key的时候，
     * setnx就会进来先占位，当key存在了，其他的setnx就进不来了。
     * 等到第一个执行完成后，在del命令释放位子。
     */
    public void testLock1(){
//
//        redisTemplate.execute(jedis->{
//            Long setnx = jedis.setnx("k1", "v1");
//            //setnx的返回值为long类型
//            if (setnx == 1) {
//                //没人占位
//                jedis.set("name", "zl");
//                String name = jedis.get("name");
//                System.out.println(name);
//                //释放资源
//                redisTemplate.del("k1");
//            }else{
//                //有人占位，停止/暂缓 操作
//            }
//        });
    }
}
