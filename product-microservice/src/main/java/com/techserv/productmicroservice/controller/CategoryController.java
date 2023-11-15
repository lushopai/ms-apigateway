package com.techserv.productmicroservice.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
@Data
public class CategoryController {

    @Value("${app.testProp}")
    private String testProp;

    private String getTestProp(){
        return this.testProp;
    }
}
