package com.seckill.mq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {
    @Bean
    public Queue delaySeckillQueue(){
        return QueueBuilder.durable("delaySeckillQueue")
                .withArgument("x-dead-letter-exchange","seckillExchange")
                .withArgument("x-dead-letter-routing-key","seckillQueue")
                .build();
    }
    @Bean
    public Queue seckillQueue(){
        return new  Queue("seckillQueue");
    }
    @Bean
    public Exchange seckillExchange(){
    return new DirectExchange("seckillExchange");
    }
    @Bean
    public Binding seckillQueueExchange(Queue seckillQueue,Exchange seckillExchange){
        return BindingBuilder.bind(seckillQueue).to(seckillExchange).with("seckillQueue").noargs();
    }
}
