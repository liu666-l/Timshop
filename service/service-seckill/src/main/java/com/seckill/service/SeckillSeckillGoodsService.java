package com.seckill.service;

import com.github.pagehelper.PageInfo;
import pojo.SeckillSeckillGoods;

import java.util.List;


public interface SeckillSeckillGoodsService {

    /***
     * SeckillSeckillGoods多条件分页查询
     * @param seckillSeckillGoods
     * @param page
     * @param size
     * @return
     */
    PageInfo<SeckillSeckillGoods> findPage(SeckillSeckillGoods seckillSeckillGoods, int page, int size);

    /***
     * SeckillSeckillGoods分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SeckillSeckillGoods> findPage(int page, int size);

    /***
     * SeckillSeckillGoods多条件搜索方法
     * @param seckillSeckillGoods
     * @return
     */
    List<SeckillSeckillGoods> findList(SeckillSeckillGoods seckillSeckillGoods);

    /***
     * 删除SeckillSeckillGoods
     * @param id
     */
    void delete(Long id);

    /***
     * 修改SeckillSeckillGoods数据
     * @param seckillSeckillGoods
     */
    void update(SeckillSeckillGoods seckillSeckillGoods);

    /***
     * 新增SeckillSeckillGoods
     * @param seckillSeckillGoods
     */
    void add(SeckillSeckillGoods seckillSeckillGoods);

    /**
     * 根据ID查询SeckillSeckillGoods
     * @param id
     * @return
     */
     SeckillSeckillGoods findById(Long id);

    /***
     * 查询所有SeckillSeckillGoods
     * @return
     */
    List<SeckillSeckillGoods> findAll();

   List<SeckillSeckillGoods> list(String time);
   SeckillSeckillGoods one(String time,Long id);
}
