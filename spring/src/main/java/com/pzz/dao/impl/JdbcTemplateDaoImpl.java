package com.pzz.dao.impl;

import com.pzz.dao.JdbcTemplateDao;
import com.pzz.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


public class JdbcTemplateDaoImpl implements JdbcTemplateDao {
    // 声明一个JdbcTemplate，类似于DbUtils中的QueryRunner
    private JdbcTemplate template;
    //查询方法
    @Override
    public void selectAll(){
        // 调用查询方法，传入一个Sql语句和结果集映射处理器对象
        String sql="select * from user";
        List<User> query = template.query(sql, new BeanPropertyRowMapper<>(User.class));
        for (User user : query) {
            System.out.println(user);
        }
    }
    @Override
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
}
