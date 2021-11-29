package com.prylipko.oleg.repository;

import com.prylipko.oleg.domain.MovieComplaint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface MovieComplaintRepository extends CrudRepository<MovieComplaint, UUID> {
}
