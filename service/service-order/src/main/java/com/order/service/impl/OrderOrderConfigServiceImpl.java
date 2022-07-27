package com.order.service.impl;

import com.order.dao.OrderOrderConfigMapper;
import com.order.pojo.OrderOrderConfig;
import com.order.service.OrderOrderConfigService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class OrderOrderConfigServiceImpl implements OrderOrderConfigService {

    @Autowired
    private OrderOrderConfigMapper orderOrderConfigMapper;


    /**
     * OrderOrderConfig条件+分页查询
     * @param orderOrderConfig 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<OrderOrderConfig> findPage(OrderOrderConfig orderOrderConfig, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(orderOrderConfig);
        //执行搜索
        return new PageInfo<OrderOrderConfig>(orderOrderConfigMapper.selectByExample(example));
    }

    /**
     * OrderOrderConfig分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<OrderOrderConfig> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<OrderOrderConfig>(orderOrderConfigMapper.selectAll());
    }

    /**
     * OrderOrderConfig条件查询
     * @param orderOrderConfig
     * @return
     */
    @Override
    public List<OrderOrderConfig> findList(OrderOrderConfig orderOrderConfig){
        //构建查询条件
        Example example = createExample(orderOrderConfig);
        //根据构建的条件查询数据
        return orderOrderConfigMapper.selectByExample(example);
    }


    /**
     * OrderOrderConfig构建查询对象
     * @param orderOrderConfig
     * @return
     */
    public Example createExample(OrderOrderConfig orderOrderConfig){
        Example example=new Example(OrderOrderConfig.class);
        Example.Criteria criteria = example.createCriteria();
        if(orderOrderConfig!=null){
            // ID
            if(!StringUtils.isEmpty(orderOrderConfig.getId())){
                    criteria.andEqualTo("id",orderOrderConfig.getId());
            }
            // 正常订单超时时间（分）
            if(!StringUtils.isEmpty(orderOrderConfig.getOrderOrderTimeout())){
                    criteria.andEqualTo("orderOrderTimeout",orderOrderConfig.getOrderOrderTimeout());
            }
            // 秒杀订单超时时间（分）
            if(!StringUtils.isEmpty(orderOrderConfig.getSeckillSeckillTimeout())){
                    criteria.andEqualTo("seckillSeckillTimeout",orderOrderConfig.getSeckillSeckillTimeout());
            }
            // 自动收货（天）
            if(!StringUtils.isEmpty(orderOrderConfig.getTakeTakeTimeout())){
                    criteria.andEqualTo("takeTakeTimeout",orderOrderConfig.getTakeTakeTimeout());
            }
            // 售后期限
            if(!StringUtils.isEmpty(orderOrderConfig.getServiceServiceTimeout())){
                    criteria.andEqualTo("serviceServiceTimeout",orderOrderConfig.getServiceServiceTimeout());
            }
            // 自动五星好评
            if(!StringUtils.isEmpty(orderOrderConfig.getCommentCommentTimeout())){
                    criteria.andEqualTo("commentCommentTimeout",orderOrderConfig.getCommentCommentTimeout());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id){
        orderOrderConfigMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改OrderOrderConfig
     * @param orderOrderConfig
     */
    @Override
    public void update(OrderOrderConfig orderOrderConfig){
        orderOrderConfigMapper.updateByPrimaryKey(orderOrderConfig);
    }

    /**
     * 增加OrderOrderConfig
     * @param orderOrderConfig
     */
    @Override
    public void add(OrderOrderConfig orderOrderConfig){
        orderOrderConfigMapper.insert(orderOrderConfig);
    }

    /**
     * 根据ID查询OrderOrderConfig
     * @param id
     * @return
     */
    @Override
    public OrderOrderConfig findById(Integer id){
        return  orderOrderConfigMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询OrderOrderConfig全部数据
     * @return
     */
    @Override
    public List<OrderOrderConfig> findAll() {
        return orderOrderConfigMapper.selectAll();
    }
}
