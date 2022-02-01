package com.prylipko.oleg.dto.movieRating;

import com.prylipko.oleg.dto.user.ReadUserResponse;
import lombok.Data;
import java.time.Instant;
import java.util.UUID;

@Data
public class ReadMovieRatingResponse {

    private UUID id;
    private ReadUserResponse user;
    private int rating;
    private ReadMovieRatingResponse movie;
    private Instant createdAt;
    private Instant updatedAt;
}
