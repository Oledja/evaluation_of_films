package com.prylipko.oleg.controller;

import com.prylipko.oleg.dto.person.CreatePersonRequest;
import com.prylipko.oleg.dto.person.PatchPersonRequest;
import com.prylipko.oleg.dto.person.ReadPersonResponse;
import com.prylipko.oleg.dto.person.UpdatePersonRequest;
import com.prylipko.oleg.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    public ReadPersonResponse getCrew(@PathVariable UUID id) {
        return personService.getPerson(id);
    }

    @PostMapping("/create")
    public ReadPersonResponse createCrew(@RequestBody CreatePersonRequest create) {
        return personService.createPerson(create);
    }

    @PatchMapping("/{id}")
    public ReadPersonResponse patchCrew(@PathVariable UUID id, @RequestBody PatchPersonRequest patch) {
        return personService.patchPerson(id, patch);
    }

    @PutMapping("/{id}")
    public ReadPersonResponse updateCrew(@PathVariable UUID id, @RequestBody UpdatePersonRequest update) {
        return personService.updatePerson(id, update);
    }

    @DeleteMapping("/{id}")
    public void deleteCrew(@PathVariable UUID id) {
        personService.deletePerson(id);
    }
}
