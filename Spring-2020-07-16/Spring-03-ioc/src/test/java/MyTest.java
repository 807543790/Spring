import com.zhangbin.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/17-16:15
 */
public class MyTest {

    @Test
    public void getUser(){
        ApplicationContext context =new  ClassPathXmlApplicationContext("beans.xml");
        User user = (User) context.getBean("uusseerr");
       user.show();
        System.out.println();
    }
}
