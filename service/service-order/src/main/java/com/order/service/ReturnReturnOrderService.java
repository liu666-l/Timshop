package com.order.service;

import com.order.pojo.ReturnReturnOrder;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface ReturnReturnOrderService {

    /***
     * ReturnReturnOrder多条件分页查询
     * @param returnReturnOrder
     * @param page
     * @param size
     * @return
     */
    PageInfo<ReturnReturnOrder> findPage(ReturnReturnOrder returnReturnOrder, int page, int size);

    /***
     * ReturnReturnOrder分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<ReturnReturnOrder> findPage(int page, int size);

    /***
     * ReturnReturnOrder多条件搜索方法
     * @param returnReturnOrder
     * @return
     */
    List<ReturnReturnOrder> findList(ReturnReturnOrder returnReturnOrder);

    /***
     * 删除ReturnReturnOrder
     * @param id
     */
    void delete(String id);

    /***
     * 修改ReturnReturnOrder数据
     * @param returnReturnOrder
     */
    void update(ReturnReturnOrder returnReturnOrder);

    /***
     * 新增ReturnReturnOrder
     * @param returnReturnOrder
     */
    void add(ReturnReturnOrder returnReturnOrder);

    /**
     * 根据ID查询ReturnReturnOrder
     * @param id
     * @return
     */
     ReturnReturnOrder findById(String id);

    /***
     * 查询所有ReturnReturnOrder
     * @return
     */
    List<ReturnReturnOrder> findAll();
}
