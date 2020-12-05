//package org.top.bean;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.BeanPostProcessor;
//import org.springframework.stereotype.Component;
//
///**
// * 后置处理器
// */
//@Component
//public class MyBeanPostProcessor implements BeanPostProcessor {
//
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("postProcessBeforeInitialization ====> "+beanName);
//        return bean;
//    }
//
//
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("postProcessAfterInitialization ====> "+beanName);
//        return bean;
//    }
//
//}
