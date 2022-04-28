package com.pzz.dao.impl;

import com.pzz.dao.StudentDao;
import org.springframework.stereotype.Component;


@Component("studentDaoImpl")
public class StudentDaoImpl implements StudentDao {
    @Override
    public void show() {
        System.out.println("开始。。。。。。。");
    }
}
