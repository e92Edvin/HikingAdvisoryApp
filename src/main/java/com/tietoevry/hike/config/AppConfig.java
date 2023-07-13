package com.tietoevry.hike.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {
    @Bean
    @RequestScope
    public Map<String, String> hikeRequestContextHolder() {
        return new HashMap<>();
    }
}
