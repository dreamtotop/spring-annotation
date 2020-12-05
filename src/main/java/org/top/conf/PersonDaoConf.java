package org.top.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.top.bean.Person;
import org.top.dao.PersonDao;

@Configuration
@ComponentScan({"org.top.service","org.top.dao"})
//@ComponentScan({"org.top"})
public class PersonDaoConf {

    //@Primary
    @Bean("personDao2")
    public PersonDao personDao(){
        PersonDao personDao = new PersonDao();
        personDao.setLabel(2);
        return personDao;
    }
}
