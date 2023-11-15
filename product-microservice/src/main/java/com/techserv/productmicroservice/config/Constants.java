package com.techserv.productmicroservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "constants")
@Data
public class Constants {


    //private HashMap<String,String> actuator;

}
