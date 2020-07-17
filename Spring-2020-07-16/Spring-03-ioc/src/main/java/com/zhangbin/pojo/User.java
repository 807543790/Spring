package com.zhangbin.pojo;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/17-16:13
 */
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("name="+name);
    }
}
