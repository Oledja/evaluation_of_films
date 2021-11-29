package com.prylipko.oleg.repository;

import com.prylipko.oleg.domain.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReviewRepository extends CrudRepository<Review, UUID> {
}
