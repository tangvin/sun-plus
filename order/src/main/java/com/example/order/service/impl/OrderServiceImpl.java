package com.example.order.service.impl;

import com.example.order.bean.OrderDetailsInfoPO;
import com.example.order.bean.OrderIndexPO;
import com.example.order.bean.OrderLogPO;
import com.example.order.mapper.*;
import com.example.order.service.OrderLogService;
import com.example.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author tangyin@belink.com
 * @version V1.0
 * @title
 * @description 事务测试
 * @date 2022-08-02 21:10
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);


    @Autowired
    OrderDetailsInfoMapper orderDetailsInfoMapper;
    @Autowired
    OrderDetailsExtendMapper orderDetailsExtendMapper;
    @Autowired
    OrderIndexMapper orderIndexMapper;
    @Autowired
    OrderIndexExtendMapper orderIndexExtendMapper;
    @Autowired
    OrderLogService orderLogService;
    @Autowired
    OrderLogMapper orderLogMapper;

    @Override
    public OrderDetailsInfoPO findById(Integer id) {
        logger.debug("param id : {}", id);
        OrderDetailsInfoPO orderInfoPO = orderDetailsInfoMapper.findById(id);
        logger.debug("result orderInfoPO : {}", orderInfoPO);
        return orderInfoPO;
    }

    @Override
    @Transactional
    public int addTransOrderInfo() {
        //明细表
        addOrderDetailsInfo();
        //index表
        addOrderIndex();
        //操作日志表
        addOrderLog();
        return 1;
    }


    private void addOrderDetailsInfo() {
        OrderDetailsInfoPO orderDetailsInfoPO = new OrderDetailsInfoPO();
        orderDetailsInfoPO.setTransOrderId("10031");
        orderDetailsInfoPO.setSuperOrder("10000");
        orderDetailsInfoPO.setOrderState("1");
        orderDetailsInfoPO.setTxDt("2022-08-14");
        int i = orderDetailsInfoMapper.insertOrderDetailsInfo(orderDetailsInfoPO);
        System.out.println("addOrderDetailsInfo_______________i:" + i);
//        if (true) {
//            i = 1 / 0;
//        }
    }


    private void addOrderIndex() {
        OrderIndexPO orderIndexPO = new OrderIndexPO();
        orderIndexPO.setTransOrderId("10031");
        orderIndexPO.setTxAmt(BigDecimal.TEN);
        int i = orderIndexMapper.insertOrderIndex(orderIndexPO);
        System.out.println("addOrderIndex------------i==:" + i);
//        if (true) {
//            i = 1 / 0;
//        }
    }


    private void addOrderLog() {
        for (int i = 0; i < 10; i++) {
            try{
                OrderLogPO transOrderLogPO = new OrderLogPO();
                transOrderLogPO.setTransOrderId("10031");
                transOrderLogPO.setOptType("1");
                transOrderLogPO.setTxAmt("109");
                transOrderLogPO.setCreateTime("2022-08-14");
                int insertTransLog = orderLogMapper.insertTransLog(transOrderLogPO);
                System.out.println("addOrderLog_____________i:" + insertTransLog);
                if(i == 6){
                   throw new Exception("第六错感");
                }
            }catch (Exception e){
                log.error("第-"+i+"--次出现异常拉---------e.getMessage():",e.getMessage());
            }
        }
//        if (true) {
//            i = 1 / 0;
//        }
    }

}
