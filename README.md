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
                
Spring-03:ioc创建对象的方式

        <!--一：无参构造方法-->
            <!-- 当实体类创建有参构造方法时，要对bean单独处理，因为它默认使用的是无参构造方法
                 <bean id="user" class="com.zhangbin.pojo.User">
                    <property name="name" value="张斌"></property>
                 </bean>-->
        <!--二：有参构造方法-->
                <!--如果使用有参构造方法必须要使用一下几个方法-->
                <!--1.下标赋值 设置有参构造方法的第一个值为张斌1-->
                <!--<bean id="user" class="com.zhangbin.pojo.User">-->
                    <!--<constructor-arg index="0" value="张斌1"></constructor-arg>-->
                <!--</bean>-->
        
                <!--2.通过类型赋值 设置有参构造方法的第一个值为张斌2 ,不建议使用，因为可能会存在两个参数类型相同-->
                <!--<bean id="user" class="com.zhangbin.pojo.User">-->
                    <!--<constructor-arg type="java.lang.String" value="张斌2"/>-->
                <!--</bean>-->
        
                <!--3.直接通过参数名称来设置-->
                    <bean id="user" class="com.zhangbin.pojo.User">
                    <constructor-arg name="name" value="张斌3"/>
                    </bean>
        总结：在配置文件加载的时候，容器中管理的对象就已经初始化了，只要注册号Bean，就回默认调用无参构造方法        
        
        <!--Spring配置-->
                <!--1：别名：
                    为当前bean创建别名，使用context.getBean注册时，可以使用bean之前的ID也可以使用别名，效果一样没什么乱用-->
                <alias name="user" alias="uusseerr"></alias>
        
                <!--2：bean的配置
                    id: bean的唯一标识符，也就是相当于我们的对象名称
                    class: bean对象对应的全限定名：包名加类型
                    name: 也是别名，可以产生多个，分割的方式有多种可以用空格，逗号，分号
                -->
                <bean id="user" class="com.zhangbin.pojo.User" name="user2 user3,user4;user5">
                    <constructor-arg name="name" value="张斌3"/>
                </bean>
                <!--3.import:
                    他可以将多个bean文件导入合并为一个
                -->
                <import resource="beans1.xml"></import>
                <import resource="beans2.xml"></import>    
