package com.prylipko.oleg.dto.movieComplaint;

import com.prylipko.oleg.domain.Status;
import lombok.Data;

@Data
public class UpdateMovieComplaintRequest {

    private String description;
    private Status status;
}
