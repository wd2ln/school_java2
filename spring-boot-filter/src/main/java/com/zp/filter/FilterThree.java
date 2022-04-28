package com.zp.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.Collections;

@Configuration
public class FilterThree {
    @Bean
    FilterRegistrationBean<Filter> sexFilterFilterRegistrationBean(){
        FilterRegistrationBean<Filter> bean=new FilterRegistrationBean<>();
        bean.setFilter(new FilterTwo01());
        //设置优先级
        bean.setOrder(-1);
        bean.setUrlPatterns(Collections.singletonList("/*"));
        return bean;
    }
    @Bean
    FilterRegistrationBean<Filter> ageFilterFilterRegistrationBean(){
        FilterRegistrationBean<Filter> bean=new FilterRegistrationBean<>();
        bean.setFilter(new FilterTwo02());
        bean.setOrder(1);
        bean.setUrlPatterns(Collections.singletonList("/filter/test2"));
        return bean;
    }
}
