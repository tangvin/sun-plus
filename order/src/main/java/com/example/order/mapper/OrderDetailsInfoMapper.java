package com.example.order.mapper;


import com.example.order.bean.OrderDetailsInfoPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName:
 * @Description:
 * @Author: Bruce_T
 * @data: 2019/9/5  11:23
 * @Version: 1.0
 * @Modified: By:
 */
@Mapper
public interface OrderDetailsInfoMapper {
    /**根据id查询订单*/
    OrderDetailsInfoPO findById(@Param("id") Integer id);


    int insertOrderDetailsInfo(OrderDetailsInfoPO transOrderInfoPO);

}

