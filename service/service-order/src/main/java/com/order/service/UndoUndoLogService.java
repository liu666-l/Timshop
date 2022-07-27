package com.order.service;

import com.order.pojo.UndoUndoLog;
import com.github.pagehelper.PageInfo;
import com.order.pojo.UndoUndoLog;

import java.util.List;


public interface UndoUndoLogService {

    /***
     * UndoUndoLog多条件分页查询
     * @param undoUndoLog
     * @param page
     * @param size
     * @return
     */
    PageInfo<UndoUndoLog> findPage(UndoUndoLog undoUndoLog, int page, int size);

    /***
     * UndoUndoLog分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<UndoUndoLog> findPage(int page, int size);

    /***
     * UndoUndoLog多条件搜索方法
     * @param undoUndoLog
     * @return
     */
    List<UndoUndoLog> findList(UndoUndoLog undoUndoLog);

    /***
     * 删除UndoUndoLog
     * @param id
     */
    void delete(Long id);

    /***
     * 修改UndoUndoLog数据
     * @param undoUndoLog
     */
    void update(UndoUndoLog undoUndoLog);

    /***
     * 新增UndoUndoLog
     * @param undoUndoLog
     */
    void add(UndoUndoLog undoUndoLog);

    /**
     * 根据ID查询UndoUndoLog
     * @param id
     * @return
     */
     UndoUndoLog findById(Long id);

    /***
     * 查询所有UndoUndoLog
     * @return
     */
    List<UndoUndoLog> findAll();
}
