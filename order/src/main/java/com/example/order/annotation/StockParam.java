package com.example.order.annotation;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER , ElementType.METHOD , ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface StockParam {

    /**
     * @author zxhtom
     * @Description 组成key
     * @Date 11:11 2020年03月26日, 0026
     * @Param []
     * @return java.lang.String[]
     */
    String[] names() default {""};
}
