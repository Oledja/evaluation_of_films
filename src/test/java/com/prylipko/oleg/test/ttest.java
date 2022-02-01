package com.prylipko.oleg.test;

import com.prylipko.oleg.domain.*;
import com.prylipko.oleg.dto.user.CreateUserRequest;
import com.prylipko.oleg.repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest

public class ttest {

    @Autowired
    private GenreRepository genreRepository;


    @Autowired
    private ProductionCompanyRepository productionCompanyRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CastRepository castRepository;

    @Autowired
    private CreditRepository creditRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    RepositoryHelper repositoryHelper;

    @Test
    @Transactional
    public void test() {
        CreateUserRequest create = new CreateUserRequest();
    }

}

