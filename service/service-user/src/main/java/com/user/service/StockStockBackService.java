package com.user.service;

import com.user.pojo.StockStockBack;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface StockStockBackService {

    /***
     * StockStockBack多条件分页查询
     * @param stockStockBack
     * @param page
     * @param size
     * @return
     */
    PageInfo<StockStockBack> findPage(StockStockBack stockStockBack, int page, int size);

    /***
     * StockStockBack分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<StockStockBack> findPage(int page, int size);

    /***
     * StockStockBack多条件搜索方法
     * @param stockStockBack
     * @return
     */
    List<StockStockBack> findList(StockStockBack stockStockBack);

    /***
     * 删除StockStockBack
     * @param id
     */
    void delete(String id);

    /***
     * 修改StockStockBack数据
     * @param stockStockBack
     */
    void update(StockStockBack stockStockBack);

    /***
     * 新增StockStockBack
     * @param stockStockBack
     */
    void add(StockStockBack stockStockBack);

    /**
     * 根据ID查询StockStockBack
     * @param id
     * @return
     */
     StockStockBack findById(String id);

    /***
     * 查询所有StockStockBack
     * @return
     */
    List<StockStockBack> findAll();
}
