package com.service;

import com.goods.pojo.Goods;
import com.goods.pojo.Spu;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SpuService {
    /***
     * Spu多条件分页查询
     * @param spu
     * @param page
     * @param size
     * @return
     */
    PageInfo<Spu> findPage(Spu spu, int page, int size);

    /***
     * Spu分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Spu> findPage(int page, int size);

    /***
     * Spu多条件搜索方法
     * @param spu
     * @return
     */
    List<Spu> findList(Spu spu);

    /***
     * 删除Spu
     * @param id
     */
    void delete(Long id);

    /***
     * 修改Spu数据
     * @param spu
     */
    void update(Spu spu);

    /***
     * 新增Spu
     * @param spu
     */
    void add(Spu spu);

    /**
     * 根据ID查询Spu
     * @param id
     * @return
     */
    Spu findById(Long id);

    /***
     * 查询所有Spu
     * @return
     */
    List<Spu> findAll();

    /**
     * 添加商品(SPU+ SKUlIST)
     * @param goods   update  add
     */
    void save(Goods goods);

    Goods findGoodsById(long id);

    /**
     * 审核商品
     * @param id
     */
    void auditSpu(long id);

    /**
     * 上架商品
     * @param id
     */
    void putSpu(long id);

    /**
     * 批量上架商品
     * @param ids
     * @return
     */
    int putMany(long[] ids);

    /**
     * 下架
     * @param id
     */
    void pullSpu(long id);

    /**
     * 批量下架商品
     * @param ids
     */
    int pullMany(long[] ids);

    void logicDeleteSpu(Long id);


    void restoreSpu(Long id);


}
