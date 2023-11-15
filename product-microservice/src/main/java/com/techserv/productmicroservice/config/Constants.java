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

    private Security security;
    private Jwt jwt;

    @Data
    public static class Security {
        private String jwtSecret;
        private long jwtExpirationMs;
        private String frontEndOrigin;
    }

    @Data
    public static class Jwt {
        private String secretKey;
        private long expirationTimeInMillis;
    }
}
