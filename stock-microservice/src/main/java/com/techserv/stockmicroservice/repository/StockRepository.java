package com.techserv.stockmicroservice.repository;

import com.techserv.stockmicroservice.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock,Long> {

    Optional<Stock> findByCode(String code);
}
