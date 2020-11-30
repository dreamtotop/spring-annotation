一.容器中注册组件的方式：
1.  xml 配置
2. 包扫描+组件标注注解（@Controller,@Service,@Repository,@Component）
3. @Bean
4. @Import
   3.1 @Import (id 默认为全类名)
   3.2 @ImportSelector （导入组件的全类名数组，需要实现ImportSelector接口）
   3.3 ImportBeanDefinitionRegistrar(实现改接口)，手动注册bean
5. 使用Spring提供的FactoryBean (工厂Bean)
    5.1 默认取到的是工厂bean调用getObject()方法创建的对象
    5.2 要获取工厂bean本身，需要给id前面加一个 & 标识
    
二. bean的生命周期
容器管理bean的生命周期（也可以自定义bean的初始化和销毁方法）

构造（对象创建）：
    单实例： 容器启动时创建对象
    多实例： 每次获取的时候创建对象
    
初始化：
      对象创建完成，并赋值号，然后调用初始化方法

销毁：
      单实例：容器关闭时，调用销毁方法
      多实例：容器不会管理该bean，容器不会调用销毁方法

1. XML配置
    <bean id="person" class="org.top.bean.Person" init-method="" destroy-method=""/>
2. 通过@Bean(initMethod = "", destroyMethod = "") 指定初始化方法和销毁方法

3.通过bean实现InitializingBean接口定义初始化逻辑，实现DisposableBean接口定义销毁逻辑。（Dog）

4.可以使用JSR250(方法上加该注解)
    @PostConstruct ：在bean创建完成并且属性赋值完成，来执行初始化方法。
    @PreDestroy : 在容器销毁bean之前通知进行清理工作

5.BeanPostProcessor:bean的后置处理器
    在bean的初始化前后进行一些处理工作

    
