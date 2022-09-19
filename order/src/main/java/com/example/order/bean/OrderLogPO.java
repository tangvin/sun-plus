package com.example.order.bean;

import lombok.Data;

/**
 * @author tangyin@belink.com
 * @version V1.0
 * @title
 * @description
 * @date 2022-08-02 20:01
 */
@Data
public class OrderLogPO {
    private int id;
    private String transOrderId;
    private String optType;
    private String txAmt;
    private String createTime;
    private String resultMsg;

}
