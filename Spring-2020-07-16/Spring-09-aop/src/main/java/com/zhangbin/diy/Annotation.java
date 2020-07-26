package com.zhangbin.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/26-22:29
 */
//方法三：使用注解实现

@Aspect //标注这是一个切面
public class Annotation {


    @Before("execution( * com.zhangbin.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("====================方法调用前==================");
    }


    @After("execution( * com.zhangbin.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("====================方法调用后==================");
    }

    @Around("execution( * com.zhangbin.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕前");
        Object proceed = jp.proceed();
        System.out.println("环绕后");
    }
}
