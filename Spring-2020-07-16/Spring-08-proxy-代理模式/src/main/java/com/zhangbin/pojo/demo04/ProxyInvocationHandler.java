package com.zhangbin.pojo.demo04;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/26-17:09
 */
//公共的动态代理
public class ProxyInvocationHandler implements InvocationHandler {

    //被代理的租房接口
    private Object target;

    //生成接口的SET方法
    public void setTarget(Object target) {
        this.target = target;
    }

    //生成得到代理类
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),target.getClass().getInterfaces(),this);

    }

    //处理代理实例，并返回结果
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //方法调用前使用的方法,获取的是实现类的方法名
        log(method.getName());
        //动态代理的本质，就是使用反射机制实现！
        Object invoke = method.invoke(target, args);
        return invoke;
    }

    public void log(String msg){
        System.out.println("执行了"+msg+"方法");
    }

}
