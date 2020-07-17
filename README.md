# Spring
优点：
    Spring是一个开源的免费的框架（容器）
    Spring是一个轻量级，非侵入式的框架
    控制反转（IOC），面向切面编程（AOP）
    支持事务的处理，对框架整合的支持
    总结一句话：**Spring就是一个轻量级的控制反转（IOC）和面向切面编程（AOP）的框架**
    
Spring-01:
        ioc实现的作用
        
            public class UserTest {
                public static void main(String[] args) {
                    UserServiceImpl userService = new UserServiceImpl();
            
            //        在我们之前的业务中，用户的需求可能会影响我们底层的代码，我们需要根据用户的需求去修改源代码
            //        如果程序代码十分庞大，修改一次成本代价非常大
            //        userService.setUserDao(new UserDaoImpl());
                      userService.setUserDao(new ControllerDaoImpl());
                      userService.getUser();
                }
            }
            
            
            使用Spring创建对象
                <bean id="ControllerDaoImpl" class="com.zhangbin.dao.ControllerDaoImpl"></bean>
                <bean id="UserDaoImpl" class="com.zhangbin.dao.UserDaoImpl"></bean>
            
                <bean id="UserServiceImpl" class="com.zhangbin.service.UserServiceImpl">
                    <property name="userDao" ref="UserDaoImpl"></property>
                </bean>
            
                <!--ref：引用Spring容器中创建好的对象-->
                <!--value：具体的值，基本数据类型-->
            测试方法：    
                  //使用Spring
                        // 获取ApplicationContext:拿到Spring的容器
                        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
                        //通过容器调用，需要什么就获取什么
                        UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("UserServiceImpl");
                        userServiceImpl.getUser();
Spring-02:
        所谓ioc:对象由Spring来创建，管理，装配
            
            
            <!--使用spring来创建对象，在spring这些都称为bean
        
            类型 变量名 = new 类型（）
            Hello hello =new Hello()
        
            id = 变量名  id是唯一的自定义的。
            class = new 的对象
            property 相当于给对象中的属性设置一个值，设置值是通过实体类的SET方法实现的-->
            <bean id="helloId" class="com.zhangbin.pojo.Hello">
                <property name="str"  value="Spring"></property>
            </bean>
            
            测试方法：
        //      获取spring的上下文对象，固定的
                ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //      我们的对象都在spring中的管理了，我们如果使用直接去里边取出来就可以了;
                Hello hello =(Hello) context.getBean("helloId");
                 System.out.println(hello.toString());
                }