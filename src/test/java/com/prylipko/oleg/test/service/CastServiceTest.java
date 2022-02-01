package com.prylipko.oleg.test.service;

import com.prylipko.oleg.domain.Cast;
import com.prylipko.oleg.domain.Gender;
import com.prylipko.oleg.domain.Person;
import com.prylipko.oleg.dto.cast.CreateCastRequest;
import com.prylipko.oleg.dto.cast.PatchCastRequest;
import com.prylipko.oleg.dto.cast.ReadCastResponse;
import com.prylipko.oleg.dto.cast.UpdateCastRequest;
import com.prylipko.oleg.dto.castRating.CreateCastRatingRequest;
import com.prylipko.oleg.dto.person.ReadPersonResponse;
import com.prylipko.oleg.repository.CastRepository;
import com.prylipko.oleg.repository.PersonRepository;
import com.prylipko.oleg.service.TranslationService;
import com.prylipko.oleg.service.cast.CastService;
import com.prylipko.oleg.test.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CastServiceTest extends BaseTest {

    @Autowired
    private CastService castService;

    @Autowired
    private TranslationService translationService;

    @Autowired
    private CastRepository castRepository;

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testGetCast() {
        Person person = generateFlatEntityAndSave(Person.class);

        CreateCastRequest createCast = new CreateCastRequest();
        createCast.setPerson(translationService.translate(person, ReadPersonResponse.class));
        createCast.setGender(Gender.MALE);
        createCast.setName("Name");

        ReadCastResponse readCast = castService.createCast(createCast);
        ReadCastResponse castAfterSave = castService.getCast(readCast.getId());

        Assertions.assertThat(readCast).isEqualToComparingFieldByField(castAfterSave);
    }

    @Test
    public void testCreateCast() {
        Person person = generateFlatEntityAndSave(Person.class);

        CreateCastRequest createCast = new CreateCastRequest();
        createCast.setPerson(translationService.translate(person, ReadPersonResponse.class));
        createCast.setGender(Gender.MALE);
        createCast.setName("Name");

        ReadCastResponse readCast = castService.createCast(createCast);
        Assert.assertTrue(castRepository.existsById(readCast.getId()));

        ReadCastResponse castAfterSave = castService.getCast(readCast.getId());
        Assertions.assertThat(readCast).isEqualToComparingFieldByField(castAfterSave);
    }

    @Test
    public void testPatchCast() {
        Cast cast = generateFlatEntityWithoutId(Cast.class);
        Person person = generateFlatEntityAndSave(Person.class);
        cast.setPerson(person);

        ReadCastResponse readCast = castService.createCast(translationService.translate(cast, CreateCastRequest.class));

        PatchCastRequest patchCast = translationService.translate(generateFlatEntityWithoutId(Cast.class), PatchCastRequest.class);
        ReadPersonResponse readPerson = translationService.translate(generateFlatEntityAndSave(Person.class), ReadPersonResponse.class);
        patchCast.setPerson(readPerson);
        ReadCastResponse castAfterPatch = castService.patchCast(readCast.getId(), patchCast);

        Assertions.assertThat(castAfterPatch).isEqualToIgnoringGivenFields(translationService.translate(patchCast, ReadCastResponse.class), "id", "createdAt", "updatedAt");
    }

    @Test
    public void testUpdateCast() {
        Cast cast = generateFlatEntityWithoutId(Cast.class);
        Person person = generateFlatEntityAndSave(Person.class);
        cast.setPerson(person);

        ReadCastResponse readCast = castService.createCast(translationService.translate(cast, CreateCastRequest.class));

        UpdateCastRequest updateCast = translationService.translate(generateFlatEntityWithoutId(Cast.class), UpdateCastRequest.class);
        ReadPersonResponse readPerson = translationService.translate(generateFlatEntityAndSave(Person.class), ReadPersonResponse.class);
        updateCast.setPerson(readPerson);
        ReadCastResponse castAfterUpdate = castService.updateCast(readCast.getId(), updateCast);

        Assertions.assertThat(castAfterUpdate).isEqualToIgnoringGivenFields(translationService.translate(updateCast, ReadCastResponse.class), "id", "createdAt", "updatedAt");
    }

    @Test
    public void testDeleteCast() {
        Cast cast = generateFlatEntityWithoutId(Cast.class);
        Person person = generateFlatEntityAndSave(Person.class);
        cast.setPerson(person);

        ReadCastResponse readCast = castService.createCast(translationService.translate(cast, CreateCastRequest.class));

        Assert.assertTrue(castRepository.existsById(readCast.getId()));
        Assert.assertTrue(personRepository.existsById(readCast.getPerson().getId()));
        castService.deleteCast(readCast.getId());

        Assert.assertFalse(castRepository.existsById(readCast.getId()));
        Assert.assertTrue(personRepository.existsById(readCast.getPerson().getId()));
    }
}
