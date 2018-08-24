package com.store.order.Form;
/*
 *  Created by Shike
 *  2018/8/22:13:50
 **/

import javax.validation.constraints.NotEmpty;

public class OrderForm {
    //The name of buyer
    @NotEmpty
    private String name;
// phone number of buyer
    @NotEmpty
    private String phone;
    @NotEmpty
    private String address;
    @NotEmpty
    private String openid;
    @NotEmpty
    private String items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String item) {
        this.items = item;
    }
}
