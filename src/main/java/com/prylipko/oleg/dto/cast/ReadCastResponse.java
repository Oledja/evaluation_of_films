package com.prylipko.oleg.dto.cast;

import com.prylipko.oleg.domain.Gender;
import com.prylipko.oleg.dto.person.ReadPersonResponse;
import lombok.Data;
import java.time.Instant;
import java.util.UUID;


@Data
public class ReadCastResponse {

    private UUID id;
    private ReadPersonResponse readPersonResponse;
    private String name;
    private Gender gender;
    private Instant createdAt;
    private Instant updatedAt;
}
