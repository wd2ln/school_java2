package com.pzz.proxy_pattern_cjlib;

import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

public class CjlibTest {
    @Test
    public void testCjlib(){
        //当事人，被代理对象
        Shop shop = new Shop();
        // cgLib动态代理核心类，用于生成代理对象
        Enhancer enhancer = new Enhancer();
        //设置代理对象
        enhancer.setSuperclass(Shop.class);
        // 设置回调拦截
        enhancer.setCallback(new LineShop());
        // 创建代理对象
        Shop o = (Shop)enhancer.create();
        //执行对应方法
        o.name();
        o.run();
    }
}
