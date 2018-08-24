package com.store.order.Exception;
/*
 *  Created by Shike
 *  2018/8/22:14:48
 **/

import com.store.order.enums.ResultEnums;

public class OrderException extends RuntimeException{
    private Integer code;

    public OrderException(Integer code,String message) {
        super(message);
        this.code = code;
    }
    public OrderException(ResultEnums resultEnums){
        super(resultEnums.getMsg());
        this.code=resultEnums.getCode();
    }
}
