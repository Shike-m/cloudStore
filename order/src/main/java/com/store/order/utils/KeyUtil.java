package com.store.order.utils;

import java.util.Random;

/*
 *  Created by Shike
 *  2018/8/22:12:52
 **/
//generate unique key for order
public class KeyUtil {
    public static synchronized String genUniqueKey(){
        Integer number = new Random().nextInt(900000) +1000000;
        return System.currentTimeMillis()+String.valueOf(number);
    }
}
