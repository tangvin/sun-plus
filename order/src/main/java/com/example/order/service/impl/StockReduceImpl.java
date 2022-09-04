package com.example.order.service.impl;

import ch.qos.logback.core.CoreConstants;
import com.example.order.utils.RedisLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;

/**
 * @author tangyin@belink.com
 * @version V1.0
 * @title
 * @description
 * @date 2022-09-03 21:13
 */
public class StockReduceImpl {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisLock redisLock;

    public void test() throws Exception{
        RedisAtomicLong entityIdCounter = new RedisAtomicLong("key1", redisTemplate.getConnectionFactory());
        if (redisTemplate.hasKey("key1")) {
            //表示lockKey的库存信息有变动。此时无法进行交易
            throw new Exception("库存变动。暂无法交易");
        }
        Long increment = entityIdCounter.decrementAndGet();
        if (increment >= 0) {
            try {
//                Object proceed = pjp.proceed();
            } catch (Throwable throwable) {
                //所占资源需要释放回资源池
                while (!redisLock.tryGetLock("key1", "")) {

                }
                //表示lockKey的库存信息有变动。此时无法进行交易
                long l = entityIdCounter.incrementAndGet();
                if (l < 1) {
                    redisTemplate.opsForValue().set("key1",1);
                }
                redisLock.unLock(CoreConstants.LINE_SEPARATOR + "key1");
                throwable.printStackTrace();
            }
        } else {
            redisTemplate.opsForValue().set("key1",0);
            throw new Exception("库存不足！无法操作");
        }
    }
}
