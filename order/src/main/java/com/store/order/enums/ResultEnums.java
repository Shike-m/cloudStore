package com.store.order.enums;
/*
 *  Created by Shike
 *  2018/8/22:14:49
 **/

public enum ResultEnums {
    PARAM_ERROR(0,"arguments error"),
    CART_EMPTY(1,"Cart is empty"),
    ;
    private Integer code;
    private String msg;

    ResultEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
