package com.prylipko.oleg.dto.user;

import com.prylipko.oleg.domain.Gender;
import com.prylipko.oleg.dto.role.ReadRoleResponse;
import lombok.Data;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
public class ReadUserResponse {

    private UUID id;
    private String userName;
    private LocalDate birthday;
    private Gender gender;
    private Set<ReadRoleResponse> roles;
    private Instant createdAt;
    private Instant updatedAt;
}
