package com.example.order.utils;

import com.example.order.annotation.StockLock;
import com.example.order.annotation.StockParam;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Map;

/**
 * @author tangyin@belink.com
 * @version V1.0
 * @title
 * @description
 * @date 2022-09-03 21:09
 */
public class StockKeyGenerator {

    public String getLockKey(ProceedingJoinPoint pjp) {
        //获取方法签名
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        //获取方法cacheLock注解
        StockLock stockLock = method.getAnnotation(StockLock.class);
        //获取方法参数
        Object[] args = pjp.getArgs();
        Parameter[] parameters = method.getParameters();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < parameters.length; i++) {
            StockParam stockParam = parameters[i].getAnnotation(StockParam.class);
            Object arg = args[i];
            if (arg instanceof Map) {
                Map<String, Object> temArgMap = (Map<String, Object>) arg;
                String[] names = stockParam.names();
                for (String name : names) {
                    if (builder.length() > 0) {
                        builder.append(stockLock.delimiter());
                    }
                    builder.append(temArgMap.get(name));
                }
            }

        }
        return builder.toString();
    }
}
