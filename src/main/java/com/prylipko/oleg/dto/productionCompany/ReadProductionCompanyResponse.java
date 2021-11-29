package com.prylipko.oleg.dto.productionCompany;

import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class ReadProductionCompanyResponse {

    private UUID id;
    private String name;
    private Instant createdAt;
    private Instant updatedAt;
}
