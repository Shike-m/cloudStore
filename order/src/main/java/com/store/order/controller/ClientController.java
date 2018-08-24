package com.store.order.controller;
/*
 *  Created by Shike
 *  2018/8/22:17:39
 **/

import com.store.order.client.ProductClient;
import com.store.order.domain.ProductInfo;
import com.store.order.dto.CartDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class ClientController {
    //inject LoadBalancerClient --second  way to do it.
//    @Autowired
//    private LoadBalancerClient loadBalancerClient;
    //for Configured RestTemplate inject-third way to do it.
//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg(){
        //user RestTemplate to implement it. first way to get msg
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject("http://localhost:8080/msg",String.class);
//        log.info("response={}",response);
        // inject LoadBalancerClient to do that--another way to get msg
//        RestTemplate restTemplate = new RestTemplate();
//        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
//        String url = String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort());
//        String response = restTemplate.getForObject(url,String.class);
//        String response=restTemplate.getForObject("http://PRODUCT/msg",String.class);
//        log.info("response={}",response);

        String response=productClient.msg();
        return response;
    }
   
    @GetMapping("/getProductList")
    public String getProductList(){
        List<ProductInfo> list=productClient.listForOrder(Arrays.asList("157875196366160022","164103465734242707"));
        return "sucessful";
    }

    @GetMapping("/decreaseProduct")
    public String decreaseProduct(){
        productClient.decreaseStock(Arrays.asList(new CartDTO("164103465734242707",3)));
        return "success to reduce stocks";
    }
}
