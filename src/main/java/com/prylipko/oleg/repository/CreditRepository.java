package com.prylipko.oleg.repository;

import com.prylipko.oleg.domain.Credit;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CreditRepository extends CrudRepository<Credit, UUID> {
}
