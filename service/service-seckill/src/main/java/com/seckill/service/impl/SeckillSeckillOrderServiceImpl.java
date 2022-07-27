package com.seckill.service.impl;

import com.seckill.dao.SeckillSeckillGoodsMapper;
import com.seckill.dao.SeckillSeckillOrderMapper;
import com.seckill.service.SeckillSeckillOrderService;
import com.seckill.task.MultiThreadingCreateOrder;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import entity.SeckillStatus;
import entity.SystemConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pojo.SeckillSeckillGoods;
import pojo.SeckillSeckillOrder;
import tk.mybatis.mapper.entity.Example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SeckillSeckillOrderServiceImpl implements SeckillSeckillOrderService {

    @Autowired
    private SeckillSeckillOrderMapper seckillSeckillOrderMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private SeckillSeckillGoodsMapper seckillGoodsMapper;
    @Autowired
    private MultiThreadingCreateOrder multiThreadingCreateOrder;
    //删除订单
    @Override
    public void deleteOrder(String username) {
        redisTemplate.boundHashOps("SeckillOrder").delete(username);
        //删除用户的排队信息
        redisTemplate.boundHashOps(SystemConstants.SEC_KILL_USER_QUEUE_COUNT).delete(username);  //清除排队队列
        redisTemplate.boundHashOps(SystemConstants.SEC_KILL_USER_STATUS_KEY).delete(username);   //排队状态队列

        SeckillStatus seckillStatus=(SeckillStatus) redisTemplate.boundHashOps("UserQueueStatus").get(username);

       SeckillSeckillGoods seckillGoods=(SeckillSeckillGoods) redisTemplate.boundHashOps(SystemConstants.SEC_KILL_GOODS_PREFIX+seckillStatus.getTime());
        if(seckillGoods==null){
            seckillGoodsMapper.selectByPrimaryKey(seckillGoods.getId());
            seckillGoods.setStockStockCount(seckillGoods.getStockStockCount()+1);
            seckillGoodsMapper.updateByPrimaryKeySelective(seckillGoods);
        }else {
            seckillGoods.setStockStockCount(seckillGoods.getStockStockCount()+1);
        }
        redisTemplate.boundHashOps(SystemConstants.SEC_KILL_GOODS_PREFIX+seckillStatus.getTime()).put(seckillGoods.getId(),seckillGoods);
        redisTemplate.boundListOps(SystemConstants.SEC_KILL_GOODS_COUNT_LIST+seckillGoods.getId()).leftPush("0");
    }

    //秒杀订单修改状态
    @Override
    public void updatePayStatus(String username, String transactionId, String endTime) {
        SeckillSeckillOrder order=(SeckillSeckillOrder) redisTemplate.boundHashOps(SystemConstants.SEC_KILL_ORDER_KEY).get(username);
        if(order!=null){
            order.setStatus("1");
            order.setTransactionTransactionId(transactionId);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            try {
                order.setPayPayTime(simpleDateFormat.parse(endTime));
                seckillSeckillOrderMapper.insertSelective(order);  //将订单信息存到mysql中

                //删除redis中的订单信息
                redisTemplate.boundHashOps(SystemConstants.SEC_KILL_ORDER_KEY).delete(username);

                //删除用户的排队信息
                redisTemplate.boundHashOps(SystemConstants.SEC_KILL_USER_QUEUE_COUNT).delete(username);  //清除排队队列
                redisTemplate.boundHashOps(SystemConstants.SEC_KILL_USER_STATUS_KEY).delete(username);   //排队状态队列
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    //抢单状态查询
    @Override
    public SeckillStatus queryStatus(String username) {
        return (SeckillStatus) redisTemplate.boundHashOps("UserQueueStatus").get(username);
    }

    /**
     * SeckillSeckillOrder条件+分页查询
     * @param seckillSeckillOrder 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SeckillSeckillOrder> findPage(SeckillSeckillOrder seckillSeckillOrder, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(seckillSeckillOrder);
        //执行搜索
        return new PageInfo<SeckillSeckillOrder>(seckillSeckillOrderMapper.selectByExample(example));
    }

    /**
     * SeckillSeckillOrder分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SeckillSeckillOrder> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SeckillSeckillOrder>(seckillSeckillOrderMapper.selectAll());
    }

    /**
     * SeckillSeckillOrder条件查询
     * @param seckillSeckillOrder
     * @return
     */
    @Override
    public List<SeckillSeckillOrder> findList(SeckillSeckillOrder seckillSeckillOrder){
        //构建查询条件
        Example example = createExample(seckillSeckillOrder);
        //根据构建的条件查询数据
        return seckillSeckillOrderMapper.selectByExample(example);
    }


    /**
     * SeckillSeckillOrder构建查询对象
     * @param seckillSeckillOrder
     * @return
     */
    public Example createExample(SeckillSeckillOrder seckillSeckillOrder){
        Example example=new Example(SeckillSeckillOrder.class);
        Example.Criteria criteria = example.createCriteria();
        if(seckillSeckillOrder!=null){
            // 主键
            if(!StringUtils.isEmpty(seckillSeckillOrder.getId())){
                    criteria.andEqualTo("id",seckillSeckillOrder.getId());
            }
            // 秒杀商品ID
            if(!StringUtils.isEmpty(seckillSeckillOrder.getSeckillSeckillId())){
                    criteria.andEqualTo("seckillSeckillId",seckillSeckillOrder.getSeckillSeckillId());
            }
            // 支付金额
            if(!StringUtils.isEmpty(seckillSeckillOrder.getMoney())){
                    criteria.andEqualTo("money",seckillSeckillOrder.getMoney());
            }
            // 用户
            if(!StringUtils.isEmpty(seckillSeckillOrder.getUserUserId())){
                    criteria.andEqualTo("userUserId",seckillSeckillOrder.getUserUserId());
            }
            // 商家
            if(!StringUtils.isEmpty(seckillSeckillOrder.getSellerSellerId())){
                    criteria.andEqualTo("sellerSellerId",seckillSeckillOrder.getSellerSellerId());
            }
            // 创建时间
            if(!StringUtils.isEmpty(seckillSeckillOrder.getCreateCreateTime())){
                    criteria.andEqualTo("createCreateTime",seckillSeckillOrder.getCreateCreateTime());
            }
            // 支付时间
            if(!StringUtils.isEmpty(seckillSeckillOrder.getPayPayTime())){
                    criteria.andEqualTo("payPayTime",seckillSeckillOrder.getPayPayTime());
            }
            // 状态，0未支付，1已支付
            if(!StringUtils.isEmpty(seckillSeckillOrder.getStatus())){
                    criteria.andEqualTo("status",seckillSeckillOrder.getStatus());
            }
            // 收货人地址
            if(!StringUtils.isEmpty(seckillSeckillOrder.getReceiverReceiverAddress())){
                    criteria.andEqualTo("receiverReceiverAddress",seckillSeckillOrder.getReceiverReceiverAddress());
            }
            // 收货人电话
            if(!StringUtils.isEmpty(seckillSeckillOrder.getReceiverReceiverMobile())){
                    criteria.andEqualTo("receiverReceiverMobile",seckillSeckillOrder.getReceiverReceiverMobile());
            }
            // 收货人
            if(!StringUtils.isEmpty(seckillSeckillOrder.getReceiver())){
                    criteria.andEqualTo("receiver",seckillSeckillOrder.getReceiver());
            }
            // 交易流水
            if(!StringUtils.isEmpty(seckillSeckillOrder.getTransactionTransactionId())){
                    criteria.andEqualTo("transactionTransactionId",seckillSeckillOrder.getTransactionTransactionId());
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
        seckillSeckillOrderMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SeckillSeckillOrder
     * @param seckillSeckillOrder
     */
    @Override
    public void update(SeckillSeckillOrder seckillSeckillOrder){
        seckillSeckillOrderMapper.updateByPrimaryKey(seckillSeckillOrder);
    }

    /**
     * 秒杀下单
     * @param time
     * @param id
     * @param username
     * @return
     */
    @Override
    public boolean add(String time, Long id, String username) {
        //记录用户排队次数
        Long usercount=redisTemplate.boundHashOps("UserQueueCount").increment(username,1);
        if(usercount>1){
            throw new RuntimeException("100");
        }
       SeckillStatus status= new SeckillStatus(username,new Date(),1,id,time);
       redisTemplate.boundListOps("SeckillOrderQueue").leftPush(status);
       redisTemplate.boundHashOps("UserQueueStatus").put(username,status);
        multiThreadingCreateOrder.createOrder();

        return true;
    }

    /**
     * 根据ID查询SeckillSeckillOrder
     * @param id
     * @return
     */
    @Override
    public SeckillSeckillOrder findById(Long id){
        return  seckillSeckillOrderMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SeckillSeckillOrder全部数据
     * @return
     */
    @Override
    public List<SeckillSeckillOrder> findAll() {
        return seckillSeckillOrderMapper.selectAll();
    }
}
