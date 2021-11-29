package com.prylipko.oleg.repository;

import com.prylipko.oleg.domain.CastRating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface CastRatingRepository extends CrudRepository<CastRating, UUID> {
}
