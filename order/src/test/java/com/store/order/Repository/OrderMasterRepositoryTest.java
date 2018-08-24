package com.store.order.Repository;

import com.store.order.OrderApplicationTests;
import com.store.order.domain.OrderMaster;
import com.store.order.enums.OrderStatusEnum;
import com.store.order.enums.PayStatusEnum;
import org.aspectj.weaver.ast.Or;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.Assert.*;

/*
 *  Created by Shike
 *  2018/8/22:11:35
 **/

@Component
public class OrderMasterRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void testSave(){
        OrderMaster or = new OrderMaster();
        or.setOrderId("01");
        or.setBuyerAddress("Court st");
        or.setBuyerName("XiaoLi");
        or.setBuyerOpenid("123");
        or.setBuyerPhone("133333333");
        or.setOrderAmount(new BigDecimal(10));
        or.setOrderStatus(OrderStatusEnum.NEW.getCode());
        or.setPayStatus(PayStatusEnum.WAIT.getCode());



       OrderMaster result= orderMasterRepository.save(or);
        Assert.assertTrue(result!=null);
    }
}