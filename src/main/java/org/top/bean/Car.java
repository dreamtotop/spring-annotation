package org.top.bean;

public class Car {

    private String name;

    public Car(){
        System.out.println("无参构造器初始化");
    }

    public Car(String name) {
        System.out.println("有参构造器初始化");
        this.name = name;
    }

    public void init(){
        System.out.println("对象初始化init");
    }

    public void destroy(){
        System.out.println("对象销毁destroy");
    }
}
