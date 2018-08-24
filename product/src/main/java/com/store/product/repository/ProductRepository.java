package com.store.product.repository;

import com.store.product.domain.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<ProductInfo,String> {
    List<ProductInfo> findByProductStatus(Integer productStatus);
    List<ProductInfo> findByProductIdIn(List<String > productIdList);
}
