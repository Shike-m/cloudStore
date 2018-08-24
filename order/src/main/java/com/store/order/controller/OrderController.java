package com.store.order.controller;
/*
 *  Created by Shike
 *  2018/8/22:12:13
 **/


import com.store.order.Exception.OrderException;
import com.store.order.Form.OrderForm;
import com.store.order.VO.ResultVO;
import com.store.order.convertor.OrderFormConvertOrderDTO;
import com.store.order.dto.OrderDTO;
import com.store.order.enums.ResultEnums;
import com.store.order.service.OrderService;
import com.store.order.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
@Slf4j
class OrderController {
    /*
    * 1. arguments corresponding
    * 2. query commodities--need to invoke product information
    * 3. calculate total amount of order
    * 4. fulfill order -offset inventory - need to invoke product information
    * 5. save order.- add inventory to ralated stock.
    *
    * */

    @Autowired
    private OrderService orderService;

    @GetMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            log.error("incorrect order features, orderForm={}",orderForm);
            throw new OrderException(ResultEnums.PARAM_ERROR.getCode(),
                   bindingResult.getFieldError().getDefaultMessage() );
        }

        // From orderForm to orderDTO
        OrderDTO orderDTO = OrderFormConvertOrderDTO.convert(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetails())){
            throw new OrderException(ResultEnums.CART_EMPTY);
        }
        OrderDTO result=orderService.create(orderDTO);
        Map<String, String> map = new HashMap<>();
        map.put("orderId",result.getOrderId());
        return ResultVOUtil.success(map);
    }
}
