package com.pz.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
    private static String url = null;
    private static String user = null;
    private static String password = null;
    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    // 使用静态代码块进行初始化操作：加载驱动
    static {
        try {
            // 创建Properties对象用于从Properties文件中读取数据
            Properties properties = new Properties();

            // 通过字符输入流加载数据到properties中
            properties.load(new FileReader("/home/long-an/java文件idea/mvc_web_test/src/main/resources/druid.properties"));

            // 获取对应的数据
            String driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");

            // 加载驱动
            Class.forName(driver);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     *
     * @return 返回数据库的连接
     */
    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    /**
     * 获取搬运工对象
     *
     * @return 返回一个搬运工对象
     */
    private static Statement getStatement() {
        if (connection == null) {
            connection = getConnection();
        }

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return statement;
    }

    /**
     * 增删改方法
     *
     * @param sql 传入一个SQL语句
     * @return 返回受影响的行数
     */
    public static int executeUpdate(String sql) {
        if (statement == null) {
            statement = getStatement();
        }

        int affectedRows = 0;

        try {
            affectedRows = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            close(statement, connection);
        }

        return affectedRows;
    }

    /**
     * 查询方法
     *
     * @param sql 传入一个SQL语句
     * @return 返回一个受影响的行数
     */
    public static ResultSet executeQuery(String sql) {
        try {
            resultSet = getStatement().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    /**
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
