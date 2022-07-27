package com.seckill.task;

import com.alibaba.fastjson.JSON;
import com.seckill.dao.SeckillSeckillGoodsMapper;
import entity.IdWorker;
import entity.SeckillStatus;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import pojo.SeckillSeckillGoods;
import pojo.SeckillSeckillOrder;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MultiThreadingCreateOrder {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private SeckillSeckillGoodsMapper seckillGoodsMapper;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    /**
     *Async：该方法异步执行方法
     */
    @Async
    public void createOrder(){
        try{
            System.out.println("睡眠");
            Thread.sleep(1000);
            SeckillStatus status=(SeckillStatus) redisTemplate.boundListOps("SeckillOrderQueue").rightPop();
           if(status==null){
               return;
           }
           //商品队列
           Object sgoods=redisTemplate.boundListOps("SeckillGoodCountList_"+status.getGoodsId()).rightPop();
           if(sgoods==null){
               //则表示没有库存，清理排队信息
               clearUserQueue(status.getUsername());
               return;
           }


            String username=status.getUsername();
            Long id= status.getGoodsId();
            String time=status.getTime();

            String namespace="SeckillGoods_"+time;
            SeckillSeckillGoods seckillGoods=(SeckillSeckillGoods)redisTemplate.boundHashOps(namespace).get(id);
            if(seckillGoods==null||seckillGoods.getStockStockCount()<=0){
                throw new RuntimeException("已售完");
            }
            SeckillSeckillOrder seckillOrder=new SeckillSeckillOrder();
            seckillOrder.setId(idWorker.nextId());
            seckillOrder.setSeckillSeckillId(id);
            seckillOrder.setMoney(seckillGoods.getCostCostPrice());
            seckillOrder.setUserUserId(username);
            seckillOrder.setCreateCreateTime(new Date());
            seckillOrder.setStatus("0");
            redisTemplate.boundHashOps("SeckillOrder").put(username,seckillOrder);
            seckillGoods.setStockStockCount(seckillGoods.getStockStockCount()-1);
            Thread.sleep(10000);
            System.out.println(Thread.currentThread().getId()+"操作后剩余="+seckillGoods.getStockStockCount());
            Long size=redisTemplate.boundListOps("SeckillGoodsCountList_"+status.getGoodsId()).size();


            if (size<=0){
                seckillGoods.setStockStockCount(size.intValue());
                seckillGoodsMapper.updateByPrimaryKeySelective(seckillGoods);
                redisTemplate.boundHashOps(namespace).delete(id);
            }else {
                redisTemplate.boundHashOps(namespace).put(id,seckillGoods);
            }
            //更新状态
            status.setOrderId(seckillOrder.getId());
            status.setMoney(Float.valueOf(seckillGoods.getCostCostPrice()));
            status.setStatus(2);
            redisTemplate.boundHashOps("UserQueueStatus").put(username,status);
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MMdd HH:mm:ss");
            System.out.println("下单时间"+simpleDateFormat.format(new Date()));
            //发送消息给延迟队列
            rabbitTemplate.convertAndSend("delaySeckillQueue", (Object) JSON.toJSONString(status), new MessagePostProcessor() {
                @Override
                public Message postProcessMessage(Message message) throws AmqpException {
                    message.getMessageProperties().setExpiration("1000");
                    return message;
                }
            });


            System.out.println("下单完成");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 清理用户抢单信息
     */
    public void clearUserQueue(String username){
        //排队信息
        redisTemplate.boundHashOps("UserQueueCount").delete(username);
        redisTemplate.boundHashOps("UserQueueStatus").delete(username);
    }
}
