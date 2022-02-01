package com.prylipko.oleg.controller;

import com.prylipko.oleg.dto.castRating.CreateCastRatingRequest;
import com.prylipko.oleg.dto.castRating.PatchCastRatingRequest;
import com.prylipko.oleg.dto.castRating.ReadCastRatingResponse;
import com.prylipko.oleg.dto.castRating.UpdateCastRatingRequest;
import com.prylipko.oleg.service.castRating.CastRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/cast-rating")
public class CastRatingController {

    @Autowired
    private CastRatingService castRatingService;

    @GetMapping("/{id}")
    public ReadCastRatingResponse getCastRating(@PathVariable UUID id) {
        return castRatingService.getCastRating(id);
    }

    @PostMapping("/create")
    public ReadCastRatingResponse createCastRating(@RequestBody CreateCastRatingRequest create) {
        return castRatingService.createCastRating(create);
    }

    @PatchMapping("/{id}")
    public ReadCastRatingResponse patchCastRating(@PathVariable UUID id, @RequestBody PatchCastRatingRequest patch) {
        return castRatingService.patchCastRating(id, patch);
    }

    @PutMapping("/{id}")
    public ReadCastRatingResponse updateCastRating(@PathVariable UUID id, @RequestBody UpdateCastRatingRequest update) {
        return castRatingService.updateCastRating(id, update);
    }

    @DeleteMapping("/{id}")
    public void deleteCastRating(@PathVariable UUID id) {
        castRatingService.deleteCastRating(id);
    }
}
