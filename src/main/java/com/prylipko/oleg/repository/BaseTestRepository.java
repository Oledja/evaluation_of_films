package com.prylipko.oleg.repository;

import com.prylipko.oleg.domain.AbstractEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BaseTestRepository extends CrudRepository<AbstractEntity, UUID> {
}
