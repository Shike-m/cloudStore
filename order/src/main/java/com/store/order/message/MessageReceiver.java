package com.store.order.message;
/*
 *  Created by Shike
 *  2018/8/26:21:20
 **/

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class MessageReceiver {

    @StreamListener("myMessage")
    public void process(Object message){
        log.info("MessageReceiver:{}",message);
    }
}
