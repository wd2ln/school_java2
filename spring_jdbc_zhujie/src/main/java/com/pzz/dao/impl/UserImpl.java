package com.pzz.dao.impl;

import com.pzz.dao.User;

public class UserImpl implements User {
    public void save() {
        System.out.println("我是继承的save方法");
    }
}
