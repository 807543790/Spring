import com.zhangbin.mapper.UserMapper;
import com.zhangbin.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/28-10:54
 */
public class MyTest {
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper mapper = (UserMapper) context.getBean("userimpl");
        for (User user : mapper.selectUser()) {
            System.out.println(user);
        }
    }
}
