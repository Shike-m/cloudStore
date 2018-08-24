package com.store.order.service;
/*
 *  Created by Shike
 *  2018/8/22:12:25
 **/

import com.store.order.Repository.OrderDetailRepository;
import com.store.order.Repository.OrderMasterRepository;
import com.store.order.domain.OrderMaster;
import com.store.order.dto.OrderDTO;
import com.store.order.enums.OrderStatusEnum;
import com.store.order.enums.PayStatusEnum;
import com.store.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        //save order
        OrderMaster orderMaster  = new OrderMaster();
        orderDTO.setOrderId(KeyUtil.genUniqueKey());
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderDTO.setOrderAmount(new BigDecimal(5));
        orderDTO.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderDTO.setPayStatus(PayStatusEnum.WAIT.getCode());

        orderMasterRepository.save(orderMaster);

        return orderDTO;
    }
}
