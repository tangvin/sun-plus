package com.example.order.service.impl;

import com.example.order.service.OrderLogService;
import com.example.order.service.OrderService;
import com.example.order.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @author tangyin@belink.com
 * @version V1.0
 * @title
 * @description
 * @date 2022-08-02 21:40
 */
@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    OrderLogService orderLogService;
    @Autowired
    OrderService orderService;

    @Override
    public void invoke() {
        Map<String, String> resultMap = orderService.addTransOrderInfo();
        System.out.println("========resultMap========="+resultMap);
//        int j = orderLogService.addTransOrderLog();
//        System.out.println("==========j====="+j);
    }
}
