package org.top.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 模拟日志切面类
 */
//标注当前类为切面类
@Aspect
public class LogAspect {

    //抽取公共切入点表达式
    @Pointcut("execution(public int org.top.aop.Calculator.*(..))")
    public void pointCut(){

    }


    // JoinPoint joinPoint 该参数一定出现在参数列表的第一位
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        // 获取方法名
        String method = joinPoint.getSignature().getName();
        // 获取方法参数
        Object[] args = joinPoint.getArgs();
        System.out.println("@Before "+ method+" 运行。。。，参数列表是{"+ Arrays.asList(args)+ "}");
    }
    @After("pointCut()")
    public void logEnd(){
        System.out.println("@After,除法结束。。。");
    }

    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(Object result){
        System.out.println("@AfterReturning,除法正常返回。。。，返回结果是{"+ result+ "}");
    }

    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logException(Exception exception){
        System.out.println("@AfterThrowing,除法异常。。。，异常信息，{+ "+exception+" }");
    }
}
