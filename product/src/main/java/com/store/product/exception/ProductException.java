package com.store.product.exception;
/*
 *  Created by Shike
 *  2018/8/23:20:28
 **/

public class ProductException extends RuntimeException{
    private Integer code;

    public ProductException(Integer code,String message){
        super(message);
        this.code=code;
    }

    public ProductException(String message){
        super(message);
        this.code=9;
    }
}
