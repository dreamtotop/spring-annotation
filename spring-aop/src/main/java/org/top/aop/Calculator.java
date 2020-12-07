package org.top.aop;

/**
 * 模拟业务逻辑类
 */
public class Calculator {

    public int div(int i ,int j){
        System.out.println("div()运行中");
        return i/j;
    }
}
