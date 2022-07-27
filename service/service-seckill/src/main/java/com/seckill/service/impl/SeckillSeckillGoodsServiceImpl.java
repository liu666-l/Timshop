package com.seckill.service.impl;

import com.seckill.dao.SeckillSeckillGoodsMapper;
import com.seckill.service.SeckillSeckillGoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seckill.dao.SeckillSeckillGoodsMapper;
import entity.SystemConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pojo.SeckillSeckillGoods;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class SeckillSeckillGoodsServiceImpl implements SeckillSeckillGoodsService {

    @Autowired
    private SeckillSeckillGoodsMapper seckillSeckillGoodsMapper;


    /**
     * SeckillSeckillGoods条件+分页查询
     * @param seckillSeckillGoods 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SeckillSeckillGoods> findPage(SeckillSeckillGoods seckillSeckillGoods, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(seckillSeckillGoods);
        //执行搜索
        return new PageInfo<SeckillSeckillGoods>(seckillSeckillGoodsMapper.selectByExample(example));
    }

    /**
     * SeckillSeckillGoods分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SeckillSeckillGoods> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SeckillSeckillGoods>(seckillSeckillGoodsMapper.selectAll());
    }

    /**
     * SeckillSeckillGoods条件查询
     * @param seckillSeckillGoods
     * @return
     */
    @Override
    public List<SeckillSeckillGoods> findList(SeckillSeckillGoods seckillSeckillGoods){
        //构建查询条件
        Example example = createExample(seckillSeckillGoods);
        //根据构建的条件查询数据
        return seckillSeckillGoodsMapper.selectByExample(example);
    }


    /**
     * SeckillSeckillGoods构建查询对象
     * @param seckillSeckillGoods
     * @return
     */
    public Example createExample(SeckillSeckillGoods seckillSeckillGoods){
        Example example=new Example(SeckillSeckillGoods.class);
        Example.Criteria criteria = example.createCriteria();
        if(seckillSeckillGoods!=null){
            // 
            if(!StringUtils.isEmpty(seckillSeckillGoods.getId())){
                    criteria.andEqualTo("id",seckillSeckillGoods.getId());
            }
            // spu ID
            if(!StringUtils.isEmpty(seckillSeckillGoods.getGoodsGoodsId())){
                    criteria.andEqualTo("goodsGoodsId",seckillSeckillGoods.getGoodsGoodsId());
            }
            // sku ID
            if(!StringUtils.isEmpty(seckillSeckillGoods.getItemItemId())){
                    criteria.andEqualTo("itemItemId",seckillSeckillGoods.getItemItemId());
            }
            // 标题
            if(!StringUtils.isEmpty(seckillSeckillGoods.getTitle())){
                    criteria.andLike("title","%"+seckillSeckillGoods.getTitle()+"%");
            }
            // 商品图片
            if(!StringUtils.isEmpty(seckillSeckillGoods.getSmallSmallPic())){
                    criteria.andEqualTo("smallSmallPic",seckillSeckillGoods.getSmallSmallPic());
            }
            // 原价格
            if(!StringUtils.isEmpty(seckillSeckillGoods.getPrice())){
                    criteria.andEqualTo("price",seckillSeckillGoods.getPrice());
            }
            // 秒杀价格
            if(!StringUtils.isEmpty(seckillSeckillGoods.getCostCostPrice())){
                    criteria.andEqualTo("costCostPrice",seckillSeckillGoods.getCostCostPrice());
            }
            // 商家ID
            if(!StringUtils.isEmpty(seckillSeckillGoods.getSellerSellerId())){
                    criteria.andEqualTo("sellerSellerId",seckillSeckillGoods.getSellerSellerId());
            }
            // 添加日期
            if(!StringUtils.isEmpty(seckillSeckillGoods.getCreateCreateTime())){
                    criteria.andEqualTo("createCreateTime",seckillSeckillGoods.getCreateCreateTime());
            }
            // 审核日期
            if(!StringUtils.isEmpty(seckillSeckillGoods.getCheckCheckTime())){
                    criteria.andEqualTo("checkCheckTime",seckillSeckillGoods.getCheckCheckTime());
            }
            // 审核状态，0未审核，1审核通过，2审核不通过
            if(!StringUtils.isEmpty(seckillSeckillGoods.getStatus())){
                    criteria.andEqualTo("status",seckillSeckillGoods.getStatus());
            }
            // 开始时间
            if(!StringUtils.isEmpty(seckillSeckillGoods.getStartStartTime())){
                    criteria.andEqualTo("startStartTime",seckillSeckillGoods.getStartStartTime());
            }
            // 结束时间
            if(!StringUtils.isEmpty(seckillSeckillGoods.getEndEndTime())){
                    criteria.andEqualTo("endEndTime",seckillSeckillGoods.getEndEndTime());
            }
            // 秒杀商品数
            if(!StringUtils.isEmpty(seckillSeckillGoods.getNum())){
                    criteria.andEqualTo("num",seckillSeckillGoods.getNum());
            }
            // 剩余库存数
            if(!StringUtils.isEmpty(seckillSeckillGoods.getStockStockCount())){
                    criteria.andEqualTo("stockStockCount",seckillSeckillGoods.getStockStockCount());
            }
            // 描述
            if(!StringUtils.isEmpty(seckillSeckillGoods.getIntroduction())){
                    criteria.andEqualTo("introduction",seckillSeckillGoods.getIntroduction());
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
        seckillSeckillGoodsMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SeckillSeckillGoods
     * @param seckillSeckillGoods
     */
    @Override
    public void update(SeckillSeckillGoods seckillSeckillGoods){
        seckillSeckillGoodsMapper.updateByPrimaryKey(seckillSeckillGoods);
    }

    /**
     * 增加SeckillSeckillGoods
     * @param seckillSeckillGoods
     */
    @Override
    public void add(SeckillSeckillGoods seckillSeckillGoods){
        seckillSeckillGoodsMapper.insert(seckillSeckillGoods);
    }

    /**
     * 根据ID查询SeckillSeckillGoods
     * @param id
     * @return
     */
    @Override
    public SeckillSeckillGoods findById(Long id){
        return  seckillSeckillGoodsMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SeckillSeckillGoods全部数据
     * @return
     */
    @Override
    public List<SeckillSeckillGoods> findAll() {
        return seckillSeckillGoodsMapper.selectAll();
    }
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public List<SeckillSeckillGoods> list(String time) {
        return redisTemplate.boundHashOps(SystemConstants.SEC_KILL_GOODS_PREFIX+time).values();
    }

    @Override
    public SeckillSeckillGoods one(String time, Long id) {
        return (SeckillSeckillGoods) redisTemplate.boundHashOps(SystemConstants.SEC_KILL_GOODS_PREFIX+time).get(id);
    }
}
