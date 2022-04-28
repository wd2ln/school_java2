package com.pz.dao.impl;

import com.pz.dao.S1Dao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;


public class S1DaoImpl extends JdbcDaoSupport implements S1Dao {
    @Override
    public void increaseMoney(Integer id, BigDecimal money) {
        getJdbcTemplate().update("update s1 set money=money+? where id=?",money,id);
        System.out.println("加钱成功");
    }

    @Override
    public void decreaseMoney(Integer id, BigDecimal money) {
        getJdbcTemplate().update("update s1 set money=money-? where id=?",money,id);
        System.out.println("减钱成功");
    }
}
