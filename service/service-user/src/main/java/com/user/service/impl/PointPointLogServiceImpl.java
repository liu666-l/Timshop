package com.user.service.impl;

import com.user.dao.PointPointLogMapper;
import com.user.pojo.PointPointLog;
import com.user.service.PointPointLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.user.dao.PointPointLogMapper;
import com.user.pojo.PointPointLog;
import com.user.service.PointPointLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class PointPointLogServiceImpl implements PointPointLogService {

    @Autowired
    private PointPointLogMapper pointPointLogMapper;


    /**
     * PointPointLog条件+分页查询
     * @param pointPointLog 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<PointPointLog> findPage(PointPointLog pointPointLog, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(pointPointLog);
        //执行搜索
        return new PageInfo<PointPointLog>(pointPointLogMapper.selectByExample(example));
    }

    /**
     * PointPointLog分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<PointPointLog> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<PointPointLog>(pointPointLogMapper.selectAll());
    }

    /**
     * PointPointLog条件查询
     * @param pointPointLog
     * @return
     */
    @Override
    public List<PointPointLog> findList(PointPointLog pointPointLog){
        //构建查询条件
        Example example = createExample(pointPointLog);
        //根据构建的条件查询数据
        return pointPointLogMapper.selectByExample(example);
    }


    /**
     * PointPointLog构建查询对象
     * @param pointPointLog
     * @return
     */
    public Example createExample(PointPointLog pointPointLog){
        Example example=new Example(PointPointLog.class);
        Example.Criteria criteria = example.createCriteria();
        if(pointPointLog!=null){
            // 
            if(!StringUtils.isEmpty(pointPointLog.getOrderOrderId())){
                    criteria.andEqualTo("orderOrderId",pointPointLog.getOrderOrderId());
            }
            // 
            if(!StringUtils.isEmpty(pointPointLog.getUserUserId())){
                    criteria.andEqualTo("userUserId",pointPointLog.getUserUserId());
            }
            // 
            if(!StringUtils.isEmpty(pointPointLog.getPoint())){
                    criteria.andEqualTo("point",pointPointLog.getPoint());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(String id){
        pointPointLogMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改PointPointLog
     * @param pointPointLog
     */
    @Override
    public void update(PointPointLog pointPointLog){
        pointPointLogMapper.updateByPrimaryKey(pointPointLog);
    }

    /**
     * 增加PointPointLog
     * @param pointPointLog
     */
    @Override
    public void add(PointPointLog pointPointLog){
        pointPointLogMapper.insert(pointPointLog);
    }

    /**
     * 根据ID查询PointPointLog
     * @param id
     * @return
     */
    @Override
    public PointPointLog findById(String id){
        return  pointPointLogMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询PointPointLog全部数据
     * @return
     */
    @Override
    public List<PointPointLog> findAll() {
        return pointPointLogMapper.selectAll();
    }
}
