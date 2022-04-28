package com.zp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    // 添加跨域资源访问映射
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //跨域的访问路径
        registry.addMapping("/**")
                // 允许全部的源
                .allowedOrigins("*")
                // 允许指定的源
                // .allowedOrigins("http://127.0.0.1:8848")
                // 允许指定默认的源
                // .allowedOriginPatterns("http://127.0.0.1:*")
                // .allowedOriginPatterns("http://*.baidu.com")
                // 允许的请求头
                .allowedHeaders("*")
                // 允许的请求类型
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                // 缓存时间，单位秒
                .maxAge(3600 * 24);
    }
}
