package com.store.order.enums;
/*
 *  Created by Shike
 *  2018/8/22:11:48
 **/

public enum OrderStatusEnum {
    NEW(0,"new order"),
    FINISHED(1,"finished order"),
    CANCEL(2,"cancel order"),
    ;
    private Integer code;
    private String message;
    OrderStatusEnum(Integer code, String msg) {
        this.code=code;
        this.message=msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
