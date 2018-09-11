package com.store.order.message;
/*
 *  Created by Shike
 *  2018/8/26:21:14
 **/

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface StreamClient {
    @Input("myMessage")
    SubscribableChannel input();

    @Output("myMessage")
    MessageChannel output();
}
