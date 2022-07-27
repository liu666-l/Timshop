package com.order.mq;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class MqConfig {
    @Autowired
    private Environment ev;
    @Bean
    public Queue orderDelayQueue(){
        return new Queue(ev.getProperty("${mq.pay.queue.order}"),true);
    }
    @Bean
    public Queue orderListenerQueue() {
        return QueueBuilder
                .durable("orderListenerQueue")
                //orderDelayQueue1队列信息会过期，过期之后，进入到死信队列，死信队列数据绑定到其他交换机
                .withArgument("x-dead-letter-exchange","orderListenerExchange")
                .withArgument("x-dead-letter-routing-key","orderDelayQueue") //绑定指定的routing-key
                .build();
    }
    @Bean
    public Exchange orderListenerExchange(){
        return new DirectExchange("orderListenerExchange");
    }
    @Bean
    public Binding orderListenerBinding(Queue orderDelayQueue,Exchange orderListenerExchange) {
        return BindingBuilder
                .bind(orderDelayQueue)
                .to(orderListenerExchange)
                .with("orderDelayQueue2")
                .noargs();
    }
//*******************创建秒杀队列*********************

}
