package com.pz.dao.impl;

import com.pz.dao.LoginDao;
import com.pz.entity.User;
import com.pz.util.JdbcUtilsOnDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import java.sql.Connection;
import java.sql.SQLException;

public class LoginDaoImpl implements LoginDao {
    Connection connection = JdbcUtilsOnDruid.getConnection();
    QueryRunner queryRunner=new QueryRunner();
    User query =null;
    int flag=-1;    //-1系统错误    0密码/用户名错误   1登录成功
    //登录业务
    @Override
    public int login(User user) {
        //sql语句
        String sql="select * from user where name=? and password=?";
        System.out.println(sql);
        Object[] objects={user.getName(),user.getPassword()};
        System.out.println(user.getName());
        try {
            query = queryRunner.query(connection, sql, new BeanHandler<>(User.class), objects);
            System.out.println(query);
            if (query == null) {
                flag=0;
            }else {
                flag=1;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            flag=-1;
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return flag;
    }
}
