package com.zp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    public CorsFilter corsFilter(){
        CorsConfiguration config = new CorsConfiguration();
        // 添加允许访问的内容
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("POST") ;
        config.addAllowedMethod("GET") ;
        config.addAllowedMethod("DELETE") ;
        config.addAllowedMethod("PUT") ;

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/*",config);
        return new CorsFilter(source);
    }
}
