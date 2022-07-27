package com.order.service;

import com.order.pojo.TaskTaskHis;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface TaskTaskHisService {

    /***
     * TaskTaskHis多条件分页查询
     * @param taskTaskHis
     * @param page
     * @param size
     * @return
     */
    PageInfo<TaskTaskHis> findPage(TaskTaskHis taskTaskHis, int page, int size);

    /***
     * TaskTaskHis分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<TaskTaskHis> findPage(int page, int size);

    /***
     * TaskTaskHis多条件搜索方法
     * @param taskTaskHis
     * @return
     */
    List<TaskTaskHis> findList(TaskTaskHis taskTaskHis);

    /***
     * 删除TaskTaskHis
     * @param id
     */
    void delete(Long id);

    /***
     * 修改TaskTaskHis数据
     * @param taskTaskHis
     */
    void update(TaskTaskHis taskTaskHis);

    /***
     * 新增TaskTaskHis
     * @param taskTaskHis
     */
    void add(TaskTaskHis taskTaskHis);

    /**
     * 根据ID查询TaskTaskHis
     * @param id
     * @return
     */
     TaskTaskHis findById(Long id);

    /***
     * 查询所有TaskTaskHis
     * @return
     */
    List<TaskTaskHis> findAll();
}
