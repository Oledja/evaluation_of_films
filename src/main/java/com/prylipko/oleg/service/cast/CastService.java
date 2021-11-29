package com.prylipko.oleg.service.cast;

import com.prylipko.oleg.domain.Cast;
import com.prylipko.oleg.dto.cast.CreateCastRequest;
import com.prylipko.oleg.dto.cast.PatchCastRequest;
import com.prylipko.oleg.dto.cast.ReadCastResponse;
import com.prylipko.oleg.dto.cast.UpdateCastRequest;
import com.prylipko.oleg.repository.CastRepository;
import com.prylipko.oleg.repository.RepositoryHelper;
import com.prylipko.oleg.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CastService {

    @Autowired
    private CastRepository castRepository;

    @Autowired
    private RepositoryHelper repositoryHelper;

    @Autowired
    private TranslationService translationService;

    public ReadCastResponse getCast(UUID id) {
        Cast cast = repositoryHelper.getEntityRequired(Cast.class, id);

        return translationService.translate(cast, ReadCastResponse.class);
    }

    public ReadCastResponse createCast(CreateCastRequest create) {
        Cast cast = translationService.translate(create, Cast.class);
        cast = castRepository.save(cast);

        return translationService.translate(cast, ReadCastResponse.class);
    }

    public ReadCastResponse patchCast(UUID id, PatchCastRequest patch) {
        Cast cast = repositoryHelper.getEntityRequired(Cast.class, id);
        translationService.map(patch, cast);
        cast = castRepository.save(cast);

        return translationService.translate(cast, ReadCastResponse.class);
    }

    public ReadCastResponse updateCast(UUID id, UpdateCastRequest update) {
        Cast cast = repositoryHelper.getEntityRequired(Cast.class, id);
        translationService.map(update, cast);
        cast = castRepository.save(cast);

        return translationService.translate(cast, ReadCastResponse.class);
    }

    public void deleteCast(UUID id) {
        castRepository.delete(repositoryHelper.getEntityRequired(Cast.class, id));
    }
}
