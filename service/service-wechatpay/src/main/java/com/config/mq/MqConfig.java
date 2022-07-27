package com.config.mq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

@Configuration
public class MqConfig {
    /**
     * 读取配置文件的内容
     */
    @Resource
    private Environment environment;

//    /**
//     * 创建队列
//     * @return
//     */
//    @Bean
//    public Queue orderQueue() {
//        return new Queue(environment.getProperty("mq.pay.queue.order"));
//    }
//
//    /**
//     * 创建交换机
//     * @return
//     */
//    @Bean
//    public Exchange orderExchange() {
//        return new DirectExchange(environment.getProperty("mq.pay.exchange.order"),true,false);
//    }
//
//    /**
//     * 队列绑定交换机
//     * @param queue
//     * @param exchange
//     * @return
//     */
//    @Bean
//    public Binding orderQueueExchange( Queue queue , Exchange exchange) {
//        return BindingBuilder.bind(queue).to(exchange).with(environment.getProperty("mq.pay.routing.key")).noargs();
//    }
    //***********，秒杀订单****************、
    @Bean
    public Queue SeckillrderQueue(){
        return new Queue(environment.getProperty("mq.pay.queue.seckillorder"));
    }
    @Bean
    public Exchange SedkillorderListenerExchange(){
        return new DirectExchange(environment.getProperty("mq.pay.exchange.seckillorder"),true,false);
    }
    @Bean
    public Binding SeckillorderListenerQueue(Queue SeckillrderQueue, Exchange SedkillorderListenerExchange) {
        return BindingBuilder
                .bind(SeckillrderQueue)
                .to(SedkillorderListenerExchange)
                .with(environment.getProperty("mq.pay.routing.seckillkey"))
                .noargs();
    }


}
