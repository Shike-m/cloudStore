package com.store.order.controller;
/*
 *  Created by Shike
 *  2018/8/26:21:23
 **/

import com.store.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SendMessageController {

    @Autowired
    private StreamClient streamClient;

    @GetMapping("/sendMessage")
    public void process(){
        streamClient.output().send(MessageBuilder.withPayload("now "+new Date()).build());
    }
}
