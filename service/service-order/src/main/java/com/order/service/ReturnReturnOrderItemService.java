package com.order.service;

import com.order.pojo.ReturnReturnOrderItem;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface ReturnReturnOrderItemService {

    /***
     * ReturnReturnOrderItem多条件分页查询
     * @param returnReturnOrderItem
     * @param page
     * @param size
     * @return
     */
    PageInfo<ReturnReturnOrderItem> findPage(ReturnReturnOrderItem returnReturnOrderItem, int page, int size);

    /***
     * ReturnReturnOrderItem分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<ReturnReturnOrderItem> findPage(int page, int size);

    /***
     * ReturnReturnOrderItem多条件搜索方法
     * @param returnReturnOrderItem
     * @return
     */
    List<ReturnReturnOrderItem> findList(ReturnReturnOrderItem returnReturnOrderItem);

    /***
     * 删除ReturnReturnOrderItem
     * @param id
     */
    void delete(String id);

    /***
     * 修改ReturnReturnOrderItem数据
     * @param returnReturnOrderItem
     */
    void update(ReturnReturnOrderItem returnReturnOrderItem);

    /***
     * 新增ReturnReturnOrderItem
     * @param returnReturnOrderItem
     */
    void add(ReturnReturnOrderItem returnReturnOrderItem);

    /**
     * 根据ID查询ReturnReturnOrderItem
     * @param id
     * @return
     */
     ReturnReturnOrderItem findById(String id);

    /***
     * 查询所有ReturnReturnOrderItem
     * @return
     */
    List<ReturnReturnOrderItem> findAll();
}
