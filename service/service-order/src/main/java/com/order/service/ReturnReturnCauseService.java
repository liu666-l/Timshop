package com.order.service;

import com.order.pojo.ReturnReturnCause;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface ReturnReturnCauseService {

    /***
     * ReturnReturnCause多条件分页查询
     * @param returnReturnCause
     * @param page
     * @param size
     * @return
     */
    PageInfo<ReturnReturnCause> findPage(ReturnReturnCause returnReturnCause, int page, int size);

    /***
     * ReturnReturnCause分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<ReturnReturnCause> findPage(int page, int size);

    /***
     * ReturnReturnCause多条件搜索方法
     * @param returnReturnCause
     * @return
     */
    List<ReturnReturnCause> findList(ReturnReturnCause returnReturnCause);

    /***
     * 删除ReturnReturnCause
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改ReturnReturnCause数据
     * @param returnReturnCause
     */
    void update(ReturnReturnCause returnReturnCause);

    /***
     * 新增ReturnReturnCause
     * @param returnReturnCause
     */
    void add(ReturnReturnCause returnReturnCause);

    /**
     * 根据ID查询ReturnReturnCause
     * @param id
     * @return
     */
     ReturnReturnCause findById(Integer id);

    /***
     * 查询所有ReturnReturnCause
     * @return
     */
    List<ReturnReturnCause> findAll();
}
