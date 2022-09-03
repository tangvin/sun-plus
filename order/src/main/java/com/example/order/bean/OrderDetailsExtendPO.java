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
public class OrderDetailsExtendPO {
    private int id;
    private String transOrderId;
    private String extendInfo;
    private String createTime;
    private String modifyTime;
    private String version;

}
