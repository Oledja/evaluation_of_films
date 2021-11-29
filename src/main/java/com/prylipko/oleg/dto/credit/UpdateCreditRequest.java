package com.prylipko.oleg.dto.credit;

import com.prylipko.oleg.dto.cast.ReadCastResponse;
import com.prylipko.oleg.dto.crew.ReadCrewResponse;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class UpdateCreditRequest {

    private UUID movieId;
    private List<ReadCastResponse> casts;
    private List<ReadCrewResponse> crews;
}
