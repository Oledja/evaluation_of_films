package com.prylipko.oleg.dto.reviewComplaint;

import com.prylipko.oleg.domain.Status;
import lombok.Data;

@Data
public class PatchReviewComplaintRequest {

    private String description;
    private Status status;
}
