package com.pzz.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Properties;

// 扫描指定包下的注解
@ComponentScan("com.pzz")
// 引入jdbc.properties文件
@PropertySource("classPath:jdbc.properties")
//这是一个配置类
@Configuration
public class applicationContext {
    @Value("${jdbc.driver}")
    private String driveClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    /**
     * 此方法用于获取一个JdbcTemplate对象
     *
     * 并通过@Bean注解将获取到的JdbcTemplate对象注入到Ioc容器中
     */
    @Bean(name = "jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(){
        JdbcTemplate jdbcTemplate=null;
        // 声明Properties对象并且设置参数
        Properties properties = new Properties();
        properties.setProperty("driveClassName", driveClassName);
        properties.setProperty("url", url);
        properties.setProperty("username", username);
        properties.setProperty("password", password);

        // 使用Properties对象创建Druid连接池数据源
        try {
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            // 通过数据源对象获取JdbcTemplate
            jdbcTemplate = new JdbcTemplate(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jdbcTemplate;
    }
}
