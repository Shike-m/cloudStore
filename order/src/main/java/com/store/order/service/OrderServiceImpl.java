package com.store.order.service;
/*
 *  Created by Shike
 *  2018/8/22:12:25
 **/

import com.store.order.Repository.OrderDetailRepository;
import com.store.order.Repository.OrderMasterRepository;
import com.store.order.client.ProductClient;
import com.store.order.domain.OrderDetail;
import com.store.order.domain.OrderMaster;
import com.store.order.domain.ProductInfo;
import com.store.order.dto.CartDTO;
import com.store.order.dto.OrderDTO;
import com.store.order.enums.OrderStatusEnum;
import com.store.order.enums.PayStatusEnum;
import com.store.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private ProductClient productClient;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        //generate order id
        String orderId=KeyUtil.genUniqueKey();
        //query product to confirm.
        List<String> productList = orderDTO.getOrderDetails().stream()
                                    .map(OrderDetail::getProductId)
                                    .collect(Collectors.toList());

        List<ProductInfo> productInfoList = productClient.listForOrder(productList);
        //calculate amount of order = price*quantity of items.
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        for(OrderDetail orderDetail:orderDTO.getOrderDetails()){
            for(ProductInfo productInfo:productInfoList){
                if(productInfo.getProductId().equals(orderDetail.getProductId())){
                    orderAmount=productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmount);
                    BeanUtils.copyProperties(productInfo,orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.genUniqueKey());
                    //fulfilled order
                    orderDetailRepository.save(orderDetail);
                }
            }
        }
        //offset stocks
        List<CartDTO> cartDTOList = orderDTO.getOrderDetails().stream()
                                    .map(e->new CartDTO(e.getProductId(),e.getProductQuantity()))
                                    .collect(Collectors.toList());
        productClient.decreaseStock(cartDTOList);

        //save order
        OrderMaster orderMaster  = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderDTO.setOrderAmount(orderAmount);
        orderDTO.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderDTO.setPayStatus(PayStatusEnum.WAIT.getCode());

        orderMasterRepository.save(orderMaster);

        return orderDTO;
    }
}
