package com.example.order.service;

import com.example.order.bean.OrderDetailsInfoPO;

public interface OrderService {

	OrderDetailsInfoPO findById(Integer id);

	int addTransOrderInfo();
}
