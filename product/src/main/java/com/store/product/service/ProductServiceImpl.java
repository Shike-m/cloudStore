package com.store.product.service;

import com.store.product.DTO.CartDTO;
import com.store.product.domain.ProductInfo;
import com.store.product.enums.ProductStatusEnum;
import com.store.product.exception.ProductException;
import com.store.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findList(List<String> productIdList) {
        return productRepository.findByProductIdIn(productIdList);
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO:cartDTOList){
            Optional<ProductInfo> productInfoOptional=productRepository.findById(cartDTO.getProductId());
            if(!productInfoOptional.isPresent()){
                throw new ProductException("No such stocks now");
            }
            ProductInfo productInfo=productInfoOptional.get();
            Integer result=productInfo.getProductStock()-cartDTO.getProductQuantity();
            if(result<0){
                throw new ProductException("The amount of Stock cannot fulfill the order");
            }
            productInfo.setProductStatus(result);
            productRepository.save(productInfo);
        }
    }
}
