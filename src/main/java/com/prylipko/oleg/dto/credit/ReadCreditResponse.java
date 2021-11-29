package com.prylipko.oleg.dto.credit;

import com.prylipko.oleg.dto.cast.ReadCastResponse;
import com.prylipko.oleg.dto.crew.ReadCrewResponse;
import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Data
public class ReadCreditResponse {

    private UUID id;
    private UUID movieId;
    private List<ReadCastResponse> casts;
    private List<ReadCrewResponse> crews;
    private Instant createdAt;
    private Instant updatedAt;
}
