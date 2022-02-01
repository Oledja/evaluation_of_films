package com.prylipko.oleg.controller;

import com.prylipko.oleg.dto.crew.CreateCrewRequest;
import com.prylipko.oleg.dto.crew.PatchCrewRequest;
import com.prylipko.oleg.dto.crew.ReadCrewResponse;
import com.prylipko.oleg.dto.crew.UpdateCrewRequest;
import com.prylipko.oleg.service.crew.CrewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/crews")
public class CrewController {

    @Autowired
    private CrewService crewService;

    @GetMapping("/{id}")
    public ReadCrewResponse getCrew(@PathVariable UUID id) {
        return crewService.getCrew(id);
    }

    @PostMapping("/create")
    public ReadCrewResponse createCrew(@RequestBody CreateCrewRequest create) {
        return crewService.createCrew(create);
    }

    @PatchMapping("/{id}")
    public ReadCrewResponse patchCrew(@PathVariable UUID id, @RequestBody PatchCrewRequest patch) {
        return crewService.patchCrew(id, patch);
    }

    @PutMapping("/{id}")
    public ReadCrewResponse updateCrew(@PathVariable UUID id, @RequestBody UpdateCrewRequest update) {
        return crewService.updateCrew(id, update);
    }

    @DeleteMapping("/{id}")
    public void deleteCrew(@PathVariable UUID id) {
        crewService.deleteCrew(id);
    }
}
