package com.example.order.service.impl;

import com.example.order.bean.OrderLogPO;
import com.example.order.mapper.OrderLogMapper;
import com.example.order.service.OrderLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author tangyin@belink.com
 * @version V1.0
 * @title
 * @description
 * @date 2022-08-02 21:10
 */
@Service
public class OrderLogServiceImpl implements OrderLogService {

    private final Logger logger = LoggerFactory.getLogger(OrderLogServiceImpl.class);


    @Autowired
    OrderLogMapper orderLogMapper;

    @Override
    public OrderLogPO findById(Integer id){
        OrderLogPO orderLogPO = orderLogMapper.findById(id);
        logger.debug("result orderLogPO : {}" , orderLogPO);
        return orderLogPO;
    }

    @Transactional
    @Override
    public int addTransOrderLog() {
        OrderLogPO transOrderLogPO = new OrderLogPO();
        transOrderLogPO.setTransOrderId("111");
        transOrderLogPO.setOptType("1");
        transOrderLogPO.setTxAmt("109");
        transOrderLogPO.setCreateTime("2022-08-02");
        int i = orderLogMapper.insertTransLog(transOrderLogPO);
        System.out.println("addTransOrderLog_____________i:"+i);
        if(true){
            i= 1/0;
        }
        return i;
    }

}
