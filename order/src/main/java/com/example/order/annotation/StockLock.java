package com.example.order.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface StockLock {
    /**
     * @author zxhtom
     * @Description 锁key的前缀
     * @Date 15:25 2020年03月25日, 0025
     * @Param []
     * @return java.lang.String
     */
    String prefix() default "";

    /**
     * @author zxhtom
     * @Description key的分隔符
     * @Date 15:27 2020年03月25日, 0025
     * @Param []
     * @return java.lang.String
     */
    String delimiter() default ":";


}
