package com.store.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/*
 *  Created by Shike
 *  2018/8/26:19:15
 **/
@Slf4j
@Component

public class MqReceiver {
    @RabbitListener(queues="myQueue")
    public void process(String message){
        log.info("MqReceiver:{}",message);
    }
}
