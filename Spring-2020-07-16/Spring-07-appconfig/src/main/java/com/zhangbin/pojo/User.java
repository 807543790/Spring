package com.zhangbin.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/22-22:59
 */
//这个注解就是把当前对象注入到Spring IOC容器中
@Component
public class User {
    //这个注解相当于给属性赋值
    @Value("张斌！")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
