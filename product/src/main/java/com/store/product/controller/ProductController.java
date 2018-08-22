package com.store.product.controller;

import com.store.product.VO.ProductInfoVO;
import com.store.product.VO.ProductVO;
import com.store.product.VO.ResultVO;
import com.store.product.domain.ProductCategory;
import com.store.product.domain.ProductInfo;
import com.store.product.service.ProductCategoryService;
import com.store.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
*  1. query all the products
*  2.
*
*
* */

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/list")
    public ResultVO<ProductVO> list(){
        List<ProductInfo> productInfoList=productService.findUpAll(); //query all the  onsale commodities
        List<Integer> categoryTypeList =productInfoList.stream()
                .map(p->p.getCategoryType())            //get all the types of commodities
                .collect(Collectors.toList());
            // 3. get all the categories from database
        List<ProductCategory>categoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);
        // construct data
        List<ProductVO> productVOlist = new ArrayList<>();
        for(ProductCategory pc:categoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(pc.getCategoryName());
            productVO.setCategoryType(pc.getCategoryType());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo p:productInfoList){
                if(p.getCategoryType().equals(pc.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
//                productInfoVO.setProductId(p.getProductId());
//                productInfoVO.setProductName(p.getProductName());
//                productInfoVO.setProductPrice(p.getProductPrice());
                    BeanUtils.copyProperties(p, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setFoods(productInfoVOList);
            productVOlist.add(productVO);
        }
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("successful");
        resultVO.setData(productVOlist);
        return resultVO;
    }
}
