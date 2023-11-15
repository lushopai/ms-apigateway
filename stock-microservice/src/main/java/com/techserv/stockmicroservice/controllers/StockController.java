package com.techserv.stockmicroservice.controllers;

import com.techserv.stockmicroservice.entity.Stock;
import com.techserv.stockmicroservice.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    @Autowired
    private StockRepository stockRepository;

    @GetMapping("/")
    public boolean  stockDisponible(@RequestParam String code){
        Optional<Stock> stock = stockRepository.findByCode(code);
        stock.orElseThrow(()-> new RuntimeException("No se puede encontrar el producto" + code));

        return stock.get().getQuantity() >0;
    }
}
