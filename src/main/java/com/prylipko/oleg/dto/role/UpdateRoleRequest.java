package com.prylipko.oleg.dto.role;

import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class UpdateRoleRequest {
    private UUID id;
    private String name;
    private Instant createdAt;
    private Instant updatedAt;
}
