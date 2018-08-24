package com.store.order.service;
/*
 *  Created by Shike
 *  2018/8/22:12:19
 **/

import com.store.order.dto.OrderDTO;

public interface OrderService {
    OrderDTO create(OrderDTO orderDTO);

}
