package com.prylipko.oleg.controller;

import com.prylipko.oleg.dto.cast.CreateCastRequest;
import com.prylipko.oleg.dto.cast.PatchCastRequest;
import com.prylipko.oleg.dto.cast.ReadCastResponse;
import com.prylipko.oleg.dto.cast.UpdateCastRequest;
import com.prylipko.oleg.service.cast.CastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/casts")
public class CastController {

    @Autowired
    private CastService castService;

    @GetMapping("/{id}")
    public ReadCastResponse getCast(@PathVariable UUID id) {
        return castService.getCast(id);
    }

    @PostMapping("/create")
    public ReadCastResponse createCast(@RequestBody CreateCastRequest create) {
        return castService.createCast(create);
    }

    @PatchMapping("/{id}")
    public ReadCastResponse patchCast(@PathVariable UUID id, @RequestBody PatchCastRequest patch) {
        return castService.patchCast(id, patch);
    }

    @PutMapping("/{id}")
    public ReadCastResponse updateCast(@PathVariable UUID id, @RequestBody UpdateCastRequest update) {
        return castService.updateCast(id, update);
    }

    @DeleteMapping("/{id}")
    public void deleteCast(@PathVariable UUID id) {
        castService.deleteCast(id);
    }
}
