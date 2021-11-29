package com.prylipko.oleg.dto.user;

import com.prylipko.oleg.domain.Gender;
import com.prylipko.oleg.dto.role.ReadRoleResponse;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
public class CreateUserRequest {

    private String userName;
    private String password;
    private LocalDate birthday;
    private LocalDate deathday;
    private Gender gender;
}




