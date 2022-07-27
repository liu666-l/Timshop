package com.order.service.impl;

import com.order.dao.OrderOrderItemMapper;
import com.order.pojo.OrderItem;
import com.order.service.OrderOrderItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class OrderOrderItemServiceImpl implements OrderOrderItemService {

    @Autowired
    private OrderOrderItemMapper orderOrderItemMapper;


    /**
     * OrderOrderItem条件+分页查询
     * @param orderItem 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<OrderItem> findPage(OrderItem orderItem, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(orderItem);
        //执行搜索
        return new PageInfo<OrderItem>(orderOrderItemMapper.selectByExample(example));
    }

    /**
     * OrderOrderItem分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<OrderItem> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<OrderItem>(orderOrderItemMapper.selectAll());
    }

    /**
     * OrderOrderItem条件查询
     * @param orderItem
     * @return
     */
    @Override
    public List<OrderItem> findList(OrderItem orderItem){
        //构建查询条件
        Example example = createExample(orderItem);
        //根据构建的条件查询数据
        return orderOrderItemMapper.selectByExample(example);
    }


    /**
     * OrderOrderItem构建查询对象
     * @param orderItem
     * @return
     */
    public Example createExample(OrderItem orderItem){
        Example example=new Example(OrderItem.class);
        Example.Criteria criteria = example.createCriteria();
        if(orderItem !=null){
            // ID
            if(!StringUtils.isEmpty(orderItem.getId())){
                    criteria.andEqualTo("id", orderItem.getId());
            }
            // 1级分类
            if(!StringUtils.isEmpty(orderItem.getCategoryCategoryId1())){
                    criteria.andEqualTo("categoryCategoryId1", orderItem.getCategoryCategoryId1());
            }
            // 2级分类
            if(!StringUtils.isEmpty(orderItem.getCategoryCategoryId2())){
                    criteria.andEqualTo("categoryCategoryId2", orderItem.getCategoryCategoryId2());
            }
            // 3级分类
            if(!StringUtils.isEmpty(orderItem.getCategoryCategoryId3())){
                    criteria.andEqualTo("categoryCategoryId3", orderItem.getCategoryCategoryId3());
            }
            // SPU_ID
            if(!StringUtils.isEmpty(orderItem.getSpuSpuId())){
                    criteria.andEqualTo("spuSpuId", orderItem.getSpuSpuId());
            }
            // SKU_ID
            if(!StringUtils.isEmpty(orderItem.getSkuSkuId())){
                    criteria.andEqualTo("skuSkuId", orderItem.getSkuSkuId());
            }
            // 订单ID
            if(!StringUtils.isEmpty(orderItem.getOrderOrderId())){
                    criteria.andEqualTo("orderOrderId", orderItem.getOrderOrderId());
            }
            // 商品名称
            if(!StringUtils.isEmpty(orderItem.getName())){
                    criteria.andLike("name","%"+ orderItem.getName()+"%");
            }
            // 单价
            if(!StringUtils.isEmpty(orderItem.getPrice())){
                    criteria.andEqualTo("price", orderItem.getPrice());
            }
            // 数量
            if(!StringUtils.isEmpty(orderItem.getNum())){
                    criteria.andEqualTo("num", orderItem.getNum());
            }
            // 总金额
            if(!StringUtils.isEmpty(orderItem.getMoney())){
                    criteria.andEqualTo("money", orderItem.getMoney());
            }
            // 实付金额
            if(!StringUtils.isEmpty(orderItem.getPayPayMoney())){
                    criteria.andEqualTo("payPayMoney", orderItem.getPayPayMoney());
            }
            // 图片地址
            if(!StringUtils.isEmpty(orderItem.getImage())){
                    criteria.andEqualTo("image", orderItem.getImage());
            }
            // 重量
            if(!StringUtils.isEmpty(orderItem.getWeight())){
                    criteria.andEqualTo("weight", orderItem.getWeight());
            }
            // 运费
            if(!StringUtils.isEmpty(orderItem.getPostPostFee())){
                    criteria.andEqualTo("postPostFee", orderItem.getPostPostFee());
            }
            // 是否退货
            if(!StringUtils.isEmpty(orderItem.getIsIsReturn())){
                    criteria.andEqualTo("isIsReturn", orderItem.getIsIsReturn());
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
        orderOrderItemMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改OrderOrderItem
     * @param orderItem
     */
    @Override
    public void update(OrderItem orderItem){
        orderOrderItemMapper.updateByPrimaryKey(orderItem);
    }

    /**
     * 增加OrderOrderItem
     * @param orderItem
     */
    @Override
    public void add(OrderItem orderItem){
        orderOrderItemMapper.insert(orderItem);
    }

    /**
     * 根据ID查询OrderOrderItem
     * @param id
     * @return
     */
    @Override
    public OrderItem findById(String id){
        return  orderOrderItemMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询OrderOrderItem全部数据
     * @return
     */
    @Override
    public List<OrderItem> findAll() {
        return orderOrderItemMapper.selectAll();
    }
}
