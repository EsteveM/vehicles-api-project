package com.udacity.PriceMicroservice.repository;

import com.udacity.PriceMicroservice.entity.Price;
import org.springframework.data.repository.CrudRepository;

public interface PriceRepository extends CrudRepository<Price, Long> {
}