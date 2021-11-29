package com.prylipko.oleg.dto.review;

import com.prylipko.oleg.domain.Status;
import com.prylipko.oleg.dto.user.ReadUserResponse;
import lombok.Data;

import java.util.UUID;

@Data
public class CreateReviewRequest {

    private ReadUserResponse author;
    private UUID movieId;
    private String text;
    private Status status;
}
