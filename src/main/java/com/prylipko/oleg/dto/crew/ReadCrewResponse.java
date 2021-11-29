package com.prylipko.oleg.dto.crew;

import com.prylipko.oleg.dto.person.ReadPersonResponse;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class ReadCrewResponse {

    private UUID id;
    private String job;
    private ReadPersonResponse readPersonResponse;
    private Instant createdAt;
    private Instant updatedAt;
}
