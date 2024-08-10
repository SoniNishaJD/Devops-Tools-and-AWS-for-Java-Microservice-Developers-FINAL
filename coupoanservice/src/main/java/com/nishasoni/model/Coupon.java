package com.nishasoni.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
@Entity
public class Coupon {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private BigDecimal discount;
    private String expDate;

    public Coupon() {
    }

    public Coupon(Long id) {
        this.id = id;
    }

    public Coupon(Long id, String code, BigDecimal discount, String expDate) {
        this.id = id;
        this.code = code;
        this.discount = discount;
        this.expDate = expDate;
    }

    public Coupon(String code, BigDecimal discount, String expDate) {
        this.code = code;
        this.discount = discount;
        this.expDate = expDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }
}
