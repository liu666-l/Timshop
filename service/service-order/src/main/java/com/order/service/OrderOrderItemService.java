package com.order.service;

import com.order.pojo.OrderItem;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface OrderOrderItemService {

    /***
     * OrderOrderItem多条件分页查询
     * @param orderItem
     * @param page
     * @param size
     * @return
     */
    PageInfo<OrderItem> findPage(OrderItem orderItem, int page, int size);

    /***
     * OrderOrderItem分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<OrderItem> findPage(int page, int size);

    /***
     * OrderOrderItem多条件搜索方法
     * @param orderItem
     * @return
     */
    List<OrderItem> findList(OrderItem orderItem);

    /***
     * 删除OrderOrderItem
     * @param id
     */
    void delete(String id);

    /***
     * 修改OrderOrderItem数据
     * @param orderItem
     */
    void update(OrderItem orderItem);

    /***
     * 新增OrderOrderItem
     * @param orderItem
     */
    void add(OrderItem orderItem);

    /**
     * 根据ID查询OrderOrderItem
     * @param id
     * @return
     */
     OrderItem findById(String id);

    /***
     * 查询所有OrderOrderItem
     * @return
     */
    List<OrderItem> findAll();
}
