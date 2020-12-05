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

1.构造（对象创建）：
    单实例： 容器启动时创建对象
    多实例： 每次获取的时候创建对象
    
BeanPostProcessor.postProcessBeforeInitialization()
2.初始化：
      对象创建完成，并赋值号，然后调用初始化方法
   
BeanPostProcessor.postProcessAfterInitialization
3.销毁：
      单实例：容器关闭时，调用销毁方法
      多实例：容器不会管理该bean，容器不会调用销毁方法


指定bean的初始化和销毁方法
(1. XML配置
    <bean id="person" class="org.top.bean.Person" init-method="" destroy-method=""/>
(2. 通过@Bean(initMethod = "", destroyMethod = "") 指定初始化方法和销毁方法

(3.通过bean实现InitializingBean接口定义初始化逻辑，实现DisposableBean接口定义销毁逻辑。（Dog）

(4.可以使用JSR250(方法上加该注解)
    @PostConstruct ：在bean创建完成并且属性赋值完成，来执行初始化方法。
    @PreDestroy : 在容器销毁bean之前通知进行清理工作

(5.BeanPostProcessor【interface】:bean的后置处理器
    在bean的初始化前后进行一些处理工作
    postProcessBeforeInitialization: 初始化之前工作
    postProcessAfterInitialization: 初始化之后工作
    
    
三: 给bean的属性赋值方式
(1：@Value进行属性赋值
    (1). @Value("张三")，直接进行赋值
    (2). 使用SpEL表达式进行赋值 : @Value("#{20-2}")
    (3). 使用${}取出配置文件中的值进行赋值 : @Value("${}")
    


四：自动装配:spring利用依赖注入(DI)，完成对IOC容器中各个组件的依赖关系赋值。
(1. @Autowired : 自动注入
    private PersonDao personDao;
    (1).默认优先按照类型去容器中找对应的组件，applicationContext.getBean(PersonDao.class)
    (2).如果找到多个相同类型的组件，再将属性的变量名称作为组件的id去容器中查找，applicationContext.getBean("personDao")
    (3).@Qualifier("personDao") 注定装配的组件的id，而不是使用属性名。
    (4).自动装配默认一定要将属性赋值好，没有会报错。可以
        使用@Autowired(required = false)避免报错。
    (5).@Primary:spring自动装配的时候，默认使用首选的bean



    
