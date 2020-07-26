package com.zhangbin.pojo.demo03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method
;
import java.lang.reflect.Proxy;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/26-17:09
 */
public class ProxyInvocationHandler implements InvocationHandler {

    //被代理的租房接口
    private Rent rent;

    //生成接口的SET方法
    public void setRent(Rent rent) {
        this.rent = rent;
    }

    //生成得到代理类
        public Object getProxy(){
            return Proxy.newProxyInstance(this.getClass().getClassLoader(),rent.getClass().getInterfaces(),this);

        }

        //处理代理实例，并返回结果
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //可以在实现前后插入想使用的方法
            seeHouse();
            //动态代理的本质，就是使用反射机制实现！
            Object invoke = method.invoke(rent, args);
            return invoke;
    }

    public void seeHouse(){
        System.out.println("中介带看房子");
    }
}
