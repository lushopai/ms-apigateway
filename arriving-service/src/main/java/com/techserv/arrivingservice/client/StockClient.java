package com.techserv.arrivingservice.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "stock-microservice")
public interface StockClient {

    @RequestMapping("/api/stock/")
    boolean stockDisponible(@RequestParam String code);

}
