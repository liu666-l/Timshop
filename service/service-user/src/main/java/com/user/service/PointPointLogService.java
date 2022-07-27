package com.user.service;

import com.user.pojo.PointPointLog;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface PointPointLogService {

    /***
     * PointPointLog多条件分页查询
     * @param pointPointLog
     * @param page
     * @param size
     * @return
     */
    PageInfo<PointPointLog> findPage(PointPointLog pointPointLog, int page, int size);

    /***
     * PointPointLog分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<PointPointLog> findPage(int page, int size);

    /***
     * PointPointLog多条件搜索方法
     * @param pointPointLog
     * @return
     */
    List<PointPointLog> findList(PointPointLog pointPointLog);

    /***
     * 删除PointPointLog
     * @param id
     */
    void delete(String id);

    /***
     * 修改PointPointLog数据
     * @param pointPointLog
     */
    void update(PointPointLog pointPointLog);

    /***
     * 新增PointPointLog
     * @param pointPointLog
     */
    void add(PointPointLog pointPointLog);

    /**
     * 根据ID查询PointPointLog
     * @param id
     * @return
     */
     PointPointLog findById(String id);

    /***
     * 查询所有PointPointLog
     * @return
     */
    List<PointPointLog> findAll();
}
