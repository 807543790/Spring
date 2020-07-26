package com.zhangbin.log;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/26-20:50
 */

//后置log
public class AfterLog implements AfterReturningAdvice {

    //第一个参数o：返回值
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("执行了"+method.getName()+"返回结果为"+o);
    }
}
