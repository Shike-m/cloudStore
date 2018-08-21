package com.store.product.service;

import com.store.product.domain.ProductInfo;

import java.util.List;

public interface ProductService {
    List<ProductInfo> findUpAll();
}
