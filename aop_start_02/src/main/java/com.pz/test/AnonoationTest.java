package com.pz.test;

import com.pz.advice.AnnotationAdvice;
import com.pz.config.AopConfig;
import com.pz.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnonoationTest {
    @Test
    public void test1(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
        UserServiceImpl userServiceImpl = applicationContext.getBean(UserServiceImpl.class);
        userServiceImpl.findAll();
        userServiceImpl.show();
    }
}
