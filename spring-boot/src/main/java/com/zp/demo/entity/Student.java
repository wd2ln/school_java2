package com.zp.demo.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "student")
@Data
public class Student {
    private String name;
    private Integer age;
    private Boolean gender;
    private Date birthday;
    private String[] hobby;
    private List<String> food;
    private Map<String, Object> score;
    private Car car;
}
