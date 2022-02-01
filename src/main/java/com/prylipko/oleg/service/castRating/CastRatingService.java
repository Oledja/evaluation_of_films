package com.prylipko.oleg.service.castRating;

import com.prylipko.oleg.domain.Cast;
import com.prylipko.oleg.domain.CastRating;
import com.prylipko.oleg.domain.User;
import com.prylipko.oleg.dto.castRating.CreateCastRatingRequest;
import com.prylipko.oleg.dto.castRating.PatchCastRatingRequest;
import com.prylipko.oleg.dto.castRating.ReadCastRatingResponse;
import com.prylipko.oleg.dto.castRating.UpdateCastRatingRequest;
import com.prylipko.oleg.repository.CastRatingRepository;
import com.prylipko.oleg.repository.RepositoryHelper;
import com.prylipko.oleg.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CastRatingService {

    @Autowired
    private CastRatingRepository castRatingRepository;

    @Autowired
    private RepositoryHelper repositoryHelper;

    @Autowired
    private TranslationService translationService;

    public ReadCastRatingResponse getCastRating(UUID id) {
        CastRating castRating = repositoryHelper.getEntityRequired(CastRating.class, id);

        return translationService.translate(castRating, ReadCastRatingResponse.class);
    }

    @Transactional
    public ReadCastRatingResponse createCastRating(CreateCastRatingRequest create) {
        CastRating castRating = translationService.translate(create, CastRating.class);
        castRating.setCast(repositoryHelper.getReferenceExist(Cast.class, create.getCastId()));
        castRating.setUser(repositoryHelper.getReferenceExist(User.class, create.getUserId()));
        castRating = castRatingRepository.save(castRating);

        return translationService.translate(castRating, ReadCastRatingResponse.class);
    }

    public ReadCastRatingResponse patchCastRating(UUID id, PatchCastRatingRequest patch) {
        CastRating castRating = repositoryHelper.getEntityRequired(CastRating.class, id);
        translationService.map(patch, castRating);
        castRating = castRatingRepository.save(castRating);

        return translationService.translate(castRating, ReadCastRatingResponse.class);
    }

    public ReadCastRatingResponse updateCastRating(UUID id, UpdateCastRatingRequest update) {
        CastRating castRating = repositoryHelper.getEntityRequired(CastRating.class, id);
        translationService.map(update, castRating);
        castRating = castRatingRepository.save(castRating);

        return translationService.translate(castRating, ReadCastRatingResponse.class);
    }

    public void deleteCastRating(UUID id) {
        castRatingRepository.delete(repositoryHelper.getEntityRequired(CastRating.class, id));
    }
}
