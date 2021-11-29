package com.prylipko.oleg.repository;

import com.prylipko.oleg.domain.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GenreRepository extends CrudRepository<Genre, UUID> {
}
