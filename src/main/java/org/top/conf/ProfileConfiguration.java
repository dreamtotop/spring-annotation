package org.top.conf;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 展示三种bean属性赋值
 */
@Configuration
@PropertySource({"classpath:/db.properties"})
public class ProfileConfiguration implements EmbeddedValueResolverAware {

    @Value("${db.user}")
    private String user;

    private StringValueResolver stringValueResolver;

    private String driverClass;

    /**
     * 测试环境数据源
     * @return
     * @throws PropertyVetoException
     */
    @Profile("test")
    @Bean("testDataSource")
    public DataSource dataSourceTest(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test1");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        return dataSource;
    }

    /**
     * 开发环境数据源
     * @return
     * @throws PropertyVetoException
     */
    @Profile("dev")
    @Bean("devDataSource")
    public DataSource dataSourceDev() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword("19990210");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test1");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        return dataSource;
    }


    /**
     * 生产环境数据源
     * @return
     * @throws PropertyVetoException
     */
    @Profile("prod")
    @Bean("prodDataSource")
    public DataSource dataSourceProd() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword("19990210");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test1");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {

        this.stringValueResolver = stringValueResolver;

        this.driverClass = this.stringValueResolver.resolveStringValue("${db.DriverClass}");
    }
}
