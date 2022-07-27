package com.user.service.impl;

import com.user.dao.StockStockBackMapper;
import com.user.pojo.StockStockBack;
import com.user.service.StockStockBackService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class StockStockBackServiceImpl implements StockStockBackService {

    @Autowired
    private StockStockBackMapper stockStockBackMapper;


    /**
     * StockStockBack条件+分页查询
     * @param stockStockBack 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<StockStockBack> findPage(StockStockBack stockStockBack, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(stockStockBack);
        //执行搜索
        return new PageInfo<StockStockBack>(stockStockBackMapper.selectByExample(example));
    }

    /**
     * StockStockBack分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<StockStockBack> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<StockStockBack>(stockStockBackMapper.selectAll());
    }

    /**
     * StockStockBack条件查询
     * @param stockStockBack
     * @return
     */
    @Override
    public List<StockStockBack> findList(StockStockBack stockStockBack){
        //构建查询条件
        Example example = createExample(stockStockBack);
        //根据构建的条件查询数据
        return stockStockBackMapper.selectByExample(example);
    }


    /**
     * StockStockBack构建查询对象
     * @param stockStockBack
     * @return
     */
    public Example createExample(StockStockBack stockStockBack){
        Example example=new Example(StockStockBack.class);
        Example.Criteria criteria = example.createCriteria();
        if(stockStockBack!=null){
            // 订单id
            if(!StringUtils.isEmpty(stockStockBack.getOrderOrderId())){
                    criteria.andEqualTo("orderOrderId",stockStockBack.getOrderOrderId());
            }
            // SKU的id
            if(!StringUtils.isEmpty(stockStockBack.getSkuSkuId())){
                    criteria.andEqualTo("skuSkuId",stockStockBack.getSkuSkuId());
            }
            // 回滚数量
            if(!StringUtils.isEmpty(stockStockBack.getNum())){
                    criteria.andEqualTo("num",stockStockBack.getNum());
            }
            // 回滚状态
            if(!StringUtils.isEmpty(stockStockBack.getStatus())){
                    criteria.andEqualTo("status",stockStockBack.getStatus());
            }
            // 创建时间
            if(!StringUtils.isEmpty(stockStockBack.getCreateCreateTime())){
                    criteria.andEqualTo("createCreateTime",stockStockBack.getCreateCreateTime());
            }
            // 回滚时间
            if(!StringUtils.isEmpty(stockStockBack.getBackBackTime())){
                    criteria.andEqualTo("backBackTime",stockStockBack.getBackBackTime());
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
        stockStockBackMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改StockStockBack
     * @param stockStockBack
     */
    @Override
    public void update(StockStockBack stockStockBack){
        stockStockBackMapper.updateByPrimaryKey(stockStockBack);
    }

    /**
     * 增加StockStockBack
     * @param stockStockBack
     */
    @Override
    public void add(StockStockBack stockStockBack){
        stockStockBackMapper.insert(stockStockBack);
    }

    /**
     * 根据ID查询StockStockBack
     * @param id
     * @return
     */
    @Override
    public StockStockBack findById(String id){
        return  stockStockBackMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询StockStockBack全部数据
     * @return
     */
    @Override
    public List<StockStockBack> findAll() {
        return stockStockBackMapper.selectAll();
    }
}
