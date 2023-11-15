package com.techserv.productmicroservice.controller;

import com.techserv.productmicroservice.config.Constants;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {


    @Autowired
    private Constants constants;



    //@GetMapping("/test-prop")
    private String getTestProp(){
        return constants.getActuator().get("testProp");
    }
}
