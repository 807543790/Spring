package com.zhangbin.pojo.demo04;

import com.zhangbin.pojo.demo02.UserServiceImpl;
import com.zhangbin.pojo.demo02.UserSrevice;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/26-19:55
 */
public class Client {
    public static void main(String[] args) {
        //真实角色
        UserServiceImpl userService = new UserServiceImpl();

        //代理角色
        ProxyInvocationHandler pix = new ProxyInvocationHandler();

        //设置要代理的对象
        pix.setTarget(userService);

        //动态生成代理类
        UserSrevice proxy = (UserSrevice) pix.getProxy();
        proxy.addUser();
        proxy.deleteUser();
        proxy.updateUser();
        proxy.selectUser();

    }
}
