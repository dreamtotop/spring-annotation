import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.top.aop.Calculator;
import org.top.conf.ConfOfAop;

public class TestAop {

    @Test
    public void testAop(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfOfAop.class);
        Calculator bean = context.getBean(Calculator.class);
        bean.div(1, 1);

    }
}
