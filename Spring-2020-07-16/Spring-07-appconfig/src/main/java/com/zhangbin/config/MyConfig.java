package com.zhangbin.config;

import com.zhangbin.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/22-22:58
 */
////这个对象也会被Spring容器托管，因为它本来就是个@Component
    //@Configuration代表是一个内置类，相当于beans.xml功能一样
@Configuration

//这个标签相当于之前的扫描包下的实体类标签一致
@ComponentScan("com.zhangbin.pojo")

//这个注解相当于xml文件中的<Import>标签，将多个文件同时放到一个主文件里边实现一起共用
@Import(MyConfig2.class)

public class MyConfig {
    // @Bean相当于我们之前写的<bean>标签
//        <bean id="">相当于方法的方法名（getUser）
//        <bean class="">相当于方法的返回值User
    @Bean
    public User getUser(){
        return new User();//就是返回要注入bean的对象
    }
}
