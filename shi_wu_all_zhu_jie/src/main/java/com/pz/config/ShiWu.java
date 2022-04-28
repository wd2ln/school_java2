package com.pz.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.pz.dao.impl.S1DaoImpl;
import com.pz.service.impl.S1ServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.Properties;

//开启注解扫描
@ComponentScan("com.pz")
//声明注解类
@Configuration
//引入外部properties文件
@PropertySource("classpath:jdbc.properties")
//开启事物支持
@EnableTransactionManagement
public class ShiWu {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean
    public DataSource getDruidDataSource(){
        Properties properties = new Properties();
        properties.setProperty("driverClassName", driver);
        properties.setProperty("url", url);
        properties.setProperty("username", username);
        properties.setProperty("password", password);
        DataSource dataSource = null;

        try {
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataSource;
    }
    @Bean
    public JdbcTemplate getJdbcTemplate(DruidDataSource druidDataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(druidDataSource);
        return jdbcTemplate;
    }
    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(DruidDataSource druidDataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(druidDataSource);

        return dataSourceTransactionManager;
    }
    @Bean
    public S1DaoImpl getS1DaoImpl(DruidDataSource druidDataSource){
        S1DaoImpl s1Dao = new S1DaoImpl();
        s1Dao.setDataSource(druidDataSource);
        return s1Dao;
    }
    @Bean
    public S1ServiceImpl getS1ServiceImpl(S1DaoImpl s1DaoImpl){
        S1ServiceImpl s1Service = new S1ServiceImpl();
        s1Service.setS1Dao(s1DaoImpl);
        return s1Service;
    }
}
