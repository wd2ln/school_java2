package com.zp.demo.environment;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

public class MyEnvironment implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        //定义配置文件
        String[] profiles={
                "jdbc.properties"
        };
        //循环添加
        for (String profile : profiles) {
            // 从classpath路径下面查找文件
            Resource resource = new ClassPathResource(profile);
            // 加载成PropertySource对象，并添加到Environment环境中
            environment.getPropertySources().addLast(loadProfiles(resource));
        }
    }

    private PropertySource<?> loadProfiles(Resource resource) {
        if(!resource.exists()){
            throw new IllegalArgumentException("资源"+resource+"不存在");
        }
        if (resource.getFilename().contains(".properties")){
            return loadProperty(resource);
        }else {
            return loadYml(resource);
        }
    }

    private PropertySource<?> loadYml(Resource resource) {
        try {
            Properties properties = new Properties();
            properties.load(resource.getInputStream());
            return new PropertiesPropertySource(resource.getFilename(),properties);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException("资源"+resource+"加载失败");
        }
    }

    private PropertySource<?> loadProperty(Resource resource) {
        try {
            YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
            factory.setResources(resource);
            //从输入流中加载一个Properties对象
            Properties properties =factory.getObject();
            return new PropertiesPropertySource(resource.getFilename(),properties);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalStateException("资源加载失败"+resource,e);
        }
    }
}
