package com.techserv.productmicroservice.controller;

import com.techserv.productmicroservice.config.Constants;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/categories")
@RefreshScope
public class CategoryController {

    @Autowired
    private Constants constants;
    
    String demo = "";

    @PostConstruct
    public void init() {
    	System.out.println("sdas" + constants.getJwt());
    	demo = constants.getJwt().getSecretKey().toString();
    	System.out.println(demo);
    }

    @GetMapping("/test-prop")
    private String getTestProp(){
        return demo;
    }
}
