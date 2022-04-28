package com.pzz.proxy_pattern_static;

/**
 * 真人类
 */
public class People implements Game {
    @Override
    public void login() {
        System.out.println("登录成功");
    }

    @Override
    public void play() {
        System.out.println("开始玩");
    }
}
