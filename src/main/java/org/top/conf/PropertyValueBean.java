package org.top.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.top.bean.PersonValue;

/**
 * 属性注入
 */
@Configuration
// 使用PropertySource读取外部配置文件
@PropertySource(value = {"classpath:/person.properties",})
public class PropertyValueBean {

//    @Bean
//    public Person person(){
//        return new Person("老王",24);
//    }
//
//    @Bean
//    public Person person1(){
//        return new Person("隔壁老王",25);
//    }

    @Bean
    public PersonValue personValue(){
        return new PersonValue();
    }

}
