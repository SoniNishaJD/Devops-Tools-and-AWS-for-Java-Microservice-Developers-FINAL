package com.nishasoni.controller;

import com.nishasoni.dto.Coupon;
import com.nishasoni.model.Product;
import com.nishasoni.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private RestTemplate restTemplate;
    @Value("${couponService.url}")
    private String CouponServiceURL;

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public Product create(@RequestBody Product product){
       Coupon coupon = restTemplate.getForObject("http://localhost:8081/ai/coupon/coupons/" + product.getCouponCode(), Coupon.class);
       product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
        return repository.save(product);
    }

    public Product sendErrorResponse(Product product){
        return  product;
    }
}
