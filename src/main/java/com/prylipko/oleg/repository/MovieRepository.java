package com.prylipko.oleg.repository;

import com.prylipko.oleg.domain.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MovieRepository extends CrudRepository<Movie, UUID> {
}
