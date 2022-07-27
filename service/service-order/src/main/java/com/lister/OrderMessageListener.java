package com.lister;

import com.alibaba.fastjson.JSON;
import com.order.service.OrderService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = {"queue.order"})
public class OrderMessageListener {
    private final static String SUCCESS = "SUCCESS";

    @Autowired
    private OrderService orderService;

//    @Autowired
//    private WeChatPayFeign weChatPayFeign;

    /**
     * 监听mq的消息
     * @param message xml格式的消息
     */
    @RabbitHandler
    public void getMessage(String message) throws Exception {
        Map<String, String> map = JSON.parseObject(message,Map.class);
        System.out.println("监听到的消息："+map);
        String return_code=map.get("return_code");
        if(return_code.equals("SUCCESS")){
            String reslut_code=map.get("result_code");
            String out_trade_no=map.get("out_trade_no");
            if(return_code.equals("SUCCESS")){
                orderService.updateStatus(out_trade_no,map.get("time_end"),map.get("trandsaction_id"));
            }else{
                orderService.deleteOrder(out_trade_no);
            }
        }

    }

}
