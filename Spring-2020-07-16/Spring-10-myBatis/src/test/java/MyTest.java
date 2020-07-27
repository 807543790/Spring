import com.zhangbin.mapper.UserMapper;
import com.zhangbin.pojo.User;
import com.zhangbin.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/27-20:39
 */
public class MyTest {

    //测试MyBatis基本功能
    @Test
    public void selectUser(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectUser();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    //测试MyBatis集成到Spring中实现查询方法
    @Test
    public void test01(){

       ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper usermapperimpl = (UserMapper) context.getBean("usermapperimpl");
        usermapperimpl.selectUser();
    }

    //测试第二种MyBatis集成到Spring中实现查询方法
    @Test
    public void test02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper usermapperimpl = (UserMapper) context.getBean("usermapperimpl2");
        usermapperimpl.selectUser();
    }
}
