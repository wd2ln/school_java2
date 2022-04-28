package com.pz.service;

import com.pz.dao.impl.LoginDaoImpl;
import com.pz.entity.User;

public class LoginService {
    LoginDaoImpl loginDao=new LoginDaoImpl();
    public boolean loginUser(User user){
        if (1!=loginDao.login(user)){
            return false;
        }else {
            return true;
        }
    }
}
