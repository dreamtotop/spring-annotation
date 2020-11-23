容器中注册组件的方式：
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