package com.prylipko.oleg.controller;

import com.prylipko.oleg.dto.movie.CreateMovieRequest;
import com.prylipko.oleg.dto.movie.PatchMovieRequest;
import com.prylipko.oleg.dto.movie.ReadMovieResponse;
import com.prylipko.oleg.dto.movie.UpdateMovieRequest;
import com.prylipko.oleg.service.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/id")
    public ReadMovieResponse getMovie(@PathVariable UUID id) {
        return movieService.getMovie(id);
    }

    @PostMapping
    public ReadMovieResponse createMovie(@RequestBody CreateMovieRequest create) {
        return movieService.createMovie(create);
    }

    @PatchMapping("/id")
    public ReadMovieResponse patchMovie(@PathVariable UUID id,
                                        @RequestBody PatchMovieRequest patch) {
        return movieService.patchMovie(id, patch);
    }

    @PutMapping("/id")
    public ReadMovieResponse updateMovie(@PathVariable UUID id,
                                         @RequestBody UpdateMovieRequest update) {
        return movieService.updateMovie(id, update);
    }

    @DeleteMapping("/id")
    public void deleteMovie(@PathVariable UUID id) {
        movieService.deleteMovie(id);
    }
}
