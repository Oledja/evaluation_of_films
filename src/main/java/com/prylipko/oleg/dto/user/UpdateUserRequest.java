package com.prylipko.oleg.dto.user;

import com.prylipko.oleg.domain.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateUserRequest {

    private String userName;
    private String password;
    private LocalDate birthday;
    private LocalDate deathday;
    private Gender gender;
}
