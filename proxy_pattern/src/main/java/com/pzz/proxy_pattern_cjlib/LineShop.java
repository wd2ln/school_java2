package com.pzz.proxy_pattern_cjlib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

// 网店，实现CGLib动态代理的核心接口MethodInterceptor
public class LineShop implements MethodInterceptor {
    /**
     * 所有生成的代理方法都调用此方法，而不是原始方法
     *
     * @param obj 被代理对象
     * @param method 被代理对象的方法
     * @param args 被代理对象的方法参数
     * @param proxy 代理对象，用来调用未被拦截的方法，可多次调用
     * @return 被代理对象的方法返回值
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

        System.out.println("执行的方法名：" + method.getName());
        // 执行被代理对象中的方法
        Object o = proxy.invokeSuper(obj, args);
        return o;
    }
}
