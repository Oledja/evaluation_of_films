package com.prylipko.oleg.dto.reviewComplaint;

import com.prylipko.oleg.domain.Status;
import lombok.Data;

@Data
public class UpdateReviewComplaintRequest {

    private String description;
    private Status status;
}
