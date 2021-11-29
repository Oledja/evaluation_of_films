package com.prylipko.oleg.dto.person;

import com.prylipko.oleg.domain.Gender;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class ReadPersonResponse {

    private UUID id;
    private String name;
    private LocalDate birthday;
    private LocalDate deathday;
    private Gender gender;
    private String biography;
    private Instant createdAt;
    private Instant updatedAt;
}
