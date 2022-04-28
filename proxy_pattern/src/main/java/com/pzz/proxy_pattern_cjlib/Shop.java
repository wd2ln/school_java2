package com.pzz.proxy_pattern_cjlib;


// 被代理对象
public class Shop {
    public void name(){
        System.out.println("喜提商店");
    }
    public void run(){
        System.out.println("卖了一件商品");
    }
}
