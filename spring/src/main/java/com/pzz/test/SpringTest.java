package com.pzz.test;

import com.pzz.dao.User;
import com.pzz.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    @Test
    //使用无参构造方法
    public void testSpring(){
        ClassPathXmlApplicationContext  applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) applicationContext.getBean("userDao");
        user.save();
    }
    @Test
    //使用静态工厂
    public void testSpring1(){
        ClassPathXmlApplicationContext  applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User userDaoFactory1 = (User) applicationContext.getBean("userDaoFactory");
        userDaoFactory1.save();

    }
    @Test
    //使用实例工厂
    public void testSpring2(){
        ClassPathXmlApplicationContext  applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User userDaoFactory1 = (User) applicationContext.getBean("userDao1");
        userDaoFactory1.save();

    }
    @Test
    //使用set注入
    public void testSpring3(){
        ClassPathXmlApplicationContext  applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userDaoFactory1 = (UserService) applicationContext.getBean("userService");
        userDaoFactory1.save();

    }
    @Test
    //使用构造方法注入
    public void testSpring4(){
        ClassPathXmlApplicationContext  applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userDaoFactory1 = (UserService) applicationContext.getBean("userServiceCon");
        userDaoFactory1.save();

    }
}
