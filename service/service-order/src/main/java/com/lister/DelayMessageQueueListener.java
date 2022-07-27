package com.lister;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@RabbitListener(queues = "orderDelayQueue")
public class DelayMessageQueueListener {
    @RabbitHandler
   private void getDelaymessage(String message){
       SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       System.out.println("创建时间"+simpleDateFormat.format(new Date()));
       System.out.println("监听到的消息"+message);

   }

}
