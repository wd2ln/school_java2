package com.zp.service.impl;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.zp.entity.User;
import com.zp.service.UserService;
import com.zp.util.JwtUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public Map<String, Object> logins(User user) {
        Map<String, Object> map =null;
        if (user.getUsername().equals("tom")&&user.getPassword().equals("123")){
            map=new HashMap<>();
            map.put("code",200);
            map.put("success",true);
            map.put("message","登录成功");
            //设置token
            Map<String, Object> claim = new HashMap<>();
            claim.put("username",user.getUsername());
            String token = JwtUtil.createToken(claim,System.currentTimeMillis()+1000*200);
            map.put("token",token);
        }
        return map;
    }

    @Override
    public Map<String, Object> testToken(String token) {
        System.out.println(token);
        //没有token
        if (token==""){
            return null;
        }
        Map<String, Object> token1 = JwtUtil.getToken(token);
        Map<String, Object> map = JwtUtil.getToken(token);
        map.put("username",token1.get("username"));
        return map;
    }
}
