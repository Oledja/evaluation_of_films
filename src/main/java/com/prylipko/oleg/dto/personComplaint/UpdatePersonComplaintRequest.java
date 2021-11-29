package com.prylipko.oleg.dto.personComplaint;

import com.prylipko.oleg.domain.Status;
import lombok.Data;

@Data
public class UpdatePersonComplaintRequest {

    private String description;
    private Status status;
}
