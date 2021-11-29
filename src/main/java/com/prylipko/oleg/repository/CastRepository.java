package com.prylipko.oleg.repository;

import com.prylipko.oleg.domain.Cast;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface CastRepository extends CrudRepository<Cast, UUID> {
}
