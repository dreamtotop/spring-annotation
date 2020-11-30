package org.top.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Dog implements InitializingBean, DisposableBean {


    public Dog(){
        System.out.println("Dog init");
    }
    /**
     * 定义bean的销毁
     * @throws Exception
     */
    //@PreDestroy
    public void destroy() throws Exception {
        System.out.println("Dog destroy");
    }

    /**
     * 定义bean的初始化方法
     * @throws Exception
     */
    //@PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("Dog afterPropertiesSet");
    }
}
