package com.prylipko.oleg.test.service;

import com.prylipko.oleg.domain.*;
import com.prylipko.oleg.dto.credit.CreateCreditRequest;
import com.prylipko.oleg.dto.credit.ReadCreditResponse;
import com.prylipko.oleg.dto.crew.CreateCrewRequest;
import com.prylipko.oleg.repository.CreditRepository;
import com.prylipko.oleg.service.TranslationService;
import com.prylipko.oleg.service.cast.CastService;
import com.prylipko.oleg.service.credit.CreditService;
import com.prylipko.oleg.service.crew.CrewService;
import com.prylipko.oleg.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CreditServiceTest extends BaseTest {

    @Autowired
    private CreditService creditService;

    @Autowired
    private CreditRepository creditRepository;

    @Autowired
    private CastService castService;

    @Autowired
    private CrewService crewService;

    @Autowired
    private TranslationService translationService;
/**
    public void testGetCredit() {
        Movie movie = generateFlatEntityAndSave(Movie.class);
        Cast cast = generateFlatEntityAndSave(Cast.class);
        cast.setPerson(generateFlatEntityAndSave(Person.class));

        Cast cast1 = generateFlatEntityAndSave(Cast.class);
        cast1.setPerson(generateFlatEntityAndSave(Person.class));

        Crew crew = generateFlatEntityAndSave(Crew.class);
        crew.setPerson(generateFlatEntityAndSave(Person.class));

        Crew crew1 = generateFlatEntityAndSave(Crew.class);
        crew.setPerson(generateFlatEntityAndSave(Person.class));

        CreateCreditRequest createCredit = new CreateCreditRequest();
        createCredit.setMovieId(movie.getId());
        createCredit.setCasts(List.of(castService.getCast(cast.getId())));
        createCredit.setCasts(List.of(castService.getCast(cast1.getId())));
        createCredit.setCrews(List.of(crewService.getCrew(crew.getId())));
        createCredit.setCrews(List.of(crewService.getCrew(crew1.getId())));

        ReadCreditResponse readCredit = creditService.createCredit(createCredit);
    }
 **/
}
