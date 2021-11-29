package com.prylipko.oleg.dto.personComplaint;

import com.prylipko.oleg.domain.Status;
import com.prylipko.oleg.dto.person.ReadPersonResponse;
import com.prylipko.oleg.dto.user.ReadUserResponse;
import lombok.Data;
import java.time.Instant;
import java.util.UUID;

@Data
public class ReadPersonComplaintResponse {

    private UUID id;
    private ReadUserResponse author;
    private String description;
    private Status status;
    private ReadPersonResponse person;
    private Instant createdAt;
    private Instant updatedAt;
}
