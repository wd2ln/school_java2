package com.pzz.test;

import com.pzz.dao.impl.JdbcTemplateDaoImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcTest {
    @Test
    public void test1(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplateDaoImpl jdbcTemplateDaoImpl = applicationContext.getBean("jdbcTemplateDaoImpl", JdbcTemplateDaoImpl.class);
        jdbcTemplateDaoImpl.selectAll();
    }
}
