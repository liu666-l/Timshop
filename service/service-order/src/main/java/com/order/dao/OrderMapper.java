package com.order.dao;

import com.order.pojo.Order;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;


public interface OrderMapper extends Mapper<Order> {
    @Select("select * from tb_order where id = #{outTradeNo} limit 1")
    Order findById(String outTradeNo);

}
