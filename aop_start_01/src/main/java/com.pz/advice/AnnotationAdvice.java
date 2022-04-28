package com.pz.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

//声明切面类
@Aspect
public class AnnotationAdvice {
    // 声明切点
    @Pointcut("execution(* com.pz.service.impl.*ServiceImpl.*(..))")
    public void pointCut(){};
    // 前置通知
    @Before("AnnotationAdvice.pointCut()")
    public void before() {
        System.out.println("before advice --> 前置通知，方法执行前调用");
    }
    @AfterReturning("AnnotationAdvice.pointCut()")
    // 后置通知
    public void afterReturning() {
        System.out.println("AfterReturning --> 后置通知，出现异常时不执行");
    }
@AfterThrowing("AnnotationAdvice.pointCut()")
    // 异常通知
    public void afterThrowing() {
        System.out.println("AfterThrowing --> 出现异常时执行");
    }
@After("AnnotationAdvice.pointCut()")
    // 最终通知
    public void after() {
        System.out.println("After advice --> 最终通知，出现异常时也会调用");
    }
@Around("AnnotationAdvice.pointCut()")
    // 环绕通知
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Around --> 环绕通知，方法调用之前执行");

        // 执行方法
        Object proceed = joinPoint.proceed();

        System.out.println("Around --> 环绕通知，方法调用之后执行");

        return proceed;
    }

}
