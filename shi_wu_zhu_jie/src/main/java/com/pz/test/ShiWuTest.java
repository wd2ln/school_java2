package com.pz.test;

import com.pz.service.S1Service;
import com.pz.service.impl.S1ServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

public class ShiWuTest {
    // 测试声明式事务
    @Test
    public void test1(){
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("applicationContext.xml");
        S1Service s1Service = applicationContext.getBean("s1ServiceImpl", S1Service.class);
        s1Service.transfer(1,2, BigDecimal.valueOf(100));
    }
}
