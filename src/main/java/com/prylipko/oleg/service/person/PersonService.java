package com.prylipko.oleg.service.person;

import com.prylipko.oleg.domain.Person;
import com.prylipko.oleg.dto.person.CreatePersonRequest;
import com.prylipko.oleg.dto.person.PatchPersonRequest;
import com.prylipko.oleg.dto.person.ReadPersonResponse;
import com.prylipko.oleg.dto.person.UpdatePersonRequest;
import com.prylipko.oleg.repository.PersonRepository;
import com.prylipko.oleg.repository.RepositoryHelper;
import com.prylipko.oleg.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RepositoryHelper repositoryHelper;

    @Autowired
    private TranslationService translationService;

    public ReadPersonResponse getPerson(UUID id) {
        Person person = repositoryHelper.getEntityRequired(Person.class, id);

        return translationService.translate(person, ReadPersonResponse.class);
    }

    public ReadPersonResponse createPerson(CreatePersonRequest create) {
        Person person = translationService.translate(create, Person.class);
        person = personRepository.save(person);

        return translationService.translate(person, ReadPersonResponse.class);
    }

    public ReadPersonResponse patchPerson(UUID id, PatchPersonRequest patch) {
        Person person = repositoryHelper.getEntityRequired(Person.class, id);
        translationService.map(patch, person);
        person = personRepository.save(person);

        return translationService.translate(person, ReadPersonResponse.class);
    }

    public ReadPersonResponse updatePerson(UUID id, UpdatePersonRequest update) {
        Person person = repositoryHelper.getEntityRequired(Person.class, id);
        translationService.map(update, person);
        person = personRepository.save(person);

        return translationService.translate(person, ReadPersonResponse.class);
    }

    public void deletePerson(UUID id) {
        personRepository.delete(repositoryHelper.getEntityRequired(Person.class, id));
    }
}
