package com.store.product.service;

import com.store.product.DTO.CartDTO;
import com.store.product.domain.ProductInfo;
import com.store.product.repository.ProductRepositoryTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@Component
public class ProductServiceImplTest extends ProductRepositoryTest {

    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll() {
        List<ProductInfo> list = productService.findUpAll();
        Assert.assertTrue(((List) list).size()>0);
    }

    @Test
    public void decreateStock() throws Exception{
        CartDTO cartDTO = new CartDTO();
        cartDTO.setProductId("157875196366160022");
        cartDTO.setProductQuantity(2);
        List<CartDTO>list=new ArrayList<>();
        list.add(cartDTO);
        productService.decreaseStock(list);

    }
}