package com.prylipko.oleg.controller;

import com.prylipko.oleg.dto.movieRating.CreateMovieRatingRequest;
import com.prylipko.oleg.dto.movieRating.PatchMovieRatingRequest;
import com.prylipko.oleg.dto.movieRating.ReadMovieRatingResponse;
import com.prylipko.oleg.dto.movieRating.UpdateMovieRatingRequest;
import com.prylipko.oleg.service.movieRating.MovieRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/movie-ratings")
public class MovieRatingController {

    @Autowired
    private MovieRatingService movieRatingService;

    @GetMapping("/{id}")
    public ReadMovieRatingResponse getCrew(@PathVariable UUID id) {
        return movieRatingService.getMovieRating(id);
    }

    @PostMapping("/create")
    public ReadMovieRatingResponse createCrew(@RequestBody CreateMovieRatingRequest create) {
        return movieRatingService.createMovieRating(create);
    }

    @PatchMapping("/{id}")
    public ReadMovieRatingResponse patchCrew(@PathVariable UUID id, @RequestBody PatchMovieRatingRequest patch) {
        return movieRatingService.patchMovieRating(id, patch);
    }

    @PutMapping("/{id}")
    public ReadMovieRatingResponse updateCrew(@PathVariable UUID id, @RequestBody UpdateMovieRatingRequest update) {
        return movieRatingService.updateMovieRating(id, update);
    }

    @DeleteMapping("/{id}")
    public void deleteMovieRating(@PathVariable UUID id) {
        movieRatingService.deleteMovieRating(id);
    }
}
