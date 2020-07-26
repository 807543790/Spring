package com.zhangbin.pojo.demo02;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/26-15:54
 */
public class UserProxy implements  UserSrevice{

    //导入实现类
    private UserServiceImpl userSreviceimpl;

    //使用SET注入
    public void setUserSreviceimpl(UserServiceImpl userSreviceimpl) {
        this.userSreviceimpl = userSreviceimpl;
    }

    public void addUser() {
        log("add");
        userSreviceimpl.addUser();
    }

    public void deleteUser() {
        log("delete");
        userSreviceimpl.deleteUser();
    }

    public void updateUser() {
        log("update");
        userSreviceimpl.updateUser();
    }

    public void selectUser() {
        log("select");
        userSreviceimpl.selectUser();
    }

    //添加公共方法日志
    public void log(String msg){
        System.out.println("添加日志"+msg+"！！！");
    }
}
