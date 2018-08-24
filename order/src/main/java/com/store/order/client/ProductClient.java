package com.store.order.client;
/*
 *  Created by Shike
 *  2018/8/22:22:09
 *
 *  This interface just built for feign. Under this way, the config class does not need  again.
 **/

import com.store.order.domain.ProductInfo;
import com.store.order.dto.CartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="product")
public interface ProductClient {

    @GetMapping("/msg")
    public String msg();

    @PostMapping("/product/listForOrder")
    public List<ProductInfo> listForOrder(@RequestBody List<String> productIdList);

    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<CartDTO> cartDTOList);

}
