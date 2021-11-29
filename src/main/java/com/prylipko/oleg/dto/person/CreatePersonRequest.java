package com.prylipko.oleg.dto.person;

import com.prylipko.oleg.domain.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreatePersonRequest {

    private String name;
    private LocalDate birthday;
    private LocalDate deathday;
    private Gender gender;
    private String biography;
}
