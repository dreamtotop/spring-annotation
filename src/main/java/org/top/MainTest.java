package org.top;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.top.bean.Person;
import org.top.conf.BeanConfiguration;


//@ComponentScan(value = "org.top", excludeFilters = {
//    @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
//    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {PersonService.class})
//})
public class MainTest {

    public static void main(String[] args) {

    // ****************  根据xml配置文件来获取对象 *************************** //
        // 根据xml 配置文件获取对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // 根据bean id获取配置的对象
        Person getPersonById = (Person) context.getBean("person");
        System.out.println(getPersonById);

        // 根据类型来获取
        Person getPersonByType = (Person) context.getBean(Person.class);
        System.out.println(getPersonByType);
        System.out.println();

    // ************* 根据 Spring 注解 来获取对象  ***************//

        /**
         * @Bean 注解 给容器注册对象(默认是单实例)，类型为返回值类型， id默认为方法名
         *  1 . value 或 name 可以指定具体的 id值
         */
        ApplicationContext annotationContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        Person person = (Person) annotationContext.getBean("person");
        Person person1 = (Person) annotationContext.getBean("person");
        System.out.println(person);
        System.out.println(person == person1);
        System.out.println();


        /**
         * @Scope 注解 （声明对象作用域）
         *  1. prototype : 多实例， ioc容器启动时，并不会调用方法去创建对象放在容器中，每次获取对象的时候才会调用方法创建。
         *  2. singleton : 单实例，ioc容器启动时，会调用方法去创建对象放在容器中。
         *  3. request : 同一次请求创建一个实例
         *  4. session: 同一个session创建一个实例
         */
        Person personByScope1 = (Person) annotationContext.getBean("Person");
        Person personByScope2 = (Person) annotationContext.getBean("Person");
        System.out.println(personByScope1);
        System.out.println(personByScope1 == personByScope2);
        System.out.println();

        /**
         * 单实例Bean,默认在IOC容器启动时创建对象
         *  @Lazy : 懒加载注解：容器启动时不创建对象，获取对象时才创建对象
         */

        //annotationContext.getBean("person2");


        /**
         *  @Bean("bill")
         *     @Conditional({WindowsCondition.class})
         *
         * @Conditional : 按照一定的条件进行判断，满足条件后向容器中注册Bean
         * 该注解可以使用在方法上，也可以使用在类上
         */



        // ******* 测试 FactoryBean ****************  //
        /**
         *  通过FactoryBean来向容器中注册Bean
         */
        Object bean = annotationContext.getBean("factoryBean");
        System.out.println(bean.getClass());
        //获取工厂Bean本身(增加前缀)
        Object factory = annotationContext.getBean("&factoryBean");
        System.out.println(factory.getClass());


        // *******       测试包扫描@ComponentScan注解   ************** //
        /**
         * @ComponentScan(value = "org.top", excludeFilters = {
         *         @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
         * })
         * 1. value : 指定要扫描的包
         * 2. excludeFilters  ： 扫描按照指定的规则排除组件
         * 3. includeFilters  ： 扫描按照规则只需要那些组件
         *  -- FilterType.ANNOTATION 根据注解
         *  -- FilterType.ASSIGNABLE_TYPE 根据类型
         *  -- FilterType.ASPECTJ 根据ASPECTJ表达式
         *  -- FilterType.REGEX 根据正则表达式
         *  -- FilterType.CUSTOM  根据自定义规则
         */
        // 获取所有的注册组件
//        String[] names = annotationContext.getBeanDefinitionNames();
//        for(String name : names){
//            System.out.println(name);
//        }
    }
}
