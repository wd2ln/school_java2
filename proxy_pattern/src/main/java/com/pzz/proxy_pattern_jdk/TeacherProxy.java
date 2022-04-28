package com.pzz.proxy_pattern_jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理
 */
public class TeacherProxy implements InvocationHandler {
    // 包含一个动态的被代理对象(当事人)
    private  final Object music;
    // 通过构造方法进行传参
    public TeacherProxy(Object music) {
        this.music = music;
    }

    /**
     * 此方法用于代理对象调用被代理对象的操作
     *
     * @param o 代理对象(律师)
     * @param method 被代理对象的方法
     * @param objects 被代理对象的方法所需要的参数
     * @return 被代理对象的方法执行后的返回值
     * @throws Throwable 非法参数异常、安全异常、空指针异常
     */
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        // 获取被代理对象方法的方法名
        System.out.println("执行的方法名"+method.getName());
        // 执行被代理对象的方法
        Object invoke = method.invoke(music, objects);
        return invoke;
    }
}
