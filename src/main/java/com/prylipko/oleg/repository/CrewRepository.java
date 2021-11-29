package com.prylipko.oleg.repository;

import com.prylipko.oleg.domain.Crew;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface CrewRepository extends CrudRepository<Crew, UUID> {
}
