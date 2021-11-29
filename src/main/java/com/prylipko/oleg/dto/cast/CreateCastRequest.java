package com.prylipko.oleg.dto.cast;

import com.prylipko.oleg.domain.Gender;
import com.prylipko.oleg.dto.person.ReadPersonResponse;
import lombok.Data;

@Data
public class CreateCastRequest {

    private ReadPersonResponse readPersonResponse;
    private String name;
    private Gender gender;
}
