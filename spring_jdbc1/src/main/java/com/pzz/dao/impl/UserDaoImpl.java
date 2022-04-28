package com.pzz.dao.impl;

import com.pzz.dao.UserDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.zip.DataFormatException;

@Repository
public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;
    @Override
    public void findAll() {
        String sql="select * from user";
        List<UserDao> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(UserDao.class));
        for (UserDao userDao : query) {
            System.out.println(userDao);
        }
    }

    @Override
    public void findById() {

    }
}
