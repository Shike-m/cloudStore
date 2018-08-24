package com.store.product.service;

import com.store.product.DTO.CartDTO;
import com.store.product.domain.ProductInfo;

import java.util.List;

public interface ProductService {
    List<ProductInfo> findUpAll();
    //query for products list
    List<ProductInfo> findList(List<String> productIdList);

    //offset stocks
    void decreaseStock(List<CartDTO> cartDTOList);
}
