package com.order.service;

import com.order.pojo.OrderOrderLog;
import com.github.pagehelper.PageInfo;
import com.order.pojo.OrderOrderLog;

import java.util.List;


public interface OrderOrderLogService {


    PageInfo<OrderOrderLog> findPage(OrderOrderLog orderOrderLog, int page, int size);

    /***
     * OrderOrderLog分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<OrderOrderLog> findPage(int page, int size);

    /***
     * OrderOrderLog多条件搜索方法
     * @param orderOrderLog
     * @return
     */
    List<OrderOrderLog> findList(OrderOrderLog orderOrderLog);

    /***
     * 删除OrderOrderLog
     * @param id
     */
    void delete(String id);

    /***
     * 修改OrderOrderLog数据
     * @param orderOrderLog
     */
    void update(OrderOrderLog orderOrderLog);

    /***
     * 新增OrderOrderLog
     * @param orderOrderLog
     */
    void add(OrderOrderLog orderOrderLog);

    /**
     * 根据ID查询OrderOrderLog
     * @param id
     * @return
     */
     OrderOrderLog findById(String id);

    /***
     * 查询所有OrderOrderLog
     * @return
     */
    List<OrderOrderLog> findAll();
}
