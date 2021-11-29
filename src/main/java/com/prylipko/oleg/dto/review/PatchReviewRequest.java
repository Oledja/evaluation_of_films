package com.prylipko.oleg.dto.review;

import com.prylipko.oleg.domain.Status;
import lombok.Data;

@Data
public class PatchReviewRequest {

    private String text;
    private Status status;
}
