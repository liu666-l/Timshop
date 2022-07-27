package com.seckill.mq;

import com.alibaba.fastjson.JSON;
import com.seckill.service.SeckillSeckillOrderService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "${mq.pay.queue.seckillorder}")
public class SeckillMessageListener {
    @Autowired
    private SeckillSeckillOrderService seckillOrderService;
    @RabbitHandler
public void getMessage(String m){
     //将支付信息转成Map
        try {
            Map<String,String> resultmap= JSON.parseObject(m,Map.class);
            //return_code->通信表始-Success
            String return_code=resultmap.get("return_code");
            String outtradeno=resultmap.get("out_trade_no");
            String attach=resultmap.get("attach");
            Map<String,String> attachMap= JSON.parseObject(attach,Map.class);
            if(return_code.equals("SUCCESS")){
                String result_code=resultmap.get("return_code");
                if(result_code.equals("SUCCESS")){
                seckillOrderService.updatePayStatus(attachMap.get("username"),resultmap.get("transaction_id"),resultmap.get("time_end"));
                }else {
                    seckillOrderService.deleteOrder(attachMap.get("username"));
                }
            }
            //
        } catch (Exception e) {
            e.printStackTrace();
        }

}
}
