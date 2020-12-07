package org.top.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.top.aop.Calculator;
import org.top.aop.LogAspect;

@Configuration
@EnableAspectJAutoProxy // 开启基于注解的aop模式
public class ConfOfAop {

    /**
     * 将业务逻辑类加入到容器中
     */
    @Bean
    public Calculator calculator(){
        return new Calculator();
    }

    /**
     * 将切面类加入容器中
     */

    @Bean
    public LogAspect logAspect(){
        return new LogAspect();
    }


}
