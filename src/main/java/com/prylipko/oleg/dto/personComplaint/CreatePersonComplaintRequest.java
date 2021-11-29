package com.prylipko.oleg.dto.personComplaint;

import com.prylipko.oleg.domain.Status;
import com.prylipko.oleg.dto.movie.ReadMovieResponse;
import com.prylipko.oleg.dto.person.ReadPersonResponse;
import com.prylipko.oleg.dto.user.ReadUserResponse;
import lombok.Data;

@Data
public class CreatePersonComplaintRequest {

    private ReadUserResponse author;
    private String description;
    private Status status;
    private ReadPersonResponse person;
}
