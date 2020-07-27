package com.zhangbin.mapper;

import com.zhangbin.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/27-22:04
 */
public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper {

//    第二种实现方法直接继承SqlSessionDaoSupport，这样就通过getSqlSession()拿到SqlSession了，剩下的方法都一样
    public List<User> selectUser() {
        return getSqlSession().getMapper(UserMapper.class).selectUser();
    }
}
