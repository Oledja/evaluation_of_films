package com.prylipko.oleg.dto.castRating;

import com.prylipko.oleg.dto.cast.ReadCastResponse;
import com.prylipko.oleg.dto.user.ReadUserResponse;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class ReadCastRatingResponse {

    private UUID id;
    private ReadUserResponse user;
    private int rating;
    private ReadCastResponse cast;
    private Instant createdAt;
    private Instant updatedAt;
}
