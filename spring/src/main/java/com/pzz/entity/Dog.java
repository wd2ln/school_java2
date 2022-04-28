package com.pzz.entity;

public class Dog {
    private String name;
    private String info;

    public void setName(String name) {
        this.name = name;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
