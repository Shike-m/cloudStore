package com.store.order.convertor;
/*
 *  Created by Shike
 *  2018/8/22:14:58
 **/

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.store.order.Exception.OrderException;
import com.store.order.Form.OrderForm;
import com.store.order.domain.OrderDetail;
import com.store.order.dto.OrderDTO;
import com.store.order.enums.ResultEnums;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class OrderFormConvertOrderDTO {
    public static OrderDTO convert(OrderForm orderForm){
        Gson gson = new Gson();
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> list=new ArrayList<>();
        try {
            list = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        }catch(Exception e){
            throw new OrderException(ResultEnums.PARAM_ERROR);
        }
        orderDTO.setOrderDetails(list);
        return orderDTO;
    }

}
