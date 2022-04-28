package com.pzz.service.impl;

import com.pzz.dao.User;
import com.pzz.service.UserService;

public class UserServiceImpl implements UserService {
private User user;

//    public void setUser(User user) {
//        this.user = user;
//    }

    public UserServiceImpl(User user) {
        this.user = user;
    }

    public UserServiceImpl() {
    }

    @Override
    public void save() {
user.save();
    }
}
