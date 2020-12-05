package org.top.bean;

import org.springframework.beans.factory.annotation.Value;

public class PersonValue {

    @Value("${person.name}")
    private String name;

    @Value("${person.age}")
    private Integer age;

    public PersonValue(){

    }

    public PersonValue(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
