package com.zp.controller;

import com.zp.entity.User;
import com.zp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private  UserService userService;
    @RequestMapping("login")
    public Map<String,Object> login(User user){
        System.out.println("controller login ....");
        return userService.logins(user);
    }
    @RequestMapping("isToken")
    public Map<String,Object> isToken(String token){
        return userService.testToken(token);
    }
}
