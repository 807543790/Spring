# Spring
##优点：
    Spring是一个开源的免费的框架（容器）
    Spring是一个轻量级，非侵入式的框架
    控制反转（IOC），面向切面编程（AOP）
    支持事务的处理，对框架整合的支持
    总结一句话：**Spring就是一个轻量级的控制反转（IOC）和面向切面编程（AOP）的框架**
    
##Spring-01:
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
                        
                        
##Spring-02:
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
                
##Spring-03:ioc创建对象的方式

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
                
##Spring-04:di-依赖注入                
```xml
         
                <bean id="student" class="com.zhangbin.pojo.Student">
                    <!--第一种：普通注入，value-->
                    <property name="name" value="张斌"/>
                    
                    <!--第二种：创建实体类bean，然后实体类注入，ref -->
                    <property name="address" ref="address"/>
                    
                    <!--第三种：数组注入-->
                    <property name="books">
                        <array>
                            <value>红楼梦</value>
                            <value>西游记</value>
                            <value>水浒传</value>
                            <value>三国演义</value>
                        </array>
                    </property>
                    
                    <!--第四种：list注入-->
                    <property name="hobbys">
                        <list>
                            <value>篮球</value>
                            <value>足球</value>
                            <value>健身</value>
                        </list>
                    </property>
                    
                    <!--第五种map注入-->
                    <property name="card">
                        <map>
                            <entry key="身份证" value="123456"></entry>
                            <entry key="军官证" value="123456789"></entry>
                        </map>
                    </property>
                    
                    <!--第六种：set注入-->
                    <property name="games">
                        <set>
                            <value>LOL</value>
                            <value>PUBG</value>
                            <value>DNF</value>
                        </set>
                    </property>
                    
                    <!--第七种：null注入-->
                    <property name="wife">
                        <null></null>
                    </property>
                    
                    <!--第八种：properties注入-->
                    <property name="info">
                        <props>
                            <prop key="学号">12345</prop>
                            <prop key="身份证号">11111</prop>
                            <prop key="手机号">18629241475</prop>
                        </props>
                    </property>
                </bean>
```             
                
###Spring-04-01：拓展方式注入
```xml
                    <?xml version="1.0" encoding="UTF-8"?>
                    <beans xmlns="http://www.springframework.org/schema/beans"
                           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                           xmlns:p="http://www.springframework.org/schema/p"
                           xmlns:c="http://www.springframework.org/schema/c"
                           xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
                    
                        <!--p命名空间   可以直接注入属性的值：properties
                            1.先添加XML配置： xmlns:p="http://www.springframework.org/schema/p"
                            2.在bean标签注册时直接使用 p:name="张斌" p:age="18"将数据传入实体类测试
                            -->
                        <bean id="user" class="com.zhangbin.pojo.User" p:name="张斌" p:age="18"></bean>
                    
                        <!--c命名空间   通过构造器注入：construct-args 
                            1.先添加XML配置： xmlns:c="http://www.springframework.org/schema/c"
                            2.保证实体类有参无参构造器够存在
                            3.在bean标签注册时直接使用  c:name="张斌1" c:age="21"将数据传入实体类测试
                            
                            注意：实体类使用@Date注解会报错
                            -->
                        <bean id="user2" class="com.zhangbin.pojo.User" c:name="张斌1" c:age="21"></bean>
                    </beans>
```
              
###Spring-04-02：作用域
        
               <bean id="user2" class="com.zhangbin.pojo.User" c:name="张斌1" c:age="21" scope="prototype"></bean>
                <!--作用域（scope）：
                1.单例模式（scope="singleton"） 使用单例模式创建多个测试，使用的是一个对象，内存地址相同 Spring默认的
                2.原型模式（scope="prototype"） 使用原型模式创建多个测试，使用的是多个个对象，内存地址不同
                3.request
                4.session           3,4,5只能在web开发中使用
                5.application
                -->
##Spring-05：Bean的自动装配
        1.自动装配是Spring满足bean依赖一种方式
        2.Spring会在上下文中自动寻找，并自动给bean装配属性
        3.在Spring中有三种配置的方式
            1.在XML中显示配置（之前的方式就是）
            2.在java中显示配置
            3.隐式的自动装配（重要，也是当学习模块）
            
              <!-- autowire="byName"
                    byName自动装配: 会自动在bean上下文中查找和自己对应的set后边的值对应的bean的ID，如果有就自动装配（弊端：set后边的值必须和bean的id一致）
                    byType自动装配：会自动在bean上下文中查找和自己对象属性类型相同的bean，如果有就自动装配（弊端：对象类型必须是唯一）
                 -->
            <bean id="user" class="com.zhangbin.pojo.User" autowire="byType">
                <property name="name" value="张斌"></property>
            </bean>
    
            <!--小结：-->
                <!--byname的时候，需要保证所有的bean的ID唯一，并且这个bean需要和自动注入的属性的set方法的值一致-->
                <!--bytype的时候，需要保证所有的bean的class唯一，并且这个bean需要和自动注入的属性的类型一致-->
                
        @Autowired
        
            1、使用：
                1.导入依赖
                <?xml version="1.0" encoding="UTF-8"?>
                  <beans xmlns="http://www.springframework.org/schema/beans"
                         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                         xmlns:context="http://www.springframework.org/schema/context"
                         xsi:schemaLocation="http://www.springframework.org/schema/beans
                          https://www.springframework.org/schema/beans/spring-beans.xsd
                          http://www.springframework.org/schema/context
                          https://www.springframework.org/schema/context/spring-context.xsd">
                          
                      **1.导入自动配置,开启注解的支持
                      <context:annotation-config/>
                      2.指定要扫描的包，这个包下的的注解会生效
                      <context:component-scan base-package="com.zhangbin.pojo"/>**
                  
                      <bean id="dog" class="com.zhangbin.pojo.Dog"></bean>
                      <bean id="cat" class="com.zhangbin.pojo.Cat"></bean>
                      <bean id="user" class="com.zhangbin.pojo.User"></bean>
                  </beans>
                  
            2、总结：     
                1.直接在属性上使用即可，也可以在set方法上使用
                2.使用Autowired我们可不用编写Set方法了，前提是你这个自动装配的属性在IOC（也就是Spring）容器中存在，且符合类型：bytype
                3.@Nullable注解，字段标记了这个注解，说明这个字段可以为NUll；
                4.@Auotwired(required = false) 说明这个属性的对象可以为NUll;
                5.@Qualifier(value = "dog222") 假如存在多个相同的对象但是不同名称的bean，可以使用该注解指定bean
                    示例：
                         <bean id="dog" class="com.zhangbin.pojo.Dog"></bean>
                         <bean id="dog222" class="com.zhangbin.pojo.Dog"></bean>
                6.@Resource 可以替代@Auotwired,该注解只要保证bean数据类型唯一，或者bean名称有相同的即可运行。
                    如果都不符合可是使用name属性指定唯一的名称 @Resource(name = "dog222")和  @Qualifier(value = "dog222")类似
                    
                小结：@Resource和@Autowired的区别：
                    相同点：都是用来自动装配的，都可以放在属性的字段上
                    不同点:1.@Autowired 默认通过bytype的方式实现【常用】
                           2.@Resource 默认通过byname的方式实现，如果找不到名字，则通过bytype实现 【常用】    
##Spring-06:注解    

- @Component      
    @Component:等价于<bean id="user" class="com.zhangbin.pojo.User">   
    @Component有几个衍生注解，我们在web开发中，会按照MVC三层架构分层
    - dao 【@Repository】
    - service 【@service】
    - controller 【@Controller】
    - pojo 【@Component】
    这四个注解都是一样的，都是代表将当前对象注册到Spring中，装配Bean
                   
- @Value()
    @Value("张斌")：相当于<property name="name" value="张斌">，可以放在属性上，也可以放在set上
- @Scope("prototype")
    @Scope("prototype")   在属性上设置该属性是否为单例或者是原型模式 
    
    总结：
        xml与注解
        ·xml更加万能,适用于任何场合，维护简单方便
        ·注解维护复杂，只能在当前类使用
    
    
##Spring-07:使用javaConfig实现配置（不使用XML文件将对象放入Spring IOC容器并使用）  

- @Configuration
         这个对象也会被Spring容器托管，因为它本来就是个@Component
         @Configuration代表是一个内置类，相当于beans.xml功能一样
         
- @ComponentScan("com.zhangbin.pojo")
          这个标签相当于之前的扫描包下的实体类标签一致
          
- @Import(MyConfig2.class)
          这个注解相当于xml文件中的<Import>标签，将多个文件同时放到一个主文件里边实现一起共用
- @Bean
           // @Bean相当于我们之前写的<bean>标签
          //        <bean id="">相当于方法的方法名（getUser）
          //        <bean class="">相当于方法的返回值User
          
使用步骤
    1.创建javaConfog文件（相当于之前的XML文件）
```java
        package com.zhangbin.config;
        
        import com.zhangbin.pojo.User;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.ComponentScan;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.context.annotation.Import;
        
        /**
         * 认认真真敲代码，开开心心每一天
         *
         * @Date 2020/7/22-22:58
         */
        ////这个对象也会被Spring容器托管，因为它本来就是个@Component
            //@Configuration代表是一个内置类，相当于beans.xml功能一样
        @Configuration
        
        //这个标签相当于之前的扫描包下的实体类标签一致
        @ComponentScan("com.zhangbin.pojo")
        
        //这个注解相当于xml文件中的<Import>标签，将多个文件同时放到一个主文件里边实现一起共用
        @Import(MyConfig2.class)
        
        public class MyConfig {
            // @Bean相当于我们之前写的<bean>标签
        //        <bean id="">相当于方法的方法名（getUser）
        //        <bean class="">相当于方法的返回值User
            @Bean
            public User getUser(){
                return new User();//就是返回要注入bean的对象
            }
        }

``` 

2.实现测试类
```java
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
```
##Spring-08:代理模式

静态代理模式的好处：
- 可以使真实角色的操作更加纯粹，不用去关注一些公共的业务（如房东只要做租房，不用管其他）
- 公共可以交给代理角色，实现了业务的分工
- 公共业务发生拓展的时候，方便集中管理
代理模式的缺点：
- 一个正式角色就会产生一个代理角色，代码量会翻倍，开发效率会变低
```java
    //代理，中介
    public class Proxy implements Rent{
    
        //房东
        private Host host;
    
        public Proxy() {
        }
    
        public Proxy(Host host) {
            this.host = host;
        }
    
        //实现租房接口
        public void rent() {
            //中介带你看房
            seeHouse();
            //不用面向房东直接看房
            host.rent();
            //中介收费
            fare();
            //中介签合同
            hetong();
    
        }
    
        //看房
        public void seeHouse(){
            System.out.println("中介带你看房");
        }
    
        //收中介费
        public void fare(){
            System.out.println("收中介费");
        }
    
        //签合同
        public void hetong(){
            System.out.println("签租赁合同");
        }
    }

```
步骤：
    1.创建租房接口
    2.真实角色(房东)
    3.代理角色(中介)
    4.客户端访问代理角色    
---------------------------------------------------------------------------------------------------------------------------------

动态代理模式：     

- 动态代理和静态代理角色是一样
- 动态代理的代理类是动态生成的，不是我们直接写好的
- 动态代理分为两大类:基于接口的动态代理，基于类的动态代理
    基于接口-JDK动态代理
    基于类-cglib
    java字节码实现-javasist
    
    需要了解两个类：proxy:代理,InvocationHandler:调用处理程序
    
动态代理的好处：
    1.可以使真实角色的操作更加纯粹，不用关注一些公共业务
    2.公共业务就交给了代理角色，实现了业务的分工。
    3.公共业务发生拓展的时候，方便集中管理。
    4.一个动态代理类代理的是一个接口，一般就是对应的一类业务