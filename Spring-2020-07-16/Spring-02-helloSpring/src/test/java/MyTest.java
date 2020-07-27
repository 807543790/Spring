import com.zhangbin.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/17-10:29
 */
public class MyTest {
    public static void main(String[] args) {
//        获取spring的上下文对象，固定的
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        我们的对象都在spring中的管理了，我们如果使用直接去里边取出来就可以了;
        Hello hello =(Hello) context.getBean("hello");
        System.out.println(hello.toString());
    }
}
