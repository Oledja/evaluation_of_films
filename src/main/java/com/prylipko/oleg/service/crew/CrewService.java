package com.prylipko.oleg.service.crew;

import com.prylipko.oleg.domain.Crew;
import com.prylipko.oleg.dto.credit.CreateCreditRequest;
import com.prylipko.oleg.dto.credit.PatchCreditRequest;
import com.prylipko.oleg.dto.credit.UpdateCreditRequest;
import com.prylipko.oleg.dto.crew.ReadCrewResponse;
import com.prylipko.oleg.repository.CrewRepository;
import com.prylipko.oleg.repository.RepositoryHelper;
import com.prylipko.oleg.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CrewService {

    @Autowired
    private CrewRepository crewRepository;

    @Autowired
    private RepositoryHelper repositoryHelper;

    @Autowired
    private TranslationService translationService;

    public ReadCrewResponse getCrew(UUID id) {
        Crew crew = repositoryHelper.getEntityRequired(Crew.class, id);

        return translationService.translate(crew, ReadCrewResponse.class);
    }

    public ReadCrewResponse createCrew(CreateCreditRequest create) {
        Crew crew = translationService.translate(create, Crew.class);
        crew = crewRepository.save(crew);

        return translationService.translate(crew, ReadCrewResponse.class);
    }

    public ReadCrewResponse patchCrew(UUID id, PatchCreditRequest patch) {
        Crew crew = repositoryHelper.getEntityRequired(Crew.class, id);
        translationService.map(patch, crew);
        crew = crewRepository.save(crew);

        return translationService.translate(crew, ReadCrewResponse.class);
    }

    public ReadCrewResponse updateCrew(UUID id, UpdateCreditRequest update) {
        Crew crew = repositoryHelper.getEntityRequired(Crew.class, id);
        translationService.map(update, crew);
        crew = crewRepository.save(crew);

        return translationService.translate(crew, ReadCrewResponse.class);
    }

    public void deleteCrew(UUID id) {
        crewRepository.delete(repositoryHelper.getEntityRequired(Crew.class, id));
    }
}
