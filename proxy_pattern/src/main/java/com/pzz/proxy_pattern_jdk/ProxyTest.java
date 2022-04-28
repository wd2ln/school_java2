package com.pzz.proxy_pattern_jdk;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {
    @Test
    public void testProxy(){
        // 安排一个当事人(被代理对象)
        Teacher teacher = new Teacher();
        // 安排一个老师(代理对象)
        InvocationHandler handler =new TeacherProxy(teacher);
        // 根据被代理对象的类加载器、类的所有对象以及InvocationHandler接口实现类来获取代理对象(代理老师)
        Music o = (Music) Proxy.newProxyInstance(Teacher.class.getClassLoader(), Teacher.class.getInterfaces(), handler);
        o.listen();
        o.sing();
    }

}
