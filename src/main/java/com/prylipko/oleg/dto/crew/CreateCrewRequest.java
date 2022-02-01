package com.prylipko.oleg.dto.crew;

import com.prylipko.oleg.dto.person.ReadPersonResponse;
import lombok.Data;

@Data
public class CreateCrewRequest {

    private String job;
    private ReadPersonResponse person;
}
