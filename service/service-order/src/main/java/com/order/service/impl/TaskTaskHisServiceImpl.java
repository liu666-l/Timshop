package com.order.service.impl;

import com.order.dao.TaskTaskHisMapper;
import com.order.pojo.TaskTaskHis;
import com.order.service.TaskTaskHisService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.order.dao.TaskTaskHisMapper;
import com.order.pojo.TaskTaskHis;
import com.order.service.TaskTaskHisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class TaskTaskHisServiceImpl implements TaskTaskHisService {

    @Autowired
    private TaskTaskHisMapper taskTaskHisMapper;


    /**
     * TaskTaskHis条件+分页查询
     * @param taskTaskHis 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<TaskTaskHis> findPage(TaskTaskHis taskTaskHis, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(taskTaskHis);
        //执行搜索
        return new PageInfo<TaskTaskHis>(taskTaskHisMapper.selectByExample(example));
    }

    /**
     * TaskTaskHis分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<TaskTaskHis> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<TaskTaskHis>(taskTaskHisMapper.selectAll());
    }

    /**
     * TaskTaskHis条件查询
     * @param taskTaskHis
     * @return
     */
    @Override
    public List<TaskTaskHis> findList(TaskTaskHis taskTaskHis){
        //构建查询条件
        Example example = createExample(taskTaskHis);
        //根据构建的条件查询数据
        return taskTaskHisMapper.selectByExample(example);
    }


    /**
     * TaskTaskHis构建查询对象
     * @param taskTaskHis
     * @return
     */
    public Example createExample(TaskTaskHis taskTaskHis){
        Example example=new Example(TaskTaskHis.class);
        Example.Criteria criteria = example.createCriteria();
        if(taskTaskHis!=null){
            // 任务id
            if(!StringUtils.isEmpty(taskTaskHis.getId())){
                    criteria.andEqualTo("id",taskTaskHis.getId());
            }
            // 
            if(!StringUtils.isEmpty(taskTaskHis.getCreateCreateTime())){
                    criteria.andEqualTo("createCreateTime",taskTaskHis.getCreateCreateTime());
            }
            // 
            if(!StringUtils.isEmpty(taskTaskHis.getUpdateUpdateTime())){
                    criteria.andEqualTo("updateUpdateTime",taskTaskHis.getUpdateUpdateTime());
            }
            // 
            if(!StringUtils.isEmpty(taskTaskHis.getDeleteDeleteTime())){
                    criteria.andEqualTo("deleteDeleteTime",taskTaskHis.getDeleteDeleteTime());
            }
            // 任务类型
            if(!StringUtils.isEmpty(taskTaskHis.getTaskTaskType())){
                    criteria.andEqualTo("taskTaskType",taskTaskHis.getTaskTaskType());
            }
            // 交换机名称
            if(!StringUtils.isEmpty(taskTaskHis.getMqMqExchange())){
                    criteria.andEqualTo("mqMqExchange",taskTaskHis.getMqMqExchange());
            }
            // routingkey
            if(!StringUtils.isEmpty(taskTaskHis.getMqMqRoutingkey())){
                    criteria.andEqualTo("mqMqRoutingkey",taskTaskHis.getMqMqRoutingkey());
            }
            // 任务请求的内容
            if(!StringUtils.isEmpty(taskTaskHis.getRequestRequestBody())){
                    criteria.andEqualTo("requestRequestBody",taskTaskHis.getRequestRequestBody());
            }
            // 任务状态
            if(!StringUtils.isEmpty(taskTaskHis.getStatus())){
                    criteria.andEqualTo("status",taskTaskHis.getStatus());
            }
            // 
            if(!StringUtils.isEmpty(taskTaskHis.getErrormsg())){
                    criteria.andEqualTo("errormsg",taskTaskHis.getErrormsg());
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
        taskTaskHisMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改TaskTaskHis
     * @param taskTaskHis
     */
    @Override
    public void update(TaskTaskHis taskTaskHis){
        taskTaskHisMapper.updateByPrimaryKey(taskTaskHis);
    }

    /**
     * 增加TaskTaskHis
     * @param taskTaskHis
     */
    @Override
    public void add(TaskTaskHis taskTaskHis){
        taskTaskHisMapper.insert(taskTaskHis);
    }

    /**
     * 根据ID查询TaskTaskHis
     * @param id
     * @return
     */
    @Override
    public TaskTaskHis findById(Long id){
        return  taskTaskHisMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询TaskTaskHis全部数据
     * @return
     */
    @Override
    public List<TaskTaskHis> findAll() {
        return taskTaskHisMapper.selectAll();
    }
}
