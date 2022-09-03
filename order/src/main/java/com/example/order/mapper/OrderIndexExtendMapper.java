package com.example.order.mapper;


import com.example.order.bean.OrderIndexExtendPO;
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
public interface OrderIndexExtendMapper {

    /**根据id查询订单*/
    OrderIndexExtendPO findById(@Param("id") Integer id);


    /*大大*/
    int insertOrderIndexExtend(OrderIndexExtendPO orderIndexExtendPO);

}

