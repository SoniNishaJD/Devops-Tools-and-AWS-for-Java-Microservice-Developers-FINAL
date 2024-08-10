package com.nishasoni.controller;

import com.nishasoni.model.Coupon;
import com.nishasoni.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coupon")
public class CouponController {

    @Autowired
    CouponRepository repository;


    @RequestMapping(value = "/coupon", method = RequestMethod.POST)
    public Coupon create(@RequestBody Coupon coupon){
        return repository.save(coupon);
    }

    @RequestMapping(value = "/coupons/{code}", method = RequestMethod.GET)
    public Coupon getCoupon(@PathVariable("code") String code){
        return repository.findByCode(code);
    }

}
