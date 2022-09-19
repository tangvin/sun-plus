package com.example.order.service;

import com.example.order.bean.OrderDetailsInfoPO;

import java.util.Map;

public interface OrderService {

	OrderDetailsInfoPO findById(Integer id);

	Map<String,String> addTransOrderInfo(String orderId);
}
