package com.zhangbin.mapper;

import com.zhangbin.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/27-20:36
 */
public interface UserMapper {
    List<User> selectUser();

    int addUser(User user);

    int deleteUser(@Param("id") int id);
}
