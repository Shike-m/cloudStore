package com.store.product.repository;

import com.store.product.domain.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void findByProductDescription() {
        List<ProductInfo> list = productRepository.findByProductStatus(0);

        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void findByProductIdIn() throws Exception{
        List<ProductInfo> list= productRepository.findByProductIdIn(Arrays.asList("157875196366160022","164103465734242707"));
        Assert.assertTrue(list.size()>0);
    }
}