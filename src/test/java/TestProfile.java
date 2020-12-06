import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.top.conf.ProfileConfiguration;

import javax.sql.DataSource;

public class TestProfile {


    /**
     * 1. 使用命令行参数动态切换环境,在虚拟机参数位置
     *      -Dspring.profiles.active=dev
     */

    @Test
    public void test(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProfileConfiguration.class);
        String[] names = context.getBeanNamesForType(DataSource.class);
        for(String bean: names){
            System.out.println(bean);
        }

        //验证driverClass的属性赋值
//        DataSource prodDataSource = (DataSource) context.getBean("prodDataSource");
//        System.out.println(prodDataSource);
    }

    /**
     * 使用代码方式设置环境参数
     */
    @Test
    public void test1(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注册激活环境
        context.getEnvironment().setActiveProfiles("prod","test");
        //注册配置类
        context.register(ProfileConfiguration.class);
        //启动容器
        context.refresh();
        String[] names = context.getBeanNamesForType(DataSource.class);
        for(String bean: names){
            System.out.println(bean);
        }
    }
}
