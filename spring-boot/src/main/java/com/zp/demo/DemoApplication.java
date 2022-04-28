package com.zp.demo;

import com.zp.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {
    @Value("${student.name}")
    private String name;
    @Value("${student.age}")
    private String age;
    @Autowired
    private Student student;
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @RequestMapping("/hello")
    public String helle(){
        return "hello"+name+age;
    }
    @RequestMapping("/stu")
    public Student student(){
        return student;
    }
}

