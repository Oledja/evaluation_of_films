package com.prylipko.oleg.dto.cast;

import com.prylipko.oleg.domain.Gender;
import com.prylipko.oleg.dto.person.ReadPersonResponse;
import lombok.Data;

@Data
public class PatchCastRequest {

    private ReadPersonResponse person;
    private String name;
    private Gender gender;
}
