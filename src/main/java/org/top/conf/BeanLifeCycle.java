package org.top.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.top.bean.Car;
import org.top.bean.Dog;

@Configuration
public class BeanLifeCycle {

    @Bean
    public Car car(){
        return new Car();
    }

    // 验证无参
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car1(){
        return new Car();
    }

    //@Scope("prototype")
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car2(){
        return new Car("benz");
    }

//    @Bean
//    public Dog dog(){
//        return new Dog();
//    }
}
