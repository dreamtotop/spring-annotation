容器中注册组件的方式：
1. 包扫描+组件标注注解（@Controller,@Service,@Repository,@Component）
2. @Bean
3. @Import
   3.1 @Import (id 默认为全类名)
   3.2 @ImportSelector （导入组件的全类名数组，需要实现ImportSelector接口）