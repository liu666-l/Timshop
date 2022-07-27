package com.order.service;

import com.order.pojo.OrderItem;

import java.util.List;

public interface CartService {
    void add(Integer num,String id,String username);
    List<OrderItem> list(String username);
}
