package com.store.order.Repository;
/*
 *  Created by Shike
 *  2018/8/22:11:34
 **/

import com.store.order.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
}
