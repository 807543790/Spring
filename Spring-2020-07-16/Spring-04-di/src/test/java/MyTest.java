import com.zhangbin.pojo.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/19-23:27
 */
public class MyTest {
    public static void main(String[] args) {
        ApplicationContext Context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) Context.getBean("student");
        System.out.println(student.getName());

    }
}
