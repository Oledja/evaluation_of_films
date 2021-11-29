package com.prylipko.oleg.dto.crew;

import com.prylipko.oleg.dto.person.ReadPersonResponse;
import lombok.Data;

@Data
public class PatchCrewRequest {

    private String job;
    private ReadPersonResponse readPersonResponse;
}
