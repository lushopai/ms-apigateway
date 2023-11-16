package com.techserv.arrivingservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.techserv.arrivingservice.client.StockClient;
import com.techserv.arrivingservice.entity.Arriving;
import com.techserv.arrivingservice.repository.ArrivingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/arriendos")
public class ArrivingController {

    @Autowired
    private ArrivingRepository arrivingRepository;

    @Autowired
    private StockClient stockClient;

    @PostMapping("/save")
    @HystrixCommand(fallbackMethod = "fallbackToStockService")
    private String saveArriendo(@RequestBody Arriving request) {

        boolean inStock = stockClient.stockDisponible(request.getCode());

        if (inStock) {
            Arriving arriving = new Arriving();
            arriving.setCode(UUID.randomUUID().toString());

            arrivingRepository.save(arriving);
            return "OK";
        }
        return "NOK";


    }

    private String fallbackToStockService() {
        return "Something went wrong, please try after some";
    }
}
