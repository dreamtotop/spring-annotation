AOP:(动态代理)
    指在程序运行期间动态的将某段代码切入到指定方法指定位置进行运行的编程方式。
    
通知方法：
    前置通知(@Before): 在目标方法之前运行
    后置通知(@After)： 在目标方法之后运行
    返回通知(@AfterReturning： 目标方法正常返回运行
    异常通知(@AfterThrowing)： 目标方法发生异常运行
    环绕通知(@Around)： 动态代理，手动推进目标方法的运行，(joinPoint.procced())
    
@EnableAspectJAutoProxy : 开启基于注解的aop模式


使用AOP三部曲：
1.将业务逻辑组件和切面类都加入到IOC容器中,并标注切面类@Aspect
2.在切面类上的方法上标注通知注解，告诉Spring何时运行(切入点表达式)
3.开启基于注解的aop模式，@EnableAspectJAutoProxy


AOP原理：
  @EnableAspectJAutoProxy：
    @Import({AspectJAutoProxyRegistrar.class})：利用AspectJAutoProxyRegistrar
    自定义给容器中注册internalAutoProxyCreator=AnnotationAwareAspectJAutoProxyCreator。
    
  AnnotationAwareAspectJAutoProxyCreator 实现后置处理器(在bean初始化完成前后进行逻辑处理)，
    自动装配BeanFactoryAware