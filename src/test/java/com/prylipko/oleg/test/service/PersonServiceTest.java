package com.prylipko.oleg.test.service;

import com.prylipko.oleg.repository.PersonRepository;
import com.prylipko.oleg.service.person.PersonService;
import com.prylipko.oleg.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonServiceTest extends BaseTest {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @Test
    public void testGetPerson() {
        System.out.println(personRepository.count() + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
