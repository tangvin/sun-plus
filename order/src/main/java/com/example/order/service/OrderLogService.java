package com.example.order.service;

import com.example.order.bean.OrderLogPO;

public interface OrderLogService {

	OrderLogPO findById(Integer id);

	int addTransOrderLog();
}
