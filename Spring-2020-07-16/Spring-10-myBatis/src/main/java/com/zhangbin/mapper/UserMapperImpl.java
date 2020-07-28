package com.zhangbin.mapper;

import com.zhangbin.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/27-21:19
 */
public class UserMapperImpl implements UserMapper {
    //我们所有的操作，都是使用sqlSession来执行，现在都使用SqlSessionTemplate
    private SqlSessionTemplate session;

    //设置SET方法，方便Spring使用
    public void setSession(SqlSessionTemplate session) {
        this.session = session;
    }

    //之前测试的方法现在直接写在下边的方法中
    public List<User> selectUser() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        return mapper.selectUser();
    }

}
