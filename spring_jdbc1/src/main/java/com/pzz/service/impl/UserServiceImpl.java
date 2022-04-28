package com.pzz.service.impl;

import com.pzz.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void find() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext");
        Object userDaoImpl = applicationContext.getBean("userDaoImpl");
        System.out.println(userDaoImpl);
    }
}
