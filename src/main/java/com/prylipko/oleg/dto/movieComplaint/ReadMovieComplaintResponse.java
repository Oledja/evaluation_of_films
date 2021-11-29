package com.prylipko.oleg.dto.movieComplaint;

import com.prylipko.oleg.domain.Status;
import com.prylipko.oleg.dto.movie.ReadMovieResponse;
import com.prylipko.oleg.dto.user.ReadUserResponse;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class ReadMovieComplaintResponse {

    private UUID id;
    private ReadUserResponse author;
    private String description;
    private Status status;
    private ReadMovieResponse movie;
    private Instant createdAt;
    private Instant updatedAt;
}
