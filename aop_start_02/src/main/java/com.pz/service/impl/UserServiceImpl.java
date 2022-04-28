package com.pz.service.impl;

import com.pz.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void findAll() {
        System.out.println("找到4个人");
    }

    @Override
    public void show() {
        System.out.println("四个人都是学生");
    }
}
