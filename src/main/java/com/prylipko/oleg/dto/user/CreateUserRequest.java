package com.prylipko.oleg.dto.user;

import com.prylipko.oleg.domain.Gender;
import lombok.Data;
import java.time.LocalDate;

@Data
public class CreateUserRequest {

    private String userName;
    private String password;
    private String passwordConfirm;
    private LocalDate birthday;
    private String country;
    private Gender gender;
}




