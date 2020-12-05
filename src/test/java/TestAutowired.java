import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.top.bean.Person;
import org.top.conf.PersonDaoConf;
import org.top.dao.PersonDao;
import org.top.service.PersonService;

public class TestAutowired {



    @Test
    public void test(){
        //验证装配的是同一个对象
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersonDaoConf.class);
        PersonService bean = context.getBean(PersonService.class);
        System.out.println(bean);
        PersonDao bean1 = context.getBean(PersonDao.class);
        System.out.println(bean1);

    }

    @Test
    public void test1(){
        // 验证存在多个同类型的实例
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersonDaoConf.class);
        PersonService bean = context.getBean(PersonService.class);
        System.out.println(bean);

        PersonDao personDao1 = (PersonDao)context.getBean("personDao");
        System.out.println(personDao1);
        PersonDao personDao2 = (PersonDao) context.getBean("personDao2");
        System.out.println(personDao2);
    }
}
