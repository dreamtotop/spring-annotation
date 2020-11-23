package org.top.conf;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.top.bean.Book;
import org.top.bean.Person;
import org.top.bean.StudentFactoryBean;
import org.top.condition.LinuxCondition;
import org.top.condition.WindowsCondition;

@Configuration
@ComponentScan(value = "org.top", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
})
@Import({Book.class, MyImportBeanDefinitionRegistrar.class, MyImportSelector.class})
public class BeanConfiguration {

    // 给容器注册对象，类型为返回值类型， id默认为方法名(属性value(name)可以指定id)
    //@Bean(value = "Person")
    @Bean
    public Person person(){
        System.out.println("ioc 容器中添加Person");
        return new Person("李四",24);
    }

    //  创建用于验证 对象作用域的对象实例
    @Scope("prototype")
    @Bean(value = "Person")
    public Person person1(){
        System.out.println("ioc 容器中国添加 Person");
        return new Person("王五",24);
    }

    // 创建用于验证懒加载的对象实例
    @Bean
    @Lazy
    public Person person2(){
        System.out.println("懒加载  ,ioc 容器中国添加 Person");
        return new Person("懒加载",24);
    }


    // 创建用于验证条件成立的对象实例
    @Bean("bill")
    @Conditional({WindowsCondition.class})
    public Person Bill(){
        return new Person("比尔盖茨",60);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person Linus(){
        return new Person("利纳斯",48);
    }

    // 创建通过FactoryBean注入bean
    @Bean
    public FactoryBean factoryBean(){
        return new StudentFactoryBean();
    }

}
