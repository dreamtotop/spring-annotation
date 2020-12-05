import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import org.top.bean.Person;
import org.top.bean.PersonValue;
import org.top.conf.PropertyValueBean;

public class PropertyValueTest {


    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PropertyValueBean.class);

    /**
     * 如果IOC容器中存在多个同类型的bean时，根据类型来获取实例会报错，必须根据id来获取。
     */
    @Test
    public void testValue(){

        //Person bean = applicationContext.getBean(Person.class);
        //Person bean = (Person) applicationContext.getBean("person");

        PersonValue bean = applicationContext.getBean(PersonValue.class);
        System.out.println(bean);

        Environment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("person.name");
        System.out.println(property);
    }
}
