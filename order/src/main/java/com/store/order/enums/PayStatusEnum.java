package com.store.order.enums;
/*
 *  Created by Shike
 *  2018/8/22:11:53
 **/

public enum PayStatusEnum {

    WAIT(0,"waiting to pay"),
    SUCCESS(1,"pay successful"),
        ;
    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String msg) {
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
