package com.prylipko.oleg.test.service;

import com.prylipko.oleg.domain.Cast;
import com.prylipko.oleg.domain.CastRating;
import com.prylipko.oleg.domain.User;
import com.prylipko.oleg.dto.castRating.CreateCastRatingRequest;
import com.prylipko.oleg.dto.castRating.PatchCastRatingRequest;
import com.prylipko.oleg.dto.castRating.ReadCastRatingResponse;
import com.prylipko.oleg.dto.castRating.UpdateCastRatingRequest;
import com.prylipko.oleg.repository.CastRatingRepository;
import com.prylipko.oleg.repository.CastRepository;
import com.prylipko.oleg.repository.UserRepository;
import com.prylipko.oleg.service.TranslationService;
import com.prylipko.oleg.service.castRating.CastRatingService;
import com.prylipko.oleg.test.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CastRatingServiceTest extends BaseTest {

    @Autowired
    private CastRatingService castRatingService;

    @Autowired
    private TranslationService translationService;

    @Autowired
    private CastRatingRepository castRatingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CastRepository castRepository;

    @Test
    public void testGetCastRating() {
        User user = generateFlatEntityAndSave(User.class);
        Cast cast = generateFlatEntityAndSave(Cast.class);

        CreateCastRatingRequest createCastRating = new CreateCastRatingRequest();
        createCastRating.setRating(8);
        createCastRating.setUserId(user.getId());
        createCastRating.setCastId(cast.getId());

        ReadCastRatingResponse readCastRating = castRatingService.createCastRating(createCastRating);
        ReadCastRatingResponse castAfterSave = castRatingService.getCastRating(readCastRating.getId());

        Assertions.assertThat(readCastRating).isEqualToComparingFieldByField(castAfterSave);
    }

    @Test
    public void testCreateCastRating() {
        User user = generateFlatEntityAndSave(User.class);
        Cast cast = generateFlatEntityAndSave(Cast.class);

        CreateCastRatingRequest createCastRating = new CreateCastRatingRequest();
        createCastRating.setRating(8);
        createCastRating.setUserId(user.getId());
        createCastRating.setCastId(cast.getId());

        ReadCastRatingResponse readCastRating = castRatingService.createCastRating(createCastRating);
        Assert.assertTrue(castRatingRepository.existsById(readCastRating.getId()));

        ReadCastRatingResponse castAfterSave = castRatingService.getCastRating(readCastRating.getId());
        Assertions.assertThat(readCastRating).isEqualToComparingFieldByField(castAfterSave);

    }
    
    @Test
    public void testPatchCastRating() {
        CastRating castRating = generateFlatEntityAndSave(CastRating.class);

        PatchCastRatingRequest patchCastRating = new PatchCastRatingRequest();
        patchCastRating.setRating(5);

        ReadCastRatingResponse readCastRating = castRatingService.patchCastRating(castRating.getId(), patchCastRating);

        Assert.assertTrue(readCastRating.getRating() == patchCastRating.getRating());

    }

    @Test
    public void testUpdateCastRating() {
        CastRating castRating = generateFlatEntityAndSave(CastRating.class);

        UpdateCastRatingRequest updateCastRating = new UpdateCastRatingRequest();
        updateCastRating.setRating(8);

        ReadCastRatingResponse readCastRating = castRatingService.updateCastRating(castRating.getId(), updateCastRating);

        Assert.assertTrue(readCastRating.getRating() == updateCastRating.getRating());
    }

    @Test
    public void testDeleteCastRating() {
        User user = generateFlatEntityAndSave(User.class);
        Cast cast = generateFlatEntityAndSave(Cast.class);

        CreateCastRatingRequest createCastRating = new CreateCastRatingRequest();
        createCastRating.setRating(8);
        createCastRating.setUserId(user.getId());
        createCastRating.setCastId(cast.getId());

        ReadCastRatingResponse readCastRating = castRatingService.createCastRating(createCastRating);
        Assert.assertTrue(castRatingRepository.existsById(readCastRating.getId()));
        Assert.assertTrue(userRepository.existsById(user.getId()));
        Assert.assertTrue(castRepository.existsById(cast.getId()));

        castRatingService.deleteCastRating(readCastRating.getId());
        Assert.assertFalse(castRatingRepository.existsById(readCastRating.getId()));
        Assert.assertTrue(userRepository.existsById(user.getId()));
        Assert.assertTrue(castRepository.existsById(cast.getId()));

    }
}
