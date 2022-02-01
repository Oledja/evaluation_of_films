package com.prylipko.oleg.controller;

import com.prylipko.oleg.dto.movieComplaint.CreateMovieComplaintRequest;
import com.prylipko.oleg.dto.movieComplaint.PatchMovieComplaintRequest;
import com.prylipko.oleg.dto.movieComplaint.ReadMovieComplaintResponse;
import com.prylipko.oleg.dto.movieComplaint.UpdateMovieComplaintRequest;
import com.prylipko.oleg.service.movieComplaint.MovieComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/movie-complaints")
public class MovieComplaintController {

    @Autowired
    private MovieComplaintService movieComplaintService;

    @GetMapping("/{id}")
    public ReadMovieComplaintResponse getCrew(@PathVariable UUID id) {
        return movieComplaintService.getMovieComplaint(id);
    }

    @PostMapping("/create")
    public ReadMovieComplaintResponse createCrew(@RequestBody CreateMovieComplaintRequest create) {
        return movieComplaintService.createMovieComplaint(create);
    }

    @PatchMapping("/{id}")
    public ReadMovieComplaintResponse patchCrew(@PathVariable UUID id, @RequestBody PatchMovieComplaintRequest patch) {
        return movieComplaintService.patchMovieComplaint(id, patch);
    }

    @PutMapping("/{id}")
    public ReadMovieComplaintResponse updateCrew(@PathVariable UUID id, @RequestBody UpdateMovieComplaintRequest update) {
        return movieComplaintService.updateMovieComplaint(id, update);
    }

    @DeleteMapping("/{id}")
    public void deleteMovieComplaint(@PathVariable UUID id) {
        movieComplaintService.deleteMovieComplaint(id);
    }
}
