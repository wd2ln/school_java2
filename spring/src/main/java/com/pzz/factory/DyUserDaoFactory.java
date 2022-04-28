package com.pzz.factory;

import com.pzz.dao.User;
import com.pzz.dao.impl.UserImpl;

public class DyUserDaoFactory {
    //实例工厂
    public  User getUserDaoImpl1(){
        return new UserImpl();
    }
}
