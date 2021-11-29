package com.prylipko.oleg.dto.genre;

import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class ReadGenreResponse {

    private UUID id;
    private String name;
    private Instant createdAt;
    private Instant updatedAt;
}
