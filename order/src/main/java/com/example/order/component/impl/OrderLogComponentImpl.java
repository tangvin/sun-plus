package com.example.order.component.impl;

import com.example.order.bean.OrderLogPO;
import com.example.order.component.OrderLogComponent;
import com.example.order.mapper.OrderLogMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author tangyin@belink.com
 * @version V1.0
 * @title
 * @description
 * @date 2022-09-19 19:42
 */
@Component
@Slf4j
public class OrderLogComponentImpl implements OrderLogComponent {


    @Autowired
    OrderLogMapper orderLogMapper;

    @Override
    public void recordMsgLog(String orderId) {
        OrderLogPO transOrderLogPO = new OrderLogPO();
        transOrderLogPO.setTransOrderId(orderId);
        transOrderLogPO.setOptType("1");
        transOrderLogPO.setTxAmt("66666");
        transOrderLogPO.setCreateTime("2022-09-19");
        transOrderLogPO.setResultMsg("okokokok");
        System.out.println("orderId=="+orderId);
        //保存日志
        int i = orderLogMapper.insertTransLog(transOrderLogPO);
    }
}
