package com.pzz.factory;

import com.pzz.dao.User;
import com.pzz.dao.impl.UserImpl;

public class UserDaoFactory {
    //静态工厂
    public static User getUserDaoImpl(){
        return new UserImpl();
    }
}
