package com.pzz.proxy_pattern_jdk;

public class Teacher implements Music{
    @Override
    public void listen() {
        System.out.println("听音乐");
    }

    @Override
    public void sing() {
        System.out.println("唱歌");
    }
}
