package com.order.service;

import com.order.pojo.OrderOrderConfig;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface OrderOrderConfigService {

    /***
     * OrderOrderConfig多条件分页查询
     * @param orderOrderConfig
     * @param page
     * @param size
     * @return
     */
    PageInfo<OrderOrderConfig> findPage(OrderOrderConfig orderOrderConfig, int page, int size);

    /***
     * OrderOrderConfig分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<OrderOrderConfig> findPage(int page, int size);

    /***
     * OrderOrderConfig多条件搜索方法
     * @param orderOrderConfig
     * @return
     */
    List<OrderOrderConfig> findList(OrderOrderConfig orderOrderConfig);

    /***
     * 删除OrderOrderConfig
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改OrderOrderConfig数据
     * @param orderOrderConfig
     */
    void update(OrderOrderConfig orderOrderConfig);

    /***
     * 新增OrderOrderConfig
     * @param orderOrderConfig
     */
    void add(OrderOrderConfig orderOrderConfig);

    /**
     * 根据ID查询OrderOrderConfig
     * @param id
     * @return
     */
     OrderOrderConfig findById(Integer id);

    /***
     * 查询所有OrderOrderConfig
     * @return
     */
    List<OrderOrderConfig> findAll();
}
