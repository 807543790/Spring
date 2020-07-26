package com.zhangbin.pojo.demo03;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/26-15:55
 */

//测试
public class Client {
    public static void main(String[] args) {
       //真实角色
        Host host = new Host();

        //代理角色：现在不需要，也没有
        ProxyInvocationHandler pih = new ProxyInvocationHandler();

        //通过调用程序处理角色来处理我们要调用的接口对象
        pih.setRent(host);
        Rent proxy = (Rent) pih.getProxy();//这里的proxy就是动态生成的
        proxy.rent();

    }
}
