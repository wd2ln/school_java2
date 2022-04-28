package com.pz.util;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtilsOnDruid {

    // 数据库源
    private static DataSource dataSource;
    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;


    static {
        try {
            // 加载Properties文件
            Properties properties = new Properties();
            properties.load(new FileReader("/home/long-an/java文件idea/mvc_web_test/src/main/resources/druid.properties"));

            // 已经完成数据库连接池操作
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回数据库连接对象，连接失败返回null
     *
     * @return java.sql.Connection 数据库连接对象
     */
    public static Connection getConnection() {
        try {
            // 通过数据源获取连接
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /*
     * 重载关闭资源方法，以满足多种场景
     */
    public static void close(Connection connection) {
        close(resultSet, statement, connection);
    }

    public static void close(ResultSet resultSet) {
        close(resultSet, statement, connection);
    }

    public static void close(Statement statement, Connection connection) {
        close(resultSet, statement, connection);
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
