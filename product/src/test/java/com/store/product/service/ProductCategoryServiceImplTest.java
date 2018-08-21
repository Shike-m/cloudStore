package com.store.product.service;

import com.store.product.domain.ProductCategory;
import com.store.product.repository.ProductCategoryRepository;
import com.store.product.repository.ProductRepositoryTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@Component
public class ProductCategoryServiceImplTest extends ProductRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> list=productCategoryRepository.findByCategoryTypeIn(Arrays.asList(11,22));
        Assert.assertTrue(list.size()>0);
    }
}