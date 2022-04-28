package com.pz.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class XmlAdvice {
    // 前置通知
    public void before() {
        System.out.println("before advice --> 前置通知，方法执行前调用");
    }

    // 后置通知
    public void afterReturning() {
        System.out.println("AfterReturning --> 后置通知，出现异常时不执行");
    }

    // 异常通知
    public void afterThrowing() {
        System.out.println("AfterThrowing --> 出现异常时执行");
    }

    // 最终通知
    public void after() {
        System.out.println("After advice --> 最终通知，出现异常时也会调用");
    }

    // 环绕通知
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Around --> 环绕通知，方法调用之前执行");

        // 执行方法
        Object proceed = joinPoint.proceed();

        System.out.println("Around --> 环绕通知，方法调用之后执行");

        return proceed;
    }

}
