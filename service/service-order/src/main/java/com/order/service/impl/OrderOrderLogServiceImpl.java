package com.order.service.impl;

import com.order.dao.OrderOrderLogMapper;
import com.order.pojo.OrderOrderLog;
import com.order.service.OrderOrderLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class OrderOrderLogServiceImpl implements OrderOrderLogService {

    @Autowired
    private OrderOrderLogMapper orderOrderLogMapper;


    /**
     * OrderOrderLog条件+分页查询
     * @param orderOrderLog 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<OrderOrderLog> findPage(OrderOrderLog orderOrderLog, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(orderOrderLog);
        //执行搜索
        return new PageInfo<OrderOrderLog>(orderOrderLogMapper.selectByExample(example));
    }

    /**
     * OrderOrderLog分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<OrderOrderLog> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<OrderOrderLog>(orderOrderLogMapper.selectAll());
    }

    /**
     * OrderOrderLog条件查询
     * @param orderOrderLog
     * @return
     */
    @Override
    public List<OrderOrderLog> findList(OrderOrderLog orderOrderLog){
        //构建查询条件
        Example example = createExample(orderOrderLog);
        //根据构建的条件查询数据
        return orderOrderLogMapper.selectByExample(example);
    }


    /**
     * OrderOrderLog构建查询对象
     * @param orderOrderLog
     * @return
     */
    public Example createExample(OrderOrderLog orderOrderLog){
        Example example=new Example(OrderOrderLog.class);
        Example.Criteria criteria = example.createCriteria();
        if(orderOrderLog!=null){
            // ID
            if(!StringUtils.isEmpty(orderOrderLog.getId())){
                    criteria.andEqualTo("id",orderOrderLog.getId());
            }
            // 操作员
            if(!StringUtils.isEmpty(orderOrderLog.getOperater())){
                    criteria.andEqualTo("operater",orderOrderLog.getOperater());
            }
            // 操作时间
            if(!StringUtils.isEmpty(orderOrderLog.getOperateOperateTime())){
                    criteria.andEqualTo("operateOperateTime",orderOrderLog.getOperateOperateTime());
            }
            // 订单ID
            if(!StringUtils.isEmpty(orderOrderLog.getOrderOrderId())){
                    criteria.andEqualTo("orderOrderId",orderOrderLog.getOrderOrderId());
            }
            // 订单状态
            if(!StringUtils.isEmpty(orderOrderLog.getOrderOrderStatus())){
                    criteria.andEqualTo("orderOrderStatus",orderOrderLog.getOrderOrderStatus());
            }
            // 付款状态
            if(!StringUtils.isEmpty(orderOrderLog.getPayPayStatus())){
                    criteria.andEqualTo("payPayStatus",orderOrderLog.getPayPayStatus());
            }
            // 发货状态
            if(!StringUtils.isEmpty(orderOrderLog.getConsignConsignStatus())){
                    criteria.andEqualTo("consignConsignStatus",orderOrderLog.getConsignConsignStatus());
            }
            // 备注
            if(!StringUtils.isEmpty(orderOrderLog.getRemarks())){
                    criteria.andEqualTo("remarks",orderOrderLog.getRemarks());
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
        orderOrderLogMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改OrderOrderLog
     * @param orderOrderLog
     */
    @Override
    public void update(OrderOrderLog orderOrderLog){
        orderOrderLogMapper.updateByPrimaryKey(orderOrderLog);
    }

    /**
     * 增加OrderOrderLog
     * @param orderOrderLog
     */
    @Override
    public void add(OrderOrderLog orderOrderLog){
        orderOrderLogMapper.insert(orderOrderLog);
    }

    /**
     * 根据ID查询OrderOrderLog
     * @param id
     * @return
     */
    @Override
    public OrderOrderLog findById(String id){
        return  orderOrderLogMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询OrderOrderLog全部数据
     * @return
     */
    @Override
    public List<OrderOrderLog> findAll() {
        return orderOrderLogMapper.selectAll();
    }
}
