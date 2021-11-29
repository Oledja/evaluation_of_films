package com.prylipko.oleg.repository;

import com.prylipko.oleg.domain.MovieRating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MovieRatingRepository extends CrudRepository<MovieRating, UUID> {
}
