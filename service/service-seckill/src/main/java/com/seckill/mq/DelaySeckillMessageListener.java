package com.seckill.mq;

import com.alibaba.fastjson.JSON;
import com.seckill.service.SeckillSeckillOrderService;
import entity.SeckillStatus;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@RabbitListener(queues = "seckillQueue")
public class DelaySeckillMessageListener {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private SeckillSeckillOrderService seckillOrderService;
    @RabbitHandler
    public void getMessage(String m){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        System.out.println("回滚时间："+simpleDateFormat.format(new Date()));
        SeckillStatus status= JSON.parseObject(m,SeckillStatus.class);
        Object userQueue=redisTemplate.boundHashOps("UserQueueStatus").get(status.getUsername());
        if(userQueue!=null){
            seckillOrderService.deleteOrder(status.getUsername());
        }

    }
}
