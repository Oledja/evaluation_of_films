package com.prylipko.oleg.test.service;

import com.prylipko.oleg.domain.Person;
import com.prylipko.oleg.dto.person.CreatePersonRequest;
import com.prylipko.oleg.dto.person.PatchPersonRequest;
import com.prylipko.oleg.dto.person.ReadPersonResponse;
import com.prylipko.oleg.dto.person.UpdatePersonRequest;
import com.prylipko.oleg.repository.PersonRepository;
import com.prylipko.oleg.service.TranslationService;
import com.prylipko.oleg.service.person.PersonService;
import com.prylipko.oleg.test.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonServiceTest extends BaseTest {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @Autowired
    private TranslationService translationService;

    @Test
    public void testGetPerson() {
        Person person = generateFlatEntityAndSave(Person.class);

        ReadPersonResponse readPerson = personService.getPerson(person.getId());
        Person personAfterSave = translationService.translate(readPerson, Person.class);

        Assertions.assertThat(personAfterSave).isEqualToComparingFieldByField(person);
    }

    @Test
    public void testCreatePerson() {
        Person person = generateFlatEntityWithoutId(Person.class);
        CreatePersonRequest createPerson = translationService.translate(person, CreatePersonRequest.class);

        ReadPersonResponse readPerson = personService.createPerson(createPerson);
        Person personAfterSave = translationService.translate(readPerson, Person.class);

        Assertions.assertThat(personAfterSave).isEqualToIgnoringGivenFields(person, "id", "createdAt", "updatedAt");
    }

    @Test
    public void testPatchPerson() {
        Person person = generateFlatEntityAndSave(Person.class);

        PatchPersonRequest patchPerson = translationService.translate(
                generateFlatEntityWithoutId(Person.class), PatchPersonRequest.class);

        ReadPersonResponse readPerson = personService.patchPerson(person.getId(), patchPerson);
        Assertions.assertThat(patchPerson).isEqualToComparingFieldByField(readPerson);
    }

    @Test
    public void testUpdatePerson() {
        Person person = generateFlatEntityAndSave(Person.class);

        UpdatePersonRequest updatePerson = translationService.translate(
                generateFlatEntityWithoutId(Person.class), UpdatePersonRequest.class);

        ReadPersonResponse readPerson = personService.updatePerson(person.getId(), updatePerson);
        Assertions.assertThat(updatePerson).isEqualToComparingFieldByField(readPerson);
    }

    @Test
    public void testDeletePerson() {
        Person person = generateFlatEntityAndSave(Person.class);

        Assert.assertTrue(personRepository.existsById(person.getId()));
        personService.deletePerson(person.getId());
        Assert.assertFalse(personRepository.existsById(person.getId()));
    }
}
