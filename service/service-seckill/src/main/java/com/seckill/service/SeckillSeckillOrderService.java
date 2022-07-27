package com.seckill.service;

import com.github.pagehelper.PageInfo;
import entity.SeckillStatus;
import pojo.SeckillSeckillOrder;

import java.util.List;


public interface SeckillSeckillOrderService {
//删除订单
void deleteOrder(String username);

    /**修改订单状态
     *
     */
    void updatePayStatus(String username, String transactionId, String endTime);
    /**
 * 状态查询
 */
SeckillStatus queryStatus(String username);
    /***
     * SeckillSeckillOrder多条件分页查询
     * @param seckillSeckillOrder
     * @param page
     * @param size
     * @return
     */
    PageInfo<SeckillSeckillOrder> findPage(SeckillSeckillOrder seckillSeckillOrder, int page, int size);

    /***
     * SeckillSeckillOrder分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SeckillSeckillOrder> findPage(int page, int size);

    /***
     * SeckillSeckillOrder多条件搜索方法
     * @param seckillSeckillOrder
     * @return
     */
    List<SeckillSeckillOrder> findList(SeckillSeckillOrder seckillSeckillOrder);

    /***
     * 删除SeckillSeckillOrder
     * @param id
     */
    void delete(Long id);

    /***
     * 修改SeckillSeckillOrder数据
     * @param seckillSeckillOrder
     */
    void update(SeckillSeckillOrder seckillSeckillOrder);

    /***
     * 新增SeckillSeckillOrder
     *
     */
    boolean add(String time,Long id,String username);

    /**
     * 根据ID查询SeckillSeckillOrder
     * @param id
     * @return
     */
     SeckillSeckillOrder findById(Long id);

    /***
     * 查询所有SeckillSeckillOrder
     * @return
     */
    List<SeckillSeckillOrder> findAll();
}
