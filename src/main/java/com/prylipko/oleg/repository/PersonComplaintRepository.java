package com.prylipko.oleg.repository;

import com.prylipko.oleg.domain.PersonComplaint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonComplaintRepository extends CrudRepository<PersonComplaint, UUID> {
}
