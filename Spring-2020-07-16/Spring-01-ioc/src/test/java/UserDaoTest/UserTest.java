package UserDaoTest;

import com.zhangbin.dao.ControllerDaoImpl;
import com.zhangbin.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/16-23:14
 */
public class UserTest {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

//        在我们之前的业务中，用户的需求可能会影响我们底层的代码，我们需要根据用户的需求去修改源代码
//        如果程序代码十分庞大，修改一次成本代价非常大
//        userService.setUserDao(new UserDaoImpl());
          userService.setUserDao(new ControllerDaoImpl());
          userService.getUser();
//-------------------------------------------------------------------------------------------------------------------------
        //使用Spring
        // 获取ApplicationContext:拿到Spring的容器
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //通过容器调用，需要什么就获取什么
        UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("UserServiceImpl");
        userServiceImpl.getUser();
    }
}
