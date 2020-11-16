package org.top.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判断操作系统类型
 */
public class WindowsCondition implements Condition {

    /**
     *
     * @param conditionContext   : 判断条件能使用的上下文环境
     * @param annotatedTypeMetadata ： 注释信息
     * @return
     */
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        // 获取beanFactory
        // ConfigurableListableBeanFactory factory = conditionContext.getBeanFactory();
        // 获取类加载器
        // ClassLoader loader = conditionContext.getClassLoader();
        // 获取环境
        Environment environment = conditionContext.getEnvironment();
        String property = environment.getProperty("os.name");

        // 获取bean 定义的注册类信息(用于判断容器中bean注册情况，也可以给容器中注册bean)
        //BeanDefinitionRegistry registry = conditionContext.getRegistry();
        if(property.contains("Windows")){
            return true;
        }
        return false;
    }
}
