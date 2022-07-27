package com.order.service.impl;

import com.order.dao.UndoUndoLogMapper;
import com.order.pojo.UndoUndoLog;
import com.order.service.UndoUndoLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class UndoUndoLogServiceImpl implements UndoUndoLogService {

    @Autowired
    private UndoUndoLogMapper undoUndoLogMapper;


    /**
     * UndoUndoLog条件+分页查询
     * @param undoUndoLog 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<UndoUndoLog> findPage(UndoUndoLog undoUndoLog, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(undoUndoLog);
        //执行搜索
        return new PageInfo<UndoUndoLog>(undoUndoLogMapper.selectByExample(example));
    }

    /**
     * UndoUndoLog分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<UndoUndoLog> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<UndoUndoLog>(undoUndoLogMapper.selectAll());
    }

    /**
     * UndoUndoLog条件查询
     * @param undoUndoLog
     * @return
     */
    @Override
    public List<UndoUndoLog> findList(UndoUndoLog undoUndoLog){
        //构建查询条件
        Example example = createExample(undoUndoLog);
        //根据构建的条件查询数据
        return undoUndoLogMapper.selectByExample(example);
    }


    /**
     * UndoUndoLog构建查询对象
     * @param undoUndoLog
     * @return
     */
    public Example createExample(UndoUndoLog undoUndoLog){
        Example example=new Example(UndoUndoLog.class);
        Example.Criteria criteria = example.createCriteria();
        if(undoUndoLog!=null){
            // 
            if(!StringUtils.isEmpty(undoUndoLog.getId())){
                    criteria.andEqualTo("id",undoUndoLog.getId());
            }
            // 
            if(!StringUtils.isEmpty(undoUndoLog.getBranchBranchId())){
                    criteria.andEqualTo("branchBranchId",undoUndoLog.getBranchBranchId());
            }
            // 
            if(!StringUtils.isEmpty(undoUndoLog.getXid())){
                    criteria.andEqualTo("xid",undoUndoLog.getXid());
            }
            // 
            if(!StringUtils.isEmpty(undoUndoLog.getRollbackRollbackInfo())){
                    criteria.andEqualTo("rollbackRollbackInfo",undoUndoLog.getRollbackRollbackInfo());
            }
            // 
            if(!StringUtils.isEmpty(undoUndoLog.getLogLogStatus())){
                    criteria.andEqualTo("logLogStatus",undoUndoLog.getLogLogStatus());
            }
            // 
            if(!StringUtils.isEmpty(undoUndoLog.getLogLogCreated())){
                    criteria.andEqualTo("logLogCreated",undoUndoLog.getLogLogCreated());
            }
            // 
            if(!StringUtils.isEmpty(undoUndoLog.getLogLogModified())){
                    criteria.andEqualTo("logLogModified",undoUndoLog.getLogLogModified());
            }
            // 
            if(!StringUtils.isEmpty(undoUndoLog.getExt())){
                    criteria.andEqualTo("ext",undoUndoLog.getExt());
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
        undoUndoLogMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改UndoUndoLog
     * @param undoUndoLog
     */
    @Override
    public void update(UndoUndoLog undoUndoLog){
        undoUndoLogMapper.updateByPrimaryKey(undoUndoLog);
    }

    /**
     * 增加UndoUndoLog
     * @param undoUndoLog
     */
    @Override
    public void add(UndoUndoLog undoUndoLog){
        undoUndoLogMapper.insert(undoUndoLog);
    }

    /**
     * 根据ID查询UndoUndoLog
     * @param id
     * @return
     */
    @Override
    public UndoUndoLog findById(Long id){
        return  undoUndoLogMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询UndoUndoLog全部数据
     * @return
     */
    @Override
    public List<UndoUndoLog> findAll() {
        return undoUndoLogMapper.selectAll();
    }
}
