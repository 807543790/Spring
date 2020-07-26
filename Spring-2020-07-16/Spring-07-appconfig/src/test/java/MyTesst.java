import com.zhangbin.config.MyConfig;
import com.zhangbin.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/22-23:03
 */
public class MyTesst {
    //不使用XML文件将对象注入到Spring IOC容器中，我们就只能AnnotationConfig 上下文获取容器，通过配置类的class对象加载
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        User user = context.getBean("getUser", User.class);
        System.out.println(user.getName());
    }


}
