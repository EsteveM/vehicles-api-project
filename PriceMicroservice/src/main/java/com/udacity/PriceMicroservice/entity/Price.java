package com.udacity.PriceMicroservice.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String currency;
    private BigDecimal price;


    public Price(Long id, String currency, BigDecimal price) {
        this.id = id;
        this.currency = currency;
        this.price = price;
    }

    public Price(String currency, BigDecimal price) {
        this.currency = currency;
        this.price = price;
    }

    public Price() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}