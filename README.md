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
    