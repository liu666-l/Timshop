package com.order.service.impl;

import com.order.dao.TaskMapper;
import com.order.pojo.Task;
import com.order.service.TaskService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.order.dao.TaskMapper;
import com.order.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;


    /**
     * Task条件+分页查询
     * @param task 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Task> findPage(Task task, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(task);
        //执行搜索
        return new PageInfo<Task>(taskMapper.selectByExample(example));
    }

    /**
     * Task分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Task> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Task>(taskMapper.selectAll());
    }

    /**
     * Task条件查询
     * @param task
     * @return
     */
    @Override
    public List<Task> findList(Task task){
        //构建查询条件
        Example example = createExample(task);
        //根据构建的条件查询数据
        return taskMapper.selectByExample(example);
    }


    /**
     * Task构建查询对象
     * @param task
     * @return
     */
    public Example createExample(Task task){
        Example example=new Example(Task.class);
        Example.Criteria criteria = example.createCriteria();
        if(task!=null){
            // 任务id
            if(!StringUtils.isEmpty(task.getId())){
                    criteria.andEqualTo("id",task.getId());
            }
            // 
            if(!StringUtils.isEmpty(task.getCreateCreateTime())){
                    criteria.andEqualTo("createCreateTime",task.getCreateCreateTime());
            }
            // 
            if(!StringUtils.isEmpty(task.getUpdateUpdateTime())){
                    criteria.andEqualTo("updateUpdateTime",task.getUpdateUpdateTime());
            }
            // 
            if(!StringUtils.isEmpty(task.getDeleteDeleteTime())){
                    criteria.andEqualTo("deleteDeleteTime",task.getDeleteDeleteTime());
            }
            // 任务类型
            if(!StringUtils.isEmpty(task.getTaskTaskType())){
                    criteria.andEqualTo("taskTaskType",task.getTaskTaskType());
            }
            // 交换机名称
            if(!StringUtils.isEmpty(task.getMqMqExchange())){
                    criteria.andEqualTo("mqMqExchange",task.getMqMqExchange());
            }
            // routingkey
            if(!StringUtils.isEmpty(task.getMqMqRoutingkey())){
                    criteria.andEqualTo("mqMqRoutingkey",task.getMqMqRoutingkey());
            }
            // 任务请求的内容
            if(!StringUtils.isEmpty(task.getRequestRequestBody())){
                    criteria.andEqualTo("requestRequestBody",task.getRequestRequestBody());
            }
            // 任务状态
            if(!StringUtils.isEmpty(task.getStatus())){
                    criteria.andEqualTo("status",task.getStatus());
            }
            // 任务错误信息
            if(!StringUtils.isEmpty(task.getErrormsg())){
                    criteria.andEqualTo("errormsg",task.getErrormsg());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Long id){
        taskMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Task
     * @param task
     */
    @Override
    public void update(Task task){
        taskMapper.updateByPrimaryKey(task);
    }

    /**
     * 增加Task
     * @param task
     */
    @Override
    public void add(Task task){
        taskMapper.insert(task);
    }

    /**
     * 根据ID查询Task
     * @param id
     * @return
     */
    @Override
    public Task findById(Long id){
        return  taskMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Task全部数据
     * @return
     */
    @Override
    public List<Task> findAll() {
        return taskMapper.selectAll();
    }
}
