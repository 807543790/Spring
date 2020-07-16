package com.zhangbin.service;

import com.zhangbin.dao.UserDao;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/16-23:10
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    //使用SET方法实现动态注入！
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser() {
        userDao.getUser();
    }
}
