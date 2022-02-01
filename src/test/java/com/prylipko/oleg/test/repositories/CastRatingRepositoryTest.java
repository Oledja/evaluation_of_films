package com.prylipko.oleg.test.repositories;

import com.prylipko.oleg.domain.Cast;
import com.prylipko.oleg.domain.CastRating;
import com.prylipko.oleg.domain.User;
import com.prylipko.oleg.repository.CastRatingRepository;
import com.prylipko.oleg.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CastRatingRepositoryTest extends BaseTest {

    @Autowired
    private CastRatingRepository castRatingRepository;

    @Test
    public void testCreateCastRating() {
        Cast cast = generateFlatEntityAndSave(Cast.class);
        User user = generateFlatEntityAndSave(User.class);

        CastRating castRating = new CastRating();
        castRating.setCast(cast);
        castRating.setUser(user);
        castRating.setRating(1);
        CastRating castRatingAfterSave = castRatingRepository.save(castRating);

        Assert.assertEquals(user, castRatingAfterSave.getUser());
        Assert.assertEquals(cast, castRatingAfterSave.getCast());
        Assert.assertTrue(castRatingAfterSave.getRating() == 1);
    }
}
