package org.top.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 创建工厂Bean
 */
public class StudentFactoryBean implements FactoryBean<Student> {

    // 返回对象，该对象会添加到容器中
    public Student getObject() throws Exception {
        System.out.println("通过FactoryBean创建student对象");
        return new Student();
    }


    public Class<?> getObjectType() {
        return Student.class;
    }

    /**
     * 是否是单例(true: 单例， false: 非单例)
     * @return
     */
    public boolean isSingleton(){
        return true;
    }
}
