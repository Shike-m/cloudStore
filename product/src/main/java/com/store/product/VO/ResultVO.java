package com.store.product.VO;

//http returned outest object.
public class ResultVO<T> {
    private Integer code;  // error code
    private String msg; //notice information
    private T data;     //content

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
