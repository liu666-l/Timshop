package com.order.service.impl;

import com.order.dao.ReturnReturnOrderItemMapper;
import com.order.pojo.ReturnReturnOrderItem;
import com.order.service.ReturnReturnOrderItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class ReturnReturnOrderItemServiceImpl implements ReturnReturnOrderItemService {

    @Autowired
    private ReturnReturnOrderItemMapper returnReturnOrderItemMapper;


    /**
     * ReturnReturnOrderItem条件+分页查询
     * @param returnReturnOrderItem 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<ReturnReturnOrderItem> findPage(ReturnReturnOrderItem returnReturnOrderItem, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(returnReturnOrderItem);
        //执行搜索
        return new PageInfo<ReturnReturnOrderItem>(returnReturnOrderItemMapper.selectByExample(example));
    }

    /**
     * ReturnReturnOrderItem分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<ReturnReturnOrderItem> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<ReturnReturnOrderItem>(returnReturnOrderItemMapper.selectAll());
    }

    /**
     * ReturnReturnOrderItem条件查询
     * @param returnReturnOrderItem
     * @return
     */
    @Override
    public List<ReturnReturnOrderItem> findList(ReturnReturnOrderItem returnReturnOrderItem){
        //构建查询条件
        Example example = createExample(returnReturnOrderItem);
        //根据构建的条件查询数据
        return returnReturnOrderItemMapper.selectByExample(example);
    }


    /**
     * ReturnReturnOrderItem构建查询对象
     * @param returnReturnOrderItem
     * @return
     */
    public Example createExample(ReturnReturnOrderItem returnReturnOrderItem){
        Example example=new Example(ReturnReturnOrderItem.class);
        Example.Criteria criteria = example.createCriteria();
        if(returnReturnOrderItem!=null){
            // ID
            if(!StringUtils.isEmpty(returnReturnOrderItem.getId())){
                    criteria.andEqualTo("id",returnReturnOrderItem.getId());
            }
            // 分类ID
            if(!StringUtils.isEmpty(returnReturnOrderItem.getCategoryCategoryId())){
                    criteria.andEqualTo("categoryCategoryId",returnReturnOrderItem.getCategoryCategoryId());
            }
            // SPU_ID
            if(!StringUtils.isEmpty(returnReturnOrderItem.getSpuSpuId())){
                    criteria.andEqualTo("spuSpuId",returnReturnOrderItem.getSpuSpuId());
            }
            // SKU_ID
            if(!StringUtils.isEmpty(returnReturnOrderItem.getSkuSkuId())){
                    criteria.andEqualTo("skuSkuId",returnReturnOrderItem.getSkuSkuId());
            }
            // 订单ID
            if(!StringUtils.isEmpty(returnReturnOrderItem.getOrderOrderId())){
                    criteria.andEqualTo("orderOrderId",returnReturnOrderItem.getOrderOrderId());
            }
            // 订单明细ID
            if(!StringUtils.isEmpty(returnReturnOrderItem.getOrderOrderItemId())){
                    criteria.andEqualTo("orderOrderItemId",returnReturnOrderItem.getOrderOrderItemId());
            }
            // 退货订单ID
            if(!StringUtils.isEmpty(returnReturnOrderItem.getReturnReturnOrderId())){
                    criteria.andEqualTo("returnReturnOrderId",returnReturnOrderItem.getReturnReturnOrderId());
            }
            // 标题
            if(!StringUtils.isEmpty(returnReturnOrderItem.getTitle())){
                    criteria.andLike("title","%"+returnReturnOrderItem.getTitle()+"%");
            }
            // 单价
            if(!StringUtils.isEmpty(returnReturnOrderItem.getPrice())){
                    criteria.andEqualTo("price",returnReturnOrderItem.getPrice());
            }
            // 数量
            if(!StringUtils.isEmpty(returnReturnOrderItem.getNum())){
                    criteria.andEqualTo("num",returnReturnOrderItem.getNum());
            }
            // 总金额
            if(!StringUtils.isEmpty(returnReturnOrderItem.getMoney())){
                    criteria.andEqualTo("money",returnReturnOrderItem.getMoney());
            }
            // 支付金额
            if(!StringUtils.isEmpty(returnReturnOrderItem.getPayPayMoney())){
                    criteria.andEqualTo("payPayMoney",returnReturnOrderItem.getPayPayMoney());
            }
            // 图片地址
            if(!StringUtils.isEmpty(returnReturnOrderItem.getImage())){
                    criteria.andEqualTo("image",returnReturnOrderItem.getImage());
            }
            // 重量
            if(!StringUtils.isEmpty(returnReturnOrderItem.getWeight())){
                    criteria.andEqualTo("weight",returnReturnOrderItem.getWeight());
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
        returnReturnOrderItemMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改ReturnReturnOrderItem
     * @param returnReturnOrderItem
     */
    @Override
    public void update(ReturnReturnOrderItem returnReturnOrderItem){
        returnReturnOrderItemMapper.updateByPrimaryKey(returnReturnOrderItem);
    }

    /**
     * 增加ReturnReturnOrderItem
     * @param returnReturnOrderItem
     */
    @Override
    public void add(ReturnReturnOrderItem returnReturnOrderItem){
        returnReturnOrderItemMapper.insert(returnReturnOrderItem);
    }

    /**
     * 根据ID查询ReturnReturnOrderItem
     * @param id
     * @return
     */
    @Override
    public ReturnReturnOrderItem findById(String id){
        return  returnReturnOrderItemMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询ReturnReturnOrderItem全部数据
     * @return
     */
    @Override
    public List<ReturnReturnOrderItem> findAll() {
        return returnReturnOrderItemMapper.selectAll();
    }
}
