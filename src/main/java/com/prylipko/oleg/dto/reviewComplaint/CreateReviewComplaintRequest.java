package com.prylipko.oleg.dto.reviewComplaint;

import com.prylipko.oleg.domain.Status;
import com.prylipko.oleg.dto.review.ReadReviewResponse;
import com.prylipko.oleg.dto.user.ReadUserResponse;
import lombok.Data;

@Data
public class CreateReviewComplaintRequest {

    private ReadUserResponse author;
    private String description;
    private Status status;
    private ReadReviewResponse review;
}
