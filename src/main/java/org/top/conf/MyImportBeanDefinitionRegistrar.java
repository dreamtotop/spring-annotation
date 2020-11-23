package org.top.conf;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.top.bean.Color;

/**
 * @Import 的第三种用法
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *
     * @param importingClassMetadata :当前类的注解信息
     * @param registry ：BeanDefinition注册类，调用BeanDefinitionRegistry.registerBeanDefinition()手动注册bean
     *
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry){
        // 指定bean的类型(作用域等)
        RootBeanDefinition beanDefinition = new RootBeanDefinition(Color.class);
        // 指定bean的id
        registry.registerBeanDefinition("color",beanDefinition);
    }

}
