package com.pzz.proxy_pattern_static;

/**
 * 代理类
 */
public class ProxyPeople implements Game{
    // 包含一个被代理的对象
    private final Game game;

    public ProxyPeople(Game game) {
        this.game = game;
    }

    @Override
    public void login() {
        game.login();
        this.run();
    }

    @Override
    public void play() {
        game.play();
        this.sleep();
    }
    //跑方法
    private void run(){
        System.out.println("你移动了100m");
    }
    //方法
    private void sleep(){
        System.out.println("你掉线了");
    }
}
