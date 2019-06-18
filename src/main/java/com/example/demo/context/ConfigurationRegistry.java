package com.example.demo.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfigurationRegistry {

    @Bean
    public WebMvcConfigurer corsConfigurer() {

        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {

                registry.addMapping("/**").allowedOrigins("*")
                        .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin",
                                "CSRF-TOKEN", "X-CSRF-TOKEN", "Access-Control-Request-Method",
                                "Access-Control-Request-Headers")
                        .allowedMethods("*")
                        .exposedHeaders("Access-Control-Allow-Origin",
                                "Access-Control-Allow-Credentials",
                                "Access-Control-Allowed-Headers")
                        .allowCredentials(false);
            }
        };
    }
}