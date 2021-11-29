package com.prylipko.oleg.repository;

import com.prylipko.oleg.domain.ProductionCompany;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductionCompanyRepository extends CrudRepository<ProductionCompany, UUID> {
}
