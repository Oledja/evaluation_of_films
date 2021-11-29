package com.prylipko.oleg.repository;

import com.prylipko.oleg.domain.ReviewComplaint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReviewComplaintRepository extends CrudRepository<ReviewComplaint, UUID> {
}
