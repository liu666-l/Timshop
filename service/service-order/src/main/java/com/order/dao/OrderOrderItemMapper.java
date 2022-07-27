package com.order.dao;

import com.order.pojo.OrderItem;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface OrderOrderItemMapper extends Mapper<OrderItem> {
    /**
     * 根据订单的id查询order_item集合
     * @param orderId
     * @return
     */
    @Select("select * from tb_order_item where order_id = #{orderId}")
    List<OrderItem> findByOrderId(String orderId);


}
