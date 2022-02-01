package com.prylipko.oleg.controller;

import com.prylipko.oleg.dto.personComplaint.CreatePersonComplaintRequest;
import com.prylipko.oleg.dto.personComplaint.PatchPersonComplaintRequest;
import com.prylipko.oleg.dto.personComplaint.ReadPersonComplaintResponse;
import com.prylipko.oleg.dto.personComplaint.UpdatePersonComplaintRequest;
import com.prylipko.oleg.service.personComplaint.PersonComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/person-complaints")
public class PersonComplaintController {

    @Autowired
    private PersonComplaintService personComplaintService;

    @GetMapping("/{id}")
    public ReadPersonComplaintResponse getCrew(@PathVariable UUID id) {
        return personComplaintService.getPersonComplaint(id);
    }

    @PostMapping("/create")
    public ReadPersonComplaintResponse createCrew(@RequestBody CreatePersonComplaintRequest create) {
        return personComplaintService.createPersonComplaint(create);
    }

    @PatchMapping("/{id}")
    public ReadPersonComplaintResponse patchCrew(@PathVariable UUID id, @RequestBody PatchPersonComplaintRequest patch) {
        return personComplaintService.patchPersonComplaint(id, patch);
    }

    @PutMapping("/{id}")
    public ReadPersonComplaintResponse updateCrew(@PathVariable UUID id, @RequestBody UpdatePersonComplaintRequest update) {
        return personComplaintService.updatePersonComplaint(id, update);
    }

    @DeleteMapping("/{id}")
    public void deleteCrew(@PathVariable UUID id) {
        personComplaintService.deletePersonComplaint(id);
    }
}
