package com.example.order.mapper;


import com.example.order.bean.OrderDetailsExtendPO;
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
public interface OrderDetailsExtendMapper {

    /**根据id查询订单*/
    OrderDetailsExtendPO findById(@Param("id") Integer id);


    /**
     *
     * @param transOrderIndexExtendPO
     * @return
     */
    int insertOrderDetailsExtend(OrderDetailsExtendPO transOrderIndexExtendPO);

}

