package com.zp.service;

import com.zp.entity.User;

import java.util.Map;

public interface UserService {
    Map<String, Object> logins(User user);

    Map<String, Object> testToken(String token);
}
