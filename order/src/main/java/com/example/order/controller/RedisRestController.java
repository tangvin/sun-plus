package com.example.order.controller;

import com.example.order.component.RedisComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tangyin@belink.com
 * @version V1.0
 * @title
 * @description
 * @date 2022-09-04 11:05
 */
@RestController
@RequestMapping("/redis")
public class RedisRestController {



    @Autowired
    RedisComponent redisComponent;

    @RequestMapping(value = "/set", method = { RequestMethod.GET })
    public String set(@RequestParam String value) {
        redisComponent.set("testredis", value);
        return "0000";
    }

    @RequestMapping(value = "/get", method = { RequestMethod.GET })
    public String get() {
        String value = (String) redisComponent.get("testredis");
        return value;
    }
}
