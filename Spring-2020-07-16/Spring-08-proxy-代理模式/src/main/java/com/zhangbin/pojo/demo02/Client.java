package com.zhangbin.pojo.demo02;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/26-15:55
 */

//测试
public class Client {
    public static void main(String[] args) {
        //创建User实现类
        UserServiceImpl userService = new UserServiceImpl();

        //创建代理
        UserProxy userProxy = new UserProxy();
        //将实现类使用SET传入代理模式
        userProxy.setUserSreviceimpl(userService);
        //通过代理模式实现调用
        userProxy.addUser();

    }
}
