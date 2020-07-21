import com.zhangbin.pojo.Student;
import com.zhangbin.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/19-23:27
 */
public class MyTest {
//    set多种注入模式测试
    public static void main(String[] args) {
        ApplicationContext Context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) Context.getBean("student");
        System.out.println(student.toString());

    }
//    c/p命名空间测试
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("userbean.xml");
        User user = context.getBean("user2", User.class);
        System.out.println(user.toString());
    }

    //作用域测试
    @Test
    public void test02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("userbean.xml");
        User user2 = context.getBean("user2", User.class);
        User user = context.getBean("user2", User.class);
        System.out.println(user == user2);
    }
}
