package org.top.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.top.dao.PersonDao;

@Service
public class PersonService {

    @Autowired
    //@Qualifier("personDao2")
    private PersonDao personDao;


    @Qualifier("personDao3")
    @Autowired(required = false)
    private PersonDao personDao3;


    @Override
    public String toString() {
        return "PersonService{" +
                "personDao=" + personDao +
                '}';
    }
}
