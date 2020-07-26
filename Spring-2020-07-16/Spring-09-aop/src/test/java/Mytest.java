import com.zhangbin.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/26-21:08
 */
public class Mytest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //动态代理的是接口
        UserService userService = (UserService) context.getBean("userService");

        userService.addUser();
    }
}
