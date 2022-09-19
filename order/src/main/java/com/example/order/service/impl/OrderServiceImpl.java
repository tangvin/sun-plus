package com.example.order.service.impl;

import com.example.order.annoation.OperationLogAnnotation;
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

import javax.print.DocFlavor;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

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
    @OperationLogAnnotation(operModul = "交易中心-订单模块", operType = "新增", operDesc = "新增订单明细")
    public Map<String, String> addTransOrderInfo() {
//        //明细表
//        addOrderDetailsInfo();
//        //index表
//        addOrderIndex();
//        //操作日志表
//        addOrderLog();
        Map<String, String> hashMap = new HashMap<>();
        try {
            //明细表
            hashMap.put("message", "ok");
            addOrderDetailsInfo();
            System.out.println("===========addOrderIndex()=============");
            addOrderIndex();
            int o = 1 / 0;
        } catch (Exception e) {

            throw e;
        }
        return hashMap;


    }

//    @Transactional(noRollbackFor = Exception.class)
//    public void test1(){
//        OrderDetailsInfoPO orderDetailsInfoPO = new OrderDetailsInfoPO();
//        orderDetailsInfoPO.setTransOrderId("999999");
//        orderDetailsInfoPO.setSuperOrder("10000000");
//        orderDetailsInfoPO.setOrderState("1");
//        orderDetailsInfoPO.setTxDt("2022-09-19");
//        int i = orderDetailsInfoMapper.insertOrderDetailsInfo(orderDetailsInfoPO);
//        System.out.println("**********i**"+i);
//    }


    @OperationLogAnnotation(operModul = "交易中心-订单模块", operType = "新增", operDesc = "新增订单明细表数据")
    private void addOrderDetailsInfo() {
        try {
            OrderDetailsInfoPO orderDetailsInfoPO = new OrderDetailsInfoPO();
            orderDetailsInfoPO.setTransOrderId("10031");
            orderDetailsInfoPO.setSuperOrder("10000");
            orderDetailsInfoPO.setOrderState("1");
            orderDetailsInfoPO.setTxDt("2022-08-14");
            int i = orderDetailsInfoMapper.insertOrderDetailsInfo(orderDetailsInfoPO);
            System.out.println("addOrderDetailsInfo_______________i:" + i);
            int o = 1 / 0;
        } catch (Exception e) {
            log.error("addOrderDetailsInfo异常了，抛异常了:{}",e.getMessage());
            throw e;
        }
    }


//    @OperationLogAnnotation(operModul = "交易中心-订单模块", operType = "新增", operDesc = "新增订单索引表数据")
    private void addOrderIndex() {
        try {
            OrderIndexPO orderIndexPO = new OrderIndexPO();
            orderIndexPO.setTransOrderId("10031");
            orderIndexPO.setTxAmt(BigDecimal.TEN);
            int i = orderIndexMapper.insertOrderIndex(orderIndexPO);
            System.out.println("addOrderIndex------------i==:" + i);
            i = 1 / 0;
        } catch (Exception e) {
            log.error("addOrderIndex出现异常,但没有抛异常:{}", e.getMessage());
        }
    }


    private void addOrderLog() {
        for (int i = 0; i < 10; i++) {
            try {
                OrderLogPO transOrderLogPO = new OrderLogPO();
                transOrderLogPO.setTransOrderId("10031");
                transOrderLogPO.setOptType("1");
                transOrderLogPO.setTxAmt("109");
                transOrderLogPO.setCreateTime("2022-08-14");
                int insertTransLog = orderLogMapper.insertTransLog(transOrderLogPO);
                System.out.println("addOrderLog_____________i:" + insertTransLog);
                if (i == 6) {
                    throw new Exception("第六错感");
                }
            } catch (Exception e) {
                log.error("第-" + i + "--次出现异常拉---------e.getMessage():", e.getMessage());
            }
        }
//        if (true) {
//            i = 1 / 0;
//        }
    }

}
