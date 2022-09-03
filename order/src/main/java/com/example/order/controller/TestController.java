package com.example.order.controller;

import com.example.order.bean.OrderDetailsInfoPO;
import com.example.order.service.OrderService;
import com.example.order.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author tangyin@belink.com
 * @version V1.0
 * @title
 * @description
 * @date 2022-08-02 20:11
 */
@RequestMapping("/test")
@RestController
@Slf4j
public class TestController {


    @Autowired
    private OrderService orderService;
    @Autowired
    private TransactionService transactionService;

    @RequestMapping("/getOrderById")
    public OrderDetailsInfoPO getOrderById(String id) {
        log.debug("param id : {}", id);
        return orderService.findById(Integer.parseInt(id));
    }

    @RequestMapping("/testTransaction")
    public void testTransaction() {
         transactionService.invoke();
    }


}
