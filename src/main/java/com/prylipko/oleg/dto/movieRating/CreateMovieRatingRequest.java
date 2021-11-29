package com.prylipko.oleg.dto.movieRating;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateMovieRatingRequest {

    private UUID userId;
    private int rating;
    private UUID MovieId;
}
