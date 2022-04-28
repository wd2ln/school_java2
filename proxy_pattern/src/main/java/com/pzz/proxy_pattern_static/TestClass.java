package com.pzz.proxy_pattern_static;

import org.junit.Test;

/**
 * 测试类
 */
public class TestClass {
    @Test
    public void test1(){
        People game=new People();
        ProxyPeople proxyGame=new ProxyPeople(game);
        proxyGame.play();
        proxyGame.login();
    }

}
