package com.prylipko.oleg.dto.castRating;

import lombok.Data;
import java.util.UUID;

@Data
public class CreateCastRatingRequest {

    private UUID userId;
    private int rating;
    private UUID castId;
}
