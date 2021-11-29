package com.prylipko.oleg.dto.user;

import com.prylipko.oleg.domain.Gender;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
public class ReadUserResponse {

    private UUID id;
    private String userName;
    private String password;
    private LocalDate birthday;
    private LocalDate deathday;
    private Gender gender;
    private Set<ReadUserResponse> roles;
    private Instant createdAt;
    private Instant updatedAt;
}
