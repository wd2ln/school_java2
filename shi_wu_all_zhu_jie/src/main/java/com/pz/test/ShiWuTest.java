package com.pz.test;

import com.pz.config.ShiWu;
import com.pz.service.S1Service;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

public class ShiWuTest {
    // 测试声明式事务
    @Test
    public void test1(){
        //ApplicationContext applicationContext= new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ShiWu.class);
        S1Service s1Service = applicationContext.getBean( S1Service.class);
        s1Service.transfer(2,1, BigDecimal.valueOf(300));
    }
}
