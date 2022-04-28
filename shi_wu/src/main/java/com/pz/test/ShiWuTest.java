package com.pz.test;

import com.pz.service.impl.S1ServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

public class ShiWuTest {
    @Test
    public void test1(){
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("applicationContext.xml");
        S1ServiceImpl s1ServiceImpl = applicationContext.getBean("s1ServiceImpl", S1ServiceImpl.class);
        s1ServiceImpl.transfer(1,2, BigDecimal.valueOf(300));
    }
}
