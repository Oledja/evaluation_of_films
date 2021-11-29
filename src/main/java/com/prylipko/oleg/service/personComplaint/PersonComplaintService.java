package com.prylipko.oleg.service.personComplaint;

import com.prylipko.oleg.domain.PersonComplaint;
import com.prylipko.oleg.dto.person.UpdatePersonRequest;
import com.prylipko.oleg.dto.personComplaint.CreatePersonComplaintRequest;
import com.prylipko.oleg.dto.personComplaint.PatchPersonComplaintRequest;
import com.prylipko.oleg.dto.personComplaint.ReadPersonComplaintResponse;
import com.prylipko.oleg.dto.personComplaint.UpdatePersonComplaintRequest;
import com.prylipko.oleg.repository.PersonComplaintRepository;
import com.prylipko.oleg.repository.RepositoryHelper;
import com.prylipko.oleg.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PersonComplaintService {

    @Autowired
    private PersonComplaintRepository personComplaintRepository;

    @Autowired
    private RepositoryHelper repositoryHelper;

    @Autowired
    private TranslationService translationService;

    public ReadPersonComplaintResponse getPersonComplaint(UUID id) {
        PersonComplaint personComplaint = repositoryHelper.getEntityRequired(PersonComplaint.class, id);

        return translationService.translate(personComplaint, ReadPersonComplaintResponse.class);
    }

    public ReadPersonComplaintResponse createPersonComplaint(CreatePersonComplaintRequest create) {
        PersonComplaint personComplaint = translationService.translate(create, PersonComplaint.class);
        personComplaint = personComplaintRepository.save(personComplaint);

        return translationService.translate(personComplaint, ReadPersonComplaintResponse.class);
    }

    public ReadPersonComplaintResponse patchPersonComplaint(UUID id, PatchPersonComplaintRequest patch) {
        PersonComplaint personComplaint = repositoryHelper.getEntityRequired(PersonComplaint.class, id);
        translationService.map(patch, personComplaint);
        personComplaint = personComplaintRepository.save(personComplaint);

        return translationService.translate(personComplaint, ReadPersonComplaintResponse.class);
    }

    public ReadPersonComplaintResponse updatePersonComplaint(UUID id, UpdatePersonComplaintRequest update) {
        PersonComplaint personComplaint = repositoryHelper.getEntityRequired(PersonComplaint.class, id);
        translationService.map(update, PersonComplaint.class);
        personComplaint = personComplaintRepository.save(personComplaint);

        return translationService.translate(personComplaint, ReadPersonComplaintResponse.class);
    }

    public void deletePersonComplaint(UUID id) {
        personComplaintRepository.delete(repositoryHelper.getEntityRequired(PersonComplaint.class, id));
    }
}
