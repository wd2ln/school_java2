package com.pzz.entity;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Student {
    private String name;
    private Integer age;
    private List<String> stuList;
    private Map<String,Dog> stuMap;
    private Properties properties;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", stuList=" + stuList +
                ", stuMap=" + stuMap +
                ", properties=" + properties +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setStuList(List stuList) {
        this.stuList = stuList;
    }

    public void setStuMap(Map stuMap) {
        this.stuMap = stuMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
