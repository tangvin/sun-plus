package com.example.order.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author tangyin@belink.com
 * @version V1.0
 * @title
 * @description
 * @date 2022-08-02 20:01
 */
@Data
public class OrderIndexPO {
    private int id;
    private String transOrderId;
    private BigDecimal txAmt;
    private String createTime;
    private String modifyTime;

}
