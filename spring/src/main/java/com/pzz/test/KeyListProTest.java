package com.pzz.test;

import com.pzz.entity.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KeyListProTest {
    @Test
    public void test1(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student =(Student) applicationContext.getBean("student");
        System.out.println(student);
    }
}
