package com.zhangbin.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/22-21:37
 */


//@Component 等价于<bean id="user" class="com.zhangbin.pojo.User">
@Component
@Scope("prototype")
public class User {
    @Value("张斌")
    public String name;
}
