package com.store.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *  Created by Shike
 *  2018/8/22:16:59
 **/
@RestController
public class ServerController {

    @GetMapping("/msg")
    public String msg(){
        return "This is a message";
    }
}
