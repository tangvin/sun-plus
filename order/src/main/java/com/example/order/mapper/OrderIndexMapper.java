package com.example.order.mapper;


import com.example.order.bean.OrderIndexPO;
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
public interface OrderIndexMapper {

    /**根据id查询订单*/
    OrderIndexPO findById(@Param("id") Integer id);


    /**
     *
     * @param orderIndexPO
     * @return
     */
    int insertOrderIndex(OrderIndexPO orderIndexPO);

}

