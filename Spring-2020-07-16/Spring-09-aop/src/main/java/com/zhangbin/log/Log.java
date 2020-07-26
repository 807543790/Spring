package com.zhangbin.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/26-20:46
 */

//前置log
public class Log implements MethodBeforeAdvice {


    /**
     * method:要执行的目标对象的方法
     * objects：参数
     * o:目标对象
     * **/
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(o.getClass().getName()+"的"+method.getName()+"被执行了");
    }
}
