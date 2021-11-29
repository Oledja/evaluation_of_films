package com.prylipko.oleg.dto.movieComplaint;

import com.prylipko.oleg.domain.Status;
import com.prylipko.oleg.dto.movie.ReadMovieResponse;
import com.prylipko.oleg.dto.user.ReadUserResponse;
import lombok.Data;

@Data
public class CreateMovieComplaintRequest {

    private ReadUserResponse author;
    private String description;
    private Status status;
    private ReadMovieResponse movie;
}
