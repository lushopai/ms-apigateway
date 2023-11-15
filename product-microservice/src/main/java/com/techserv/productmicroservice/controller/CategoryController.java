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



    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    @Value("${app.description}")
    private String appDescription;

    @GetMapping("/test-prop")
    private String getTestProp(){
        System.out.println(appDescription);
        return this.appDescription;
    }
}
